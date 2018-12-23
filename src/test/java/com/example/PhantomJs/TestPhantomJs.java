package com.example.PhantomJs;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Theodore_YU on 2017/12/14.
 */
public class TestPhantomJs {
    @Test
    public void t1() throws IOException {
//        String image = getImage("https://www.baidu.com/ ");
//        System.out.println(image);
//        get("https://www.baidu.com/ ");
//        String html = getParseredHtml2("https://www.baidu.com/");
//        System.out.println("html"+html);
    }
    @Test
    public void jsPath(){
        URL resource = this.getClass().getResource("code.js");
        System.out.println(resource);
    }

    private  void get(String url) throws IOException {
        String js = "G:\\工作\\demo\\src\\main\\resources\\code.js ";
        String name = "123.jpg";
        Process p = Runtime.getRuntime().exec("G:\\工作\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe " + js + url+name);
        System.out.println(p);
    }


    private String getImage(String url) throws IOException {
        String js = "G:\\工作\\demo\\src\\main\\resources\\code.js ";
        String name = "123.jpg";
        Process p = Runtime.getRuntime().exec("G:\\工作\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe " + js + url+name);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sbf = new StringBuilder();
        String tmp;
        while((tmp = br.readLine())!=null){
            sbf.append(tmp);
        }
        //System.out.println(sbf.toString());
        return sbf.toString();
    }
    public static String getParseredHtml2(String url) throws IOException
    {
        String js = "templates/1.xls ";
        Process p = Runtime.getRuntime().exec("G:\\工作\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe " + js + url);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sbf = new StringBuilder();
        String tmp;
        while ((tmp = br.readLine()) != null)
        {
            sbf.append(tmp);
        }
        String[] result = sbf.toString().split("companyServiceMod");
        String result2 = "";
        if(result.length >= 2)
        {
            result2 = result[1];
            if(result2.length() > 200)
            {
                result2 = result2.substring(0, 200);
            }
        }
        //System.out.println("resut2: "+result2);
        return result2;
    }
}
