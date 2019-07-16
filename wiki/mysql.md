###centons 7 安装mysql

1. 首先进入本机的源文件目录
`cd /usr/local/src`
2. 使用wget下载官方yum源的rpm包：
`wget https://dev.mysql.com/get/mysql57-community-release-el7-11.noarch.rpm`
3. 安装rpm包：
`rpm -ivh mysql57-community-release-el7-11.noarch.rpm`
4. 再次使用yum来安装mysql-server:
`yum install -y mysql-server`
可以看到这次不再提示安装Mariadb了

5. 安装完成后，启动mysqld服务：
`systemctl start mysqld`
查看是否成功启动：
`ps aux|grep mysqld`
6. 设置mysqld服务开机自启动：
`systemctl enable mysqld`
7. 使用初始密码登录
由于MySQL从5.7开始不允许首次安装后，使用空密码进行登录，系统会随机生成一个密码以供管理员首次登录使用，这个密码记录在/var/log/mysqld.log文件中，使用下面的命令可以查看此密码：

`cat /var/log/mysqld.log|grep 'A temporary password'`
2019-07-15T06:26:01.775304Z 1 [Note] A temporary password is generated for root@localhost: ylevgX:Dc9ci就是初始密码。 
使用此密码登录MySQL:
`mysql -u root -p`
8. 更改默认密码：
切换数据库：
`use mysql;`
修改root密码：
`alter user 'root'@'localhost' identified by 'your_password';`
将your_password替换成你自己的密码就可以了，当然，这个密码是强密码，要求密码包含大小写字母、数字及标点符号，长度应该在6位以上。 
重新使用新的密码登录，如果可以正常登录说明你的MySQL已经成功安装在CentOS 7.4上了

密码强制验证去除
`set global validate_password_policy=0;
 set global validate_password_length=1;`
 远程链接
 `update user set host = '%' where user = 'root';`
