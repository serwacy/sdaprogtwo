package pl.sdacademy.prog.stra;

import java.util.*;
import java.util.stream.Collectors;

public class CountryCurrencyDataStatisticService {
    public Collection<String> getCountriesWithOneWordName(final List<CountryCurrencyData> list){
        return list.stream()
                .map(CountryCurrencyData::getCountry)
                .filter(country -> !country.contains(" "))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public long getCountriesWithCurrencyUSD (final Collection<CountryCurrencyData> data) {
        final Map<String, List<CountryCurrencyData>> currencyToCountryCurrencyData = data.stream()
                .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName));
        return currencyToCountryCurrencyData.entrySet().stream()
                .filter(entry -> entry.getKey().equals("USD"))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .count();
    }
    public List<String> getCountriesWithCurrencyEUR (final Collection<CountryCurrencyData> data) {
        return data.stream()
                .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName))
                .getOrDefault("EUR", Collections.emptyList())
                .stream()
                .map(CountryCurrencyData::getCountry)
                .collect(Collectors.toList());
    }
    public List<String> getCountriesWithUniqueCurrency (final Collection<CountryCurrencyData> data) {
        return data.stream()
                .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyShortName))
                .values().stream()
                .filter(countryCurrencyData -> countryCurrencyData.size() == 1)
                .flatMap(Collection::stream)
                .map(CountryCurrencyData::getCountry)
                .collect(Collectors.toList());
    }
    public Map<String, Integer> getNumberOfCountriesWithGivenValue(final Collection<CountryCurrencyData> data){
        return data.stream()
                .collect(Collectors.groupingBy(CountryCurrencyData::getCurrencyFullName))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }
    public Double sumAllAmountValues (final Collection<CountryCurrencyData> data){
        return data.stream()
                .mapToDouble(CountryCurrencyData::getAmount)
                .sum();
    }
}
