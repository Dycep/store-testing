import constants.FilepathConstants;
import models.UserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.APIUtil;
import utils.JSONUtil;
import utils.StoreAPIUtil;


import static org.testng.Assert.assertEquals;

public class RegistrationTest {

    @BeforeClass
    public void setUp() {
        APIUtil.setBaseUri((String) JSONUtil.getValueFromJsonFileByKey("src/test/resources/config/config.json", "baseUri"));
    }

    @Test
    public void testRegistrationAndItsConfirmation(){
        UserModel testUser = JSONUtil.getValueFromJsonFileByKey(FilepathConstants.TEST_DATA_FILEPATH.getFilePath(), "user", UserModel.class);
        String token = StoreAPIUtil.registerUser(testUser);
        assertEquals(StoreAPIUtil.confirmRegistration(token), "confirmed", "response message should be equal 'confirms'");//TODO message and assert response message
    }
}
