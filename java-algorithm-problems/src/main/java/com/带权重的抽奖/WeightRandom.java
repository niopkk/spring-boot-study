package com.带权重的抽奖;

import java.util.Arrays;
import java.util.Random;

/**
 * com.带权重的抽奖
 * <p>
 * Created by tianxin2 on 2019/12/12
 */
public class WeightRandom {

    private Pair[] options;

    private double[] cumulativeProbabilities;

    private Random rnd;

    public WeightRandom(Pair[] options) {
        this.options = options;
        this.rnd = new Random();
        prepare();
    }

    private void prepare() {
        int weights = 0;
        for (Pair pair : options) {
            weights += pair.getWeight();//计算 累计权重
        }
        System.out.println("weight..." + weights);
        cumulativeProbabilities = new double[options.length];
        int sum = 0;
        for (int i = 0; i < options.length; i++) {
            sum += options[i].getWeight();
            cumulativeProbabilities[i] = sum / (double) weights;
        }
        System.out.println("cumulativeProbabilities...:" + Arrays.toString(cumulativeProbabilities));
    }

    public Object nextItem() {
        double randomValue = rnd.nextDouble();
        int index = Arrays.binarySearch(cumulativeProbabilities, randomValue);
        if (index < 0) {
            index = -index - 1;
        }
        return options[index].getItem();
    }
}
