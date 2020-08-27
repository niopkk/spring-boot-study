package com.bbz.service;

public interface RedPacketService {

    int rob(long redid, long userId);

    long setRedPacket(int total, int count);
}
