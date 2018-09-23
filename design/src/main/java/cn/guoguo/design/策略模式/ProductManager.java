package cn.guoguo.design.策略模式;

public interface ProductManager {
    void demand(String demand);

    default void chat() {
        System.out.print("这尼玛开发，天天造bug，客户叼爆我们了");
    }
}
