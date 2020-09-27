### rabbitMq 安装
 `https://ken.io/note/centos7-erlang-install`
 `https://ken.io/note/centos7-rabbitmq-install-setup`
 
```下载redis 
docker serarch rabbitmq

docker pull rabbitmq

docker run -d -p 5672:5672 -p 15671:15672 --name rabbitmq rabbitmq


docker exec -it rabbitmq /bin/bash
rabbitmq-plugins enable rabbitmq_management //安装网页管理页面

web访问端口号 ip:15671打开管理页面
```