package com.dov.database;

public class DBProcessorMain {
    public static void main(String[] args) {
        DBProcessor dbProcessor = new DBProcessor();
        try {
            dbProcessor.readDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
