package com.kaavie.file;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 提供强大的文件查找器
 * <p>
 * Created by kaavie on 2017/5/9.
 */
public class DirectioryStreamStudy {
    /**
     * 查找path下所有的properties文件,不会找字目录
     */
    public static void findFile() {

        Path path = Paths.get("F:\\partner\\partner-manager\\src\\main\\resources");
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.properties");
            for (Path path2 : stream) {
                System.out.println(path2.getFileName());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 查找所有的文件,包括根目录
     */
    public static void findAllFile() {

        Path path = Paths.get("F:\\partner\\partner-manager");
        try {
            Files.walkFileTree(path, new MyFindJavaVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        findAllFile();
    }

}

class MyFindJavaVisitor extends SimpleFileVisitor<Path> {
    private int a;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".java")) {
            a++;
            System.out.println(a+"||"+file.getFileName()+"||"+file.toAbsolutePath());

        }
        return FileVisitResult.CONTINUE;
    }
}