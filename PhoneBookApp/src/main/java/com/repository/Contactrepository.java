package com.repository;

import com.model.PhoneBook;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Contactrepository extends JpaRepository<PhoneBook,Long> {

    @Modifying
    @Transactional
    @Query(value = "update PhoneBook c set c.name=?2 where c.primaryContactNo=?1")
    void updateUserByNumber(Long primaryContactNumber, String newName);
    @Query(value = "select u from PhoneBook u where u.name like %?1%")
    List<PhoneBook> findbyname(String name);
    @Query(value = "select u from PhoneBook u where u.email like %?1%")
    List<PhoneBook>findbyemail(String email);
}
