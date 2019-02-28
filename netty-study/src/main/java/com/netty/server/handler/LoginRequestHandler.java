package com.netty.server.handler;

import com.netty.protocol.request.LoginRequestPacket;
import com.netty.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            System.out.println("校验成功！");
            loginResponsePacket.setSuccess(true);
        } else {
            System.out.println("校验失败!");
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("校验失败!");
        }
       ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
