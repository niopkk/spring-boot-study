package com.bbz.ioc.step06.beans.io;

import java.net.URL;

public class LoaderResource {


    public Resource getResource(String local) {
        URL resource = this.getClass().getClassLoader().getResource(local);
        return new UrlResource(resource);
    }
}
