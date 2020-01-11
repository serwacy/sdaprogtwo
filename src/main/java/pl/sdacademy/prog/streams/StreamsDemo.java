package pl.sdacademy.prog.streams;

import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        final String pathToLoad = args[0];
        final CountryOlympicsDataReadFileService readFileService = new CountryOlympicsDataReadFileService();
        final CountryOlympicsDataStatisticService statisticService = new CountryOlympicsDataStatisticService();
        final List<CountryOlympicsData> list = readFileService.readDataFromFile(pathToLoad);

//        statisticService.getCountriesThatWonAtLeastOneGoldMedal(list)
//                .forEach(System.out::println);
        System.out.println(statisticService.getCountryWithMostGoldMedals(list));
    }
}
