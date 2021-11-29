package reflection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class exercise1 {
    public List<File> processAnnotation(String pkgName) {
        String scanPkgName = pkgName.replace(".", "/");

        URL url = Thread.currentThread().getContextClassLoader().getResource(scanPkgName);
        File scanDir = new File(url.getFile());

        List<File> classes = new ArrayList<>();

        for (File file : scanDir.listFiles()) {
            classes.add(file);
        }

        return classes;
    }

}
