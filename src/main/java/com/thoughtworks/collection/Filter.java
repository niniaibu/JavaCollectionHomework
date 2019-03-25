package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer> array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> resultList = array.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> resultList = array.stream().filter(integer -> integer % 3 == 0).collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer first : firstList) {
            if (secondList.contains(first)) {
                resultList.add(first);
            }

        }
        return resultList;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> resultList = new ArrayList<>();
        for (Integer integer : array) {
            if (!resultList.contains(integer)) {
                resultList.add(integer);
            }
        }
        return resultList;
    }
}