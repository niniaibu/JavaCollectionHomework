package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        return rightBorder >= leftBorder ? getEvens(leftBorder, rightBorder, sum) : getEvens(rightBorder, leftBorder, sum);
    }

    private int getEvens(int leftBorder, int rightBorder, int sum) {
        sum += IntStream.rangeClosed(leftBorder, rightBorder).filter(i -> i % 2 == 0).sum();
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        return rightBorder >= leftBorder ? getOdds(leftBorder, rightBorder, sum) : getOdds(rightBorder, leftBorder, sum);
    }

    private int getOdds(int leftBorder, int rightBorder, int sum) {
        sum += IntStream.rangeClosed(leftBorder, rightBorder).filter(i -> i % 2 == 1).sum();
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(x -> x * 3 + 2).reduce(0, (a, b) -> a + b);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(this::getConvertToNumber).collect(Collectors.toList());
    }

    private int getConvertToNumber(int integer) {
        return integer % 2 == 1 ? integer * 3 + 2 : integer;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(integer -> integer % 2 == 1).mapToInt(integer -> integer * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        return evenList.size() % 2 == 1 ? evenList.get(evenList.size() / 2) : (evenList.get(evenList.size() / 2) + evenList.get(evenList.size() / 2 - 1)) >> 1;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        int sum = evenList.stream().mapToInt(integer -> integer).sum();
        return (double) (sum / evenList.size());
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = getEvenList(arrayList);
        return evenList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        Set<Integer> evenUniqueSet = new HashSet<>(getEvenList(arrayList));
        return new ArrayList<>(evenUniqueSet);
    }

    public List sortByEvenAndOdd(List<Integer> arrayList) {
        List oddListRevert = arrayList.stream().filter(integer -> integer % 2 == 1)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List evenListResult = getEvenList(arrayList).stream().sorted().collect(Collectors.toList());
        evenListResult.addAll(oddListRevert);
        return evenListResult;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size() - 1)
                .mapToObj(i -> (arrayList.get(i) + arrayList.get(i + 1)) * 3)
                .collect(Collectors.toList());
    }

    private List<Integer> getEvenList(List<Integer> arrayList) {
        return arrayList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
    }
}
