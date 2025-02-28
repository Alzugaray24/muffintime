package com.buildingblocks.challenges.domain.player.entities;

import com.buildingblocks.challenges.domain.board.values.CardId;
import com.buildingblocks.challenges.domain.board.values.Title;
import com.buildingblocks.challenges.domain.board.values.Type;
import com.buildingblocks.challenges.domain.player.values.LevelId;
import com.buildingblocks.shared.domain.generic.Entity;

public class Level extends Entity<LevelId> {

    private Number currentLevel;
    private Type type;

    public Level(Number currentLevel, Type type) {
        super(new LevelId());
        this.currentLevel = currentLevel;
        this.type = type;
    }

    public Level(LevelId identity, Number currentLevel, Type type) {
        super(identity);
        this.currentLevel = currentLevel;
        this.type = type;
    }

    public Number getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Number currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
