package com.netty.protocol.response;

import com.netty.protocol.Packet;
import lombok.Data;

import static com.netty.protocol.command.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {


    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
