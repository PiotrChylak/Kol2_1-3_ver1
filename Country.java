import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Country {
    private final String name;

    private static String path1;
    private static String path2;

    public static void setFiles(String pathisko1, String pathisko2) throws FileNotFoundException {
        try {
            BufferedReader readerPath1 = new BufferedReader(new FileReader(pathisko1));
            Country.path1 = pathisko1;
        } catch (FileNotFoundException a) {
            FileNotFoundException x = new FileNotFoundException(pathisko1);
            throw x;
        }

        try {
            BufferedReader readerPath2 = new BufferedReader(new FileReader(pathisko2));
            Country.path2 = pathisko2;
        } catch (FileNotFoundException e) {
            FileNotFoundException x = new FileNotFoundException(pathisko2);
            throw x;
        }
    }

    public String getName() {
        return name;
    }

    public Country(String name) {
        this.name = name;
    }


//    Wywołaj metodę getCountryColumns wewnątrz metody fromCsv i przekaż dalej rzucany przez nią
//    wyjątek CountryNotFoundException.

//    W metodzie fromCsv w zależności od rodzaju państwa utwórz obiekt klasy CountryWithoutProvinces lub CountryWithProvinces.
//    Następnie dla kolejnych linii z danymi liczbowymi wywołaj metodę
//    addDailyStatistic na rzecz:
//    obiektu CountryWithoutProvinces, lub
//    kolejnych komórek tablicy prowincji obiektu CountryWithProvinces.
//    Należy zapisać statystyki dla wszystkich dat znajdujących się pliku
    public static Country fromCsv(String name) throws IOException, CountryNotFoundException {
        String line = "";
        String line1 = "";
        BufferedReader reader = new BufferedReader(new FileReader(Country.path1));

        line = reader.readLine();
        line1 = line;

        getCountryColumns(line, name);

        String[] fields = line.split(",");

        int i = 0;

        Country finalCountry;

        while (!(fields[i].equals(name))) {
            i++;
        }

        line = reader.readLine();

        String[] fields2 = line.split(",");


        if (fields2[i].equals("nan")) {
            CountryWithoutProvinces countrywo = new CountryWithoutProvinces(name);
            CountryColumns chuj = getCountryColumns(line1, name);
            int gowno = chuj.firstColumnIndex;

            countrywo.addDailyStatistic(fields2[0], gowno);
            while((line = reader.readLine()) != null){
                fields2 = line.split(",");
                countrywo.addDailyStatistic(fields2[0], gowno);
            }


            finalCountry = countrywo;


        } else {
            List<Country> list = new ArrayList<>();
            while (fields[i].equals(name)) {
                list.add(new Country(fields2[i]));
                i++;
            }

            CountryWithProvinces countryw = new CountryWithProvinces(name, (Country[]) list.toArray());
            finalCountry = countryw;
        }
        reader.close();
        return finalCountry;
    }

    private static class CountryColumns{
        public final int firstColumnIndex, columnCount;

        public CountryColumns(int firstColumnIndex, int columnCount) {
            this.firstColumnIndex = firstColumnIndex;
            this.columnCount = columnCount;
        }
    }

    private static CountryColumns getCountryColumns(String line, String name) throws CountryNotFoundException{
        String[] fields = line.split(",");
        int counter = 0;
        int counter2 = 0;

        while(!(fields[counter].equals(name))){
            counter++;
        }
        int counter3 = counter;

        while (fields[counter].equals(name))
        {
            counter++;
            counter2++;
        }

        CountryColumns cos = new CountryColumns(counter3, counter2);
        return cos;
    }
}

//    Wywołaj metodę getCountryColumns wewnątrz metody fromCsv i przekaż dalej rzucany przez nią
//    wyjątek CountryNotFoundException.


//        Wewnątrz klasy Country zdefiniuj prywatną, statyczną klasę CountryColumns. Klasa powinna posiadać
//        publiczne, ostateczne, całkowite pola firstColumnIndex, columnCount ustawiane przy pomocy
//        konstruktora.
//        W klasie Country zdefiniuj prywatną, statyczną metodę getCountryColumns, która otrzyma jako
//        parametry: napis będący pierwszym wierszem pliku CSV oraz napis zawierający poszukiwane państwo.
//        Metoda powinna zwrócić obiekt klasy CountryColumns zawierający informację o początkowej kolumnie
//        oraz liczbie kolumn poświęconej państwu. Jest to jednocześnie informacja, czy państwo posiada prowincje.


//        W klasie Country zdefiniuj statyczne, prywatne pola zawierające ścieżkę do obu plików CSV. Napisz
//        statyczną metodę klasy Country o nazwie setFiles ustawiającą te dwa pliki na wartości swoich argumentów. Metoda ta powinna zweryfikować,
//        czy pliki istnieją i można je odczytać. Jeżeli nie będzie to
//        1
//        możliwe, należy rzucić wyjątek FileNotFoundException podając mu jako argument konstruktora ścieżkę
//        do błędnego pliku.
//        W klasie Country napisz publiczną, statyczną metodę fromCsv, która przyjmie jako argument napis
//        zawierający nazwę kraju, a zwróci polimorficzny obiekt typu Country. Metoda fromCsv powinna otwierać
//        i zamykać pliki i może założyć, że ścieżki do nich są poprawne

//          Na tym etapie klasa Country powinna mieć prywatne, ostateczne pole name klasy String zawierające
//       nazwę państwa oraz publiczne metody: akcesor do pola name oraz publiczny konstruktor przyjmujący
//       jako argument nazwę państwa i ustawiający go w polu name.
