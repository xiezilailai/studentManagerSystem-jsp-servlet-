package com.xiezilailai.example.model;

/**
 * Created by 蝎子莱莱123 on 2016/2/10.
 */
public class stuInfo {
    private int id;
    private String nickname;
    private String realname;
    private byte sex;
    private String borndate;
    private String profession;
    private String[] subject={""};
    private String subjects="";
    private String[] hobby={""};
    private String hobbies="";
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getSubjects() {
        subjects="";
        if(subject!=null){
            for(int i=0;i<subject.length;i++){
                subjects+=subject[i]+"&";
            }
            subjects=subjects.substring(0,subjects.length()-1);
        }
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getHobbies() {
        hobbies="";
        if(hobby!=null){
            for(int i=0;i<hobby.length;i++){
                hobbies+=hobby[i]+"&";
            }
            hobbies=hobbies.substring(0,hobbies.length()-1);
        }
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
