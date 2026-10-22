package com.novasl.gym.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "duration_days", nullable = false)
    private int duration_days;

    public Plan(){}
    public Plan(String name, BigDecimal price, int duration_days){
        this.name = name;
        this.price = price;
        this.duration_days = duration_days;
    }

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration_days() { return duration_days; }
    public void setDuration_days(int duration_days) {
        this.duration_days = duration_days;
    }
}
