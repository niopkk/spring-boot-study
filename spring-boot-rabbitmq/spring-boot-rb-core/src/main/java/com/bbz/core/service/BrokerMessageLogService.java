package com.bbz.core.service;


import com.bbz.core.entity.BrokerMessageLog;

import java.util.List;

public interface BrokerMessageLogService {

    void saveBrokerMessageLog(BrokerMessageLog bml);

    BrokerMessageLog findByMessageId(String messageId);

    List<BrokerMessageLog> findByStatusAndNextRetry(String status, long nextRetry);
}
