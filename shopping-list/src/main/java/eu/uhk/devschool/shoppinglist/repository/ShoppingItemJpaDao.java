package eu.uhk.devschool.shoppinglist.repository;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
                createQuery("SELECT si FROM ShoppingItem si WHERE si.content =:content", ShoppingItem.class);
        query.setParameter("content", shoppingItem.getContent());
        return query.getSingleResult();
    }

    public ShoppingItem shoppingItemById(Long id) {
        TypedQuery<ShoppingItem> query = entityManager.createQuery("SELECT si FROM ShoppingItem si WHERE si.id = :id", ShoppingItem.class);
        query.setParameter("id", id);

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
