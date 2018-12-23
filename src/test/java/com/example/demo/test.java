package com.example.demo;

import cn.ucloud.ufile.exception.UfileException;
import com.ucloudUtils.FileUploadUtil;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by Theodore_YU on 2017/12/8.
 */
public class test {
    @Test
    public void test1() throws UfileException, IOException {
        String region = "cn-bj";
        byte[] buff = "123".getBytes(Charset.forName("UTF-8"));
        InputStream is = new ByteArrayInputStream(buff);
        String bucketName = "unpatgpcm";
        FileUploadUtil.putStream(is, "text/plain", "123.txt", bucketName,region);
        is.close();
    }
}