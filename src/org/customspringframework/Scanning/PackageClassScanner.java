package org.customspringframework.Scanning;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Scans a given package and loads all class definitions.
 */
public class PackageClassScanner {

    private final List<Class<?>> discoveredClasses;

    public PackageClassScanner(String packageName) {
        this.discoveredClasses = scanPackage(packageName);
    }

    private List<Class<?>> scanPackage(String packageName) {
        String path = packageName.replace('.', '/');
        File directory = new File(ClassLoader.getSystemResource(path).getFile());
        try {
            return findClasses(directory, packageName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to scan classes in package: " + packageName, e);
        }
    }

    private List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) return classes;

        File[] files = directory.listFiles();
        if (files == null) return classes;

        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().replace(".class", "");
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }

    public List<Class<?>> getDiscoveredClasses() {
        return discoveredClasses;
    }
}
