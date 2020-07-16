create table order_item
(
    id          int auto_increment
        primary key,
    order_id    varchar(50) null,
    unit_price  bigint  null,
    create_time bigint  null
)
    charset = utf8;

create table product_order
(
    id          int auto_increment
        primary key,
    name        varchar(50) null,
    order_no    varchar(30) null,
    total_price bigint  null,
    pay_type    int         null,
    create_time bigint  null
)
    charset = utf8;



create table sys_user
(
    id          int auto_increment primary key comment '主键自增',
    `name`      varchar(50) comment '用户名',
    account     varchar(50)   not null comment '账号',
    pass_word   varchar(50)   not null comment '密码',
    status      int default 0 comment '账号状态 0 启用,1 禁用',
    login_time  bigint        null comment '登陆时间',
    create_time bigint        not null comment '创建时间',
    modify_time bigint        null comment '修改时间',
    is_deleted   int default 0 not null comment ''
) char set = 'utf8mb4';
create table sys_role
(
    id          int auto_increment primary key comment '主键自增',
    `name`      varchar(50) comment '角色名称',
    create_time bigint        not null comment '创建时间',
    modify_time bigint        null comment '修改时间',
    is_deleted   int default 0 not null comment ''
) charset = 'utf8mb4';
create table sys_permissions
(
    id          int auto_increment primary key comment '主键自增',
    `name`      varchar(50) comment '权限名称',
    `url`       varchar(150) comment '链接',
    pid         int default 0 comment '父级节点',
    create_time bigint        not null comment '创建时间',
    modify_time bigint        null comment '修改时间',
    is_deleted   int default 0 not null comment ''
) charset = 'utf8mb4';

create table sys_role_permissions
(
    id          int auto_increment primary key comment '主键自增',
    role_id int comment '角色id',
    permissions_id int comment '权限id'
)charset = 'utf8mb4';

create table sys_user_role
(
    id          int auto_increment primary key comment '主键自增',
    user_id int comment '用户id',
    role_id int comment '角色id'
)charset = 'utf8mb4';
