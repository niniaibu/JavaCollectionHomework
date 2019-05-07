package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        if (right > left) {
            IntStream.range(left, right + 1).forEach(resultList::add);
        } else {
            IntStream.range(right, left + 1).map(item -> left - right - item + 2).forEach(resultList::add);
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        if (right > left) {
            IntStream.range(left, right + 1).filter(integer -> integer % 2 == 0).forEach(resultList::add);
        } else {
            IntStream.range(right, left + 1).filter(integer -> integer % 2 == 0).map(item -> left - right - item + 3).forEach(resultList::add);
        }
        return resultList;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> resultList = Arrays.stream(array).filter(i -> i % 2 == 0)
                .boxed().collect(Collectors.toList());
        return resultList;
    }

    public int popLastElment(int[] array) {
        int last = array[array.length - 1];
        return last;
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> resultList = new ArrayList<>();
        Arrays.stream(firstArray).forEach(first ->
                Arrays.stream(secondArray).filter(second -> first == second).mapToObj(second -> first).
                        forEach(resultList::add));
        return resultList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> secondList = Arrays.asList(secondArray);
        List<Integer> resultList = new ArrayList<>(firstList);
        secondList.stream().filter(second -> !firstList.contains(second)).forEach(resultList::add);
        return resultList;
    }
}
