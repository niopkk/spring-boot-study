package com.netty.protocol.response;


import com.netty.protocol.Packet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.netty.protocol.command.Command.LOGIN_RESPONSE;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
