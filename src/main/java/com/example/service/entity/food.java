package com.example.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class food {

    @Id
    @Column(name = "id_food")
    private Integer id_food;

    @Column(name = "place_type")
    private String place_type;

    @Column(name = "diet_type")
    private String diet_type;

    @Column(name = "food_type")
    private String food_type;

    @Column(name = "id_service")
    private Integer id_service;

    public food() {

    }

    @Override
    public String toString() {
        return "food{" +
                "id_food=" + id_food +
                ", place_type='" + place_type + '\'' +
                ", diet_type='" + diet_type + '\'' +
                ", food_type='" + food_type + '\'' +
                ", id_service=" + id_service +
                '}';
    }

    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }

    public String getPlace_type() {
        return place_type;
    }

    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }

    public String getDiet_type() {
        return diet_type;
    }

    public void setDiet_type(String diet_type) {
        this.diet_type = diet_type;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }
}
