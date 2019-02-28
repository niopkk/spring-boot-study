package com.bbz.core.service.impl;

import com.bbz.core.entity.BrokerMessageLog;
import com.bbz.core.repository.BrokerMessageLogRepository;
import com.bbz.core.service.BrokerMessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerMessageLogServiceImpl implements BrokerMessageLogService {

    @Autowired
    private BrokerMessageLogRepository brokerMessageLogRepository;

    @Override
    public void saveBrokerMessageLog(BrokerMessageLog bml) {
        brokerMessageLogRepository.save(bml);
    }

    @Override
    public BrokerMessageLog findByMessageId(String messageId) {
        return brokerMessageLogRepository.findByMessageId(messageId);
    }

    @Override
    public List<BrokerMessageLog> findByStatusAndNextRetry(String status, long nowTime) {
        return brokerMessageLogRepository.findAll((Specification<BrokerMessageLog>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("status").as(String.class), status));
            predicates.add(builder.lt(root.get("nextRetry").as(Long.class), nowTime));
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        });

    }


}
