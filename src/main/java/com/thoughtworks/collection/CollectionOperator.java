package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        int internal = right - left;
        if (internal >= 0) {
            for (int i = left; i <= right; i++) {
                resultList.add(i);
            }
        } else {
            for (int i = left; i >= right; i--) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        int internal = right - left;
        if (internal >= 0) {
            for (int i = left; i <= right; i++) {
                if (i % 2 == 0) {
                    resultList.add(i);
                }
            }
        } else {
            for (int i = left; i >= right; i--) {
                if (i % 2 == 0) {
                    resultList.add(i);
                }
            }
        }
        return resultList;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> resultList = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public int popLastElment(int[] array) {
        int last = array[array.length - 1];
        return last;
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> resultList = new ArrayList<>();
        for (int first : firstArray) {
            for (int second : secondArray) {
                if (first == second) {
                    resultList.add(first);
                }
            }
        }
        return resultList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> secondList = Arrays.asList(secondArray);
        List<Integer> resultList = new ArrayList<>(firstList);
        for (Integer second : secondList) {
            if (!firstList.contains(second)) {
                resultList.add(second);
            }
        }
        return resultList;
    }
}
