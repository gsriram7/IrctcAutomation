/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Sriram Ganesh
 */
public class Selenium {

    /**
     * @param args the command line arguments
     */
    
    public static WebDriver driver;
    
    public static void fillLogin() throws InterruptedException {
        driver.findElement(By.name("j_username")).sendKeys("gsriram777");
        driver.findElement(By.name("j_password")).sendKeys("********");
        Thread.sleep(5000);
        driver.findElement(By.name("submit")).click();        
    }
    
    public static void fillPassengerDetails() throws InterruptedException {
        driver.findElement(By.name("addPassengerForm:psdetail:0:psgnName")).sendKeys("Selvaram");
        driver.findElement(By.name("addPassengerForm:psdetail:0:psgnAge")).sendKeys("21");
        driver.findElement(By.name("addPassengerForm:psdetail:0:psgnGender")).sendKeys("M");
        driver.findElement(By.name("addPassengerForm:psdetail:0:idCardType")).sendKeys("STUDENT_ICARD");
        driver.findElement(By.name("addPassengerForm:psdetail:0:idCardNumber")).sendKeys("11C94");
        Thread.sleep(7000);
        driver.findElement(By.id("validate")).click();        
    }
    
    
    private static void fillPassengerDetailsWithInvalidCaptcha() throws InterruptedException {
        Thread.sleep(7000);
        driver.findElement(By.id("validate")).click();        
    }
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        driver = new FirefoxDriver();
        driver.get("http://www.irctc.co.in");
        while(driver.getTitle().equals("IRCTC Next Generation eTicketing System")){
            fillLogin();
        }
        driver.findElement(By.name("jpform:fromStation")).sendKeys("CHENNAI EGMORE - MS");
        driver.findElement(By.name("jpform:toStation")).sendKeys("MADURAI JN - MDU");
        driver.findElement(By.name("jpform:journeyDateInputDate")).sendKeys("05-04-2015");
        driver.findElement(By.name("jpform:jpsubmit")).click();
        while(!driver.getTitle().equals("Book Ticket - Passengers Information")){}
        fillPassengerDetails();
        while(driver.getTitle().equals("Book Ticket - Passengers Information")){
            fillPassengerDetailsWithInvalidCaptcha();
        }
        driver.findElement(By.id("jpBook:payOption:2")).click();
        driver.findElement(By.id("jpBook:bankDCList")).sendKeys("ICICI Bank");
        //driver.findElement(By.id("jpBook:bankINBList")).sendKeys("IDBI Bank");
        driver.findElement(By.id("validate")).click();
       
        //driver.findElement(By.name("CorporateSignonCorpId")).sendKeys("*********");        
        //driver.findElement(By.name("CorporateSignonPassword")).sendKeys("***********");     
        //driver.findElement(By.name("Action.ShoppingMall.Signon")).click();
        //driver.close();
        
        driver.findElement(By.name("CardTypeSelectBox")).sendKeys("Visa-Debit/Credit");
        driver.findElement(By.name("CardNum1")).sendKeys("****");
        driver.findElement(By.name("CardNum2")).sendKeys("****");
        driver.findElement(By.name("CardNum3")).sendKeys("****");
        driver.findElement(By.name("CardNum4")).sendKeys("****");
        driver.findElement(By.name("ExpDtMon")).sendKeys("**");
        driver.findElement(By.name("ExpDtYr")).sendKeys("****");
        driver.findElement(By.name("CVVNum")).sendKeys("***");
        driver.findElement(By.name("NameOnCard")).sendKeys("***********");
        driver.findElement(By.name("ATMPIN")).sendKeys("4321");
        driver.findElement(By.name("btnPay")).click();
    }

}
