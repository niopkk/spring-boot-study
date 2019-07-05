package com.bbz.designtest.impl;

import com.bbz.designtest.Fetchers;
import com.bbz.designtest.model.FetchJob;

import java.util.function.Consumer;

/**
 * com.bbz.designtest.impl
 * <p>
 * Created by tianxin2 on 2019-07-04
 */
public class FetchersImpl implements Fetchers {
    @Override
    public FetchJob findOne(String id) {
        return null;
    }

    @Override
    public FetchJob createJob(Consumer<JobBuilder> consumer) {
        FetchJob job = new FetchJob();
        JobBuildImpl build = new JobBuildImpl(job);
        consumer.accept(build);
        return job;
    }

    private class JobBuildImpl implements JobBuilder {
        FetchJob fetchJob;

        public JobBuildImpl(FetchJob fetchJob) {
            this.fetchJob = fetchJob;
        }

        @Override
        public JobBuilder withType(String type) {
            fetchJob.setType(type);
            return this;
        }
    }
}
