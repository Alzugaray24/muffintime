package com.buildingblocks.challenges.infra.mainservice.config;

import com.buildingblocks.challenges.application.board.createboard.CreateBoardUseCase;
import com.buildingblocks.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateBoardUseCase createBoardUseCase(MongoAdapter mongoAdapter) {
        return new CreateBoardUseCase(mongoAdapter);
    }

}
