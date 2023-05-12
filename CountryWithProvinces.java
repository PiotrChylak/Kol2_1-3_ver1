public class CountryWithProvinces extends Country{

    private Country[] table;
    public CountryWithProvinces(String name, Country[] table) {
        super(name);
        this.table = table;
    }
}

//        Klasa CountryWithoutProvinces nie dodaje żadnych pól i w swoim konstruktorze wywołuje konstrotor klasy nadrzędnej.
//        Klasa CountryWithProvinces powinna posiadać prywatną tablicę obiektów Country, których nazwy
//        powinny odpowiadać nazwom prowincji. Konstruktor klasy CountryWithProvinces powinien dodatkowo
//        przyjmować jako parametr taką tablicę i ustawiać ją w polu klasy.
