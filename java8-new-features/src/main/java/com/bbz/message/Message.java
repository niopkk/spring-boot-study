package com.bbz.message;

import com.bbz.util.Dates;
import com.bbz.util.Https;

import java.util.HashMap;
import java.util.Map;

public class Message {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap();

        map.put("send_captcha", "16626263159");
        Long unixNow = Dates.unixNow();
        String url = String.format("http://passport.baicizhan.com/rpc/unified_user_service/send_captcha/%s", Dates.unixNow());
        Https.getInstance()
                .post(url, map, unixNow.toString());

    }
}
