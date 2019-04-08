package eu.uhk.devschool.shoppinglist.repository;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ShoppingItemJpaDao {

    private EntityManager entityManager;

    @Autowired
    public ShoppingItemJpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ShoppingItem> getAll() {
        TypedQuery<ShoppingItem> query = entityManager.createQuery("SELECT si FROM ShoppingItem si", ShoppingItem.class);
        return query.getResultList();
    }

    public ShoppingItem findByContent(ShoppingItem shoppingItem) {
        TypedQuery<ShoppingItem> query = entityManager.
                createQuery("SELECT si FROM ShoppingItem si WHERE content =:content", ShoppingItem.class);
        query.setParameter("content", shoppingItem.getContent());
        return query.getSingleResult();
    }

    public void persist(ShoppingItem shoppingItem) {
        entityManager.persist(shoppingItem);
    }

    public void update(ShoppingItem shoppingItem) {
        entityManager.merge(shoppingItem);
    }

    public void delete(ShoppingItem shoppingItem) {
        entityManager.remove(shoppingItem);
    }
}
