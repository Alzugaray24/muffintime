package com.buildingblocks.challenges.domain.board;

import com.buildingblocks.challenges.domain.board.events.CreatedBoard;
import com.buildingblocks.challenges.domain.board.values.Title;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;


public class BoardHandler extends DomainActionsContainer {

    private final Board board;

    public BoardHandler(Board board) {
        this.board = board;
        add(createdBoard());
    }

    public Consumer<DomainEvent> createdBoard() {
        return (DomainEvent event) -> {
            if (event instanceof CreatedBoard createdBoardEvent) {
                board.setTitle(Title.of(createdBoardEvent.getBoardName()));
                board.generateDeck();
            }
        };
    }
}