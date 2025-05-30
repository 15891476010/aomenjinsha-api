package com.youlai.boot.index.model.query;

import lombok.Data;

@Data
public class EbUserGameBalanceQuery {
    private String player_id;
    private String currency;
    private String timestamp;
    private String sign;
}
