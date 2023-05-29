package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class service {

    @Id
    @Column(name = "id_service")
    private Integer id_service;

    @Column(name = "id_supplier")
    private Integer id_supplier;

    @Column(name = "duration")
    private String duration;

    @Column(name = "price")
    private Double price;

    @Column(name = "photo_url")
    private String photo_url;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "country")
    private String country;


    public service(Integer id_service, Integer id_supplier, String duration, Double price, String photo_url, String name, String category, Integer availability, String country) {
        this.id_service = id_service;
        this.id_supplier = id_supplier;
        this.duration = duration;
        this.price = price;
        this.photo_url = photo_url;
        this.name = name;
        this.category = category;
        this.availability = availability;
        this.country = country;
    }

    public service() {

    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }

    public Integer getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Integer id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
