package com.buildingblocks.challenges.application.player.createplayer;

import com.buildingblocks.shared.application.Request;

public class CreatePlayerRequest extends Request {

    private String nickName;

    public CreatePlayerRequest() {
        super(null);
    }

    public CreatePlayerRequest(String nickName) {
        super(null);
        this.nickName = nickName;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickname) {
        this.nickName = nickname;
    }

}
