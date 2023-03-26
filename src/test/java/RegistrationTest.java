import constants.FilepathConstants;
import framework.utilities.WebDriverUtil;
import models.UserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.registrationpage.RegistrationPage;
import utils.APIUtil;
import utils.JSONUtil;
import utils.StoreAPIUtil;


import static org.testng.Assert.assertEquals;

public class RegistrationTest {

    @BeforeClass
    public void setUp() {
        APIUtil.setBaseUri(JSONUtil.getValueFromJsonFileByKey("src/test/resources/config/testconfig.json", "baseUri"));
    }

    @Test
    public void testApiRegistrationAndItsConfirmation(){
        UserModel testUser = JSONUtil.getValueFromJsonFileByKey(FilepathConstants.TEST_DATA_FILEPATH.getFilePath(), "user", UserModel.class);
        String token = StoreAPIUtil.registerUser(testUser);
        String responseMessage = StoreAPIUtil.confirmRegistration(token);
        assertEquals(responseMessage, "confirmed", "response message should be equal 'confirmed'");
    }

    @Test
    public void testUIRegistrationAndItsConfirmation(){
        WebDriverUtil.getInstance().getDriver().get("http://localhost:3000/registration");
        UserModel user = JSONUtil.getValueFromJsonFileByKey("src/test/resources/testdata/test.json", "user");
        RegistrationPage.registrationForm().fillRegistrationForm(user);
        RegistrationPage.registrationForm().submitForm();
    }
}
