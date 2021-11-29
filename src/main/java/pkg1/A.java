package pkg1;

import reflection.ReflectionClass;

@ReflectionClass
public class A {
    String str;
    int cnt;

    A() {
        str = "строка";
        cnt = 3;
    }

    /**
     * Переопределение метода toString
     **/
    @Override
    public String toString() {
        return "A{" +
                "str='" + str + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
