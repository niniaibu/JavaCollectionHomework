package com.thoughtworks.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Reduce {

    private List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    public double getAverage() {
        double sum = arrayList.stream().mapToDouble(integer -> integer).sum();
        return sum / arrayList.size();

    }

    public double getOrderedMedian() {
        double median = arrayList.get(arrayList.size() / 2);
        if (arrayList.size() % 2 == 0) {
            median = (median + arrayList.get((arrayList.size() / 2) - 1)) / 2.0;
        }
        return median;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(n -> n % 2 == 0).findFirst().orElse(0);
    }

    public int getIndexOfFirstEven() {
        int firstOfEven = arrayList.stream().filter(integer -> integer % 2 == 0).findFirst().orElse(-1);
        return arrayList.indexOf(firstOfEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() != arrayList.size()) {
            return false;
        } else {
            return IntStream.range(0, arrayList.size()).allMatch(i -> this.arrayList.get(i).equals(arrayList.get(i)));
        }
    }

    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        double medianLinkList;
        int size = arrayList.size();
        medianLinkList = singleLink.getNode(size / 2 + 1);
        if (size % 2 != 1) {
            medianLinkList = (medianLinkList + singleLink.getNode(size / 2)) / 2.0;
        }
        return medianLinkList;
    }

    public int getLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.stream().filter(integer -> integer % 2 == 1).findFirst().orElse(-1);
    }

    public int getIndexOfLastOdd() {
        Collections.reverse(arrayList);
        int lastOfOdd = arrayList.stream().filter(integer -> integer % 2 == 1).findFirst().orElse(-1);
        return arrayList.size() - 1 - arrayList.indexOf(lastOfOdd);
    }
}
