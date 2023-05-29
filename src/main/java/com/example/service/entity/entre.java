package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entertainment")
public class entre {

    @Id
    @Column(name = "id_enter")
    private Integer id_enter;
    @Column(name = "enter_type")
    private String enter_type;
    @Column(name = "time_arrival")
    private String time_arrival;
    @Column(name = "time_departure")
    private String time_departure;
    @Column(name = "restriction")
    private String restriction;
    @Column(name = "id_service")
    private Integer id_service;


    public entre() {
    }

    public entre(Integer id_enter, String enter_type, String time_arrival, String time_departure, String restriction, Integer id_service) {
        this.id_enter = id_enter;
        this.enter_type = enter_type;
        this.time_arrival = time_arrival;
        this.time_departure = time_departure;
        this.restriction = restriction;
        this.id_service = id_service;
    }

    public Integer getId_enter() {
        return id_enter;
    }

    public void setId_enter(Integer id_enter) {
        this.id_enter = id_enter;
    }

    public String getEnter_type() {
        return enter_type;
    }

    public void setEnter_type(String enter_type) {
        this.enter_type = enter_type;
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

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }
}
