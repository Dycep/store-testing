package framework.utilities;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public abstract class Form {

    protected final By locator;
    protected final String name;

    public Form(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

}
