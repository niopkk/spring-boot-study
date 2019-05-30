package com.bbz;

import java.util.HashMap;
import java.util.Map;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019-05-30
 */
public class FunnelRateLimiter {

    static class Funnel {
        int capacity;//漏洞容量
        float leakingRate;//漏嘴流水速率
        int leftQuota; //漏斗剩余空间
        long leakingTs;//上一次漏斗时间


        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            leftQuota = capacity;
            leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs; // 距离上一次漏水过去了多久
            int deltaQuota = (int) (deltaTs * leakingRate);//又可以腾出不少空间了
            if (deltaQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (deltaQuota < 1) {// 腾出空间太小，最小单位是1
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTs;

            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }

    private Map<String, Funnel> funnels = new HashMap<>();

    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        return funnel.watering(1); // 需要1个quota
    }
}
