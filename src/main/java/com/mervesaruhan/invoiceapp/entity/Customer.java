package com.mervesaruhan.invoiceapp.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String city;
    @CreationTimestamp
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Invoice> invoices = new ArrayList<>();
}
