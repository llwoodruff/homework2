package pkg2;

import reflection.ReflectionClass;

@ReflectionClass
public class C {
    String str;
    int cnt;

    C() {
        str = "строка";
        cnt = 3;
    }

    /**
     * Переопределение метода toString
     **/
    @Override
    public String toString() {
        return "C{" +
                "str='" + str + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
