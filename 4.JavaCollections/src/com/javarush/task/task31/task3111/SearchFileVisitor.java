package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private boolean isPartOfName;
    private boolean isPartOfContent;
    private boolean isMinSize;
    private boolean isMaxSize;
    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        isPartOfName = false;
        isPartOfContent = false;
        isMinSize = false;
        isMaxSize = false;
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        //1 условие
        if (partOfName!=null){
            if (file.getFileName().toString().contains(partOfName)) isPartOfName = true;
        }
        else isPartOfName = true;

        //2 условие
        if (partOfContent!=null){
            String str = new String(content);
            if (str.contains(partOfContent)) isPartOfContent = true;
        }
        else isPartOfContent = true;

        //3 условие
        if (minSize!=0){
            if (content.length > minSize) isMinSize = true;
        }
        else isMinSize = true;

        //4 условие
        if (maxSize!=0){
            if (content.length < maxSize) isMaxSize = true;
        }
        else isMaxSize = true;

        if (isPartOfName && isPartOfContent && isMinSize && isMaxSize)
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public void setPartOfName (String partOfName){
        this.partOfName = partOfName;
    }

    public void setPartOfContent (String partOfContent){
        this.partOfContent = partOfContent;
    }

    public void setMinSize (int minSize){
        this.minSize = minSize;
    }

    public void setMaxSize (int maxSize){
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles(){

        return foundFiles;
    }
}
