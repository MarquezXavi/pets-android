package com.sezzh.pets.io.db;

/**
 * Created by sezzh on 26/09/16.
 */
public class DbConstants {

    public final static int DATABASE_VERSION = 2;
    public final static String DATABASE_NAME = "pet.db";
    public final static String PET_TABLE_NAME = "pet";
    public final static  String PET_TABLE_CREATE =
            "CREATE TABLE " + PET_TABLE_NAME + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "avatar TEXT);";
}
