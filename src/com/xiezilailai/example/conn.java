package com.xiezilailai.example;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by 蝎子莱莱123 on 2016/2/9.
 */
public class conn {
    public Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/jkxystudent?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            String user="root";
            String password="jsk19970311abcde";
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
