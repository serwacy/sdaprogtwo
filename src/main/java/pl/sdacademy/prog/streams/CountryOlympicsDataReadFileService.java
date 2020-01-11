package pl.sdacademy.prog.streams;

import pl.sdacademy.prog.stra.GenericException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CountryOlympicsDataReadFileService {
    private static final int COUNTRY_NAME_INDEX = 0;
    private static final int GOLD_MEDALS_NUMBER_INDEX = 1;
    private static final int SILVER_MEDALS_NUMBER_INDEX = 2;
    private static final int BRONZE_MEDALS_NUMBER_INDEX = 3;
    private static final int NUMBER_OF_FOURTH_PLACE_INDEX = 4;
    private static final int MINIMUM_DATA_LENGTH = 4;
    private static final int ADDITIONAL_DATA_LENGTH = 5;

    public List<CountryOlympicsData> readDataFromFile (final String path){
        return readLinesFromFile(path).stream()
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(","))
                .map(this::toCountryOlympicsData)
                .collect(Collectors.toList());
    }

    private List<String> readLinesFromFile(final String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException exp) {
            throw new GenericException("File" + path + " not found", exp);
        }
    }

    private CountryOlympicsData toCountryOlympicsData(final String[] splitLineData){
        validateMandatoryDataExist(splitLineData);

        final String shortName = splitLineData[COUNTRY_NAME_INDEX];
        final int goldMedals = Integer.parseInt(splitLineData[GOLD_MEDALS_NUMBER_INDEX]);
        final int silverMedals = Integer.parseInt(splitLineData[SILVER_MEDALS_NUMBER_INDEX]);
        final int bronzeMedals = Integer.parseInt(splitLineData[BRONZE_MEDALS_NUMBER_INDEX]);
        final int fourthPlace = doesAdditionalDataExist(splitLineData);

        return CountryOlympicsData.builder()
                .shortName(shortName)
                .goldMedalsNumber(goldMedals)
                .silverMedalsNumber(silverMedals)
                .bronzeMedalsNumber(bronzeMedals)
                .numberOfFourthPlaces(fourthPlace)
                .build();
    }

    private void validateMandatoryDataExist(String[] splitLineData){
        if(splitLineData.length < MINIMUM_DATA_LENGTH) {
            throw new GenericException("Line does not contain all mandatory data");
        }
    }

    private int doesAdditionalDataExist(final String[] splitLineData) {
        if(splitLineData.length == ADDITIONAL_DATA_LENGTH) {
            return Integer.parseInt(splitLineData[NUMBER_OF_FOURTH_PLACE_INDEX]);
        }
        return 0;
    }
}
