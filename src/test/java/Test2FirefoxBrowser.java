import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test2FirefoxBrowser {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @Test
    public void test2FireFox () throws InterruptedException, MalformedURLException {


        String remote_url_firefox = "http://localhost:4444/wd/hub";
        FirefoxOptions options  = new FirefoxOptions();
//            options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
        Thread.sleep(10000);
        driver.set(new RemoteWebDriver(new URL(remote_url_firefox), options));
        driver.get().navigate().to("https://www.amazon.com");
        String url = driver.get().getCurrentUrl();
        System.out.println(url);
        String title = driver.get().getTitle();
        System.out.println(title);

        driver.get().quit();
    }
}
