package com.buildingblocks.challenges.domain.board.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class BoardId extends Identity {
    public BoardId() {
        super();
    }

    private BoardId(String value) {
        super(value);
    }

    public static BoardId of(String value) {
        return new BoardId(value);
    }
}
