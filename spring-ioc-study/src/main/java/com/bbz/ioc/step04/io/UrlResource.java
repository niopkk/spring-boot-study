package com.bbz.ioc.step04.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        //1、创建URLConnection对象
        URLConnection urlConnection = url.openConnection();
        //2、建立连接
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
