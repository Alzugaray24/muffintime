package com.buildingblocks.challenges.application.board.startboard;

import com.buildingblocks.challenges.application.board.shared.BoardMapper;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.board.Board;
import com.buildingblocks.shared.application.ICommandUseCase;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public class StartBoardUseCase implements ICommandUseCase<StartBoardRequest, Mono<BoardResponse>> {

    private final IEventRepositoryPort repository;

    public StartBoardUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BoardResponse> execute(StartBoardRequest request) {
        return repository.findEventsByAggregateId(request.getBoardId())
                .collectList()
                .flatMap(events -> {
                    Board board = Board.from(request.getBoardId(), events);
                    board.startBoard(request.getBoardId());
                    List<DomainEvent> uncommittedEvents = board.getUncommittedEvents();
                    uncommittedEvents.forEach(repository::save);
                    board.markEventsAsCommitted();
                    return Mono.just(BoardMapper.toResponse(board));
                });
    }
}