package com.example.abdulrahman.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by Abdulrahman on 20/10/17.
 */

public class DBSql {
    DBMange mange;
    public DBSql(Context context){
        mange=new DBMange(context);
    }

    public long insert (String user,String pass){
        SQLiteDatabase database=mange.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DBmodle.Coluuser,user);
        values.put(DBmodle.ColuPassword,pass);
        long id=database.insert(DBmodle.TableBame,"",values);

        return id;
    }

    public Cursor querasy (String [] projection,String selection , String [] selectionArr,String SortOrder){
        SQLiteDatabase database=mange.getWritableDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder=new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(DBmodle.TableBame);

        Cursor cursor=sqLiteQueryBuilder.query(database,projection,selection,selectionArr,null,null,SortOrder);

        return cursor;

    }

    public int delect(String Selection, String[] SlectionArg){
       SQLiteDatabase sqLiteDatabase=mange.getWritableDatabase();
        int count =sqLiteDatabase.delete(DBmodle.TableBame,Selection,SlectionArg);
        return count;
    }
}
