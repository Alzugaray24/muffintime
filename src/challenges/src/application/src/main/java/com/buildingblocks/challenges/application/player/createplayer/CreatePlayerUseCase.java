package com.buildingblocks.challenges.application.player.createplayer;

import com.buildingblocks.challenges.application.player.shared.PlayerMapper;
import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;


public class CreatePlayerUseCase implements ICommandUseCase<CreatePlayerRequest, Mono<PlayerResponse>> {

    private final IEventRepositoryPort repository;

    public CreatePlayerUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    // CreatePlayerUseCase.java
    @Override
    public Mono<PlayerResponse> execute(CreatePlayerRequest request) {
        Player player = new Player();
        player.createPlayer(request.getNickname());
        player.getUncommittedEvents().forEach(repository::save);
        player.markEventsAsCommitted();
        return Mono.just(PlayerMapper.toResponse(player));
    }
}