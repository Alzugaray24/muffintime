// AssignPlayerToBoardUseCase.java
package com.buildingblocks.challenges.application.board.assignPlayerToBoard;

import com.buildingblocks.challenges.application.board.shared.BoardMapper;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.board.Board;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.util.List;

public class AssignPlayerToBoardUseCase implements ICommandUseCase<AssignPlayerToBoardRequest, Mono<BoardResponse>> {

    private final IEventRepositoryPort repository;

    public AssignPlayerToBoardUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<BoardResponse> execute(AssignPlayerToBoardRequest request) {
        return repository.findEventsByAggregateId(request.getBoardId())
                .collectList()
                .flatMap(boardEvents -> {
                    Board board = Board.from(request.getBoardId(), boardEvents);
                    return repository.findEventsByAggregateId(request.getPlayerId())
                            .collectList()
                            .flatMap(playerEvents -> {
                                Player player = Player.from(request.getPlayerId(), playerEvents);
                                board.assignPlayerToBoard(player);
                                board.getUncommittedEvents().forEach(repository::save);
                                board.markEventsAsCommitted();
                                return Mono.just(BoardMapper.toResponse(board));
                            });
                });
    }
}