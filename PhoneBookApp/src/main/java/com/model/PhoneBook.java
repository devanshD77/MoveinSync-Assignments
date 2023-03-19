package com.model;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.util.*;
@Entity
@Table(name = "contacts")
public class PhoneBook {
    @Id
    private Long primaryContactNo;

    private Long secondaryContactNo;


    private String name;
    private String email;

    public PhoneBook() {

    }

    public PhoneBook(Long primaryContactNo, Long secondaryContactNo, String name, String email) {
        this.primaryContactNo = primaryContactNo;
        this.secondaryContactNo = secondaryContactNo;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "primaryContactNo=" + primaryContactNo +
                ", secondaryContactNo=" + secondaryContactNo +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getPrimaryContactNo() {
        return primaryContactNo;
    }

    public void setPrimaryContactNo(Long primaryContactNo) {
        this.primaryContactNo = primaryContactNo;
    }

    public Long getSecondaryContactNo() {
        return secondaryContactNo;
    }

    public void setSecondaryContactNo(Long secondaryContactNo) {
        this.secondaryContactNo = secondaryContactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
