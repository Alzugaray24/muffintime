// PlayerHandler.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.player.events.CreatedPlayer;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;


public class PlayerHandler extends DomainActionsContainer {

    private final Player player;

    public PlayerHandler(Player player) {
        this.player = player;
        add(createPlayer());
    }

    public Consumer<DomainEvent> createPlayer() {
        return (DomainEvent event) -> {
            if (event instanceof CreatedPlayer createdPlayer) {
               player.setNickName(NickName.of(createdPlayer.getNickname()));
            }
        };
    }


}