package com.bbz.中介模式Data应用;

/**
 * com.bbz.中介模式Data应用
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public abstract class AbstractDatabase {


    public static final String MYSQL = "mysql";
    public static final String REDIS = "redis";
    public static final String ELASTICSEARCH = "elasticsearch";

    protected AbstractMediator mediator;

    public AbstractDatabase(AbstractMediator mediator) {
        this.mediator = mediator;
    }


    public abstract void addData(String data);

    public abstract void add(String data);

}
