package com.zph.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther zph
 * @date 2022/9/18 - 17:36
 */
@Controller
public class ExcelExport {
    @RequestMapping(value = "excel", method = RequestMethod.GET)
    public void exportUser(HttpServletResponse resp){
        try{
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");

            String filepath = "e:/excel";
            File file = new File(filepath);
            String filename = "用户信息" + df.format(new Date()) + ".xlsx";
            InputStream fis = new BufferedInputStream(new FileInputStream(filepath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            resp.reset();
            resp.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8")));
            resp.setHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(resp.getOutputStream());
            resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            // 输出文件
            os.write(buffer);
            os.flush();
            os.close();
            System.err.println("到处成功");
        }catch (Exception e){
            System.err.println("到处失败");
            e.printStackTrace();
        }
    }
}
