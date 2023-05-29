package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class serviceLogdment {


    private Integer id_logdment;
    private String logdment_type;
    private String room_type;
    private Integer id_service;

    private Integer id_supplier;
    private String duration;
    private Double price;
    private String photo_url;
    private String name;
    private String category;
    private Integer availability;

    private String country;



    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public serviceLogdment(Integer id_logdment, String logdment_type, String room_type, Integer id_service, Integer id_supplier, String duration, Double price, String photo_url, String name, String category, Integer availability, String country) {
        this.id_logdment = id_logdment;
        this.logdment_type = logdment_type;
        this.room_type = room_type;
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

    @Override
    public String toString() {
        return "serviceLogdment{" +
                "id_logdment=" + id_logdment +
                ", logdment_type='" + logdment_type + '\'' +
                ", room_type='" + room_type + '\'' +
                ", id_service=" + id_service +
                ", id_supplier=" + id_supplier +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                ", photo_url='" + photo_url + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", availability=" + availability +
                ", country='" + country + '\'' +
                '}';
    }
}
