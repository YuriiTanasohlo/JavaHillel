package main.java.Package.Lesson22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Decrypt {
    final private String hash = "5f50dfa5385e66ce46ad8d08a9c9be68";
    final private int minLength = 6;
    final private int maxLength = 12;
    final private String passwordSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
    final private int countOfThreads = 8;
    private final int step = passwordSymbols.length();
    


    ExecutorService executorService = Executors.newFixedThreadPool(countOfThreads);

    public void getLength(){
        System.out.println(passwordSymbols.length());
    }
}
