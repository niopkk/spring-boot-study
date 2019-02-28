package com.netty.protocol.request;

import com.netty.protocol.Packet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.netty.protocol.command.Command.LOGIN_REQUEST;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginRequestPacket extends Packet {


    private String userId;

    private String userName;

    private String password;


    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
