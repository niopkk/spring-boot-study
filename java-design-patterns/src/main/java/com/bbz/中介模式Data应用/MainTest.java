package com.bbz.中介模式Data应用;

import com.bbz.中介模式Data应用.support.EsDatabase;
import com.bbz.中介模式Data应用.support.MySqlDatabase;
import com.bbz.中介模式Data应用.support.RedisDatabase;
import com.bbz.中介模式Data应用.support.SyncMediator;

/**
 * com.bbz.中介模式Data应用
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class MainTest {

    public static void main(String[] args) {
        AbstractMediator syncMediator = new SyncMediator();
        MySqlDatabase mysqlDatabase = new MySqlDatabase(syncMediator);
        RedisDatabase redisDatabase = new RedisDatabase(syncMediator);
        EsDatabase esDatabase = new EsDatabase(syncMediator);

        syncMediator.setMySqlDatabase(mysqlDatabase);
        syncMediator.setRedisDatabase(redisDatabase);
        syncMediator.setEsDatabase(esDatabase);

        System.out.println("\n---------mysql 添加数据 1，将同步到Redis和ES中-----------");
        mysqlDatabase.add("1");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------Redis添加数据 2，将不同步到其它数据库-----------");
        redisDatabase.add("2");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------ES 添加数据 3，只同步到 Mysql-----------");
        esDatabase.add("3");
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();



    }
}
