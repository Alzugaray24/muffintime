package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class LevelId extends Identity {
    public LevelId() {
        super();
    }

    private LevelId(String value) {
        super(value);
    }

    public static LevelId of(String value) {
        return new LevelId(value);
    }
}
