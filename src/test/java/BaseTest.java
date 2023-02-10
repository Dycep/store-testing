import org.testng.annotations.BeforeTest;
import utils.APIUtil;
import utils.JSONUtil;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        APIUtil.setBaseUri((String) JSONUtil.getValueFromJsonFileByKey("src/test/resources/config/config.json", "baseUri"));
    }
}
