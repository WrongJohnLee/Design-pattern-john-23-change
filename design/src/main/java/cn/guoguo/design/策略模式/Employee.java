package cn.guoguo.design.策略模式;

import cn.guoguo.design.facotryPattern.DyFactory;
import cn.guoguo.design.facotryPattern.SimpleFacotry;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
    //算法值1
    private int workTime;
    //算法值2
    private int type;
    //具体策略接口1
    private Coder coder;
    //具体策略接口2
    private ProductManager pm;
    public static final int IS_CODER = 1;
    public static final int IS_PM = 2;

    public Employee(int type) {
        this.type = type;
    }

    public void work(int time) {
        workTime += time;
        //根据不同算法得到不同具体策略实现
        /*if (workTime > 10) {
            if (type == IS_CODER) {
                coder = SimpleFacotry.createCoder(this);
            } else if (type == IS_PM) {
                pm = new OldPM();
            }
        }else {
            if (type == IS_CODER){
                coder = SimpleFacotry.createCoder(this);
            }
            if (type == IS_PM) {
                pm = new YoungPM();
            }
        }*/
        coder = DyFactory.getInstance().createCoder(this);
    }

    //根据具体策略执行里面的逻辑
    public void doSomething() {
        //doSomthing
        /*if (type == IS_PM) {
            pm.chat();//策略具体实现
            pm.demand(LocalDate.now().toString());//策略具体实现
        }
        if (type == IS_CODER) {
            coder.chat();//策略具体实现
            coder.code();//策略具体实现
        }*/
        coder.chat();
        coder.code();
        //doSomthing
    }

    public int getWorkTime() {
        return workTime;
    }
}
