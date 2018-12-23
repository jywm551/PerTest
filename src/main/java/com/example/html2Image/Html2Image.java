package com.example.html2Image;


import gui.ava.html.image.generator.HtmlImageGenerator;

/**
 * Created by Theodore_YU on 2017/12/13.
 */
public class Html2Image {

    public static void main(String[] args){
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        imageGenerator.loadUrl("D:\\program files\\feiq\\Recv Files\\就业班\\day20-55web\\day27--html\\资料\\WEB01\\cart.html");
        try {
            Thread.sleep(5000);
            imageGenerator.getBufferedImage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageGenerator.saveAsImage("G:\\工作\\新建文件夹\\1.jpg");
    }
}
