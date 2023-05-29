package com.example.service.entity;

import javax.persistence.Column;

public class serviceEnter {

    private Integer id_supplier;
    private String duration;
    private Double price;
    private String photo_url;
    private String name;
    private String category;
    private Integer availability;
    private Integer id_enter;
    private String enter_type;
    private String time_arrival;
    private String time_departure;
    private String restriction;
    private Integer id_service;

    private String country;

    public serviceEnter(Integer id_supplier, String duration, Double price, String photo_url, String name, String category, Integer availability, Integer id_enter, String enter_type, String time_arrival, String time_departure, String restriction, Integer id_service, String country) {
        this.id_supplier = id_supplier;
        this.duration = duration;
        this.price = price;
        this.photo_url = photo_url;
        this.name = name;
        this.category = category;
        this.availability = availability;
        this.id_enter = id_enter;
        this.enter_type = enter_type;
        this.time_arrival = time_arrival;
        this.time_departure = time_departure;
        this.restriction = restriction;
        this.id_service = id_service;
        this.country = country;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    @Override
    public String toString() {
        return "serviceEnter{" +
                "id_supplier=" + id_supplier +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                ", photo_url='" + photo_url + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", availability=" + availability +
                ", id_enter=" + id_enter +
                ", enter_type='" + enter_type + '\'' +
                ", time_arrival='" + time_arrival + '\'' +
                ", time_departure='" + time_departure + '\'' +
                ", restriction='" + restriction + '\'' +
                ", id_service=" + id_service +
                ", country='" + country + '\'' +
                '}';
    }
}
