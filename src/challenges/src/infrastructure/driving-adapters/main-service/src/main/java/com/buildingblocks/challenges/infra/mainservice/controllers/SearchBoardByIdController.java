package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.board.searchboardbyid.SearchBoardByIdRequest;
import com.buildingblocks.challenges.application.board.searchboardbyid.SearchBoardByIdUseCase;
import com.buildingblocks.challenges.application.board.shared.BoardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/boards")
public class SearchBoardByIdController {

    private final SearchBoardByIdUseCase useCase;

    public SearchBoardByIdController(SearchBoardByIdUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/search")
    public Mono<BoardResponse> searchBoardById(@RequestBody SearchBoardByIdRequest request) {
        return useCase.execute(request);
    }
}