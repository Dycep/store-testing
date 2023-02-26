import constants.FilepathConstants;
import models.ItemModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.APIUtil;
import utils.JSONUtil;
import utils.StoreAPIUtil;

import static org.testng.Assert.*;

public class ItemRequestsTest {

    @DataProvider(name = "items")
    public Object[] items(){
        return JSONUtil.getValueFromJsonFileByKey("src/test/resources/testdata/testdata.json", "items", ItemModel[].class);
    }

    @BeforeClass
    public void setUp() {
        APIUtil.setBaseUri((String) JSONUtil.getValueFromJsonFileByKey("src/test/resources/config/config.json", "adminUri"));
    }

    @Test(dataProvider = "items")
    public void testCRUDOperations(ItemModel item){
        int itemsBefore = StoreAPIUtil.getItems().length;
        String itemId = StoreAPIUtil.createItem(item);
        assertTrue(itemsBefore < StoreAPIUtil.getItems().length, "number of items should be increased");
        String updatedItemName = JSONUtil.getValueFromJsonFileByKey(FilepathConstants.TEST_DATA_FILEPATH.getFilePath(), "updatedItem", ItemModel.class).getName();
        StoreAPIUtil.updateItem(itemId, updatedItemName);
        assertEquals(StoreAPIUtil.getItem(itemId).getName(), updatedItemName, "name of item should be changed");
        StoreAPIUtil.deleteItem(itemId);
        assertEquals(itemsBefore, StoreAPIUtil.getItems().length, "item should be deleted");
    }
}
