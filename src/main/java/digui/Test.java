package digui;

import java.lang.reflect.Method;

/**
 * @author masun
 * @date 2021/12/3
 */
public class Test {


    public static void main(String[] args) throws Exception {
        ShowA showA = new ShowA() {
            @Override
            public A getA() {
                return new A();
            }

            public void show() {
                System.out.println("Hello");
            }
        };

        Class<? extends ShowA> aClass = showA.getClass();
        Method show = aClass.getMethod("show");
        show.setAccessible(true);
        show.invoke(showA);


    }

    interface ShowA {
        A getA();
    }


    static class A {
        public A() {
            System.out.println(111);
        }

        public void show() {
            System.out.println(2);
        }

    }


}
