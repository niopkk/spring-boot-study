package com.bbz.consumer;

import com.bbz.util.Strings;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerMain {


    public static void main(String[] args) {
        String name = "";
        String name1 = "22323";
        validInput(name, iput -> System.out.println(Strings.isNotBlank(name) ? "名字正常" : "名字不能为空"));

        System.out.println(validInput1(name1, input -> Strings.isNotBlank(name1) ? "名字正常" : "名字不能为空"));

        Time time = createJob(jobBuild -> jobBuild.go("开始时间").end("结束时间"));
        System.out.printf(time.toString());
    }

    private static void validInput(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    private static String validInput1(String s, Function<String, String> function) {
        return function.apply(s);
    }

    static class Time {
        private String startTime;

        private String endTime;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    '}';
        }
    }

    private static Time createJob(Consumer<JobBuild> consumer) {
        Time time = new Time();
        JobBuildImpl build = new JobBuildImpl(time);
        consumer.accept(build);
        return time;
    }


    interface JobBuild {


        JobBuild go(String var);

        JobBuild end(String var1);
    }

    static class JobBuildImpl implements JobBuild {

        private Time time;

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public JobBuildImpl(Time time) {
            this.time = time;
        }

        @Override
        public JobBuild go(String var) {
            this.time.setStartTime(var);
            return this;
        }

        @Override
        public JobBuild end(String var1) {
            this.time.setEndTime(var1);
            return this;
        }
    }
}
