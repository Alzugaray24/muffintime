package com.buildingblocks.challenges.application.board.shared;

import java.util.Deque;
import java.util.List;

public class BoardResponse {

    private final String boardId;
    private final String boardName;
    private final List<Player> players;
    private final Deque<Card> discardPile;
    private final Deque<Card> deck;

    public BoardResponse(String boardId, String boardName, List<Player> players, Deque<Card> deck, Deque<Card> discardPile) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.players = players;
        this.discardPile = discardPile;
        this.deck = deck;
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
        private final String title;
        private final String type;

        public Card(String title, String type) {
            this.title = title;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }
    }


}