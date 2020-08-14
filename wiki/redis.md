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

