package rs.booka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rs.booka.base.BasePage;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "/html/body/div[4]/div[2]/form[1]/div[3]/input[3]")
    public WebElement loginButton;

    public void doLogin(String userName, String passWord){

        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    }
}
