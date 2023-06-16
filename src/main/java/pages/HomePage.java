package pages;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[5]/div/a")
    public WebElement signIn;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "/html/body/div[4]/div[2]/form[1]/div[3]/input[3]")
    public WebElement loginBtn;

    public void goToSignIn(){
        signIn.click();
    }

    /*public void signIn(){
        username.sendKeys("mama.komlumku18@gmail.com");
        password.sendKeys("ZaTest183!");
        loginBtn.click();
    }*/

    public void signIn(String Username, String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);
        loginBtn.click();
    }
}
