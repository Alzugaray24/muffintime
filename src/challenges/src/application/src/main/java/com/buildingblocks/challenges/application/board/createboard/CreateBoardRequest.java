package com.buildingblocks.challenges.application.board.createboard;

import com.buildingblocks.shared.application.Request;

public class CreateBoardRequest extends Request {

    private String name;

    public CreateBoardRequest() {
        super(null);
    }

    public CreateBoardRequest(String name) {
        super(null);
        this.name = name;
    }

    public String getBoardName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}