package cn.guoguo.design.策略模式;

import java.util.ArrayList;
import java.util.List;

public interface Devlopment {
    List<Coder> coders = new ArrayList<>();
    List<ProductManager> productMangers = new ArrayList<>();

    void devlop();

    default void entryCoder(Coder coder){
        coders.add(coder);
    }

    default void entryProductManger(ProductManager productManager){
        productMangers.add(productManager);
    }
}
