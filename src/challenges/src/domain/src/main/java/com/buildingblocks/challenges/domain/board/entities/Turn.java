package com.buildingblocks.challenges.domain.board.entities;

import com.buildingblocks.challenges.domain.board.values.*;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.shared.domain.generic.Entity;

public class Turn extends Entity<TurnId> {

    private Player playerTurn;
    private IsTurn isTurn;

    public Turn(Player playerTurn, IsTurn isTurn) {
        super(new TurnId());
        this.playerTurn = playerTurn;
        this.isTurn = isTurn;
    }

    public Turn(TurnId identity, Title title, Type type) {
        super(identity);
        this.playerTurn = playerTurn;
        this.isTurn = isTurn;
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    public IsTurn getIsTurn() {
        return isTurn;
    }

    public void setIsTurn(IsTurn isTurn) {
        this.isTurn = isTurn;
    }
}
