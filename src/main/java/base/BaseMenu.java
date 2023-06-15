package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.GiftPage;

public class BaseMenu {
    public WebDriver driver;
    public BaseMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Knjige")
    public WebElement books;

    @FindBy(linkText = "Gift")
    public WebElement gift;

    @FindBy(linkText = "Pisci")
    public WebElement writers;

    @FindBy(linkText = "O nama")
    public WebElement aboutUs;

    @FindBy (linkText = "Uskoro")
    public WebElement soon;

    @FindBy (linkText = "Newsletter")
    public WebElement newsletter;

    @FindBy (linkText = "Konkurs")
    public WebElement competition;

    public GiftPage goToBooks(){
        books.click();
        return new GiftPage(driver);
    }

    public GiftPage goToGift(){
        gift.click();
        return new GiftPage(driver);
    }

}
