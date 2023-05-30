package swag.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import swag.utilities.ConfigReader;
import swag.utilities.Driver;

public class Hooks {





    @Before("@ui")
    public void setupMethod1() {
       Driver.getDriver().get(ConfigReader.getProperty("swagUrl"));

    }




    @After("@swag")
    public void tearDownMethod(Scenario scenario) {

        if(scenario.isFailed()){

        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

    }

    @After("@swag")
    public void tearDown(){

        Driver.closeDriver();

    }







}
