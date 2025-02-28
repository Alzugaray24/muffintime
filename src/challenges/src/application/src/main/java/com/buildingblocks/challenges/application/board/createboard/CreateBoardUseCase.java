package com.buildingblocks.challenges.application.board.createboard;

import com.buildingblocks.challenges.application.board.shared.BoardMapper;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import com.buildingblocks.challenges.domain.board.Board;
import com.buildingblocks.shared.application.ICommandUseCase;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import reactor.core.publisher.Mono;

public class CreateBoardUseCase implements ICommandUseCase<CreateBoardRequest, Mono<BoardResponse>> {

    private final IEventRepositoryPort repository;

    public CreateBoardUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BoardResponse> execute(CreateBoardRequest request) {
        Board board = new Board();
        board.createBoard(request.getBoardName());
        board.getUncommittedEvents().forEach(repository::save);
        board.markEventsAsCommitted();
        return Mono.just(BoardMapper.toResponse(board));
    }
}
