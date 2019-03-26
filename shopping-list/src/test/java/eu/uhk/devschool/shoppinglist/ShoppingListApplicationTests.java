package eu.uhk.devschool.shoppinglist;
import com.fasterxml.jackson.core.JsonProcessingException;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.service.ShoppingItemService;
import eu.uhk.devschool.shoppinglist.util.JsonSerializerUtil;
import eu.uhk.devschool.shoppinglist.web.controller.ShoppingItemController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static eu.uhk.devschool.shoppinglist.web.constant.WebConstant.SHOPPING_ITEM_URL;
import static eu.uhk.devschool.shoppinglist.web.constant.WebConstant.SHOPPING_LIST_URL;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingListApplicationTests {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ShoppingItemService shoppingItemService;

	@InjectMocks
	private ShoppingItemController shoppingItemController;

	private String inputJson;

	@Before
	public void setup() throws JsonProcessingException {
		inputJson = new JsonSerializerUtil<ShoppingItem>().parseToJson(new ShoppingItem("susenka", (short) 3));
	}

	@Test
	public void shoppingListTest() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(SHOPPING_LIST_URL);

		this.mockMvc.perform(builder)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void addShoppingItemTest() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(SHOPPING_ITEM_URL)
				.header("Content-Type", MediaType.APPLICATION_JSON_UTF8)
				.content(inputJson);

		this.mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateShoppingItemTest() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put(SHOPPING_ITEM_URL)
				.header("Content-Type", MediaType.APPLICATION_JSON_UTF8)
				.content(inputJson);

		this.mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteShoppingItemTest() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete(SHOPPING_ITEM_URL)
				.header("Content-Type", MediaType.APPLICATION_JSON_UTF8)
				.content(inputJson);

		this.mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}