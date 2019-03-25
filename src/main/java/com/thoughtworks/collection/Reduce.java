package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int max = arrayList.stream().max(Comparator.naturalOrder()).get();
        return max;
    }

    public double getMinimum() {
        int min = arrayList.stream().min(Comparator.naturalOrder()).get();
        return min;
    }

    public double getAverage() {
        double sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        double average = sum / arrayList.size();
        return average;

    }

    public double getOrderedMedian() {
        double median;
        if (arrayList.size() % 2 != 0) {
            median = arrayList.get(arrayList.size() / 2);
        } else {
            median = (arrayList.get(arrayList.size() / 2) + arrayList.get((arrayList.size() / 2) - 1)) / 2.0;
        }
        return median;
    }

    public int getFirstEven() {
        int firstEven = arrayList.stream().filter(n -> n % 2 == 0).findFirst().get();
        return firstEven;
    }

    public int getIndexOfFirstEven() {
        int index = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() != arrayList.size()) {
            return false;
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (this.arrayList.get(i) != arrayList.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        for (int i = 0; i < arrayList.size(); i++) {
            singleLink.addTailPointer(arrayList.get(i));

        }
        double medianLinkList;
        int size = arrayList.size();
        if (size % 2 == 1) {
            medianLinkList = singleLink.getNode(size/2 + 1);
        } else {
            medianLinkList = (singleLink.getNode(size / 2 + 1) + singleLink.getNode(size / 2)) / 2.0;
        }
        return medianLinkList;
    }

    public int getLastOdd() {
        int lastOdd = -1;
        for (int i = arrayList.size() - 1; i >= 0; i++) {
            if (arrayList.get(i) % 2 == 1) {
                lastOdd = arrayList.get(i);
                break;
            }
        }
        return lastOdd;
    }

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size() - 1; i > 0; i--) {
            if (arrayList.get(i) % 2 == 1) {
                return i;
            }
        }
        return -1;
    }
}
