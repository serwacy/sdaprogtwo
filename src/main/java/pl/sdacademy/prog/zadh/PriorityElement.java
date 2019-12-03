package pl.sdacademy.prog.zadh;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PriorityElement <T, P extends Comparable<P>>{
    private T element;
    private P priority;
}
