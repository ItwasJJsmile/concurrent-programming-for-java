package org.lester.concurrence.chapterOne;

/**
 * Created by Dr.Lester on 2017/9/30.
 * 模板方法
 */
public class TemplateMethod {

    public final void print(String message) {
        System.out.println("################");
        wrapPrint(message);
        System.out.println("################");
    }

    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }
        };
        t1.print("Hello Thread");

        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };

        t2.print("Hello Thread");

    }

    /*
        注意：
             wrapPrint可以写成一个空的实现，也可以写成抽象方法，
             start方法里面没有写成抽象的，那我也不写成抽象的，
             在真正的模板方法里面要写成抽象类，抽象方法，这里不需要。
     */
}
