package com.kaavie.file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *文件路径
 * Created by kaavie on 2017/5/9.
 */
public class Pathstudy {

    public static void  main(String[] args){

   //     Path path = Paths.get("F:\\partner\\partner-manager");

        Path path2 =Paths.get("pom.xml");
System.out.println(path2.toAbsolutePath());
        System.out.println(path2.getFileName());
        System.out.println(path2.getNameCount());
        System.out.println(path2.getParent());
        System.out.println(path2.getRoot());
        System.out.println(path2.subpath(0,2));


    }
}
