package com.buildingblocks.challenges.application.board.searchboardbyid;

import com.buildingblocks.shared.application.Request;

public class SearchBoardByIdRequest extends Request {

    private String boardId;

    public SearchBoardByIdRequest() {
        super(null);
    }

    public SearchBoardByIdRequest(String boardId) {
        super(null);
        this.boardId = boardId;
    }

    public String getBoardId() {
        return boardId;
    }

}