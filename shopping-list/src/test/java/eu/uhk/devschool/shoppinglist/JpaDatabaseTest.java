package eu.uhk.devschool.shoppinglist;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItemState;
import eu.uhk.devschool.shoppinglist.repository.ShoppingItemJpaDao;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaDatabaseTest {

    @Autowired
    private ShoppingItemJpaDao shoppingItemJpaDao;

    @Test
    public void jpqlJpaTest() {
        cleanIfRecordsExist();

        shoppingItemJpaDao.persist(new ShoppingItem("Jablicko", (short) 1, ShoppingItemState.NEW));
        shoppingItemJpaDao.persist(new ShoppingItem("Banana", (short) 2, ShoppingItemState.NEW));

        List<ShoppingItem> persistedShoppingItems = shoppingItemJpaDao.getAll();
        Assert.assertThat(persistedShoppingItems, IsCollectionWithSize.hasSize(2));
    }

    private void cleanIfRecordsExist() {
        List<ShoppingItem> shoppingItems = shoppingItemJpaDao.getAll();
        if (shoppingItems != null && !shoppingItems.isEmpty()) {
            for (ShoppingItem shoppingItem : shoppingItems) {
                shoppingItemJpaDao.delete(shoppingItem);
            }
        }
    }

}
