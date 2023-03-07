package framework.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodsForTestUtil {

    public static int selectNumFromText(String text){
        StringBuilder number = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            number.append(matcher.group());
        }
        return Integer.parseInt(number.toString());
    }

    public static String getStringFromListOfWebElements(By by){
        List<WebElement> list = WebDriverUtil.getInstance().getDriver().findElements(by);
        StringBuilder textFromList = new StringBuilder();
        for (WebElement element : list) {
            textFromList.append(element.getText());
        }

        return textFromList.toString();
    }

    public static String removeSubstringFrom(String substring, String from){
        return from.replaceAll(substring,"");
    }

    public static String formatCurrentDateAndTime(String pattern, Locale locale){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return formatter.format(LocalDateTime.now());
    }

    public static String formatDate(String toFormat,String oldPattern, String newPattern, Locale locale){
        LocalDate date = LocalDate.parse(toFormat, DateTimeFormatter.ofPattern(oldPattern,locale));
        return date.format(DateTimeFormatter.ofPattern(newPattern,locale));
    }


    public static String capitalizeFirstLetterInString(String string){
        return (string.substring(0,1).toUpperCase()+string.substring(1));
    }

    public static String randomAlphabeticString(){
        return RandomStringUtils.randomAlphabetic(1,20);
    }

}
