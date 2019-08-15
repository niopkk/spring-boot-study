package com.bbz.中介模式Data应用.support;

import com.bbz.中介模式Data应用.AbstractDatabase;
import com.bbz.中介模式Data应用.AbstractMediator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * com.bbz.中介模式Data应用.support
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class EsDatabase extends AbstractDatabase {

    private List<String> dataset = new CopyOnWriteArrayList<>();

    public EsDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.mediator.sync(AbstractDatabase.ELASTICSEARCH, data);
    }

    public void count() {
        int count = this.dataset.size();
        System.out.println("Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }

}
