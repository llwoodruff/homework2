package reflection;


import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.List;

public class main {
    private static Annotation[] Annotations;

    public static void main (String[] args) throws IOException, ClassNotFoundException {
        exercise1 ex1 = new exercise1();
        String pkgName = "pkg2"; //"pkg1";

        List<File> cl = ex1.processAnnotation(pkgName);

        String clType = "java.lang.Object";
        String classNameStr = null;
        System.out.println();
        for (File className : cl) {
            classNameStr = pkgName.concat("." + className.getName().replace(".class", ""));
            Class<?> classX = Class.forName(classNameStr);
            if(classX.isAnnotationPresent(ReflectionClass.class)){
                //System.out.println(classX.arrayType());
                AnnotatedType checkIu = classX.getAnnotatedSuperclass();
                //checkIu.equals("java.lang.Object")  //"java.lang.Object".equals(checkIu) // почему-то такое сравнение не срабатывает. хоть и выводится java.lang.Object
                if (checkIu != null){
                    System.out.println("Class with reflection  " + classNameStr);
                }
            }
        }
    }
}


