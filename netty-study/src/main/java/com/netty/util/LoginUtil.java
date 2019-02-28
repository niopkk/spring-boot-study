package com.netty.util;

import com.netty.protocol.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

public class LoginUtil {

    public static void makerAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static Boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return loginAttr.get() != null;
    }

}
