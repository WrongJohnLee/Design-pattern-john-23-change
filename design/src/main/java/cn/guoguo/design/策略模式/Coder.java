package cn.guoguo.design.策略模式;

public interface Coder {
    void code();

    default void chat() {
        System.out.print("产品狗日的，提这啥鸡儿需求哟！");
    }
}
