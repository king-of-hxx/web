package com.example.controller;

import com.example.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/discover")
public class DiscoverController {

    @PostMapping("/upload")
    public Result upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception{
        Map<String,Object> resultMap=new HashMap<>();
        if(file.isEmpty()){
            resultMap.put("resultType","fail");
            resultMap.put("message","文件为空");
        }else{
            String rootPath=request.getServletContext().getRealPath("/mydata");
            System.out.println(rootPath);
            String filename=file.getOriginalFilename();

            File destFile=new File(rootPath,filename);

            if(!destFile.getParentFile().exists()){
                destFile.getParentFile().mkdirs();
            }

            file.transferTo(destFile);
            System.out.println(rootPath);
            System.out.println(filename);
        }
        return Result.success(null);
    }
}
