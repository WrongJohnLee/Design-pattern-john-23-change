package cn.guoguo.design.facotryPattern;

import cn.guoguo.design.facotryPattern.workAnnotion.EmpWorkRegion;
import cn.guoguo.design.策略模式.Coder;
import cn.guoguo.design.策略模式.Employee;
import cn.guoguo.design.策略模式.OldCoder;
import cn.guoguo.design.策略模式.YoungCoder;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 工厂模式的特征，创建对象由工厂统一创建，而不是对象本身
 */
public class DyFactory {
    //具体策略包名
    private static final String EMP_DTL_STRATEGY_PCK = "cn.guoguo.design.facotryPattern.empDtlStrategy";
    //类加载器
    private ClassLoader classLoader = getClass().getClassLoader();
    //策略列表
    private List<Class<? extends Coder>> empDtlStrategyList;

    //根据总工作时间产生不同的策略
    public Coder createCoder(Employee employee) {
        for (Class<? extends Coder> coderStgy : empDtlStrategyList) {
            EmpWorkRegion empWorkRegion = coderStgy.getDeclaredAnnotation(EmpWorkRegion.class);
            //根据注解的属性（算法），获取不同的策略
            if (empWorkRegion != null &&
                    employee.getWorkTime() > empWorkRegion.min() &&
                    employee.getWorkTime() < empWorkRegion.max()){
                try {
                    return coderStgy.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //私有构造，单例
    private DyFactory() {
        init();
    }

    //提供唯一入口获取全局唯一对象
    public static DyFactory getInstance() {
        return DyFactoryInstance.instance;
    }

    //私有静态类里面new私有静态类
    private static class DyFactoryInstance {
        private static DyFactory instance = new DyFactory();
    };

    private void init() {
        empDtlStrategyList = new ArrayList<>();
        File[] resources = getResources();
        Class<Coder> coderStgyClazz = null;
        try {
            coderStgyClazz = (Class<Coder>) classLoader.loadClass(Coder.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (File resource : resources) {
            try {
                //获取指定包下的实现而不是基类或者接口的策略类
                Class<?> clazz = classLoader.loadClass(EMP_DTL_STRATEGY_PCK+ "." + resource.getName().replace(".class", ""));
                if (Coder.class.isAssignableFrom(clazz) && clazz != coderStgyClazz) {
                    empDtlStrategyList.add((Class<? extends Coder>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //获取包下的class文件
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(EMP_DTL_STRATEGY_PCK.replace(".", "/")).toURI());
            return file.listFiles((FileFilter) pathname -> {
                if (pathname.getName().endsWith(".class")){
                    return true;
                }
                return false;
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }
}
