import constants.FilepathConstants;
import models.UserModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.JSONUtil;
import utils.StoreApiUtil;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseTest{

    @Test
    public void testRegistrationAndItsConfirmation(){
        UserModel testUser = JSONUtil.getValueFromJsonFileByKey(FilepathConstants.TESTDATA_FILEPATH.getFilePath(), "user", UserModel.class);
        String token = StoreApiUtil.registerUser(testUser);
        assertEquals(StoreApiUtil.confirmRegistration(token).statusCode(), HttpStatus.SC_OK);//TODO message
        //TODO check in database
    }
}
