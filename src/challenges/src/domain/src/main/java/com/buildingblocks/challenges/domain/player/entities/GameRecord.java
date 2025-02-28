package com.buildingblocks.challenges.domain.player.entities;

import com.buildingblocks.challenges.domain.board.values.Action;
import com.buildingblocks.challenges.domain.board.values.Type;
import com.buildingblocks.challenges.domain.player.values.GameRecordId;
import com.buildingblocks.shared.domain.generic.Entity;

public class GameRecord extends Entity<GameRecordId> {

    private Action action;
    private Type type;

    public GameRecord(Action action, Type type) {
        super(new GameRecordId());
        this.action = action;
        this.type = type;
    }

    public GameRecord(GameRecordId identity, Action action, Type type) {
        super(identity);
        this.action = action;
        this.type = type;
    }


    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
