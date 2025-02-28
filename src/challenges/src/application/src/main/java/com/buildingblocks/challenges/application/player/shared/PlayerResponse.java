// src/challenges/src/application/src/main/java/com/buildingblocks/challenges/application/player/shared/PlayerResponse.java
package com.buildingblocks.challenges.application.player.shared;

import java.util.List;

public class PlayerResponse {

    private final String playerId;
    private final String nickname;
    private final List<Card> hand;
    private final Level level;
    private final List<GameRecord> gameRecord;

    public PlayerResponse(String playerId, String nickname, List<Card> hand, Level level, List<GameRecord> gameRecord) {
        this.playerId = playerId;
        this.nickname = nickname;
        this.hand = hand;
        this.level = level;
        this.gameRecord = gameRecord;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Card> getHand() {
        return hand;
    }

    public Level getLevel() {
        return level;
    }

    public List<GameRecord> getGameRecord() {
        return gameRecord;
    }

    public static class Card {
        private final String cardId;
        private final String title;
        private final String type;

        public Card(String cardId, String title, String type) {
            this.cardId = cardId;
            this.title = title;
            this.type = type;
        }

        public String getCardId() {
            return cardId;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }
    }

    public static class GameRecord {
        private final String action;
        private final String type;

        public GameRecord(String action, String type) {
            this.action = action;
            this.type = type;
        }

        public String getAction() {
            return action;
        }

        public String getType() {
            return type;
        }


    }

    public static class Level {
        private final Integer currentLevel;
        private final String type;

        public Level(Integer currentLevel, String type) {
            this.currentLevel = currentLevel;
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public Integer getCurrentLevel() {
            return currentLevel;
        }
    }
}