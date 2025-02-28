package com.buildingblocks.challenges.application.board.shared;

import com.buildingblocks.challenges.domain.board.values.IsActive;

import java.util.Deque;
import java.util.List;

public class BoardResponse {

    private final String boardId;
    private final String boardName;
    private final List<Player> players;
    private final Deque<Card> discardPile;
    private final Deque<Card> deck;
    private final IsActive isActive;

    public BoardResponse(String boardId, String boardName, IsActive isActive, List<Player> players, Deque<Card> deck, Deque<Card> discardPile) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.players = players;
        this.discardPile = discardPile;
        this.deck = deck;
        this.isActive = isActive;
    }

    // Getters
    public String getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deque<Card> getDiscardPile() {
        return discardPile;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public Deque<Card> getDeck() {
        return deck;
    }

    public static class Player {
        private final String playerId;
        private final String nickName;
        private final Deque<Card> hand;

        public Player(String playerId, String nickName, Deque<Card> hand) {
            this.playerId = playerId;
            this.nickName = nickName;
            this.hand = hand;
        }

        public String getPlayerId() {
            return playerId;
        }

        public String getNickName() {
            return nickName;
        }

        public Deque<Card> getHand() {
            return hand;
        }
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

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public String getCardId() {
            return cardId;
        }
    }


}