package com.buildingblocks.challenges.application.board.searchboardbyid;

import com.buildingblocks.challenges.application.board.shared.BoardMapper;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.board.Board;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class SearchBoardByIdUseCase implements ICommandUseCase<SearchBoardByIdRequest, Mono<BoardResponse>> {

    private final IEventRepositoryPort repository;

    public SearchBoardByIdUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public Mono<BoardResponse> execute(SearchBoardByIdRequest request) {
        return repository.findEventsByAggregateId(request.getBoardId())
                .collectList()
                .map(events -> {
                    Board board = Board.from(request.getBoardId(), events);
                    return BoardMapper.toResponse(board);
                });
    }
}