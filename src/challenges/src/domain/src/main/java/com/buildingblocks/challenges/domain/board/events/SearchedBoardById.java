package com.buildingblocks.challenges.domain.board.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class SearchedBoardById extends DomainEvent {

    private String boardId;

    public SearchedBoardById(String boardId) {
        super(EventsEnum.SEARCHED_BOARD_BY_ID.name());
        this.boardId = boardId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

}
