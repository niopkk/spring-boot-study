# docker命令

列出所有容器ID：`docker ps -aq` 

查看所有运行和没有运行的容器: `docker ps -a`  

停止所有container(容器) ：`docker stop $(docker ps -a -q)` 或 `docker stop $(docker ps -aq)`

删除所有的container(容器)`docker rm $(docker ps -a -q)`或 `docker rm $(docker ps -aq)`

拉取images(镜像):`docker pull <iamges>`

查看有哪些images(镜像):`docker images`

查看images(镜像)的详细信息: `docker inspect <image id>` 

删除images(镜像),通过image的ID或REPOSITORY: `docker rmi <image id>`

删除全部images(镜像): `docker rmi $(docker images -q)` 

强制删除全部images: `docker rmi -f $(docker images -q)`

从容器到宿主机复制：

```
docker cp tomcat：/webapps/js/text.js /home/admin
docker cp 容器名:  容器路径       宿主机路径  
```

从宿主机到容器复制:

```
docker cp /home/admin/text.js tomcat：/webapps/js
docker cp 宿主路径中文件      容器名  容器路径   
```

删除所有停止的container(容器):  `docker container prune `

删除所有不使用的images(镜像): `docker image prune --force --all `或 `docker image prune -f -a `

```
docker stop <container(容器名或ID)> 停止
docker start <container(容器名或ID)> 启动
docker kill  <container(容器名或ID)> 杀死
docker restart <container(容器名或ID)> 重启
```

docker进入容器，查看配置文件

 ```
docker exec :在运行的容器中执行命令
         -d:分离模式:在后台运行
         -i:即使没有附加也保持STDIN(标准输入)打开，以交互模式运行容器，通常与-t 同时使用
         -t:为容器重新分配一个伪终端，通常与-i同时使用
如：docker exec -it adfd /bin/bash
 ```

