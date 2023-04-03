import junit.framework.Assert;
import org.panda.pageObject.AboutPage;
import org.panda.pageObject.HomePage;
import org.testng.annotations.Test;

public class Automation_Panda extends BaseTest{

    @Test
    public void loginTest() throws InterruptedException {
        HomePage lp=new HomePage(driver);
        lp.navigateLink();
       captureScreen(driver,"HomPage");

        AboutPage ap= new AboutPage(driver);
        Thread.sleep(7000);
        ap.navigateLink();
        captureScreen(driver,"AboutPage");


        System.out.println(ap.getLocation());

    }
}
