package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.board.assignPlayerToBoard.AssignPlayerToBoardRequest;
import com.buildingblocks.challenges.application.board.assignPlayerToBoard.AssignPlayerToBoardUseCase;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/assign-player-to-board")
public class AssignPlayerToBoardController{

    private final AssignPlayerToBoardUseCase useCase;

    public AssignPlayerToBoardController(AssignPlayerToBoardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<BoardResponse> assignPlayerToBoard(@RequestBody AssignPlayerToBoardRequest assignPlayerToBoardRequest) {
        return useCase.execute(assignPlayerToBoardRequest);
    }


}
