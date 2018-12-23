package com.oss;

import com.aliyun.oss.OSSClient;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * 阿里云oss
 */
public class FileUploadUtil {

    @Test
    public void newFile() {
        UUID uuid = UUID.randomUUID();
        byte[] buff = "123".getBytes(Charset.forName("UTF-8"));
        InputStream is = new ByteArrayInputStream(buff);
        try {
            FileUploadUtil.putStream(is, uuid.toString() + ".txt", "bucketName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("存储地址：" + uuid.toString() + ".txt");
    }

    @Test
    public void uploadFile() throws FileNotFoundException {
        File file = new File("123.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        UUID uuid = UUID.randomUUID();
        String fileName = "文件别名";
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            FileUploadUtil.putStream(fileInputStream, uuid.toString() + "." + suffix, "bucketName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("存储地址：" + uuid.toString() + ".txt");
    }

    public static void putStream(InputStream is, String fileName, String bucketName) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "AccessKey";
        String accessKeySecret = "accessKeySecret";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（fileName）。
        ossClient.putObject(bucketName, fileName, is);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
