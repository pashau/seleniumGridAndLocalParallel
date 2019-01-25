package helper;

import objects.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }

    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage getPage (Class<TPage> pageClass) {
        System.out.println("###DEBUG#PageGenerator#getPage 1");
        try {
            System.out.println("###DEBUG#PageGenerator#getPage 2 (try return page)");
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            System.out.println("###DEBUG#PageGenerator#getPage 3 (catch)");
            e.printStackTrace();
            try {
                throw e;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("###DEBUG#PageGenerator#getPage 4 (catch return null)");
        return null;
    }
}
