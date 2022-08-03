import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class standaloneChrome {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static void main(String[]args) throws MalformedURLException, InterruptedException {

        String remote_url_chrome="http://localhost:4444/wd/hub";
        ChromeOptions options =new ChromeOptions();
//            options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
        driver.set(new RemoteWebDriver(new URL(remote_url_chrome),options));
        driver.get().navigate().to("https://www.google.com");
        String url = driver.get().getCurrentUrl();
        System.out.println(url);
        String title = driver.get().getTitle();
        System.out.println(title);
        Thread.sleep(2000);

        driver.get().quit();
    }

}
