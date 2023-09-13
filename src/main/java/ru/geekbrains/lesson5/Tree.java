package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "| ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                int subDirTotal = 0;
                int fileCounter = 0;

                for (File subFile : files) {
                    if (subFile.isDirectory()) {
                        subDirTotal++;
                    } else {
                        fileCounter++;
                    }
                }

                int counter = 0;

                for (File subFile : files) {
                    if (subFile.isDirectory()) {
                        counter++;
                        boolean isLastSubDir = counter == subDirTotal && fileCounter == 0;
                        print(subFile, indent + (isLast ? "  " : "| "), isLastSubDir);
                    } else {
                        System.out.print(indent);
                        if (counter == subDirTotal && fileCounter == 1) {
                            System.out.print("└─");
                        } else {
                            System.out.print("├─");
                        }
                        System.out.println(subFile.getName());
                    }
                }
            }
        }
    }
}
