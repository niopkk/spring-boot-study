package com.bbz.ioc.step05.io;

import java.net.URL;

public class ResourceLoader {

    public Resource getResource(String local) {
        URL resource = this.getClass().getClassLoader().getResource(local);
        return new UrlResource(resource);
    }
}
