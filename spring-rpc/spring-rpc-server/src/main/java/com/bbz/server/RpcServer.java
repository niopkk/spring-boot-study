package com.bbz.server;

import java.io.IOException;

public interface RpcServer {
    void stop();

    void start() throws IOException;

    void register(Class<?> serviceInterface, Class<?> impl);

    boolean isRunning();

    int getPort();
}
