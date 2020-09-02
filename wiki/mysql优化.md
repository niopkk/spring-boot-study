### mysql优化

#### 什么是索引？

mysql官方对索引的定义为:索引(index)帮助mysql高效获取数据的数据结构。

本质:索引是数据结构，可以简单理解为 ***排好序的快速查找数据结构***

##### 索引优缺点

优点:

1.  可以提高数据检索的效率，降低数据库的io成本。
2.  通过索引列对数据进行排序，降低数据排序的成本，降低cpu的消化。

缺点:

1. 虽然索引大大提高了查询速度，但同时也会降低更新表的速度，如对表进行insert、update、delete。因为更新表时，不仅要保存数据，还要保存一下索引文件每次更新添加了索引列的字段，都会调整因为更新所带来的键值变化后的索引信息。
2. 索引实际也是一张表，该表保存了主键与索引字段，并指向实体表的记录，所以索引

列也是要占用空间。

##### 索引分类

######单值索引

概念:即一个索引只包含单个列，一个表可以有多个单列索引。

```sql
create index index_name on table_name on(col_1)
```

###### 唯一索引

概念:索引列的值必须唯一，单允许有空值

```sql
create unique index index_name on table_name on (col_1)
```

###### 主键索引

设定主键后数据库会自动建立索引，innodb为聚簇索引。

###### 复合索引

即一个索引包含多个列

```sql
create index index_name on table_name on (col_1,col_2)
```

######索引其它命令

```sql
删除:drop index index_name on talbe_name
查看:show index form talbe_name
alter Table talbe_name add primary key (col_1) 添加主键 索引必须是唯一，且不能为null
alter Table table_name add INDEX index_name(col_1) 添加普通索引，索引值可多次出现。
alter Table table_name FULLText index_name(col_1) 该语句指定了索引为fulltext,用于全文索引
```

##### 索引创建的时机

1. 主键自动建立唯一索引
2. 频繁作为查询条件的字段应该创建索引
3. 查询中与其它表关联的字段，外键关系建立索引
4. 单键/组合索引的选择问题，组合索引性价比更高
5. 查询中的排序字段，排序字段若通过索引去访问将大大提高排序速度
6. 查询中统计或者分组字段

##### 不适合创建索引的情况

1. 表记录太少 （大概超过200万的数据）
2. 经常增删改的表或者字段
3. where条件用不到的字段不适合创建索引
4. 过滤性不好的不适合创建索引

##### explain 性能分析

![image-20200827145710873](/Users/tianxin2/tianxin/spring-boot-study/wiki/img/mysql/image-20200827145710873.png)

###### id

```sql
create table t1( id int(10) auto_increment,content varchar(100),primary key (id));
create table t2( id int(10) auto_increment,content varchar(100),primary key (id));
create table t3( id int(10) auto_increment,content varchar(100),primary key (id));
create table t4( id int(10) auto_increment,content varchar(100),primary key (id));

INSERT INTO t1(content) VALUES(CONCAT('t1_',FLOOR(1+RAND()*1000)));
INSERT INTO t2(content) VALUES(CONCAT('t2_',FLOOR(1+RAND()*1000)));
INSERT INTO t3(content) VALUES(CONCAT('t3_',FLOOR(1+RAND()*1000)));
INSERT INTO t4(content) VALUES(CONCAT('t4_',FLOOR(1+RAND()*1000)));
```

select 查询的序列号包含一组数字，表示查询中执行select子句或者操作表的顺序。

1. id相同执行顺序由上至下

<img src="/Users/tianxin2/tianxin/spring-boot-study/wiki/img/mysql/1598517765454.jpg" alt="1598517765454" style="zoom:33%;" />

2. id不同，如果是子查询，id的序号会递增，id值越大优先级越高，越先被执行。

3. 有相同也有不同，如果id相同，可以认为是一组，从上往下顺序执行；所在组中,id值越大，优先级越高越先执行，衍生表 =derived, 

   id号每个号码，表示一趟独立的查询，一个sql的查询越少越好

###### select_type

select_type 代表查询的类型，主要是用于区别普通查询、联合查询、子查询等复杂查询

| Select_type属性      | 含义                                                         |
| -------------------- | ------------------------------------------------------------ |
| simple               | 简单的select查询，查询中不包含子查询或者union                |
| primary              | 查询中若包含任何复杂的子部分，最外层查询则被标记为primary    |
| derived              | 在from列表查询中包含的子查询被标记为derived(衍生)，mysql会递归执行这些子查询，把结果放到临时表里。 |
| subquery             | 在select或where 列表中包含了子查询                           |
| depedent subquery    | 在select或where 列表中包含了子查询,子查询基于外层            |
| uncacheable subquery | 无法使用缓存的子查询                                         |
| union                | 若第二个select 出现在union之后，则被标记为union;若union包含在from子句的子查询中，外层select 将被标记为:derived |
| union result         | 从union表获取结果的select                                    |

###### table

这个数据基于那张表的

###### type

查询的访问类型，较为重要的一个指标，结果值从最好到最坏依次

system>const>eq_ref>ref>fulltext>ref_or_null>index_marge>unique_subquery>index_subquery>range>index>all,一般查询至少达到range级别，最好能达到ref.

###### Possible_keys

显示可能应用在这张表中的索引，一个或多个。查询涉及到的字段上若存在索引，则改索引被列出，但不一定被查询实际使用。

###### kye

使用使用的索引，如果为null,则没用使用索引。

