package com.example.mingganci;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by liuhai.lh on 17/01/12.
 */
class BaseSample {

    @Value("ss9R6ibZylr1QgcX")
    String accessKeyId="ss9R6ibZylr1QgcX";
    @Value("2LyCNL6vEN5EEO8ICy8loSrfSkCNmv")
    String accessKeySecret="2LyCNL6vEN5EEO8ICy8loSrfSkCNmv";
    @Value("cn-shanghai")
    String regionId="cn-shanghai";


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
