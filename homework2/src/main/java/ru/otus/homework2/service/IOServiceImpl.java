package ru.otus.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final PrintWriter printWriter;
    private final Scanner scanner;

    public IOServiceImpl(@Value("#{ T(java.lang.System).out }") PrintStream printStream,
                         @Value("#{ T(java.lang.System).in }") InputStream inputStream) {
        this.printWriter = new PrintWriter(printStream, true);
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public void write(String outputString) {
        printWriter.println(outputString);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }
}