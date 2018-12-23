package com.example.ftp;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.ftp.FTPUploadFile.uploadFile;

/**
 * @Author: yuwengang
 * @Date: 2018/12/20
 * @Description:
 */
public class FTPTest {
    @Test
    public void testUpLoadFromDisk(){
        try {
            FileInputStream in=new FileInputStream(new File("C:/Users/ATG/Desktop/下载.jpg"));
            boolean flag = uploadFile("192.168.100.80", 22, "pcm", "123456", "/home/pcm", "test.jpg", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
