package seleniumimportgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
/**
 * @author chala megersa
 * ID:Atr/6239/09
 **/
public class SeleniumImportGrade {
    public static void main(String[] args)  {
        
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("http://portal.aait.edu.et");
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("atr/6239/09");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("8005");
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button\n")).submit();
        driver.get("https://portal.aait.edu.et/Grade/GradeReport\n");

        String grade = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div")).getText();

        try{
            FileWriter fw=new FileWriter("grade.txt");
            fw.write(grade);
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("grades imported to grade.txt");
    }
}
