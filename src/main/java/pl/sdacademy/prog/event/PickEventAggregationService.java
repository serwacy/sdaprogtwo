package pl.sdacademy.prog.event;

import com.google.auto.service.AutoService;
import pl.sdacademy.prog.stra.GenericException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AutoService(PickEventAggregationService.class)
public class PickEventAggregationService {
    private static final String EXPECTED_TEMPERATURE_ZONE = "ambient";

    public List<PickerStatistics> aggregate (final List<PickEvent> pickEvents) {
        return pickEvents.stream()
                .flatMap(pickEvent -> toPickerStatistics(pickEvent).stream())
                .collect(Collectors.groupingBy(PickerStatistics::getPickerId))
                .values().stream()
                .map(this::toSummarizedStatistics)
                .collect(Collectors.toList());
    }

    private PickerStatistics toSummarizedStatistics (final List<PickerStatistics> pickerStatistics){
        final List<Pick> allPicks = pickerStatistics.stream()
                .map(PickerStatistics::getPicks)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        if(pickerStatistics.size() > 0){
            return PickerStatistics.builder()
                    .picks(allPicks)
                    .name(pickerStatistics.get(0).getName())
                    .activeSince(pickerStatistics.get(0).getActiveSince())
                    .pickerId(pickerStatistics.get(0).getPickerId())
                    .build();
        }
        throw new GenericException("Method requires list not to be empty");
    }

    private Optional<PickerStatistics> toPickerStatistics (final PickEvent pickEvent){
        if(!pickEvent.getArticle().getTemperatureZone().equals(EXPECTED_TEMPERATURE_ZONE)){
            return Optional.empty();
        }
        return Optional.of(PickerStatistics.builder()
                .pickerId(pickEvent.getPicker().getId())
                .activeSince(pickEvent.getPicker().getActiveSince())
                .name(pickEvent.getPicker().getName())
                .picks(List.of(Pick.builder()
                    .articleName(pickEvent.getArticle().getName())
                    .timestamp(pickEvent.getTimestamp())
                    .build()))
                .build());
    }
}
