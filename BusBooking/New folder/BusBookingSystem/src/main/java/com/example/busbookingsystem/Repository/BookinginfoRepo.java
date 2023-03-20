package com.example.busbookingsystem.Repository;

import com.example.busbookingsystem.Models.BookingInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookinginfoRepo extends JpaRepository<BookingInfo,Integer> {
    @Query(value = "select u from BookingInfo u where u.busno=?1 and u.seatno=?2 ")
    Optional<BookingInfo> ifvalid(long busno, long seatno);
    @Modifying
    @Transactional
    @Query(value = "delete from BookingInfo where busno=?1 and seatno=?2 and userid=?3")
    void cancel(long busno, long seatno, long userid);

    @Query(value = "select u from BookingInfo u where u.seatno=?2 and u.busno=?1 and u.userid=?3")
    Optional<BookingInfo> findbydetails(long busno, long seatno, long userid);
}
