# docker命令

列出所有容器ID：`docker ps -aq` 

查看所有运行和没有运行的容器: `docker ps -a`  

停止所有container(容器) ：`docker stop $(docker ps -a -q)` 或 `docker stop $(docker ps -aq)`

删除所有的container(容器)`docker rm $(docker ps -a -q)`或 `docker rm $(docker ps -aq)`

删除所有的停止的容器container(容器) `docker container prune`


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
docker日志查看
```
docker logs -f [容器名称或id] 读取最新日志
docker logs --tail 10 [容器名称或id] 查看最后10行日志
docker logs --tail 0 -f [容器名称或id] 跟踪容器的最新日志不读取整个文件
```
docker查看容器内进程
```
docker top [容器名称]
```

docker run   -d 后台运行   -p 指定映射IP或端口


数据卷:是提供给容器使用的特殊目录,它将主机操作系统目录直接映射进容器。
特性如下:  
 1. 数据卷可以在容器之间共享和重用,容器间传递数据将变的高效和方便。
 2. 对数据卷内的数据修改将会立马生效,无论在容器内修改还是在容器外修改。
 3. 对数据卷的修改不会影响到镜像,解偶应用和数据。
 4. 卷会一直存在，直到没有容器使用,可以安全的卸载它。

##### 创建数据卷
docker提供volume子命令来管理创建数据卷: ``docker volume create -d local  test`` 查看 ``ls -l /var/lib/docker/volumes``
除了create命令 volume还支持inspect(查看详细信息)、ls(列出已有数据卷)、prune(清理无用数据卷)、rm(删除数据卷)。
##### 绑定数据卷
除了使用volume子命令管理数据卷,还可以在创建容器时将主机的任意路径挂载到容器内作为数据卷，称之为绑定数据卷.  
使用docker container run 命令的时候可以使用 --mount选项来使用数据卷。  
--mount支持三种选项的数据卷:
1. volume:普通数据卷，映射到主机 ``/var/lib/docker/volume``.
2. bind:绑定数据卷，映射到主机指定目录下.
3. tmpfs:临时数据卷,只存在内存中.

