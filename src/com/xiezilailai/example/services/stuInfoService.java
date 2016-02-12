package com.xiezilailai.example.services;

import com.xiezilailai.example.model.stuInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝎子莱莱123 on 2016/2/10.
 */
public class stuInfoService {
    private Connection conn;
    private PreparedStatement psmt;


    public stuInfoService(){
        conn=new com.xiezilailai.example.conn().getCon();
    }

    public boolean addStu(stuInfo stu){
        try{
            psmt=conn.prepareStatement("insert into studentinfo (nickname, realname, sex, borndate, profession, subject, hobby, remark) VALUES (?,?,?,?,?,?,?,?)");
            psmt.setString(1,stu.getNickname());
            psmt.setString(2,stu.getRealname());
            psmt.setByte(3,stu.getSex());
            psmt.setString(4,stu.getBorndate());
            psmt.setString(5,stu.getProfession());
            psmt.setString(6,stu.getSubjects());
            psmt.setString(7,stu.getHobbies());
            psmt.setString(8,stu.getRemark());

            psmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List queryAllStu(){
        List stus=new ArrayList<>();
        try{
            psmt=conn.prepareStatement("SELECT * FROM studentinfo");
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                stuInfo stu = new stuInfo();
                stu.setId(rs.getInt(1));
                stu.setNickname(rs.getString(2));
                stu.setRealname(rs.getString(3));
                stu.setSex(rs.getByte(4));
                if (rs.getDate(5) != null)
                    stu.setBorndate(rs.getDate(5).toString());
                stu.setProfession(rs.getString(6));
                if (rs.getString(7) != null)
                    stu.setSubject(rs.getString(7).split("&"));
                if (rs.getString(8) != null)
                    stu.setHobby(rs.getString(8).split("&"));
                stu.setRemark(rs.getString(9));
                stus.add(stu);

            }
            return stus;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public stuInfo queryStuById(int id){
        try{
            psmt=conn.prepareStatement("SELECT * FROM studentinfo WHERE id=?");
            psmt.setInt(1,id);
            ResultSet rs=psmt.executeQuery();
            if(rs.next()){
                stuInfo stu = new stuInfo();
                stu.setId(rs.getInt(1));
                stu.setNickname(rs.getString(2));
                stu.setRealname(rs.getString(3));
                stu.setSex(rs.getByte(4));
                if (rs.getDate(5) != null)
                    stu.setBorndate(rs.getDate(5).toString());
                stu.setProfession(rs.getString(6));
                if (rs.getString(7) != null)
                    stu.setSubject(rs.getString(7).split("&"));
                if (rs.getString(8) != null)
                    stu.setHobby(rs.getString(8).split("&"));
                stu.setRemark(rs.getString(9));
                return stu;

            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateStu(stuInfo stu){
        try{
            psmt=conn.prepareStatement("UPDATE studentinfo SET nickname=?,realname=?,sex=?,borndate=?,profession=?,subject=?,hobby=?,remark=? WHERE id=?");
            psmt.setString(1,stu.getNickname());
            psmt.setString(2,stu.getRealname());
            psmt.setByte(3,stu.getSex());
            psmt.setString(4,stu.getBorndate());
            psmt.setString(5,stu.getProfession());
            psmt.setString(6,stu.getSubjects());
            psmt.setString(7,stu.getHobbies());
            psmt.setString(8,stu.getRemark());
            psmt.setInt(9,stu.getId());
            psmt.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteStu(int id){
        try{
            psmt=conn.prepareStatement("DELETE FROM studentinfo WHERE id =?");
            psmt.setInt(1,id);
            psmt.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
