package pl.sdacademy.prog.streams;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class CountryOlympicsData {
    private String shortName;
    private int goldMedalsNumber;
    private int silverMedalsNumber;
    private int bronzeMedalsNumber;
    private int numberOfFourthPlaces;
}
