package pages.registrationpage;

import framework.utilities.Form;
import org.openqa.selenium.By;
import pages.registrationpage.forms.RegistrationForm;

public class RegistrationPage extends Form {

    public RegistrationPage() {
        super(By.id("registration_form"), "Registration Page");
    }

    public static RegistrationForm registrationForm(){
        return new RegistrationForm();
    }
}
