package com.bbz.中介模式Data应用;

import com.bbz.中介模式Data应用.support.EsDatabase;
import com.bbz.中介模式Data应用.support.MySqlDatabase;
import com.bbz.中介模式Data应用.support.RedisDatabase;

/**
 * com.bbz.中介模式Data应用
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public abstract class AbstractMediator {

    protected MySqlDatabase mySqlDatabase;

    protected RedisDatabase redisDatabase;

    protected EsDatabase esDatabase;

    public void setMySqlDatabase(MySqlDatabase mySqlDatabase) {
        this.mySqlDatabase = mySqlDatabase;
    }

    public void setRedisDatabase(RedisDatabase redisDatabase) {
        this.redisDatabase = redisDatabase;
    }

    public void setEsDatabase(EsDatabase esDatabase) {
        this.esDatabase = esDatabase;
    }


    public abstract void sync(String databaseName, String data);
}
