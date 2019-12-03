package pl.sdacademy.prog;

import pl.sdacademy.prog.stra.CountryCurrencyDataProcessingService;
import pl.sdacademy.prog.stra.CountryCurrencyDataSavingService;
import pl.sdacademy.prog.stra.CountryCurrencyDataStatisticService;
import pl.sdacademy.prog.stra.CountryCurrencyDataValidator;

public class ProgramMain {
    public static void main(String[] args) {
        final String pathToLoad = args[0];
        final CountryCurrencyDataProcessingService service = new CountryCurrencyDataProcessingService(new CountryCurrencyDataValidator());
        service.readDataFromFile(pathToLoad).forEach(System.out::println);

        final String pathToSave = args[1];
        final CountryCurrencyDataSavingService savingService = new CountryCurrencyDataSavingService();
        savingService.saveDataToFile(pathToSave, service.readDataFromFile(pathToLoad));

        final CountryCurrencyDataStatisticService statisticService = new CountryCurrencyDataStatisticService();
        System.out.println(statisticService.getCountriesWithOneWordName(service.readDataFromFile(pathToLoad)));
        System.out.println(statisticService.getCountriesWithCurrencyUSD(service.readDataFromFile(pathToLoad)));
        System.out.println(statisticService.getCountriesWithCurrencyEUR(service.readDataFromFile(pathToLoad)));
        System.out.println(statisticService.getCountriesWithUniqueCurrency(service.readDataFromFile(pathToLoad)));
        statisticService.getNumberOfCountriesWithGivenValue(service.readDataFromFile(pathToLoad))
                .forEach((key, value) -> System.out.println("Currency: " + key + " ; Number of countries: " + value));
        System.out.println(statisticService.sumAllAmountValues(service.readDataFromFile(pathToLoad)));
    }
}
