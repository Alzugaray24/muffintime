package com.buildingblocks.challenges.domain.board.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CreatedBoard extends DomainEvent {

    private String boardName;

    public CreatedBoard(String boardName) {
        super(EventsEnum.CREATED_BOARD.name());
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

}