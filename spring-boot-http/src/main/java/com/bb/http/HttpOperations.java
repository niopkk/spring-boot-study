package com.bb.http;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * com.bb.http
 * <p>
 * Created by tianxin2 on 2019-09-04
 */
public interface HttpOperations {

    TrustManager[] ALWAYS_TRUST_MANAGERS = new TrustManager[]{new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
        }

        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }};

    void addDefaultHeader(String key, String value);

    void setDefaultHeaders(Map<String, String> headers);


    void cookie(Supplier<String[]> cookieSupplier);

    void logging(boolean enable);

    void connectionPool(int maxIdleConnections, int keepAliveSeconds);

    void setConnectionTimeout(int timeout, TimeUnit unit);


    void caching(Supplier<Boolean> offline, int maxStale, TimeUnit timeUnit);

    Map<String, String> getDefaultHeaders();


    abstract class HttpBuilderBase<I extends HttpOperations.HttpBuilderBase<I, R>, R extends HttpOperations> {

        protected R template = this.createTemplate();

        public HttpBuilderBase() {
        }

        protected abstract R createTemplate();

        protected abstract I getImplementor();

        public I header(String key, String value) {
            this.template.addDefaultHeader(key, value);
            return this.getImplementor();
        }

        public I loggin(boolean enableLoggin) {
            this.template.logging(enableLoggin);
            return this.getImplementor();
        }

        public I cookie(Supplier<String[]> cookieSupplier) {
            this.template.cookie(cookieSupplier);
            return this.getImplementor();
        }

        public I setDefaultHeaders(Map<String, String> headers) {
            this.template.setDefaultHeaders(headers);
            return this.getImplementor();
        }

        public I connectionPool(int maxIdleConnections, int keepAliveSeconds) {
            this.template.connectionPool(maxIdleConnections, keepAliveSeconds);
            return this.getImplementor();
        }
    }
}
