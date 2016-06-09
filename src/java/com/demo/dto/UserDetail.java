package com.demo.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author huico
 */
@Entity
@Table(name="USER_DETAIL")
public class UserDetail {
    
    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int useId;
    //Transient annotation will let hibernate fully ignore this column
    @Transient
    @Column(name="USER_NAME", nullable=false)
    private String userName;
    
    @Temporal(TemporalType.DATE)
    @Column(name="BIRTHDATE")
    private Date birthDate;
}
