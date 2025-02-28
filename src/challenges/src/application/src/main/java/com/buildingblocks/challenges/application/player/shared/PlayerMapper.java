package com.buildingblocks.challenges.application.player.shared;

import com.buildingblocks.challenges.domain.player.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerMapper {

    public static PlayerResponse toResponse(Player player) {
        // Map the hand of cards
        List<PlayerResponse.Card> handResponse = player.getHand() != null ? player.getHand().stream()
                .map(card -> new PlayerResponse.Card(
                        card.getIdentity().getValue(),
                        card.getTitle().getValue(),
                        card.getType().getValue()
                ))
                .collect(Collectors.toList()) : Collections.emptyList();

        // Map the game records
        List<PlayerResponse.GameRecord> gameRecordResponse = player.getGameRecord() != null ? player.getGameRecord().stream()
                .map(record -> new PlayerResponse.GameRecord(
                        record.getAction().getValue(),
                        record.getType().getValue()
                ))
                .collect(Collectors.toList()) : Collections.emptyList();

        // Map the level
        PlayerResponse.Level levelResponse = player.getLevel() != null ? new PlayerResponse.Level(
                player.getLevel().getCurrentLevel().intValue(),
                player.getLevel().getType().getValue()
        ) : new PlayerResponse.Level(0, "beginner");

        // Create and return the PlayerResponse
        return new PlayerResponse(
                player.getIdentity().getValue(),
                player.getNickName() != null ? player.getNickName().getValue() : "Unknown",
                handResponse,
                levelResponse,
                gameRecordResponse
        );
    }
}