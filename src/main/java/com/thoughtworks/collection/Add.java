package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        if (rightBorder >= leftBorder) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }

            }
        } else {
            for (int i = leftBorder; i >= rightBorder; i--) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        if (rightBorder >= leftBorder) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                if (i % 2 == 1) {
                    sum += i;
                }

            }
        } else {
            for (int i = leftBorder; i >= rightBorder; i--) {
                if (i % 2 == 1) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer * 3 + 2;
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<>(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            Integer integer = arrayList.get(i);
            if (integer % 2 == 1) {
                resultList.set(i, integer * 3 + 2);
            }
        }
        return resultList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            if (integer % 2 == 1) {
                sum += integer * 3 + 5;
            }
        }
        return sum;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        double median;
        if (evenList.size() % 2 == 1) {
            median = evenList.get(evenList.size() / 2);
        } else {
            median = (evenList.get(evenList.size() / 2) + evenList.get(evenList.size() / 2 - 1)) >> 1;
        }
        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        double average;
        int sum = 0;
        for (Integer integer : evenList) {
            sum += integer;
        }
        average = sum / evenList.size();
        return average;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        boolean isInclude =false;
        List<Integer> evenList = getEvenList(arrayList);
        if (evenList.contains(specialElment)) {
            isInclude = true;
        }
        return isInclude;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> evenUniqueSet = new HashSet<>(evenList);
        for (Integer integer : evenUniqueSet) {
            resultList.add(integer);
        }
        return resultList;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> evenList = getEvenList(arrayList);
        List<Integer> oddList = arrayList.stream().filter(integer -> integer %2 == 1).collect(Collectors.toList());
        List evenListResult = evenList.stream().sorted().collect(Collectors.toList());
        resultList.addAll(evenListResult);
        List oddListResult = oddList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        resultList.addAll(oddListResult);
        return resultList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int tmp = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            resultList.add(tmp);
        }
        return resultList;
    }

    private List<Integer> getEvenList(List<Integer> arrayList) {
        return arrayList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
    }
}
