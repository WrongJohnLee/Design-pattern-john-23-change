package cn.guoguo.design.facotryPattern;

import cn.guoguo.design.策略模式.*;

public class SimpleFacotry {
    //私有构造函数
    private SimpleFacotry() {

    }

    //只提供全局唯一入口
    public static Coder createCoder(Employee employee) {
        if (employee.getWorkTime() > 10) {
            return new OldCoder();
        }else {
            return new YoungCoder();
        }
    }
}
