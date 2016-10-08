package com.lanniuh.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * Created by linjian
 * 16/8/15.
 */
public class XmlUtil {
    public static Document str2Doc(String xml){
        Document document = null;
        try {
             document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }
}
