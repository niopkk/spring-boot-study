package com.bbz.ioc.step05.io;

import com.bbz.ioc.step04.io.Resource;
import com.bbz.ioc.step04.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        ResourceLoader resource=new ResourceLoader();
        Resource resouce = resource.getResouce("application.xml");
        InputStream inputStream = resouce.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
