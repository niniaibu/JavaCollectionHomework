package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> result = array.stream().map(n -> n * 3).collect(Collectors.toList());
        return result;
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<>();
        for (Integer integer : array) {
            result.add(letterList.get(integer - 1));
        }
        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        for (Integer integer : array) {
            int multiple = integer / 26;
            if (multiple > 0) {
                int index = integer - 26 * multiple - 1;
                if (index < 0) {
                    index += 26;
                    multiple -= 1;
                }
                String lastString = letterList.get(multiple - 1) + letterList.get(index);
                result.add(lastString);
            } else {
                result.add(letterList.get(integer - 1));
            }
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        List<Integer> result = array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return result;
    }

    public List<Integer> sortFromSmall() {
        List<Integer> result = array.stream().sorted().collect(Collectors.toList());
        return result;
    }
}
