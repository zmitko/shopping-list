package eu.uhk.devschool.shoppinglist.dto;

import javax.persistence.*;

@Entity
public class ShoppingItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public ShoppingItemCategory() {
    }

    public ShoppingItemCategory(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
