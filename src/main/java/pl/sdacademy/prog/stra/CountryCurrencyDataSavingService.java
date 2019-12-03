package pl.sdacademy.prog.stra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class CountryCurrencyDataSavingService {
    public void saveDataToFile(final String path, final List<CountryCurrencyData> list){
        final List<String> csvLines = list.stream()
                .map(this::convertCountryCurrencyDataToString)
                .collect(Collectors.toList());
        saveDataToLine(path, csvLines);
    }

    private String convertCountryCurrencyDataToString(CountryCurrencyData data){
//        return Stream.of(Arrays.toString(CountryCurrencyData.class.getDeclaredFields()))
//                .collect(Collectors.joining(","));
        return String.join(",", data.getCountry(), data.getCurrencyFullName(),
                data.getCurrencyShortName(), data.getAmount().toString());
    }

    private void saveDataToLine(final String path, final List<String> csvLines){
        try {
            Files.write(Paths.get(path), csvLines, StandardOpenOption.CREATE);
        } catch (IOException exp) {
            throw new GenericException("Cannot save file to " + path, exp);
        }
    }
}
