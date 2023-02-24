package com.system.mobile_shopping.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @SequenceGenerator(name = "hrs_user_seq_gen", sequenceName = "pms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hrs_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column()
    private String name;
    @Column()
    private String Email;

    @Column()
    private String message;

    private String subject;


}

