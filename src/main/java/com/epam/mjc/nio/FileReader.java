package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {

        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

//        Path input = Paths.get("C:\\Users\\1\\Desktop\\MJC School\\1_Stage\\stage1-module7-nio-task1\\src\\main\\resources\\Profile.txt");
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file));) {
            name = reader.readLine().split(": ")[1];
            age = Integer.parseInt(reader.readLine().split(": ")[1]);
            email = reader.readLine().split(": ")[1];
            phone = Long.parseLong(reader.readLine().split(": ")[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            List<String> lines = Files.readAllLines(input);
//            name = lines.get(0).split(": ")[1];
//            age = Integer.parseInt(lines.get(1).split(": ")[1]);
//            email = lines.get(2).split(": ")[1];
//            phone = Long.parseLong(lines.get(3).split(": ")[1]);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return new Profile(name, age, email, phone);
    }
}
