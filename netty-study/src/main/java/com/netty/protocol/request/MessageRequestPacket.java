package com.netty.protocol.request;

import com.netty.protocol.Packet;
import lombok.Data;

import static com.netty.protocol.command.Command.MESSAGE_REQUEST;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
