import constants.FilepathConstants;
import database.StoreDatabase;
import framework.utilities.WebDriverUtil;
import models.UserModel;
import org.testng.annotations.AfterMethod;
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

    @AfterMethod
    public void tearDown() {
        WebDriverUtil.getInstance().destroyWebDriverInstance();
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
        UserModel user = JSONUtil.getValueFromJsonFileByKey(FilepathConstants.TEST_DATA_FILEPATH.getFilePath(), "user", UserModel.class);
        RegistrationPage.registrationForm().fillRegistrationForm(user);
        RegistrationPage.registrationForm().submitForm();
        UserModel userFromDB = StoreDatabase.getUserByEmail(user.getEmail());
        assertEquals(user, userFromDB, "user in db should match testUser");
    }
}
