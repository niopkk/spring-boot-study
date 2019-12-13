package com.enummap;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * com.enummap
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class Clothes {
   private String id;
   private Size size;

    public Clothes() {
    }

    public Clothes(String id, Size size) {
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public static Map<Size, Integer> countBySize(List<Clothes> clothes) {
        Map<Size, Integer> map = new EnumMap<>(Size.class);
        for (Clothes clo : clothes) {
            Size size = clo.getSize();
            Integer count = map.get(size);
            if (count != null) {
                map.put(size, count + 1);
            } else {
                map.put(size, 1);
            }
        }
        return map;
    }
}
