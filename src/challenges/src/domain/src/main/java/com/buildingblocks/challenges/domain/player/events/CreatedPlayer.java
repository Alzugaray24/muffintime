package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.board.events.EventsEnum;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CreatedPlayer extends DomainEvent {

    private String nickname;

    public CreatedPlayer(String nickname) {
        super(EventsEnum.CREATED_PLAYER.name());
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
