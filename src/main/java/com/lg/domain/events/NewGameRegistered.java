package com.lg.domain.events;

import java.util.UUID;

public class NewGameRegistered implements DomainEvent {
    private String gameId;
    private UUID playerId;

    public NewGameRegistered(String gameId, UUID playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public String getGameId() {
        return gameId;
    }

    public UUID getPlayerId() {
        return playerId;
    }
}
