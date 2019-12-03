package pl.sdacademy.prog.stra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CountryCurrencyDataProcessingService {

    private static final int COUNTRY_INDEX = 0;
    private static final int CURRENCY_FULLNAME_INDEX = 1;
    private static final int CURRENCY_SHORTNAME_INDEX = 2;
    private static final int AMOUNT_INDEX = 3;
    private static final int MINIMUM_DATA_LENGTH = 3;
    private static final int ADDITIONAL_DATA_LENGTH = 4;
    private static final double AMOUNT_UPPER_BOUND = 10e6;

    private final CountryCurrencyDataValidator countryCurrencyDataValidator;

    public CountryCurrencyDataProcessingService(final CountryCurrencyDataValidator countryCurrencyDataValidator) {
        this.countryCurrencyDataValidator = countryCurrencyDataValidator;
    }

    public List<CountryCurrencyData> readDataFromFile (final String path){
        return readLinesFromFile(path).stream()
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(","))
                .map(this::toCountryCurrencyData)
                .filter(countryCurrencyDataValidator::isDataFromReadFileValid)
                .collect(Collectors.toList());
    }

    private List<String> readLinesFromFile(final String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException exp) {
            throw new GenericException("File" + path + " not found", exp);
        }
    }

    private CountryCurrencyData toCountryCurrencyData(final String[] splitLineData){
        validateMandatoryDataExist(splitLineData);

        final String country = splitLineData[COUNTRY_INDEX];
        final String currencyFullName = splitLineData[CURRENCY_FULLNAME_INDEX];
        final String currencyShortName = splitLineData[CURRENCY_SHORTNAME_INDEX];
        final double amount = calculateAmount(splitLineData);

        return CountryCurrencyData.builder()
                .country(country)
                .currencyFullName(currencyFullName)
                .currencyShortName(currencyShortName)
                .amount(amount)
                .build();
    }

    private void validateMandatoryDataExist(String[] splitLineData){
        if(splitLineData.length < MINIMUM_DATA_LENGTH) {
            throw new GenericException("Line does not contain all mandatory data");
        }
    }

    private double calculateAmount(final String[] splitLineData) {
        if(splitLineData.length == ADDITIONAL_DATA_LENGTH) {
            return Double.parseDouble(splitLineData[AMOUNT_INDEX]);
        }
        return new Random().nextDouble() * AMOUNT_UPPER_BOUND;
    }
}
