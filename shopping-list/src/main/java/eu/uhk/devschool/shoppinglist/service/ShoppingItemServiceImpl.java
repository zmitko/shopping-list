package eu.uhk.devschool.shoppinglist.service;

import eu.uhk.devschool.shoppinglist.dto.ShoppingItem;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItemCategory;
import eu.uhk.devschool.shoppinglist.dto.ShoppingItemState;
import eu.uhk.devschool.shoppinglist.exception.ValidationException;
import eu.uhk.devschool.shoppinglist.repository.ShoppingItemRepository;
import eu.uhk.devschool.shoppinglist.validator.ShoppingItemValidator;
import eu.uhk.devschool.shoppinglist.validator.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemServiceImpl implements ShoppingItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingItemServiceImpl.class);

    private ShoppingItemRepository shoppingItemRepository;

    private ShoppingItemValidator validator;

    @Override
    public List<ShoppingItem> getAllItems() {
        LOGGER.info("#getAllItems method started");
        List<ShoppingItem> shoppingItems = shoppingItemRepository.findAll();
        LOGGER.info("#getAllItems method ended");
        return shoppingItems;
    }

    @Override
    public List<ShoppingItem> getItemsByCategory(ShoppingItemCategory category) {
        LOGGER.info("#getItemsByCategory method started with the category {}", category);
        return shoppingItemRepository.getAllByCategory_Name(category);
    }

    @Override
    public ShoppingItem addShoppingItem(ShoppingItem item) {
        LOGGER.info("#addShoppingItem method started with item {}", item);
        ValidationResult validationResult = validator.prePersist(item);
        item.setState(ShoppingItemState.NEW);
        return processInternally(item, validationResult);
    }

    @Override
    public ShoppingItem updateShoppingItem(ShoppingItem shoppingItem) {
        LOGGER.info("#updateShoppingItem method started with item {}", shoppingItem);
        ValidationResult validationResult = validator.preUpdate(shoppingItem);
        return processInternally(shoppingItem, validationResult);
    }

    @Override
    public ShoppingItem deleteShoppingItem(ShoppingItem shoppingItemId) {
        LOGGER.info("#deleteShoppingItem method started with item {}", shoppingItemId);
        shoppingItemRepository.delete(shoppingItemId);
        LOGGER.info("#deleteShoppingItem method successfully completed for item {}", shoppingItemId);
        return shoppingItemId;
    }

    @Autowired
    public ShoppingItemServiceImpl(ShoppingItemRepository shoppingItemRepository, ShoppingItemValidator validator) {
        this.shoppingItemRepository = shoppingItemRepository;
        this.validator = validator;
    }

    private ShoppingItem processInternally(ShoppingItem shoppingItem, ValidationResult validationResult) {
        if (validationResult.isValid()) {
            return shoppingItemRepository.save(shoppingItem);
        } else {
            String message = String.format("These validation errors have been detected: %s", validationResult.getErrors());
            LOGGER.error(message);
            throw new ValidationException(message);
        }
    }
}
