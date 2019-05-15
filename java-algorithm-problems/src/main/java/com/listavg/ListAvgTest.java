package com.listavg;

import java.util.*;

public class ListAvgTest {

    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        for (int i = 1; i < 2; i++) {
//            strings.add("" + i + "");
//        }
//        System.out.println(Jsons.toJson(splitListFloor(strings, 6)));

        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Map<String, Integer> map = new HashMap<>();
            if (i < 10) {
                map.put("0" + i, i);
            } else if (i > 10 && i < 20) {
                map.put("1" + i, i);
            } else {
                map.put("2" + i, i);
            }
            list.add(map);
        }
        System.out.println("排序后" + list);


        int[] ints = new int[]{1, 3, 4, 2, 54, 23, 43};

        int[] ints1={1,2,3};

        System.out.println(ints[3]);
        System.out.println(ints[3] = 89);


        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.set(2,10);
        System.out.println(lists);
    }


    private static <T> Map<String, List<T>> splitListFloor(List<T> list, int pageSize) {
        Map<String, List<T>> listMap = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i += pageSize) {
            int toIndex = i + pageSize > list.size() ? list.size() : i + pageSize;
            System.out.println("开始：" + i + "结束:" + toIndex);
            if (list.subList(i, toIndex).size() > 1) {
                listMap.put(i + 1 + "F-" + toIndex + "F", list.subList(i, toIndex));
            } else {
                listMap.put(toIndex + "F", list.subList(i, toIndex));
            }
        }
        listMap.put("全部楼层", list);
        return listMap;
    }
}
