package com.mygdx.game.Typing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private static long lineCount, randomLineNumber;

   public static String getNewRandomString(){
       StringBuilder sb = new StringBuilder();

       return sb.toString();
    }

//    public static String getRandomWord(){
//
//    }
public static void openFile() {
    // Get a FileHandle to the file located in the assets folder
    FileHandle fileHandle = Gdx.files.internal("words.txt");

    // Check if the file exists
    if (fileHandle.exists()) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileHandle.read()))) {
            // Read the lines from the file
            long lineCount = reader.lines().count();
            if (lineCount == 0) {
                System.out.println("File is empty");
                return;
            }

            Random random = new Random();
            long randomLineNumber = random.nextInt((int) lineCount) + 1;

            // Reset the reader's position
            reader.close();
            BufferedReader newReader = new BufferedReader(new InputStreamReader(fileHandle.read()));

            // Skip to the random line and read it
            String randomLine = newReader.lines().skip(randomLineNumber - 1).findFirst().orElse(null);

            System.out.println("Random Line: " + randomLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("File does not exist: " + fileHandle.path());
    }
}




}
