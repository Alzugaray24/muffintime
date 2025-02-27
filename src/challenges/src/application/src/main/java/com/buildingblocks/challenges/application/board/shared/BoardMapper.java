package com.buildingblocks.challenges.application.board.shared;

import com.buildingblocks.challenges.domain.board.Board;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class BoardMapper {

    public static BoardResponse toResponse(Board board) {
        // Map the list of players
        List<BoardResponse.Player> playerResponses = board.getPlayers().stream()
                .map(player -> new BoardResponse.Player(
                        player.getIdentity().getValue(),
                        player.getNickName().getValue(),
                        player.getHand().stream()
                                .map(card -> new BoardResponse.Card(card.getTitle().getValue(), card.getType().getValue()))
                                .collect(Collectors.toCollection(ArrayDeque::new))
                ))
                .collect(Collectors.toList());

        // Map the deck of cards
        Deque<BoardResponse.Card> deckResponse = board.getDeck().stream()
                .map(card -> new BoardResponse.Card(card.getTitle().getValue(), card.getType().getValue()))
                .collect(Collectors.toCollection(ArrayDeque::new));

        // Map the discard pile
        Deque<BoardResponse.Card> discardPileResponse = board.getDiscardPile().stream()
                .map(card -> new BoardResponse.Card(card.getTitle().getValue(), card.getType().getValue()))
                .collect(Collectors.toCollection(ArrayDeque::new));


        // Create and return the BoardResponse
        return new BoardResponse(
                board.getIdentity().getValue(),
                board.getTitle().getValue(),
                playerResponses,
                deckResponse,
                discardPileResponse
        );
    }
}