package com.bbz.ioc.step06.beans.io;

import java.io.InputStream;

public interface Resource {

    InputStream getInputStream() throws Exception;

}
