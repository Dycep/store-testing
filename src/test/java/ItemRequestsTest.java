import models.ItemModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.APIUtil;
import utils.JSONUtil;
import utils.StoreAPIUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        StoreAPIUtil.updateItem(itemId, "gjfg");//TODO test data
        assertEquals(StoreAPIUtil.getItem(itemId).getName(), "gjfg");//TODO add message
        StoreAPIUtil.deleteItem(itemId);
        assertEquals(itemsBefore, StoreAPIUtil.getItems().length);
    }
}
