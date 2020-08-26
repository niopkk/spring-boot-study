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

#### 事务

```java
watch:监控key的值是否修改
multi: 服务器返回ok 表示开启事务 
exec: 执行命令 配合multi一起使用

```

#### 数据持久化

redis提供两种不同的持久化方法来将数据存储到硬盘的里面，一种方法叫快照，它可以将在与某一时刻的所有数据写入硬盘。另一种方法叫只追加文件(append-only-file)AOP,它会在执行写命令时，将被执行的写命令复制到硬盘里面。这两种方法既可以单独使用，也可以同时使用。

##### 创建快照的方法：

1. 客户端通过redis 发送bgsave命令创建一个快照，redis会调用fork来创建一个子进程，然后子进程负责将数据写入硬盘，而父进程则继续处理命令请求。
2. 客户端通过redis发送save命令创建快照，接到save命令的redis的服务器在快照创建完毕之前不会响应任何其他命令，只有在哪有足够内存的情况下才会使用这个命令。
3. 在配置文件快照配置部分配置选项 如save 60 10000 ,那么从redis 最近一次创建快照的时间算起，当60秒之内有10000次写入条件满足时，redis 就会自动触发bgsave命令。可以配置多个save 满足其中一个即可触发bgsave.
4. Redis通过shutdown命令接收到关闭服务器的请求时，或者接收到标准term信号时，会执行一个save命令，阻塞所有客户端，不在执行客户端发送的任何命令，并在save命令执行完毕之后关闭服务器
5. 当redis服务器连接另一个redis服务器，并向对方发送sync命令来开始一次复制操作的时候，如果主服务器目前没有在执行bgsave操作，或者主服务器并非刚刚执行完bgsave操作，那么主服务器就会执行bgsave命令。

对于大数据量时 bgsave创建子进程耗费时间也会越来越多，如果占有内存多达数十个GB，并且剩余空闲内存并不多，执行bgsave可能照成系统长时间的停顿。

为了防止redis创建子进程而出现的停顿，可以考虑关闭自动保存，转为 手动发送save或者bgsave来进行持久化。bgsave也可以造成系统停顿，唯一不同的是可以通过发送命令来控制停顿出现的时间，save会一直阻塞redis快照生成完毕，但不需要进行创建子进程，所以save创建快照的速度比bgsave创建快照更快。

#### AOF持久化

aof持久化会将被执行的写命令写到aof文件的末尾，以此记录数据发生的变化。



| 选项     | 同步频率                                                   |
| -------- | ---------------------------------------------------------- |
| always   | 每个redis写命令都要同步写入硬盘。这样会严重降低redis的速度 |
| everysec | 每秒执行一次同步，显示的将多个写命令同步到硬盘             |
| no       | 让操作系统来决定何时进行同步                               |

如何解决redis的aof文件不断增大，通过发送***<u>bgrewriteaof</u>***命令，重写aof文件，使aof文件的体积变的尽可能小。

bgrewriteaof的工作原理和bgsave相识，都是由redis创建一个子进程，然后由子进程负责对aof文件进行重写。快照持久化因为创建子进程而导致性能问题和内存占用问题,在aof持久化中也同样存在，如果不加以控制的话，aof文件的体积比快照的文件体积还有大好几倍.

所以aof持久化也可以通过设置：

auto-aof-rewrite-percentage和auto-of-rewrite-min-size选项来自动执行bgrewriteaof.

如:auto-aof-rewrite-percentage:100  auto-of-rewrite-min-size:64mb 那么当aof文件的体积大于64mb并且aof文件的体积比上一次重写之后的体积至少大了一倍(100%)的时候redis将会

执行***<u>bgrewriteaof</u>***命令。

#### 复制

命令:slaveof host port 命令来让服务器开始复制一个新的主服务器。