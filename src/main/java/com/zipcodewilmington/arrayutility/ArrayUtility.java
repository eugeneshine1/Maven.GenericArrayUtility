package com.zipcodewilmington.arrayutility;

import java.sql.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <E>{
    private List<E> list;
    public ArrayUtility(E[] array) {
        list = new ArrayList<>(Arrays.asList(array));
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        list.addAll(new ArrayList<>(Arrays.asList(arrayToMerge)));
        int maxCount =0;
        E freq = list.get(0);
        for(E e : list) {
            int count=0;
            for (E a : list) {
                if (e==a){
                    count++;
                }
            }
            if(count>maxCount){
                count=maxCount;
                freq= e;
            }
        }
        return freq;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        list.addAll(new ArrayList<>(Arrays.asList(arrayToMerge)));
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        list.addAll(new ArrayList<>(Arrays.asList()));
        int x = 0;
        for (E e :list) {
            if (e==valueToEvaluate) {
                x++;
            }
        }
        return x;
    }

    public E[] removeValue(E valueToRemove) {
        list.removeIf(i -> Objects.equals(i, valueToRemove));
        if (valueToRemove instanceof Integer) {
            return (E[]) list.toArray(new Integer[0]);
        } else if (valueToRemove instanceof String) {
            return (E[]) list.toArray(new String[0]);
        } else {
            return (E[]) list.toArray(new Long[0]);
        }
    }
}
