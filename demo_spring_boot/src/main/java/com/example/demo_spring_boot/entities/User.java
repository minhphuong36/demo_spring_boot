package com.example.demo_spring_boot.entities;


import lombok.Data;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "userr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles",
             joinColumns = {@JoinColumn(name="user_id")},
             inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<Role> roles;


}
