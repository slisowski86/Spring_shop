package com.github.slisowski.Spring_shop.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")

public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String name;
    private double price;





    @Embedded
    private Audit audit = new Audit();





    @Builder
    public Product(Long id, String name, String description) {
        this.id=id;
        this.name = name;
        this.description = description;


    }





}
