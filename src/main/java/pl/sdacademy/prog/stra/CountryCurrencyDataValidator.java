package pl.sdacademy.prog.stra;

import java.util.stream.Stream;

public class CountryCurrencyDataValidator {
//   metodę sumującą wszystkie wartości pola amount
//   metodę sprawdzającą czy jakakolwiek nazwa kraju jest dłuższa niż 30 znaków
    private static final int COUNTRY_NAME_MIN_LENGTH = 2;
    private static final int CURRENCY_FULL_NAME_MIN_LENGTH = 3;
    private static final int CURRENCY_SHORT_NAME_LENGTH = 3;

    public boolean isDataFromReadFileValid(final CountryCurrencyData data){
        return isCountryNameValid(data) &&
                isCurrencyFullNameValid(data) &&
                isCurrencyShortNameValid(data);
    }
    private boolean isCountryNameValid (final CountryCurrencyData data){
        return data.getCountry().length() >= COUNTRY_NAME_MIN_LENGTH;
    }
    private boolean isCurrencyFullNameValid (final CountryCurrencyData data){
        return data.getCurrencyFullName().length() >= CURRENCY_FULL_NAME_MIN_LENGTH;
    }
    private boolean isCurrencyShortNameValid (final CountryCurrencyData data){
        return data.getCurrencyShortName().matches("[A-Z]{" + CURRENCY_SHORT_NAME_LENGTH + "}");
    }
}
