package stepDefinitions;

import com.beust.ah.A;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.TeknosaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TeknosaStepDef {

    TeknosaPage page=new TeknosaPage();

    @Given("Uygulama baslatilir")
    public void uygulama_baslatilir() {
        Driver.getAndroidDriver();

    }
    @Given("Ilk ekran bolumunden atlaya tiklanir")
    public void ilk_ekran_bolumunden_atlaya_tiklanir() {
       page.atlaButonu.click();
       ReusableMethods.bekle(3);
    }

    @Given("footer bolumunden {string} bolumune tiklanir")
    public void footer_bolumunden_bolumune_tiklanir(String string) {
        page.kategorilerButonu.click();
        ReusableMethods.bekle(3);
    }

    @Given("kategoriler bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumunden_bolumune_tiklanir(String kisiselBakim) {
        ReusableMethods.scrollWithUiScrollableAndClick(kisiselBakim);
        ReusableMethods.bekle(6);
    }

    @Given("acilan sayfadan {string} secimi yapilir")
    public void acilan_sayfadan_secimi_yapilir(String sac) {
        ReusableMethods.scrollWithUiScrollableAndClick(sac);
        ReusableMethods.bekle(3);

    }
    @Given("filtrele bolumune tiklanir")
    public void filtrele_bolumune_tiklanir() {
        page.FiltreleButonu.click();
        ReusableMethods.bekle(3);

    }
    @Given("Marka {string} bolumunden marka secimi yapilir")
    public void marka_bolumunden_marka_secimi_yapilir(String marka) {
        page.markaButonu.click();
        ReusableMethods.bekle(3);
        page.markaMetinYazmaKutusu.sendKeys(marka);
        ReusableMethods.bekle(4);
        page.filtrelenmisMarkaKutusu.click();
        ReusableMethods.bekle(4);
        page.SonuclariGosterButonu.click();

    }
    @Given("siralama yapilirak {string} secilir")
    public void siralama_yapilirak_secilir(String azalanFiyat) {
        ReusableMethods.bekle(3);
        page.SiralaButonu.click();
        ReusableMethods.bekle(3);
       // page.AzalanFiyatButonu.click();
        ReusableMethods.scrollWithUiScrollableAndClick(azalanFiyat);
        ReusableMethods.bekle(3);
    }
    @Given("fiyatlarin azalan duzende oldugu test edilir")
    public void fiyatlarin_azalan_duzende_oldugu_test_edilir() {
        String yuksekFiyat=page.azalanEnYuksekFiyat.getText();
        ReusableMethods.bekle(3);
        yuksekFiyat=yuksekFiyat.replaceAll("\\D","");
        System.out.println(yuksekFiyat);

        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(),0.80,0.20,0.50,100);

        String dusukFiyat= page.azalanDusukFiyat.getText();
        dusukFiyat=dusukFiyat.replaceAll("\\D","");
        System.out.println(dusukFiyat);

        Assert.assertTrue(Integer.parseInt(yuksekFiyat)>Integer.parseInt(dusukFiyat));
    }

    @Given("fiyatlarin artan duzende oldugu test edilir")
    public void fiyatlarin_artan_duzende_oldugu_test_edilir() {

       String artanDusukFiyat=page.artanDusukFiyat.getText();
        ReusableMethods.bekle(3);
        artanDusukFiyat=artanDusukFiyat.replaceAll("\\D","");
        System.out.println(artanDusukFiyat);

        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(),0.80,0.20,0.50,100);

        String artanYuksekFiyat= page.artanYuksekFiyat.getText();
       artanYuksekFiyat=artanYuksekFiyat.replaceAll("\\D","");
        System.out.println(artanYuksekFiyat);

        Assert.assertTrue(Integer.parseInt(artanYuksekFiyat)>Integer.parseInt(artanDusukFiyat));
    }

    @Given("kategoriler bolumunden kaydirarak {string} bolumune tiklanir")
    public void kategoriler_bolumunden_kaydirarak_bolumune_tiklanir(String kategoriSecim) {
        ReusableMethods.bekle(5);
        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(),0.70,0.30,0.50,100);
        ReusableMethods.bekle(5);
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriSecim);
    }

    @Given("kullanici ekran fotografi cekmek istedigi elementin {string} ekran fotografini ceker")
    public void kullanici_ekran_fotografi_cekmek_istedigi_elementin_ekran_fotografini_ceker(String ekranGoruntusu) throws IOException {
        ReusableMethods.bekle(5);
        ReusableMethods.screenShotElement(ekranGoruntusu);

    }


}
