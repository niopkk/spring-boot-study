package com.higharray;

import com.bbz.util.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * com.higharray
 * <p>
 * Created by tianxin2 on 2019-05-15
 */
public class MainTest {


    public static void main(String[] args) {

        HighArray highArray = new HighArray(100);


        highArray.insert(77);
        highArray.insert(99);
        highArray.insert(44);
        highArray.insert(55);
        highArray.insert(22);
        highArray.insert(88);
        highArray.insert(11);
        highArray.insert(00);
        highArray.insert(66);
        highArray.insert(33);

        highArray.display();

        int seachKey = 35;

        if (highArray.find(seachKey)) {
            System.out.println("found :" + seachKey);
        } else {
            System.out.println("can't  find: " + seachKey);
        }


        highArray.del(00);
        highArray.del(55);
        highArray.del(99);
        highArray.display();


        int[] oldArray = {1, 2, 3, 4, 5, 6, 434, 23, 53, 54, 545};

        System.out.println("前:" + oldArray.length);
        nodups(6, oldArray);
        nodups(1, oldArray);
        nodups(2, oldArray);
        System.out.println(Arrays.toString(oldArray));
        System.out.println("后:" + oldArray.length);
    }

    private static boolean nodups(int value, int... array) {

        int i;
        int len = array.length;
        for (i = 0; i < len - 1; i++) {
            if (value == array[i]) {
                break;
            }
        }
        if (i == len) {
            return false;
        } else {
            for (int j = i; j < len - 1; j++) {
                array[j] = array[j + 1];
            }

            return true;
        }
    }
}
