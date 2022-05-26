package com.erivas.acs.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
@RequiredArgsConstructor
public class Attendee {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String dni;
    private String name;
    private String surname;
    private String phone;
    private Date birthDate;
    private String dniScanUrl;
    private boolean approved;

    @Override
    public String toString() {
        return "Atendee{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
