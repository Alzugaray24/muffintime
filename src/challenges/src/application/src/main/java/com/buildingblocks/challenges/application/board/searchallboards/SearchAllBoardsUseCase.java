package com.buildingblocks.challenges.application.board.searchallboards;

import com.buildingblocks.challenges.application.board.shared.BoardMapper;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.board.Board;
import com.buildingblocks.shared.application.IQueryUseCase;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.stream.Collectors;

public class SearchAllBoardsUseCase implements IQueryUseCase<Flux<BoardResponse>> {

    private final IEventRepositoryPort repository;

    public SearchAllBoardsUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Flux<BoardResponse> execute() {
        return repository
                .findAllAgregates()
                .collectList()
                .map(events -> events.stream().collect(Collectors.groupingBy(DomainEvent::getAggregateRootId)))
                .map(aggregates -> aggregates.entrySet().stream().map(entry -> {
                    entry.getValue().sort(Comparator.comparing(DomainEvent::getWhen));
                    return Board.from(entry.getKey(), entry.getValue());
                }).toList())
                .map(boards -> boards.stream().map(BoardMapper::toResponse).toList())
                .flatMapMany(Flux::fromIterable);
    }
}
