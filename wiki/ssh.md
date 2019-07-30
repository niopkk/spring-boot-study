### Windows客户端配置ssh免密登录
1、先在Windows客户端生成私钥要公钥文件,默认执行即可 `ssh-keygen` 保存在用户目录 ~/ssh目录下面</br>

2、.ssh下在新建一个config文件里面内容为 
```
host  104.245.43.165
user root
hostname  104.245.43.165
port 29427
identityfile  C:/Users/TH/.ssh/id_rsa
```
3、将公钥copy到服务器`scp -P 29427 id_rsa.pub root@104.245.43.165:/root/.ssh/ ` </br>

4、服务器端的操作
```
 touch authorized_keys #创建公钥keys文件

 cat id_rsa.pub >> authorized_keys #将公钥字符串追加拷贝到改文件

 chmod 600 authorized_keys   #修改文件权限

 cd ..

 chmod 700 .ssh #修改文件夹权限
```
5、配置ssh文件
  ```
   vi /etc/ssh/sshd_config #对sshd_config文件做如下修改

   RSAAuthentication yes
   
   PubkeyAuthentication yes
   
   PermitRootLogin yes
  ```
6、重启ssh服务 
 ```
    centos6: systemctl restart sshd.service  
    centos7: service sshd restart 
  ```   
  第二步可以忽略
 