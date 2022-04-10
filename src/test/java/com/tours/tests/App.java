package com.tours.tests;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class App {
    public static void main (String args[]) {
        String classpath = System.getProperty("java.class.path");
        String[] classPathValues = classpath.split(File.pathSeparator);
        System.out.println(Arrays.toString(classPathValues));
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\kumar\IdeaProjects\MasterFramework\target\test-classes
    }
}
