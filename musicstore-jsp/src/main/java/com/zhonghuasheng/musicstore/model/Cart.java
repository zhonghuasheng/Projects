package com.zhonghuasheng.musicstore.model;

import java.util.UUID;

public class Cart extends BaseModel {

    private UUID userUuid;
    private UUID musicUuid;

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public UUID getMusicUuid() {
        return musicUuid;
    }

    public void setMusicUuid(UUID musicUuid) {
        this.musicUuid = musicUuid;
    }
}
