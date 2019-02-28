package com.bbz.core.entity;


import javax.persistence.*;

@Entity
@Table(name = "broker_message_log")
public class BrokerMessageLog {

    /**
     * 消息id
     */
    @Id
    @Column(name = "message_id")
    private String messageId;

    /**
     * 消息体
     */
    @Column(name = "message")
    private String message;

    /**
     * 重试次数
     */
    @Column(name = "try_count")
    private Integer tryCount;

    /**
     * 消息状态
     */
    @Column(name = "status")
    private String status;

    /**
     * 重试时间
     */
    @Column(name = "next_retry")
    private Long nextRetry;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Long updateTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getNextRetry() {
        return nextRetry;
    }

    public void setNextRetry(Long nextRetry) {
        this.nextRetry = nextRetry;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
