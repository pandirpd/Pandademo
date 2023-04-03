import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.panda.utils.ReadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    ReadProperties readconfig=new ReadProperties();

    public String baseURL=readconfig.getApplicationURL();
    public static WebDriver driver;

    //@Parameters("browser")
   @BeforeClass
    //public void setup(String br)
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
   }

    public void captureScreen(WebDriver driver, String tname) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
            FileUtils.copyFile(source, target);
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
