package com.example.busbookingsystem.Repository;

import com.example.busbookingsystem.Models.BusInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepo extends JpaRepository<BusInfo, Long> {
    @Modifying
    @Transactional
    @Query(value = "update BusInfo b set b.busname=?2 where b.busno=?1")
    void updateBusByBusNo(Long busNo, String busName);
    @Query(value = "select u from BusInfo u where u.source=?1 and u.destination=?2")
    List<BusInfo> findbuses(String source, String destination);
    @Modifying
    @Transactional
    @Query(value = "update BusInfo set occupied=occupied+1,seats=seats-1 where busno=?1")
    void updateseat(long busno);
    @Modifying
    @Transactional
    @Query(value = "update BusInfo set occupied=occupied-1,seats=seats+1 where busno=?1")
    void updateseat1(long busno);
}
