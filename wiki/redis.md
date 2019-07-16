docker中安装redis
```下载redis 
docker pull redis:指定版本

运行redis
docker run -d -p 6379:6379 --name redis redis

进入docker容器 执行redis命令
docker exec -it redis redis-cli
```