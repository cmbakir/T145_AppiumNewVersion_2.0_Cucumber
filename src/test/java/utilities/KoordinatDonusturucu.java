package utilities;

import java.awt.*;

// Bu class farklı boyutlarda telefon emulatorleri calıstırırken, onceki telefon boyutunda koordinat aldı isek, onları
//donusturmemıze yardımcı olan class'dır

public class KoordinatDonusturucu {
    // Orijinal ekran boyutları
    private static final int ORIJINAL_EKRAN_GENISLIK = 1080;
    private static final int ORIJINAL_EKRAN_YUKSEKLIK = 2280;

    // Yeni cihazın ekran boyutları
    private static int yeniEkranGenislik;
    private static int yeniEkranYukseklik;

    // Koordinatları dönüştürme metodu
    public static Point koordinatlariDonustur(Point orijinalNokta, int yeniCihazEkranGenislik, int yeniCihazEkranYukseklik) {
        yeniEkranGenislik = yeniCihazEkranGenislik;
        yeniEkranYukseklik = yeniCihazEkranYukseklik;

        double xOran = (double) yeniEkranGenislik / ORIJINAL_EKRAN_GENISLIK;
        double yOran = (double) yeniEkranYukseklik / ORIJINAL_EKRAN_YUKSEKLIK;

        int yeniX = (int) (orijinalNokta.x * xOran);
        int yeniY = (int) (orijinalNokta.y * yOran);

        return new Point(yeniX, yeniY);
    }

    public static void main(String[] args) {
        // Orijinal ekran boyutlarına göre bir nokta belirleyelim
        Point orijinalNokta = new Point(530, 1700);

        // Yeni cihazın ekran boyutları
        int yeniCihazEkranGenislik = 1344; //pixel 8 pro
        int yeniCihazEkranYukseklik = 2992;

        // Koordinatları dönüştürelim
        Point donusturulmusNokta = koordinatlariDonustur(orijinalNokta, yeniCihazEkranGenislik, yeniCihazEkranYukseklik);

        // Yeni koordinatları yazdıralım
        System.out.println("Yeni X Koordinatı: " + donusturulmusNokta.x); //659
        System.out.println("Yeni Y Koordinatı: " + donusturulmusNokta.y);//2230
    }


}
