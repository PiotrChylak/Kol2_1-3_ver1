public class CountryWithoutProvinces extends Country{

    public Map<LocalDate, Integer> map = new LinkedHashMap<>();
    public CountryWithoutProvinces(String name) {
        super(name);
    }

    public void addDailyStatistic(String date, int zachorowania){
        map.put(date, zachorowania);
    }



}

//        Samodzielnie zaprojektuj w klasie CountryWithoutProvinces zawartość pozwalającą zapisać ile danego dnia w tym państwie było zakażeń i zgonów.
//        Klasa powinna umożliwiać zapisanie wielu takich
//        wpisów.
//        Zdefiniuj publiczną metodę addDailyStatistic, przyjmującą jako argumenty datę oraz dwie liczby
//        całkowite - zachorowania i zgony, która dodaje je do zaproponowanej struktury. Daty należy zapisywać
//        jako obiekty klasy LocalDat

//        Klasa CountryWithoutProvinces nie dodaje żadnych pól i w swoim konstruktorze wywołuje konstrotor klasy nadrzędnej.
//        Klasa CountryWithProvinces powinna posiadać prywatną tablicę obiektów Country, których nazwy
//        powinny odpowiadać nazwom prowincji. Konstruktor klasy CountryWithProvinces powinien dodatkowo
//        przyjmować jako parametr taką tablicę i ustawiać ją w polu klasy.
