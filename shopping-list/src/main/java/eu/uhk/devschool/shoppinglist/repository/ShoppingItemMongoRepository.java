package eu.uhk.devschool.shoppinglist.repository;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItemCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemMongoRepository extends MongoRepository<ShoppingItem, Long> {

    List<ShoppingItem> getAllByCategory_Name(ShoppingItemCategory category);

}
