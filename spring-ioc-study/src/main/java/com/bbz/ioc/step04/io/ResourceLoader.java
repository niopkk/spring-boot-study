package com.bbz.ioc.step04.io;

import java.net.URL;

public class ResourceLoader {

    public Resource getResouce(String local) {
        URL resource = this.getClass().getClassLoader().getResource(local);
        return new UrlResource(resource);
    }
}
