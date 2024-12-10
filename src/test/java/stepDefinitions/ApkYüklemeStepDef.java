package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.Driver;

public class ApkYüklemeStepDef {
    @Given("Kullanici uygulamayi yükler")
    public void kullanici_uygulamayi_yükler() {
        Driver.getAndroidDriver();
    }
}