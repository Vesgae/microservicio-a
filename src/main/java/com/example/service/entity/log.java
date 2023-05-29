package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logdment")
public class log {

    @Id
    @Column(name = "id_logdment")
    private Integer id_logdment;

    @Column(name = "logdment_type")
    private String logdment_type;

    @Column(name = "room_type")
    private String room_type;

    @Column(name = "id_service")
    private Integer id_service;

    public log() {
    }

    public log(Integer id_logdment, String logdment_type, String room_type, Integer id_service) {
        this.id_logdment = id_logdment;
        this.logdment_type = logdment_type;
        this.room_type = room_type;
        this.id_service = id_service;
    }

    @Override
    public String toString() {
        return "log{" +
                "id_logdment=" + id_logdment +
                ", logdment_type='" + logdment_type + '\'' +
                ", room_type='" + room_type + '\'' +
                ", id_service=" + id_service +
                '}';
    }

    public Integer getId_logdment() {
        return id_logdment;
    }

    public void setId_logdment(Integer id_logdment) {
        this.id_logdment = id_logdment;
    }

    public String getLogdment_type() {
        return logdment_type;
    }

    public void setLogdment_type(String logdment_type) {
        this.logdment_type = logdment_type;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }
}
