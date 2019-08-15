package com.bbz.中介者模式.suppor;

import com.bbz.中介者模式.Colleague;
import com.bbz.中介者模式.Mediator;

/**
 * com.bbz.中介者模式.suppor
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class ConcreteMediator extends Mediator {

    private ConcreteColleagueHR hr;
    private ConcreteColleagueAndroidDeveloper ad;

    public ConcreteColleagueHR getHr() {
        return hr;
    }

    public void setHr(ConcreteColleagueHR hr) {
        this.hr = hr;
    }

    public ConcreteColleagueAndroidDeveloper getAd() {
        return ad;
    }

    public void setAd(ConcreteColleagueAndroidDeveloper ad) {
        this.ad = ad;
    }

    @Override
    public void constact(String message, Colleague colleague) {
        if (colleague == hr) {
            ad.getMessage(message);
        } else {
            hr.getMessage(message);
        }
    }
}
