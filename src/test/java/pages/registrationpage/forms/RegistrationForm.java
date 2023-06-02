package pages.registrationpage.forms;

import framework.utilities.Form;
import framework.webelements.Button;
import framework.webelements.Input;
import models.UserModel;
import org.openqa.selenium.By;

public class RegistrationForm extends Form {

    private final Input firstNameInput = new Input(By.name("firstNameInput"), "'First Name' input");
    private final Input lastNameInput = new Input(By.name("lastNameInput"), "'Last Name' input");
    private final Input passwordInput = new Input(By.name("passwordInput"), "'Password' input");
    private final Input emailInput = new Input(By.name("emailInput"), "'Email' input");
    private final Input phoneInput = new Input(By.name("phoneInput"), "'Phone' input");
    private final Button submitButton = new Button(By.xpath("//input[@type='submit']"), "'Submit' button");

    public RegistrationForm() {
        super(By.id("registration_form"), "Registration Form");
    }

    public void sendFirstName(String firstName){
        firstNameInput.sendText(firstName);
    }

    public void sendLastName(String lastName){
        lastNameInput.sendText(lastName);
    }

    public void sendPassword(String password){
        passwordInput.sendText(password);
    }

    public void sendEmail(String email){
        emailInput.sendText(email);
    }

    public void sendPhone(String phone){
        phoneInput.sendText(phone);
    }

    public void fillRegistrationForm(UserModel user){
        sendFirstName(user.getFirstName());
        sendLastName(user.getLastName());
        sendPassword(user.getPassword());
        sendEmail(user.getEmail());
        sendPhone(user.getPhone());
    }

    public void submitForm(){
        submitButton.click();
    }
}
