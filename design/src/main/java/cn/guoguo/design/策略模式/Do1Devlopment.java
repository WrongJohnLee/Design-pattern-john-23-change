package cn.guoguo.design.策略模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Do1Devlopment implements Devlopment {

    @Override
    public void devlop() {
        productMangers.forEach(pm -> {
            coders.forEach(devloper -> {
                Random random = new Random();
                pm.demand("[需求]"+random.nextInt(2));
                devloper.code();
                if (pm instanceof YoungPM && devloper instanceof YoungCoder) {
                    //System.out.print("");
                }
                else if (pm instanceof YoungPM && devloper instanceof OldCoder) {

                }
                else if (pm instanceof OldPM && devloper instanceof YoungCoder) {

                }
                else if (pm instanceof OldPM && devloper instanceof OldCoder) {

                }
             }
            );
                }

        );
    }

    public static void main(String[] args) {
        Devlopment do1Devlopment = new Do1Devlopment();
        Random random = new Random();
        for (int j = 0;j < 10; j++) {
            Employee employee = new Employee(random.nextInt(5));
            for (int i = 0; i < 10; i++) {
                employee.work(random.nextInt(5));
                employee.doSomething();
                //do1Devlopment.entryCoder(employee);
            }
        }

    }
}
