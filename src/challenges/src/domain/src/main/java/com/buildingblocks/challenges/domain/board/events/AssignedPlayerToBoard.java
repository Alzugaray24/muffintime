package com.buildingblocks.challenges.domain.board.events;

import com.buildingblocks.challenges.domain.board.Board;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AssignedPlayerToBoard extends DomainEvent {

    private Player player;

    public AssignedPlayerToBoard(Player player) {
        super(EventsEnum.ASSIGNED_PLAYER_TO_BOARD.name());
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
