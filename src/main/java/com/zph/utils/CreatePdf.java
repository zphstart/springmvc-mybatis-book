package com.zph.utils;

import com.itextpdf.text.Document;

/**
 * @auther zph
 * @date 2022/9/18 - 18:08
 * 生成pdf工具类
 */
public class CreatePdf {
    public static Document createPdf(String filename){
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        Document document = new Document();
        return document;
    }
}
