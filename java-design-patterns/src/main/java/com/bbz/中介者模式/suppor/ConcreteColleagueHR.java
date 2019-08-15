package com.bbz.中介者模式.suppor;

import com.bbz.中介者模式.Colleague;
import com.bbz.中介者模式.Mediator;

/**
 * com.bbz.中介者模式.suppor
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class ConcreteColleagueHR extends Colleague {

    public ConcreteColleagueHR(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String name) {
        mediator.constact(name, this);
    }

    public void getMessage(String msg) {
        System.out.println("HR#" + name + "#:" + msg);
    }
}
