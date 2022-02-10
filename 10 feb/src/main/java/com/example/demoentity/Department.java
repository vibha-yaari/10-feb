package com.example.demoentity;


import javax.persistence.*;

@Entity
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String department;
    private String strength;
    private String percentage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
