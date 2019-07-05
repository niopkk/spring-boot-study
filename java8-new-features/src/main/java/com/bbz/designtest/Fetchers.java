package com.bbz.designtest;

import com.bbz.designtest.model.FetchJob;

import java.util.function.Consumer;

/**
 * com.bbz.designtest
 * <p>
 * Created by tianxin2 on 2019-07-04
 */
public interface Fetchers {

    FetchJob findOne(String id);

    interface JobBuilder {
        JobBuilder withType(String type);
    }


    FetchJob createJob(Consumer<JobBuilder> consumer);
}
