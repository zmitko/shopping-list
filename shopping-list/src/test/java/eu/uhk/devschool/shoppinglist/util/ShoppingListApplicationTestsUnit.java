package eu.uhk.devschool.shoppinglist.util;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.service.ShoppingItemService;
import eu.uhk.devschool.shoppinglist.support.junit.Calculator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingListApplicationTestsUnit {

  @Autowired
  private ShoppingItemService si;

  private Calculator calculator = new Calculator();


  @Test
  public void testFindAll() {
    List<ShoppingItem> itemList = si.getAllItems();
    assertNotNull(itemList);
  }


  @Test
  public void twoAndThreeIsFive() {
    long result = calculator.add(2, 3);
    assertTrue(result == 5);
  }

  @Test
  public void testAddTwoItems() {
    ShoppingItem item1 = new ShoppingItem("susenka", (short) 3);
    ShoppingItem item2 = new ShoppingItem("pomeranc", (short) 1);

    si.addShoppingItem(item1);
    si.addShoppingItem(item2);

    List<ShoppingItem> returnedList = si.getAllItems();
    assertEquals(returnedList.size(), 2);

    si.deleteShoppingItem(item1);
    si.deleteShoppingItem(item2);
  }

  @Test
  public void testRemoveItem(){
    ShoppingItem item1 = new ShoppingItem("susenkaNova", (short) 3);
    si.addShoppingItem(item1);
    List<ShoppingItem> returnedList = si.getAllItems();
    assertEquals(returnedList.size(), 1);

    si.deleteShoppingItem(item1);
    List<ShoppingItem> returnedList2 = si.getAllItems();
    assertEquals(returnedList2.size(), 0);

  }


}