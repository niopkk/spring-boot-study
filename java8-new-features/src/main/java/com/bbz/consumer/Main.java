package com.bbz.consumer;

import com.bbz.util.Jsons;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {


        System.out.println(10 / 3);
        List<Camera> list = new ArrayList<>();
        Camera camera1 = new Camera();
        camera1.setName("测试1组");
        camera1.setProvider("a");
        list.add(camera1);
        Camera camera2 = new Camera();
        camera2.setName("测试....");
        camera2.setProvider("a");
        list.add(camera2);
        Camera camera3 = new Camera();
        camera3.setName("测试。。。34");
        camera3.setProvider("b");
        list.add(camera3);
        Camera camera4 = new Camera();
        camera4.setName("测试2332");
        camera4.setProvider("b");
        list.add(camera4);

        List list1 = new ArrayList();
        list1.add(null);
        list1.add(null);
        System.out.println(list1);

        //存放apple对象集合
        List<Apple> appleList = new ArrayList<>();


        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.err.println("groupBy:" + groupBy);

        Map<String, List<Camera>> stringListMap = list.stream().collect(Collectors.groupingBy(Camera::getProvider));
        List<TreeView> lists = new ArrayList<>();
        stringListMap.forEach((k, v) -> {
            TreeView view = new TreeView();
            view.setName(k);
            List<TreeView> treeViews = v.stream().map(vi -> {
                TreeView child = new TreeView();
                child.setName(vi.getName());
                child.setId(vi.getProvider());
                return child;
            }).collect(Collectors.toList());
            view.setChildren(treeViews);
            lists.add(view);
        });
        System.out.println(Jsons.toJson(lists));


        String[] s = new String[]{"1", "2"};
        Arrays.stream(s).peek(v -> System.err.println(v.replace("1", "*"))).collect(Collectors.toList());


        double ff = 0.1 * 0.1;
        System.out.println(ff);
    }

}

class TreeView {

    private String id;

    private String name;

    private boolean open = false;

    private boolean nocheck = false;

    private List<TreeView> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

    public List<TreeView> getChildren() {
        return children;
    }

    public void setChildren(List<TreeView> children) {
        this.children = children;
    }
}

class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }
}

class Camera {
    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备厂商
     */
    private String provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
