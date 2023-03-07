import framework.utilities.WebDriverUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTest {

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void testVkLogIn() {
        WebDriverUtil.getInstance().getDriver().get("https://vk.com/");
    }
}
