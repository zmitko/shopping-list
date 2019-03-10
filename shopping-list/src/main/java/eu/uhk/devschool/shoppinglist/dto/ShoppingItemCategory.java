package eu.uhk.devschool.shoppinglist.dto;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class ShoppingItemCategory {

    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column
    private String name;

    public ShoppingItemCategory() {
    }

    public ShoppingItemCategory(String name) {

        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
