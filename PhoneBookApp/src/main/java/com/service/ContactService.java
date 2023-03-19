package com.service;

import com.controller.custException.custException;
import com.model.PhoneBook;
import com.repository.Contactrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    Contactrepository contactrepository;
    public void add(PhoneBook phoneBook) {

        contactrepository.save(phoneBook);
    }

    public Optional<PhoneBook> findUserByNumber(PhoneBook pB) {
        return  contactrepository.findById(pB.getPrimaryContactNo());

    }

    public PhoneBook removeUserByNumber(Long primaryContactNumber) throws custException {
        Optional<PhoneBook> phb=contactrepository.findById(primaryContactNumber);

        if(!phb.isPresent()){
            throw new custException("User does not exits.");
        }
        contactrepository.deleteById(primaryContactNumber);
        return phb.get();
    }

    public void updateUserByNumber(Long primaryContactNumber, String newName) throws custException {
        contactrepository.updateUserByNumber(primaryContactNumber, newName);
    }

    public List<PhoneBook> findByName(String name) throws custException {
       List<PhoneBook> rs=contactrepository.findbyname(name);
       if(rs.size()==0)
       {
           throw new custException("No such user found");
       }
        Collections.sort(rs,(a,b) -> a.getName().compareTo(b.getName()));
       return rs;
    }

    public PhoneBook findByNumber(Long number) throws custException {
        Optional<PhoneBook> phb=contactrepository.findById(number);
        if(!phb.isPresent())
        {
            throw new custException("No such user found ");
        }
        return phb.get();
    }

    public List<PhoneBook> findByemail(String email) throws custException {
        List<PhoneBook> rs=contactrepository.findbyemail(email);
        if(rs.size()==0)
        {
            throw new custException("No such user found");
        }
        Collections.sort(rs,(a,b) -> a.getName().compareTo(b.getName()));
        return rs;
    }
}
