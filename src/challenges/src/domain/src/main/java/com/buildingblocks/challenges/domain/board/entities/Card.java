package com.buildingblocks.challenges.domain.board.entities;

import com.buildingblocks.challenges.domain.board.values.CardId;
import com.buildingblocks.challenges.domain.board.values.Title;
import com.buildingblocks.challenges.domain.board.values.Type;
import com.buildingblocks.shared.domain.generic.Entity;

import javax.swing.*;

public class Card extends Entity<CardId> {

    private Title title;
    private Type type;

    public Card(Title title, Type type) {
        super(new CardId());
        this.title = title;
        this.type = type;
    }

    public Card(CardId identity,Title title, Type type) {
        super(identity);
        this.title = title;
        this.type = type;
    }


    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
