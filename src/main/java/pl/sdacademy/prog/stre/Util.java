package pl.sdacademy.prog.stre;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {
    public List<Integer> toSingleList (final List<List<Integer>> listOfLists){
        return listOfLists.stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
    public Map<List<Integer>, Integer> toMapOfListAndSumOfListElements (final List<List<Integer>> listOfLists){
        return listOfLists.stream()
                .filter(this::hasEvenNumber) //.filter(list -> list.stream().anyMatch(num -> num%2 == 0))
                .collect(Collectors.toMap(Function.identity(), this::sumOfInts));
    }
    private boolean hasEvenNumber (List<Integer> listOfInts){
        return listOfInts.stream().anyMatch(num -> num % 2 == 0);
    }
    private Integer sumOfInts (List<Integer> listOfInts){
        return listOfInts.stream().mapToInt(num -> num).sum();
    }
    public String makeSentenceFromListOfStrings (List<List<String>> listOfLists){
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .filter(str -> !str.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(" "))
                .toUpperCase().concat(".");
    }
    public Map<String,Integer> sentenceWordStatistic (String sentence){
        return Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }
}
