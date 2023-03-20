package com.example.busbookingsystem.Service;

import com.example.busbookingsystem.CustException.CustException;
import com.example.busbookingsystem.Models.AdminInfo;
import com.example.busbookingsystem.Models.BookingInfo;
import com.example.busbookingsystem.Models.BusInfo;
import com.example.busbookingsystem.Models.UserInfo;
import com.example.busbookingsystem.Repository.AdminRepo;
import com.example.busbookingsystem.Repository.BookinginfoRepo;
import com.example.busbookingsystem.Repository.BusRepo;
import com.example.busbookingsystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceA {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookinginfoRepo bookinginfoRepo;
    public void addAdmin(AdminInfo adminInfo) throws CustException {
        Optional<AdminInfo> opt = adminRepo.findById(adminInfo.getAdminid());
        if(opt.isPresent()){
            throw new CustException("Admin Already Exists");
        }
        adminRepo.save(adminInfo);
    }

    public void addBus(BusInfo busInfo,AdminInfo adminInfo) throws CustException {
        // verifying admin.
        Optional<AdminInfo> admin = adminRepo.findById(adminInfo.getAdminid());
        if(admin.isEmpty()){
            throw new CustException("Wrong id");
        }
        AdminInfo adm = admin.get();
        if(!adm.getAdminpassword().equals(adminInfo.getAdminpassword())){
            throw new CustException("Wrong Password");
        }

        busRepo.save(busInfo);
    }

    public void updateBus(BusInfo busInfo, AdminInfo adminInfo) throws CustException {
        // verifying admin.
        Optional<AdminInfo> admin = adminRepo.findById(adminInfo.getAdminid());
        if(admin.isEmpty()){
            throw new CustException("Wrong id");
        }
        AdminInfo adm = admin.get();
        if(!adm.getAdminpassword().equals(adm.getAdminpassword())){
            throw new CustException("Wrong password");
        }

        busRepo.updateBusByBusNo(busInfo.getBusno(),busInfo.getBusname());
    }

    public void deleteBus(Long busId, AdminInfo adminInfo) throws CustException {
        Optional<AdminInfo> admin = adminRepo.findById(adminInfo.getAdminid());
        if(admin.isEmpty()){
            throw new CustException("Wrong Id/Password");
        }
        AdminInfo adm = admin.get();
        if(!adm.getAdminpassword().equals(adm.getAdminpassword())){
            throw new CustException("Access Denied Wrong id/password");
        }
        busRepo.deleteById(busId);
    }

    public List<BusInfo> findbuses(String source, String destination) {
        return busRepo.findbuses(source,destination);
    }

    public Integer seats(long id) throws CustException {
       Optional<BusInfo> bs=busRepo.findById(id);
       if(bs.isEmpty())
       {
           throw new CustException("No such bus found");
       }
       return bs.get().getSeats();

    }

    public void adduser(UserInfo userInfo) throws CustException {
        Optional<UserInfo>us=userRepo.findById(userInfo.getUserid());
        if(us.isPresent())
        {
            throw new CustException("User already exists");
        }
        userRepo.save(userInfo);
    }

    public void bookseats(BookingInfo bookingInfo) throws CustException {
        Optional<BookingInfo> book=bookinginfoRepo.ifvalid(bookingInfo.getBusno(),bookingInfo.getSeatno());
        if(book.isPresent())
        {
            throw new CustException("Seat already booked");
        }
        busRepo.updateseat(bookingInfo.getBusno());
        bookinginfoRepo.save(bookingInfo);
    }

    public void cancel(BookingInfo bookingInfo) throws CustException {
        Optional<BookingInfo> bs=bookinginfoRepo.findbydetails(bookingInfo.getBusno(),bookingInfo.getSeatno(),bookingInfo.getUserid());
        if(bs.isEmpty())
        {
            throw new CustException("No such booking found");
        }
        busRepo.updateseat1(bookingInfo.getBusno());
        bookinginfoRepo.cancel(bookingInfo.getBusno(),bookingInfo.getSeatno(),bookingInfo.getUserid());
    }
}
