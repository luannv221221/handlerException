package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name",nullable = false,unique = true,length = 100)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "address")
    private String address;

}
