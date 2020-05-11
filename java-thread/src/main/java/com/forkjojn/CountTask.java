package com.forkjojn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class CountTask extends RecursiveTask<Long> {

    private static final int THERSHOLD = 1000;

    private long start;

    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THERSHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;

            List<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask subtask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subtask);
                subtask.fork();
            }
            for (CountTask task : subTasks) {
                sum += task.join();
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 2000);
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(task);
        try {
            final Long aLong = forkJoinTask.get();



            System.out.println("aLong...." + aLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
