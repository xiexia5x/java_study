package com.heima;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author laofang
 * @description
 * @date 2021-06-14
 */
@Controller
public class DownLoadController {

    /**
     * 原生API实现下载
     * @param response
     */
    @RequestMapping("/d1")
    public void downLoad1(HttpServletResponse response){
        OutputStream out=null;
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\imgs\\one.png");
            response.reset();
            //设置响应数据类型
            response.setContentType("application/octet-stream; charset=utf-8");
            //   Content-disposition 是 MIME 协议的扩展，MIME 协议指示 MIME 用户代理如何显示附加的文件。
            //   当 Internet Explorer 接收到头时，它会激活文件下载对话框，
            //   它的文件名框自动填充了头中指定的文件名。
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            out = response.getOutputStream();
            out.write(FileUtils.readFileToByteArray(file));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * springmvc api实现下载
     * @return
     * @throws IOException
     */
    @RequestMapping("/d2")
    public ResponseEntity<byte[]> download() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\imgs\\one.png");
      //  String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        //response.setContentType("application/octet-stream; charset=utf-8");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //  response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        headers.setContentDispositionFormData("attachment", file.getName());
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }



}
