package setRandom;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> parametersClass = Class.forName("setRandom.parameters");
        Random random = new Random();

        Integer val;
        final String strDef = "abcdefghijklmnopqrstuvwxyz";
        String val4 = null;

        for (Field field : parametersClass.getDeclaredFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations[0] instanceof RandomInt) {
                    RandomInt columnInteger = (RandomInt) annotations[0];
                    AnnotatedType fieldType = field.getAnnotatedType();
                    String ty = String.valueOf(fieldType);
                    if (ty.equals("java.lang.Integer")| ty.equals("int")) {
                        val = random.nextInt(columnInteger.key1() - columnInteger.key()) + columnInteger.key();
                        System.out.println("Random integer on field " + field.getName() + ": " + val);
                    } else {
                        throw new IllegalStateException("Annotation is indicated above a field is not Integer/int:  " + field.getName());
                    }
                }

                /*******************************************************/

                if (annotations[0] instanceof RandomStr) {
                    RandomStr columnString = (RandomStr) annotations[0];
                    AnnotatedType fieldType = field.getAnnotatedType();
                    String ty = String.valueOf(fieldType);
                    if (ty.equals("java.lang.String")) {
                        if(columnString.key() > 0) {
                            for (int i = 0; i < columnString.key(); i++) {
                                val4 = random.ints(columnString.key(), 0, strDef.length())
                                        .mapToObj(strDef::charAt)
                                        .map(Object::toString)
                                        .collect(Collectors.joining());
                            }

                            if (columnString.key1()) {
                                val4 = val4.toUpperCase(Locale.ROOT);
                            }
                            System.out.println("Random string " + field.getName() + ": " + val4);
                        } else {
                            throw new IllegalArgumentException("Invalid string length specified . Less than 1");
                        }
                    } else {
                        throw new IllegalStateException("Annotation is indicated above a field is not String:  " + field.getName());
                    }
                }

        }
    }


}
