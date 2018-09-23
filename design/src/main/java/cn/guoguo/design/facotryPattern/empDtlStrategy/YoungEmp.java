package cn.guoguo.design.facotryPattern.empDtlStrategy;

import cn.guoguo.design.facotryPattern.workAnnotion.EmpWorkRegion;
import cn.guoguo.design.策略模式.Coder;

@EmpWorkRegion(max = 10)
public class YoungEmp implements Coder{
    @Override
    public void code() {
        System.out.println("我打代码贼6，但是被产品打！");
    }

}
