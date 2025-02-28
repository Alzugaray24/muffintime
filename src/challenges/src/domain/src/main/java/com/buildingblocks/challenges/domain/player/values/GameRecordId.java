package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class GameRecordId extends Identity {
    public GameRecordId() {
        super();
    }

    private GameRecordId(String value) {
        super(value);
    }

    public static GameRecordId of(String value) {
        return new GameRecordId(value);
    }
}
