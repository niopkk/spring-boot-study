package com.bbz.core.repository;

import com.bbz.core.entity.BrokerMessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface BrokerMessageLogRepository extends JpaRepository<BrokerMessageLog, String>, JpaSpecificationExecutor<BrokerMessageLog>, Serializable {


    BrokerMessageLog findByMessageId(String messageId);

}
