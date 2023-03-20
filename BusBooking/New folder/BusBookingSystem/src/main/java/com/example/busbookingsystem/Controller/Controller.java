package com.example.busbookingsystem.Controller;
import com.example.busbookingsystem.CustException.CustException;
import com.example.busbookingsystem.Models.*;
import com.example.busbookingsystem.Service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private ServiceA service;
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public String addAdmin(@RequestBody AdminInfo adminInfo) throws CustException {
        service.addAdmin(adminInfo);
        return "Admin Added Successfully";
    }
    @RequestMapping(value = "/addBus",method = RequestMethod.POST)
    public String addBus(@RequestBody BusAndAdmin busAndAdmin) throws CustException {
        service.addBus(busAndAdmin.getBusInfo(),busAndAdmin.getAdminInfo());
        return "Bus Added Successfully";
    }

    @RequestMapping(value = "/deleteBus",method = RequestMethod.DELETE)
    public String deleteBus(@RequestBody BusAndAdmin busAndAdmin) throws CustException {
        service.deleteBus(busAndAdmin.getBusInfo().getBusno(),busAndAdmin.getAdminInfo());
        return "Bus deleted Successfully";
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String adduser(@RequestBody UserInfo userInfo) throws CustException {
        service.adduser(userInfo);
        return "User Added successfully";
    }
    @RequestMapping(value = "/checkbus",method = RequestMethod.GET)
    public List<BusInfo> checkbus(@RequestBody BusInfo busInfo) throws CustException {
        List<BusInfo>buses=service.findbuses(busInfo.getSource(),busInfo.getDestination());
        if(buses.size()==0)
        {
            throw new CustException("No buses found");
        }
        return buses;
    }
    @RequestMapping(value = "/seatsavailaible",method = RequestMethod.GET)
    public String seatsavailable(@RequestBody BusInfo busInfo) throws CustException {
       Integer no=0;
       no=service.seats(busInfo.getBusno());
       return "No of available seats are "+no;

    }
    @RequestMapping(value = "/bookseat",method = RequestMethod.POST)
    public String bookseat(@RequestBody BookingInfo bookingInfo) throws CustException {
        service.bookseats(bookingInfo);
        return "Seat Booked Successfully";
    }
    @RequestMapping(value = "/cancelseat",method = RequestMethod.DELETE)
    public String cancelseat(@RequestBody BookingInfo bookingInfo) throws CustException {
        service.cancel(bookingInfo);
        return "Seat cancelled successfully";
    }




}
