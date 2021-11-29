package setRandom;

public class parameters {
    @RandomInt(key = 1, key1 = 99)
    private Integer value1;
    @RandomInt(key = 100, key1 = 200)
    private int value2;


    //@RandomInt(key = 100, key1 = 200)
    //private boolean value3;

    @RandomStr(key = 50, key1 = true)
    String value4;

    @RandomStr(key1 = false)
    String value5;

    public parameters(Integer value1, int value2, boolean value3) {
        this.value1 = value1;
        this.value2 = value2;
        //this.value3 = value3;
    }

    public parameters() {

    }
}
