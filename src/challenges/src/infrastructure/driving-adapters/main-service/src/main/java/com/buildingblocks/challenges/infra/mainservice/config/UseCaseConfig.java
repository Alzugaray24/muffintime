package com.buildingblocks.challenges.infra.mainservice.config;

import com.buildingblocks.challenges.application.board.assignPlayerToBoard.AssignPlayerToBoardUseCase;
import com.buildingblocks.challenges.application.board.createboard.CreateBoardUseCase;
import com.buildingblocks.challenges.application.board.searchallboards.SearchAllBoardsUseCase;
import com.buildingblocks.challenges.application.board.searchboardbyid.SearchBoardByIdUseCase;
import com.buildingblocks.challenges.application.board.startboard.StartBoardUseCase;
import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerUseCase;
import com.buildingblocks.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateBoardUseCase createBoardUseCase(MongoAdapter mongoAdapter) {
        return new CreateBoardUseCase(mongoAdapter);
    }

    @Bean
    public SearchBoardByIdUseCase searchBoardByIdUseCase(MongoAdapter mongoAdapter) {
        return new SearchBoardByIdUseCase(mongoAdapter);
    }

    @Bean
    public SearchAllBoardsUseCase searchAllBoardsUseCase(MongoAdapter mongoAdapter) {
        return new SearchAllBoardsUseCase(mongoAdapter);
    }

    @Bean
    public CreatePlayerUseCase createPlayerUseCase(MongoAdapter mongoAdapter) {
        return new CreatePlayerUseCase(mongoAdapter);
    }

    @Bean
    public AssignPlayerToBoardUseCase assignPlayerToBoardUseCase(MongoAdapter mongoAdapter) {
        return new AssignPlayerToBoardUseCase(mongoAdapter);
    }

    @Bean
    public StartBoardUseCase startBoardUseCase(MongoAdapter mongoAdapter) {
        return new StartBoardUseCase(mongoAdapter);
    }

}
