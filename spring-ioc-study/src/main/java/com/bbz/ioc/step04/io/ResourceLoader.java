package com.bbz.ioc.step04.io;

import java.net.URL;

public class ResourceLoader {

    public Resource getResouce(String location) {
        if (location.startsWith("/")) {
//            return new FileResource(location.getBytes())
            return null;
        } else {
            URL resource = this.getClass().getClassLoader().getResource(location);
            return new UrlResource(resource);
        }
    }
}
