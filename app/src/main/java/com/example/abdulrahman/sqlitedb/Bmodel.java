package com.example.abdulrahman.sqlitedb;

/**
 * Created by Abdulrahman on 23/10/17.
 */

public class Bmodel {
    String UserName;
    String Password;
    int ID;

    public Bmodel(String userName, String password, int ID) {
        UserName = userName;
        Password = password;
        this.ID = ID;
    }
}
