package com.example.busbookingsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Optional;

@Entity
public class BookingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingid;
    private long busno;
    private long seatno;
    private long userid;

    @Override
    public String toString() {
        return "BookingInfo{" +
                "bookindid=" + bookingid +
                ", busno=" + busno +
                ", seatno=" + seatno +
                ", userid=" + userid +
                '}';
    }

    public BookingInfo(){

}
    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookindid) {
        this.bookingid = bookindid;
    }

    public long getBusno() {
        return busno;
    }

    public void setBusno(long busno) {
        this.busno = busno;
    }

    public long getSeatno() {
        return seatno;
    }

    public void setSeatno(long seatno) {
        this.seatno = seatno;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public BookingInfo(int bookindid, long busno, long seatno, long userid) {
        this.bookingid = bookindid;
        this.busno = busno;
        this.seatno = seatno;
        this.userid = userid;
    }


}
