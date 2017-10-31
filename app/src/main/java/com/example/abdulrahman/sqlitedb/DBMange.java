package com.example.abdulrahman.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Abdulrahman on 20/10/17.
 */

public class DBMange extends SQLiteOpenHelper {
Context context;
    public DBMange(Context context){
        super(context,DBmodle.DBName,null,DBmodle.DBVersion);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(DBmodle.CreatTable);
        Toast.makeText(context,"Create Table ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("Drop table "+DBmodle.TableBame);
        onCreate(db);
    }
}
