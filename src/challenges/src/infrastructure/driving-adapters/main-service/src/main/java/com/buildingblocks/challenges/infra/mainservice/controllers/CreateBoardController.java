package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.board.createboard.CreateBoardRequest;
import com.buildingblocks.challenges.application.board.createboard.CreateBoardUseCase;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-board")
public class CreateBoardController{

    private final CreateBoardUseCase useCase;

    public CreateBoardController(CreateBoardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<BoardResponse> createBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        return useCase.execute(createBoardRequest);
    }


}

