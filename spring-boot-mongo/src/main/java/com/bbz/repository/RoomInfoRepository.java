package com.bbz.repository;

import com.bbz.model.RoomInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomInfoRepository extends MongoRepository<RoomInfo, String> {

}
