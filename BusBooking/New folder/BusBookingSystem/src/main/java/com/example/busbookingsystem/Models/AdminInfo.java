package com.example.busbookingsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminInfo {

    @Id
    private Long adminid;

    private String adminname;

    private String adminpassword;


    public AdminInfo(Long admin_Id, String admin_Name, String admin_Password) {
        adminid = admin_Id;
        adminname = admin_Name;
        adminpassword = admin_Password;
    }

    public AdminInfo() {}

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "Admin_Id=" + adminid +
                ", Admin_Name='" + adminname + '\'' +
                ", Admin_Password='" + adminpassword + '\'' +
                '}';
    }
}
