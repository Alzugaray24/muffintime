package com.buildingblocks.challenges.application.board.assignPlayerToBoard;

import com.buildingblocks.shared.application.Request;

public class AssignPlayerToBoardRequest extends Request {

    private String playerId;
    private String boardId;

    public AssignPlayerToBoardRequest() {
        super(null);
    }

    public AssignPlayerToBoardRequest( String playerId, String boardId) {
        super(null);
        this.playerId = playerId;
        this.boardId = boardId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}
