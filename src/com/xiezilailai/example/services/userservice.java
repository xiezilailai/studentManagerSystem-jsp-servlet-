package com.xiezilailai.example.services;

import com.xiezilailai.example.model.UserTable;

import java.sql.*;

/**
 * Created by 蝎子莱莱123 on 2016/2/9.
 */
public class userservice {
    private PreparedStatement psm;
    private Connection conn;

    public userservice() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost/jkxystudent?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user="root";
        String password="jsk19970311abcde";
        conn= DriverManager.getConnection(url,user,password);

    }

    public boolean validUser(UserTable user) {
//        return true;

        try {
            psm=conn.prepareStatement("SELECT * FROM usertable WHERE usertable.username=? and usertable.password=?");
            if(psm==null)return false;
            psm.setString(1,user.getUsername());
            psm.setString(2,user.getPassword());
            ResultSet rs=psm.executeQuery();
            if(rs==null)return false;
            if(rs.next()){
                return true;
            }else{
                return false;
            }


        } catch (SQLException e) {
            return false;
        }
    }

    }
