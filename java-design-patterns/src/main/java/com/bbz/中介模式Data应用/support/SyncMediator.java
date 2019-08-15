package com.bbz.中介模式Data应用.support;

import com.bbz.中介模式Data应用.AbstractDatabase;
import com.bbz.中介模式Data应用.AbstractMediator;

/**
 * com.bbz.中介模式Data应用.support
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class SyncMediator extends AbstractMediator {



    @Override
    public void sync(String databaseName, String data) {
        if (databaseName.equals(AbstractDatabase.MYSQL)) {

            this.redisDatabase.addData(data);
            this.esDatabase.addData(data);
        } else if (databaseName.equals(AbstractDatabase.REDIS)) {

        } else if (databaseName.equals(AbstractDatabase.ELASTICSEARCH)) {
            this.mySqlDatabase.addData(data);
        }
    }
}
