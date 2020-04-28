package com.itheima.factory;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;
    private static Map<String, Object> beans;

    static {
        try {
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    public static Object getbean(String beanname) {
        return beans.get(beanname);
    }

  /*  public static Object getbean(String beanname) {
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanname);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
