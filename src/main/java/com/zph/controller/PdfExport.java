package com.zph.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.zph.model.GwclwxsqBean;

/**
 * @auther zph
 * @date 2022/9/17 - 22:36
 */
@Controller
public class PdfExport {
    @RequestMapping(value = "/pdf",method = RequestMethod.GET)
    public String exportPdf(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        // 1.指定解析器
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        String filename="车辆维修.pdf";
        URL url = PdfExport.class.getClassLoader().getResource("pdf/车辆维修.pdf");
        System.out.println(url);
        String path ="pdf";
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(filename, "UTF-8"));
        OutputStream os = null;
        PdfStamper ps = null;
        PdfReader reader = null;
        try {
            os = response.getOutputStream();
            // 2 读入pdf表单
            reader = new PdfReader(path+ "/"+filename);
            // 3 根据表单生成一个新的pdf
            ps = new PdfStamper(reader, os);
            // 4 获取pdf表单
            AcroFields form = ps.getAcroFields();
            // 5给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
            BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            form.addSubstitutionFont(bf);
            // 6查询数据================================================
            GwclwxsqBean gwclwxsqBean = new GwclwxsqBean("2000-07-01","张三","京B8888","奔驰","北京","20W","保险杠","维修完成","同意","维修一天");
            Map<String, String> data = new HashMap<String, String>();
            data.put("commitTime", gwclwxsqBean.getCommitTime());
            data.put("driver", gwclwxsqBean.getDriver());
            data.put("carId", gwclwxsqBean.getCarId());
            data.put("carType", gwclwxsqBean.getCarType());
            data.put("repairAddress", gwclwxsqBean.getRepairAddress());
            data.put("repairCost",gwclwxsqBean.getRepairCost());
            data.put("project", gwclwxsqBean.getProject());
            data.put("fwbzzxfzrYj", gwclwxsqBean.getFwbzzxfzrYj());
            data.put("fgldspYj", gwclwxsqBean.getFgldspYj());
            data.put("remarks", gwclwxsqBean.getRemarks());
            // 7遍历data 给pdf表单表格赋值
            for (String key : data.keySet()) {
                form.setField(key,data.get(key).toString());
            }
            ps.setFormFlattening(true);
            System.err.println("导出成功");
        } catch (Exception e) {
            System.err.println("导出失败");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                reader.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}


