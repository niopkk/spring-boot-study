package com.bbz.中介者模式.suppor;

import com.bbz.中介者模式.Colleague;
import com.bbz.中介者模式.Mediator;

/**
 * com.bbz.中介者模式.suppor
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class ConcreteColleagueAndroidDeveloper extends Colleague {

    public ConcreteColleagueAndroidDeveloper(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message) {
        mediator.constact(message, this);
    }

    public void getMessage(String msg) {
        System.out.println("Android Developer#" + name + "#:" + msg);
    }
}
