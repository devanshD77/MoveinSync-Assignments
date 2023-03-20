package com.example.busbookingsystem.Repository;

import com.example.busbookingsystem.Models.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminInfo, Long> {
}
