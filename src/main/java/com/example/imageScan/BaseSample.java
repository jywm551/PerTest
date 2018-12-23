package com.example.imageScan;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by liuhai.lh on 17/01/12.
 */
class BaseSample {
    @Value("${ali.regionId}")
    String regionId;
    @Value("${ali.accessKeyId}")
    String accessKeyId;
    @Value("${ali.accessKeySecret}")
    String accessKeySecret;

    String getDomain(){
         if("cn-shanghai".equals(regionId)){
             return "green.cn-shanghai.aliyuncs.com";
         }

         if("cn-hangzhou".equals(regionId)){
             return "green.cn-hangzhou.aliyuncs.com";
         }

        return "green.cn-shanghai.aliyuncs.com";
    }

    String getEndPointName(){
        return regionId;
    }

}
