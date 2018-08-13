package eu.uhk.devschool.shoppinglist.dto;

public class ShoppingItemCategory {

    private String name;

    public ShoppingItemCategory() {
    }

    public ShoppingItemCategory(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
