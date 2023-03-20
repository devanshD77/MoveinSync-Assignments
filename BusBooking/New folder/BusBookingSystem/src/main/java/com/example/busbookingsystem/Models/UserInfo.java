package com.example.busbookingsystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_info")
public class UserInfo {

   @Id
    private Long userid;
   private String name;

    public UserInfo(Long userid, String name) {
        this.userid = userid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserInfo()
    {

    }

}
