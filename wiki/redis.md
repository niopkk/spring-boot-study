docker中安装redis
```下载redis 
docker pull redis:指定版本

运行redis
docker run -d -p 6379:6379 --name redis redis

进入docker容器 执行redis命令
docker exec -it redis redis-cli
```

#### String

```java
//设置存储在给定键中的值
set 语法 set key value 例：set hello word 将key 设置为hello 值为 value
//获取存储在给定键中的值
get 语法 key value 例：get hello 获取key 为hello的值 返回得到的值为 word
//删除给定键中的值
del 语法 key 例:del hello 
//将存储的值加上1
incr 例：incr key-name 
//将存储的值减1  
decr 例: decr key-name
//将键存储的值减去整数amount
decrby 例:decrby key-name amount
//将键存储的值加上浮点数 amount
incrbyfloat 例: incrbyfloat key-name amount    

```

#### List

```java
//将给定的值推入列表右端
rpush 语法 rpush key value 例 rpush list-key item 设置key为list-key 
//获取列表在给定范围上的所有值
lrange lrange key 0,-1 取出所有的值 例:lrange list-key 0,-1
//获取列表在给定位置上的单个元素
lindex 语法 lindex key index(索引) 例 lindex key 0
//左边弹出一个值
lpop 语法 lpop key 例 lpop list-key 返回得到 item
```

#### Set

```java
//集合添加值
sadd: sadd set-key item 返回1表示添加成功
//获取set中的所有值
smembers :smembers set-key
//检查一个元素是否存在于集合中
sismember:sismember set-key item 返回1表示存在
//移除集合中的元素
srem:srem set-key item
```

#### Hash

```java
//散列里面添加对象(k,v)
hset 在散列里面关联起给定的键值对 例:hset hash-key sub-key1 value
//根据key 获取对象
hget 获取指定散列键的值  hget hash-key sub-key1 得到 value
//获取全部
hgetall hash-key 得到hash-key的所有值
//移除散列里面的某个键
hdel 例 hdel hash-key sub-key1  
 
```

#### ZSET

```java
//将一个带有给定分值的成员添加到有序集合里面
zadd 例 zadd zset-key 728 member1 ,zadd zset-key 987 member0
//根据元素在有序排列中所处的位置，从有序集合中获取多个元素
zrange 例: zrange zset-key 0 -1 withscores(加上显示分值score)
//获取有序列表在给定分值范围内的所有元素
zrangebyscore 例:zrangebyscore zset-key 0 800 
//如果给定成员存在于有序集合，那么移除这个成员
zrem 例: zrem zset-key member0
```

#### 持久化配置

```java
//快照持久化配置
save 60 1000
stop-writes-on-bgsave-error no
bdbcompression yes
dbfilename dump.rdb
//aof持久化
appendonly no
appendfsync everysec
no-appendfsync-on-rewrite no
auto-aof-rewrite-percentage 100
auto-aof-wewrite-min-size 64mb
  
dir ./ 共享选项，这个选项决定了快照文件和aof文件的保存位置
```

