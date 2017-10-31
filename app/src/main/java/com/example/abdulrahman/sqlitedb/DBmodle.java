package com.example.abdulrahman.sqlitedb;

/**
 * Created by Abdulrahman on 20/10/17.
 */

public class DBmodle {
    public static  final String DBName="Student";
    public static  final  String TableBame="Login";
    public static  final String Coluuser="UeserNmae";
    public static final String ColuPassword="Password";
    public static final int DBVersion=1;

    public static  final String CreatTable="Create table "+TableBame+
            "(ID integer PRIMARY KEY AUTOINCREMENT ,"+Coluuser+" TEXT,"+ColuPassword+" TEXT);";
}
