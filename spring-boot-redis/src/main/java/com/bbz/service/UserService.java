package com.bbz.service;

import java.util.Map;

public interface UserService {

    Map<String, Object> checkToken(String token);

    /**
     * @param token
     * @param userId
     * @param item   浏览的商品
     */
    void updateToken(String token, String userId, String item);

    void cleanSessions();
}
