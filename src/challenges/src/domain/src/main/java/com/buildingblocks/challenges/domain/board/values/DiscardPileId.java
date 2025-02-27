package com.buildingblocks.challenges.domain.board.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class DiscardPileId extends Identity {
    public DiscardPileId() {
        super();
    }

    private DiscardPileId(String value) {
        super(value);
    }

    public static DiscardPileId of(String value) {
        return new DiscardPileId(value);
    }
}