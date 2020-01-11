package pl.sdacademy.prog.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryOlympicsDataStatisticService {
    public List<String> getCountriesThatWonAtLeastOneGoldMedal (final List<CountryOlympicsData> list){
        return list.stream()
                .filter(x->x.getGoldMedalsNumber() >= 1)
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList());
    }
    public List<String> getCountriesThatWonAnyMedal (final List<CountryOlympicsData> list){
        return list.stream()
                .filter(x->x.getGoldMedalsNumber() + x.getSilverMedalsNumber() + x.getBronzeMedalsNumber() >= 1)
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList());
    }
    public String getCountryWithMostGoldMedals (final List<CountryOlympicsData> list){
        return list.stream()
                .sorted(Comparator.comparingInt(CountryOlympicsData::getGoldMedalsNumber).reversed())
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList())
                .get(0);
    }
    public String getCountryWithMostMedals (final List<CountryOlympicsData> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(x->x.getGoldMedalsNumber()+x.getSilverMedalsNumber()+x.getBronzeMedalsNumber()))
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList())
                .get(list.size()-1);
    }
    public String getMostUnluckyCountry (final List<CountryOlympicsData> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(CountryOlympicsData::getNumberOfFourthPlaces).reversed())
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList())
                .get(0);
    }
    public List<String> getCountryWithMoreSilverThanGoldMedals (final List<CountryOlympicsData> list) {
        return list.stream()
                .filter(x->x.getSilverMedalsNumber() > x.getGoldMedalsNumber())
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList());
    }
    public List<String> getCountryWithMoreBronzeThanSilverThanGoldMedals (final List<CountryOlympicsData> list) {
        return list.stream()
                .filter(x->x.getBronzeMedalsNumber() > x.getSilverMedalsNumber())
                .filter(x->x.getSilverMedalsNumber() > x.getGoldMedalsNumber())
                .map(CountryOlympicsData::getShortName)
                .collect(Collectors.toList());
    }
    public Map<String, Integer> getCountryMedalsStatistics (final List<CountryOlympicsData> list) {
        return list.stream()
                .collect(Collectors.toMap(CountryOlympicsData::getShortName,
                        x->x.getBronzeMedalsNumber()+x.getSilverMedalsNumber()+x.getGoldMedalsNumber()));
    }
//    public Integer GoldMedalsMode (final List<CountryOlympicsData> list){
//         return list.stream()
//                .collect(Collectors.groupingBy(CountryOlympicsData::getGoldMedalsNumber))
//                .entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()))
//                .entrySet().stream().
//    }
}
