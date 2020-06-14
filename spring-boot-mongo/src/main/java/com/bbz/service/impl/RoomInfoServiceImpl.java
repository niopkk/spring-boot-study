package com.bbz.service.impl;

import com.bbz.model.RoomInfo;
import com.bbz.repository.RoomInfoRepository;
import com.bbz.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomInfoServiceImpl implements RoomInfoService {

    @Autowired
    private RoomInfoRepository roomInfoRepository;


    @Override
    public RoomInfo save(RoomInfo roomInfo) {
        return roomInfoRepository.save(roomInfo);
    }
}
