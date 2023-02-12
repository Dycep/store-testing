package models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemModel {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
}
