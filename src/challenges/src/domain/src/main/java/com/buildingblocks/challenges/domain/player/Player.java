// Player.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.board.entities.Card;
import com.buildingblocks.challenges.domain.player.entities.GameRecord;
import com.buildingblocks.challenges.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Player extends AggregateRoot<PlayerId> {
    private NickName nickName;
    private List<GameRecord> gameRecord;
    private Deque<Card> hand;

    // region Constructors

    public Player() {
        super(new PlayerId());
        this.gameRecord = new ArrayList<>();
        this.hand = new ArrayDeque<>();
    }

    private Player(PlayerId identity) {
        super(identity);
    }

    // endregion

    // region Getters and Setters

    public NickName getNickName() {
        return nickName;
    }

    public void setNickName(NickName nickName) {
        this.nickName = nickName;
    }

    public List<GameRecord> getGameRecord() {
        return gameRecord;
    }

    public void setGameRecord(List<GameRecord> gameRecord) {
        this.gameRecord = gameRecord;
    }

    public Deque<Card> getHand() {
        return hand;
    }

    public void setHand(Deque<Card> hand) {
        this.hand = hand;
    }


    // endregion

    // region Domain Events



    // endregion

    // region Public methods


    // endregion

    // region Private methods

    // endregion


    public static Player from(final String identity, final List<DomainEvent> events) {
        Player player = new Player(PlayerId.of(identity));
        events.forEach(player::apply);
        player.markEventsAsCommitted();
        return player;
    }
}