package com.controller;

import com.controller.custException.custException;
import com.model.PhoneBook;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class contactController {
    @Autowired
    ContactService service;
    @RequestMapping(value = "/addcontacts",method = RequestMethod.POST)
    public String addContacts(@RequestBody PhoneBook phoneBook) throws custException {
        Optional<PhoneBook> opt = service.findUserByNumber(phoneBook);
        if(opt.isPresent()){
            throw new custException("User Already exits.");
        }
        service.add(phoneBook);
        return "User Added";
    }

    @RequestMapping(value = "/removecontacts/{primaryContactNumber}",method = RequestMethod.DELETE)
    public PhoneBook removeContacts(@PathVariable Long primaryContactNumber) throws custException {
       return service.removeUserByNumber(primaryContactNumber);
    }
    @RequestMapping(value = "/updatecontacts/{primaryContactNumber}/{newName}",method = RequestMethod.PUT)
    public String updateContacts(@PathVariable Long primaryContactNumber, @PathVariable String newName) throws custException {
        service.updateUserByNumber(primaryContactNumber, newName);
        return "User Updated.";
    }
    @RequestMapping(value = "/searchbyname/{name}",method = RequestMethod.GET)
    public List<PhoneBook> searchbyName(@PathVariable String name) throws custException {
        return service.findByName(name);
    }
    @RequestMapping(value = "/searchbynumber/{number}",method = RequestMethod.GET)
    public PhoneBook searchbyNumber(@PathVariable Long number) throws custException {
        return service.findByNumber(number);
    }
    @RequestMapping(value = "/searchbyemail/{email}",method = RequestMethod.GET)
    public List<PhoneBook> searchbyNumber(@PathVariable String email) throws custException {
        return  service.findByemail(email);
    }
}
