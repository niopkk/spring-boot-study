package com.bbz.util;

import okhttp3.*;

import javax.net.ssl.*;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;
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
        if (instance == null) {
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

    public void post(String url, Map<String, String> paramsMap, String unixNow) {  //这里没有返回，也可以返回string

        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        Set<String> keySet = paramsMap.keySet();
        for (String key : keySet) {
            String value = paramsMap.get(key);
            formBodyBuilder.add(key, value);
        }
        FormBody formBody = formBodyBuilder.build();
//        String s = "device_name=android%2FSEA-AL10-HUAWEI; serial=fdb9f7f48220214315; client_time=" + Strings.substring(unixNow, 0, unixNow.length() - 3) + "; device_id=fdb9f7d2da27f482; version=10; channel=null; app_name=7000301";
        Request request = new Request
                .Builder()
//                .addHeader("Content-Type", "application/x-thrift")
//                .addHeader("Accept", "application/x-thrift")
//                .addHeader("User-Agent", "bcz_app/android/7.0.3")
//                .addHeader("Accept-Encoding", "gzip, deflate, sdch")
//                .addHeader("Cookie", s)
//                .addHeader("Host", "passport.baicizhan.com")
//                .addHeader("Content-Length", "36")
//                .addHeader("Connection", "keep-alive")
                .post(formBody)
                .url(url)
                .build();
        try (Response response = mOkHttpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
