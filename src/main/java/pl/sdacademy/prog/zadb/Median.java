package pl.sdacademy.prog.zadb;

import pl.sdacademy.prog.stra.GenericException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Median {
    private static final int UPPER_BOUND_INCLUSIVE = 1000;

    public static <T extends Number> Double findMedian(final Collection<T> list){
        final boolean hasIncorrectValue = list.stream()
                .anyMatch(elem -> Math.abs(elem.doubleValue()) > UPPER_BOUND_INCLUSIVE);
        if(hasIncorrectValue || list.isEmpty()){
            throw new GenericException("Input collection has invalid elements or is empty");
        }

        final List<Double> sortedValues = list.stream()
                .map(Number::doubleValue)
                .sorted()
                .collect(Collectors.toList());

        if(sortedValues.size() % 2 != 0){
            final int medianIndex = sortedValues.size() / 2;
            return sortedValues.get(medianIndex);
        }
        else{
            final int medianIndex = sortedValues.size() / 2;
            return Double.sum(sortedValues.get(medianIndex), sortedValues.get(medianIndex - 1))/2.0;
        }
    }
}
