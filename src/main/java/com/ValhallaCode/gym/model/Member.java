package com.valhallacode.gym.model;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public Member(){}
    public Member(String firstName, String dni){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.active = true;
    }

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName(){ return firstName; }
    public void setFirstName(String firstName){ this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
