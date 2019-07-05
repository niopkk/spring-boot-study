package com.bbz.designtest.model;

/**
 * com.bbz.designtest.model
 * <p>
 * Created by tianxin2 on 2019-07-04
 */
public class FetchJob {


    /**
     * 状态
     */
    public enum Status {

        /**
         * 新创建
         */
        CREATED,


        /**
         * 正在运行
         */
        RUNNING,

        /**
         * 完成
         */
        COMPLETED,

        /**
         * 取消
         */
        CANCELED,

    }

    private long createTime = System.currentTimeMillis();


    private String type;


    /**
     * 保存点时间
     */
    private long savepointTime;


    /**
     * 保存点序列
     */
    private int savepointSequence;

    /**
     * 任务开始时间
     */
    private long startTime;


    /**
     * 任务截止时间
     */
    private long endTime;


    /**
     * 时间轴结束时间
     */
    private long finishTime;

    /**
     * 切片大小
     */
    private long slice;

    /**
     * 状态
     */
    private Status status = Status.CREATED;


    /**
     * 记录总数
     */
    private long total;


    /**
     * 任务描述
     */
    private String description;


    /**
     * 是否删除
     */
    private boolean deleted;


    /**
     * 是否实时任务
     */
    private boolean realtime;

    /**
     * 实时任务的偏移量(ms),防止获取到当前时间时却没有数据
     */
    private long realtimeOffset;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSavepointTime() {
        return savepointTime;
    }

    public void setSavepointTime(long savepointTime) {
        this.savepointTime = savepointTime;
    }

    public int getSavepointSequence() {
        return savepointSequence;
    }

    public void setSavepointSequence(int savepointSequence) {
        this.savepointSequence = savepointSequence;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public long getSlice() {
        return slice;
    }

    public void setSlice(long slice) {
        this.slice = slice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isRealtime() {
        return realtime;
    }

    public void setRealtime(boolean realtime) {
        this.realtime = realtime;
    }

    public long getRealtimeOffset() {
        return realtimeOffset;
    }

    public void setRealtimeOffset(long realtimeOffset) {
        this.realtimeOffset = realtimeOffset;
    }

    @Override
    public String toString() {
        return "FetchJob{" +
                "createTime=" + createTime +
                ", type='" + type + '\'' +
                ", savepointTime=" + savepointTime +
                ", savepointSequence=" + savepointSequence +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", finishTime=" + finishTime +
                ", slice=" + slice +
                ", status=" + status +
                ", total=" + total +
                ", description='" + description + '\'' +
                ", deleted=" + deleted +
                ", realtime=" + realtime +
                ", realtimeOffset=" + realtimeOffset +
                '}';
    }
}
