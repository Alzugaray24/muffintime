package com.buildingblocks.challenges.domain.board.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class StartedBoard extends DomainEvent {

    private String boardId;

    public StartedBoard(String boardId) {
        super(EventsEnum.STARTED_BOARD.name());
        this.boardId = boardId;

    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }


}
