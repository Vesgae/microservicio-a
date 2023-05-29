package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transport")
public class transport {
    @Id
    @Column(name = "id_transport")
    private Integer id_transport;

    @Column(name = "vehicule_type")
    private String vehicule_type;

    @Column(name = "path_name")
    private String path_name;

    @Column(name = "time_arrival")
    private String time_arrival;

    @Column(name = "time_departure")
    private String time_departure;

    @Column(name = "id_service")
    private Integer id_service;


    public transport() {
    }

    public transport(Integer id_transport, String vehicule_type, String path_name, String time_arrival, String time_departure, Integer id_service) {

        this.id_transport = id_transport;
        this.vehicule_type = vehicule_type;
        this.path_name = path_name;
        this.time_arrival = time_arrival;
        this.time_departure = time_departure;
        this.id_service = id_service;
    }

    public Integer getId_transport() {
        return id_transport;
    }

    public void setId_transport(Integer id_transport) {
        this.id_transport = id_transport;
    }

    public String getVehicule_type() {
        return vehicule_type;
    }

    public void setVehicule_type(String vehicule_type) {
        this.vehicule_type = vehicule_type;
    }

    public String getPath_name() {
        return path_name;
    }

    public void setPath_name(String path_name) {
        this.path_name = path_name;
    }

    public String getTime_arrival() {
        return time_arrival;
    }

    public void setTime_arrival(String time_arrival) {
        this.time_arrival = time_arrival;
    }

    public String getTime_departure() {
        return time_departure;
    }

    public void setTime_departure(String time_departure) {
        this.time_departure = time_departure;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }
}
