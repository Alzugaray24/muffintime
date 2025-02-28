package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import com.buildingblocks.challenges.application.board.startboard.StartBoardRequest;
import com.buildingblocks.challenges.application.board.startboard.StartBoardUseCase;
import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerRequest;
import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerUseCase;
import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/start-board")
public class StartBoardController {
    private final StartBoardUseCase useCase;

    public StartBoardController(StartBoardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<BoardResponse> startBoard(@RequestBody StartBoardRequest startBoardRequest) {
        return useCase.execute(startBoardRequest);
    }
}
