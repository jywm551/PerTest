package com.example.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created By Yu On 2018/9/4
 * Description：http请求的方法类
 **/
public class HttpClientUtil {

    private HttpClientUtil() {
    }

    /**
     * post请求
     *
     * @param url  请求地址
     * @param body 请求体
     * @return 请求结果 json格式
     * @throws Exception 异常
     */
    public static String postRequestBody(String url, String body) {
        try {

            String charset = "UTF-8";
            StringBuilder result = new StringBuilder();

            // 建立连接
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);
            connection.setDoOutput(true);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream(), charset);
            wr.write(body);
            wr.flush();
            InputStream is = connection.getInputStream();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
                is.close();
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @return : java.lang.String
     * @Description : post表单认证
     * @params : [url, authorization, map]
     * @auther : yuWenGang
     * @date : 2018/12/6
     */
    public static String postFormRequestToken(String url, String authorization, Map<String, String> map) {
        try {
            String charset = "UTF-8";
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Authorization", authorization);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);
            Set<String> keys = map.keySet();
            List<NameValuePair> formparams = new ArrayList<>();
            for (String key : keys) {
                formparams.add(new BasicNameValuePair(key, map.get(key)));
            }
            UrlEncodedFormEntity entity;
            entity = new UrlEncodedFormEntity(formparams, charset);
            httpPost.setEntity(entity);
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * get请求(表单格式)
     *
     * @param baseUrl 请求地址
     * @param params  请求参数
     * @return 返回结果
     * @throws Exception 异常
     */
    public static String getRequest(String baseUrl, Map<String, String> params) throws Exception {
        String charset = "UTF-8";
        StringBuilder result = new StringBuilder();
        StringBuilder url = new StringBuilder();

        // 获取请求参数并拼接到目标地址后
        url.append(baseUrl);
        if (params != null) {
            url.append("?");
            Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                url.append(entry.getKey()).append("=").append(entry.getValue());
                it.remove();
                if (it.hasNext())
                    url.append("&");
            }
        }
        HttpURLConnection connection = (HttpURLConnection) new URL(url.toString()).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
        InputStream is = connection.getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
            is.close();
        }
        return result.toString();
    }

    /**
     * get请求回去图片等信息
     *
     * @param baseUrl 目标地址
     * @param params  请求参数
     * @return 返回参数
     * @throws Exception 异常
     */
    public static byte[] getBinaryRequest(String baseUrl, Map<String, String> params) throws Exception {
        String charset = "UTF-8";
        StringBuilder url = new StringBuilder();
        url.append(baseUrl);

        // 获取请求参数并拼接到目标地址后
        if (params != null) {
            url.append("?");
            Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = it.next();
                url.append(entry.getKey()).append("=").append(entry.getValue());
                it.remove(); // avoids a ConcurrentModificationException
                if (it.hasNext()) url.append("&");
            }
        }
        HttpURLConnection connection = (HttpURLConnection) new URL(url.toString()).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
        InputStream response = connection.getInputStream();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = response.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        response.close();
        return outStream.toByteArray();
    }
}
