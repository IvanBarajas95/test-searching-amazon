package pages;

import com.nivelics.commons.methods.web.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class SearchBar extends Method {
    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    private WebElement searchbar;
    @FindBy(xpath="//input[@id='nav-search-submit-button']")
    private WebElement searchbutton;
    @FindBy (xpath="//span[normalize-space()='HP - Computadora todo en uno de 24 pulgadas, " +
            "procesador AMD Athlon Silver 3050U, 8 GB RAM, 256 GB SSD, Windows 10 Home (24-dd0010, blanco)']")
    private WebElement optioncomputer;
    @FindBy (xpath="//span[@id='a-autoid-0-announce']")
    private WebElement optionquantity;
    @FindBy (xpath="//a[@id='quantity_1']")
    private WebElement quantitytwo;
    @FindBy (xpath="//input[@id='add-to-cart-button']")
    private WebElement addtocart;
    @FindBy (xpath="//*[@id=\"sw-atc-details-single-container\"]/div[2]/div[1]/span")
    private WebElement agregadoalcarrito;



    public SearchBar searchword(String word){
        SoftAssert verificartexto = new SoftAssert();
        SEN_KEYS_INTERFACE.sendKeys(searchbar,word);
        UTILS_INTERFACE.clickElement(searchbutton);
        UTILS_INTERFACE.clickElement(optioncomputer);
        UTILS_INTERFACE.clickElement(optionquantity);
        verificartexto.assertEquals(webDriverFacade.getWebDriver().findElement(By.xpath
                ("//*[@id='availability']/span")).getText(),"Disponible.","el texto es diferente" +
                " por eso fallo este assert");
        UTILS_INTERFACE.clickElement(quantitytwo);
        UTILS_INTERFACE.clickElement(addtocart);
        String alertcarrito = agregadoalcarrito.getText();
        verificartexto.assertEquals(alertcarrito,"Agregado al carrito");
        verificartexto.assertAll();//el assert all se utiliza para ver que asserts fallaron


    return this;}
}
