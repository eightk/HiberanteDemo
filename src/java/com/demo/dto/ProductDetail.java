/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author huico
 */
@Entity
@Table(name = "PRODUCT_DETAIL")
public class ProductDetail {

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    @Id
    @GeneratedValue(generator = "productGenerator")
    @GenericGenerator(name = "productGenerator", strategy = "foreign", parameters = {
        @Parameter(value = "product", name = "property")})
    private int pid;
    @GeneratedValue(generator = "factoryGenerator")
    @GenericGenerator(name = "factoryGenerator", strategy = "foreign", parameters = {
        @Parameter(value = "factory", name = "property")})
    private int fid;

    /**
     * CascadeType: ALL hibernate will support not only insert but also update,
     * delete PERSIST only support insert
     * Unidirectional vs Bidirectional(need to create the mapping in the other side as well) OneToOne mapping
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    //Dont put JoinColumn here then the foreign violation or mutiple insert exception will not be triggered.
    //@JoinColumn(name = "fid", insertable = false, updatable = false)
    private Factory factory;
}
