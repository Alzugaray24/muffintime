package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.board.searchallboards.SearchAllBoardsUseCase;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/get-boards")
public class SearchAllBoardsController {

    private final SearchAllBoardsUseCase useCase;

    public SearchAllBoardsController(SearchAllBoardsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public Flux<BoardResponse> execute() {
        return useCase.execute();
    }
}