package com.system.mobile_shopping.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(name = "hrs_user_seq_gen", sequenceName = "pms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hrs_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column()
    private String name;
    @Column()
    private String price;

    @Column()
    private String message;

    private String image;

    @Transient
    private String imageBase64;
}
