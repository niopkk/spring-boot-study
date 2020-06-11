#### getResource 加载文件

.getClass().getClassLoader().getResource()和.getClass().getResource()的区别

this.getClass().getResource(fileName)：表示**只会在当前调用类所在的同一路径下**查找该fileName文件。

 this.getClass().getClassLoader().getResource(fileName)：表示**只会在根目录下**查找改文件

fileName如果是前面加"/",如“/fileName”,则表示绝对路径，取/目录下的改文件；如果是前面没用加"/",如“fileName”，则表示相对路径，取与调用类同一路径下的改文件。

如果路径中**包含包名**，getClass().getResource("com/**/fileName");包名的层级使用"/"隔开。

```java
public class MainTest {


    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {


        //默认为全路径名
        new MainTest().getResources("1.txt");

        //fileName：
        //  ClassLoader:根目录为 target/classes/
        // fileName 前面加 / 报错 原因：改变了 / 根目录 绝对路径
        new MainTest().getClassLoaderResources("/com/bbz/resource/2.txt");


    }

    public void getResources(String fileName) throws IOException {
        //fileName：
        //  1、前面加 / 表示绝对路径,在 /(根)目录下查找文件。如-> /1.txt
        //  2、没加 / 或者 ./  表示相对路径在当前类路径下面查询文件，如->./com/bbz/resource/1.txt
        System.out.println(this.getClass().getResource(fileName).getPath());
        URL url =this.getClass().getResource(fileName);
        properties.load(url.openStream());

        System.out.println(properties.getProperty("key"));
    }
    public void getClassLoaderResources(String fileName) throws IOException {
        //getClassLoader() 表示在 /(根) 目录下查找文件,路径如——> /1.txt
        //如果文件在包下面还要自己去加上包的路径，路径如——> com/bbz/resource/1.txt
        System.out.println(this.getClass().getClassLoader().getResource(fileName).getPath());
        URL url =this.getClass().getClassLoader().getResource(fileName);
        properties.load(url.openStream());

        System.out.println(properties.getProperty("key"));
    }

```