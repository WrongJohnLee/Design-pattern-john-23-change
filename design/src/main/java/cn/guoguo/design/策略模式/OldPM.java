package cn.guoguo.design.策略模式;

public class OldPM implements ProductManager {
    @Override
    public void demand(String demand) {
        System.out.println("这个需求"+demand+"我明天就要，你今晚通通宵帮我做出来吧！");
    }
}
