package com.bbz.中介者模式;

import com.bbz.中介者模式.suppor.ConcreteColleagueAndroidDeveloper;
import com.bbz.中介者模式.suppor.ConcreteColleagueHR;
import com.bbz.中介者模式.suppor.ConcreteMediator;

/**
 * com.bbz.中介者模式
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class MainTest {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleagueHR hr = new ConcreteColleagueHR("Google招聘专员", mediator);
        ConcreteColleagueAndroidDeveloper ad = new ConcreteColleagueAndroidDeveloper("屌丝开发者", mediator);

        mediator.setHr(hr);
        mediator.setAd(ad);

        hr.constact("Hi，你有意向来我们公司吗？");
        ad.constact("是Google开发Android吗？");
        hr.constact("yes!");
        ad.constact("我愿意！");

    }
}
