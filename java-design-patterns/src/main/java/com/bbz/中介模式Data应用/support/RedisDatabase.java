package com.bbz.中介模式Data应用.support;

import com.bbz.中介模式Data应用.AbstractDatabase;
import com.bbz.中介模式Data应用.AbstractMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * com.bbz.中介模式Data应用.support
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class RedisDatabase extends AbstractDatabase {

    private List<String> dataset = new ArrayList<>();

    public RedisDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.mediator.sync(AbstractDatabase.REDIS, data);
    }
    public void cache() {
        System.out.println("Redis 缓存的数据：" + this.dataset.toString());
    }
}
