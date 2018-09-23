package cn.guoguo.design.facotryPattern.empDtlStrategy;

import cn.guoguo.design.facotryPattern.workAnnotion.EmpWorkRegion;
import cn.guoguo.design.策略模式.Coder;

@EmpWorkRegion(min = 11)
public class OldEmp implements Coder {
    @Override
    public void code() {
        System.out.println("我打代码贼6，还能打产品经理！");
    }
}
