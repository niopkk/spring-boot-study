package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import com.bbz.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redpacket")
public class RedPacketController extends BaseController {

    @Autowired
    private RedPacketService redPacketService;

    @RequestMapping("/rob")
    public ResultView rob(@RequestParam(value = "redid") Long redId,
                          @RequestParam(value = "userId") Long userId) {
        return okResult("1111", redPacketService.rob(redId, userId));
    }


    @RequestMapping("/setRedPacket")
    public ResultView setRedPacket(@RequestParam(value = "total") Integer total,
                                   @RequestParam(value = "count") Integer count) {
        return okResult("222", redPacketService.setRedPacket(total, count));
    }

}
