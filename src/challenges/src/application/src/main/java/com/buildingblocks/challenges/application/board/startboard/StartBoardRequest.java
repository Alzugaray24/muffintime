package com.buildingblocks.challenges.application.board.startboard;

import com.buildingblocks.shared.application.Request;

public class StartBoardRequest extends Request {

    private String boardId;

    public StartBoardRequest() {
        super(null);
    }

    public StartBoardRequest(String boardId) {
        super(null);
        this.boardId = boardId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}