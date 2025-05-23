package com.ewflorencio.product_service.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String version;
    private int idCategory;
    private int idBrand;
    private double vlPrice;

    @ElementCollection
    private List<Size> sizes;

    @ElementCollection
    private List<Color> colors;

    @Lob
    private byte[] illustration;

}
