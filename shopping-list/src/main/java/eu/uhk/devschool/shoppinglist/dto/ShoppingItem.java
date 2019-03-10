package eu.uhk.devschool.shoppinglist.dto;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "shopping_item")
public class ShoppingItem {

    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private ShoppingItemState state;

    @Column
    private LocalDateTime createdAt;

    @Column
    private short count;

    @ManyToOne
    @JoinColumn(name="category_id")
    private ShoppingItemCategory category;

    public ShoppingItem(BigInteger id, String content, short count, ShoppingItemState state) {
        this.id = id;
        this.content = content;
        this.state = state;
        this.count = count;
        createdAt = LocalDateTime.now();
    }

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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", createdAt=" + createdAt +
                ", count=" + count +
                ", category=" + category +
                '}';
    }
}
