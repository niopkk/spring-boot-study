package com.bbz.util;

import okhttp3.*;

import javax.net.ssl.*;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

public class Https {


    private static volatile Https instance = null;
    private OkHttpClient okHttpClient;


    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sSLSocketFactory;
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
    }

    private Https() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //参数一：TimeOut等待链接的的时间TimeOut，参数二：TimeUnit时间单位
        builder.connectTimeout(10, TimeUnit.SECONDS);//点击POST是否有响应的时间
        builder.writeTimeout(30, TimeUnit.SECONDS);//请求POST数据写的时间
        builder.readTimeout(30, TimeUnit.SECONDS);//请求POST数据都的时间
        builder.sslSocketFactory(createSSLSocketFactory(), new TrustAllManager());
        builder.hostnameVerifier(new TrustAllHostnameVerifier());

        okHttpClient = builder.build();
    }

    public static Https getInstance() {
        if(instance== null){
            synchronized (Https.class) {
                if (instance == null) {
                    instance = new Https();
                }
            }
        }

        return instance;
    }

    /**
     * 得到图片的流文件
     *
     * @param * @param url
     * @param
     * @return java.io.InputStream
     */
    public InputStream getImg(String url) {
        InputStream temp = null;
        try {

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    temp = body.byteStream();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }


    public String get(String url) {
        try {
            Request request = new Request.Builder()
                    .get()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    return body.string();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
