import constants.FilepathConstants;
import models.UserModel;
import org.apache.http.HttpStatus;
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
        UserModel testUser = JSONUtil.getValueFromJsonFileByKey(FilepathConstants.TESTDATA_FILEPATH.getFilePath(), "user", UserModel.class);
        String token = StoreAPIUtil.registerUser(testUser);
        assertEquals(StoreAPIUtil.confirmRegistration(token).statusCode(), HttpStatus.SC_OK);//TODO message
    }
}
