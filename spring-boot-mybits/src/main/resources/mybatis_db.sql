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