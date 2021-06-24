package com.heima;

import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/uploadOne",method = RequestMethod.POST)
    public String uploadOne(String userName, Integer age, MultipartFile headImg) throws IOException {
        System.out.println("name:"+userName+"---age:"+age);
        //获取form表达中file对象的输入项名称 headImg
        String name = headImg.getName();
        //文件的原始名称
        String oName = headImg.getOriginalFilename();
        //获取文件后缀
        String suffixType = oName.substring(oName.lastIndexOf("."), oName.length());
        //使用UUID随机生成文件名称
        String newName= UUID.randomUUID().toString()+ suffixType;
        //保存图片 图片保存到本地
        //实际项目开发开发中保存在第三方服务器下：阿里云oss等
        headImg.transferTo(new File("C:\\Users\\Administrator\\Desktop\\imgs\\",newName));
        return "success";
    }

    /**
     * 测试上传多文件
     * @param userName
     * @param age
     * @param resumes
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadMany",method = RequestMethod.POST)
    public String uploadMany(String userName, Integer age, MultipartFile[] resumes) throws IOException {
        System.out.println("name:"+userName+"---age:"+age);

        for (MultipartFile re : resumes) {
            //获取form表达中file对象的输入项名称 headImg
            String name = re.getName();
            //文件的原始名称
            String oName = re.getOriginalFilename();
            //获取文件后缀
            String suffixType = oName.substring(oName.lastIndexOf("."), oName.length());
            //使用UUID随机生成文件名称
            String newName= UUID.randomUUID().toString()+ suffixType;
            //保存图片 图片保存到本地
            //实际项目开发开发中保存在第三方服务器下：阿里云oss等
            re.transferTo(new File("C:\\Users\\Administrator\\Desktop\\imgs\\",newName));
        }
        return "success";
    }


}
