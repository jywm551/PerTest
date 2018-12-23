package com.example.imageScan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20170112.ImageAsyncScanResultsRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhai.lh on 2017/2/17.
 * 获取图片异步检测结果接口
 * @author liuhai.lh
 * @date 2017/02/17
 */
public class ImageAsyncScanResultsSample extends BaseSample{
    @Value("${ali.regionId}")
    String regionId;
    @Value("${ali.accessKeyId}")
    String accessKeyId;
    @Value("${ali.accessKeySecret}")
    String accessKeySecret;

    public String ImageResult(String taskId) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(getEndPointName(), regionId, "Green", getDomain());
        IAcsClient client = new DefaultAcsClient(profile);

        ImageAsyncScanResultsRequest imageAsyncScanResultsRequest = new ImageAsyncScanResultsRequest();
        imageAsyncScanResultsRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
        imageAsyncScanResultsRequest.setContentType(FormatType.JSON);
        imageAsyncScanResultsRequest.setMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
        imageAsyncScanResultsRequest.setEncoding("utf-8");
        imageAsyncScanResultsRequest.setRegionId(regionId);


        List<String> taskIds = new ArrayList<String>();
        taskIds.add(taskId);
        imageAsyncScanResultsRequest.setContent(JSON.toJSONString(taskIds).getBytes("UTF-8"), "UTF-8", FormatType.JSON);

        /**
         * 请务必设置超时时间
         */
        imageAsyncScanResultsRequest.setConnectTimeout(3000);
        imageAsyncScanResultsRequest.setReadTimeout(6000);

        try {
            HttpResponse httpResponse = client.doAction(imageAsyncScanResultsRequest);

            if(httpResponse.isSuccess()){
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getContent(), "UTF-8"));
                if (200 == scrResponse.getInteger("code")) {
                    JSONArray taskResults = scrResponse.getJSONArray("data");
                    for (Object taskResult : taskResults) {
                        if(200 == ((JSONObject)taskResult).getInteger("code")){
                            JSONArray sceneResults = ((JSONObject)taskResult).getJSONArray("results");
                            for (Object sceneResult : sceneResults) {
                                String scene = ((JSONObject)sceneResult).getString("scene");
                                String suggestion = ((JSONObject)sceneResult).getString("suggestion");
                                //根据scene和suggetion做相关的处理
                                System.out.println("suggestion"+suggestion);
                                return suggestion;
                                //do something
                            }
                        }else{
                            System.out.println("task process fail:" + ((JSONObject)taskResult).getInteger("code"));
                            return "exception";
                        }
                    }
                } else {
                    System.out.println("detect not success. code:" + scrResponse.getInteger("code"));
                    return "exception";
                }
            }else{
                System.out.println("response not success. status:" + httpResponse.getStatus());
                return "exception";
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
