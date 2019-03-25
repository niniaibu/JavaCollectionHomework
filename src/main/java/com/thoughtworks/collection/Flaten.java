package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] integers : array) {
            for (Integer integer : integers) {
                result.add(integer);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] integers : array) {
            for (Integer integer : integers) {
                if (!result.contains(integer)) {
                    result.add(integer);
                }
            }
        }
        return result;
    }
}
