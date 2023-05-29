package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class serviceTransport {

    private Integer id_transport;
    private String vehicule_type;
    private String path_name;
    private String time_arrival;
    private String time_departure;
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

    public serviceTransport(Integer id_transport, String vehicule_type, String path_name, String time_arrival, String time_departure, Integer id_service, Integer id_supplier, String duration, Double price, String photo_url, String name, String category, Integer availability, String country) {
        this.id_transport = id_transport;
        this.vehicule_type = vehicule_type;
        this.path_name = path_name;
        this.time_arrival = time_arrival;
        this.time_departure = time_departure;
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
        return "serviceTransport{" +
                "id_transport=" + id_transport +
                ", vehicule_type='" + vehicule_type + '\'' +
                ", path_name='" + path_name + '\'' +
                ", time_arrival='" + time_arrival + '\'' +
                ", time_departure='" + time_departure + '\'' +
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
