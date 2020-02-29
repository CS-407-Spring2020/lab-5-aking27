package c.sakshi.lab5;

import android.database.sqlite.SQLiteDatabase;

public class DBHelper {
    SQLiteDatabase sqLiteDatabase;
    public DBHelper(SQLiteDatabase sqLiteDatabase){
        this.sqLiteDatabase = sqLiteDatabase;
    }
    public void createTable(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notes " +
                "(id INTEGER PRIMARY KEY, username TEXT, date TEXT, title TEXT, content TEXT, srcTEXT)");

    }
}
