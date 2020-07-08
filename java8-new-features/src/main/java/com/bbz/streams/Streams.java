package com.bbz.streams;

import com.bbz.util.Jsons;
import com.bbz.util.Lists;
import com.bbz.util.Strings;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {


        List<Type> list1 = Lists.of(new Type("1", "飞机"), new Type("2", "飞机"));
        List<Type> list2 = Lists.of(new Type("2", "火车"), new Type("2", "火车"));
        List<Type> list3 = Lists.of(new Type("3", "旅店"), new Type("3", "旅店"), new Type("3", "旅店"));


        System.out.println(total(list1) + total(list2) + total(list3));

        List<Types> collect = Stream.of(com.bbz.util.Streams.of(list1).map(Type::toVo), com.bbz.util.Streams.of(list2).map(Type::toVo), com.bbz.util.Streams.of(list3).map(Type::toVo)).flatMap(v -> v).collect(Collectors.toList());

        for (Types t : collect) {
            System.out.println(t.getName() + ":" + t.getType());
        }
        List<String> list = null;
        long count = com.bbz.util.Streams.of(list).count();
        System.out.println("dd:" + count);

    }



    public static Long total(List<Type> list) {

        return list != null ? list.size() : 0L;
    }


    static class Type {
        public Types toVo() {

            return Types.of(name, type);
        }


        private String name;

        private String type;

        public Type(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    static class Types {


        private String name;

        private String type;

        public static Types of(String name, String type) {
            Types types = new Types();
            types.setName(name);
            types.setType(type);
            return types;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }
}
