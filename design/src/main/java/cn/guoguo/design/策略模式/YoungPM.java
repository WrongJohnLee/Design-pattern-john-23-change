package cn.guoguo.design.策略模式;

public class YoungPM implements ProductManager {
    @Override
    public void demand(String demand) {
        System.out.println("这个需求"+demand+"是不是很难，不急，慢慢来");
    }
}
