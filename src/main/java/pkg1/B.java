package pkg1;


public class B {
    String str;
    int cnt;

    B() {
        str = "строка";
        cnt = 3;
    }

    /**
     * Переопределение метода toString
     **/
    @Override
    public String toString() {
        return "B{" +
                "str='" + str + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
