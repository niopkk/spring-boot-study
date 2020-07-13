package com.二分查找_有序数组;

public class BinarySearch {


    public static void main(String[] args) {
        HighArray highArray = new HighArray(10);
        highArray.insert(5);
        highArray.insert(1);
        highArray.insert(4);
        highArray.insert(2);
        highArray.insert(3);

        highArray.insert(7);
        highArray.insert(6);

        highArray.insert(8);
        highArray.insert(9);
        highArray.insert(10);

        highArray.delete(10);


        highArray.display();



        System.out.println("---------");

        int i = highArray.find(9);

        System.out.println(i);

    }


}
