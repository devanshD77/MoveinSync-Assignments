package com.example.busbookingsystem.Models;

public class BusAndAdmin {
    private AdminInfo adminInfo;
    private BusInfo busInfo;


    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public BusInfo getBusInfo() {
        return busInfo;
    }

    public void setBusInfo(BusInfo busInfo) {
        this.busInfo = busInfo;
    }
}
