package com.bbz.example;

import java.util.HashSet;
import java.util.Set;

public class MainTest {


    public static void main(String[] args) {


        Set set=new HashSet();
        set.add("111");
        set.add("332");
        set.add("32");


        Test test=new Test(set);

       test.getSets().add("2323");

        System.out.printf("");
    }

    public static class Test{

        public Test(Set<String> sets) {
            this.sets = sets;
        }

        private Set<String> sets;

        public Set<String> getSets() {
            return sets;
        }

        public void setSets(Set<String> sets) {
            this.sets = sets;
        }
    }
}
