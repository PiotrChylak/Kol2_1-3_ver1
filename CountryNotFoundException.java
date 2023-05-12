public class CountryNotFoundException extends Exception {

   private final String countryName;

    public CountryNotFoundException(String countryName) {
        super();
        this.countryName = countryName;
    }

    public String getMessege(){
            return "Country " + countryName + " not found";
    }

}

//        Zdefiniuj klasę wyjątku CountryNotFoundException tak, aby niemożliwa była kompilacja bez przechwycenia go.
////        Wyjątek powinien być napisany tak, aby wywołanie metody getMessage() zwróciło nazwę
////        nieznalezionego państwa.
