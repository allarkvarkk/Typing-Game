package com.mygdx.game.Typing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Logic {
    private static long lineCount, randomLineNumber;

   public static ArrayList<String> getNewRandomString(){
       ArrayList<String> paragraph = new ArrayList<>();
       Random random = new Random();
       int i = random.nextInt(20) + 40;
       for(; i >= 0; i --){
           paragraph.add(getRandomWord());
       }
       return paragraph;
    }

//    public static String getRandomWord(){
//
//    }
public static String getRandomWord() {
    // Get a FileHandle to the file located in the assets folder
    FileHandle fileHandle = Gdx.files.internal("words.txt");

    if (fileHandle.exists()) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileHandle.read()))) {
            // Read the lines from the file
            long lineCount = reader.lines().count();
            if (lineCount == 0) {
                System.out.println("File is empty");
                return "error";
            }

            Random random = new Random();
            long randomLineNumber = random.nextInt((int) lineCount) + 1;

            // Reset the reader's position
            reader.close();
            BufferedReader newReader = new BufferedReader(new InputStreamReader(fileHandle.read()));

            // Skip to the random line and read it
            String randomLine = newReader.lines().skip(randomLineNumber - 1).findFirst().orElse(null);

            return randomLine;
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("File does not exist: " + fileHandle.path());
    }
    return "error";
}




}
