package eu.uhk.devschool.shoppinglist.dto;

import java.time.LocalDateTime;

public class ShoppingItem {

    private Long id;

    private String content;

    private ShoppingItemState state;

    private LocalDateTime createdAt;

    private short count;

    private ShoppingItemCategory category;

    public ShoppingItem(String content, short count, ShoppingItemState state) {
        this.content = content;
        this.state = state;
        this.count = count;
        createdAt = LocalDateTime.now();
    }

    public ShoppingItem(String content, short count) {
        this.content = content;
        this.count = count;
        this.state = ShoppingItemState.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public ShoppingItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ShoppingItemState getState() {
        return state;
    }

    public void setState(ShoppingItemState state) {
        this.state = state;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    public ShoppingItemCategory getCategory() {
        return category;
    }

    public void setCategory(ShoppingItemCategory category) {
        this.category = category;
    }
}
