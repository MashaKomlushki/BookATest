package rs.booka.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rs.booka.pages.AccountPage;

public class TopMenu {

    WebDriver driver;
    public TopMenu(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-11314\"]/a/span")
    public WebElement knjige;

    @FindBy(xpath = "//*[@id=\"menu-item-11319\"]/a/span")
    public WebElement gift;

    @FindBy(xpath = "//*[@id=\"menu-item-895\"]/a/span")
    public WebElement pisci;

    @FindBy(xpath = "//*[@id=\"menu-item-855\"]/a/span")
    public WebElement oNama;

    @FindBy(xpath = "//*[@id=\"menu-item-18852\"]/a/span")
    public WebElement uskoro;

    @FindBy(xpath = "//*[@id=\"menu-item-50455\"]/a/span")
    public WebElement newsletter;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/form/div")
    public WebElement pretraga;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[5]/div/a")
    public WebElement prijaviSe;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[6]/div/button/span[1]")
    public WebElement korpa;


    public void gotoKnjige() {
        knjige.click();
    }

    public void gotoGift() {
        gift.click();
    }

    public void gotoPisci() {
        pisci.click();
    }

    public void gotoONama() {
        oNama.click();
    }

    public void gotoUskoro() {
        uskoro.click();
    }

    public void gotoNewsletter() {
        newsletter.click();
    }

    public void gotoPretraga() {
        pretraga.click();
    }

    public AccountPage gotoPrijaviSe() {
        prijaviSe.click();
        return new AccountPage(driver);
    }
    public void gotoKorpa() {
        korpa.click();
    }


}
