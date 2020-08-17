package com.bbz.service;

public interface UserService {

    void checkToken(String token);

    /**
     * @param token
     * @param userId
     * @param item   浏览的商品
     */
    void updateToken(String token, String userId, String item);

    void cleanSessions();
}
