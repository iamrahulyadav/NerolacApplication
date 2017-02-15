package com.abc.nerolac.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.abc.nerolac.model.User;

/**
 * Created by abc on 09-Jan-17.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "nerolac.sqlite";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + User.TABLE_NAME + " (" + User.COL_USER_ID + " integer primary key autoincrement, "
                + User.COL_EMAIL_ID + " TEXT, " + User.COL_USER_NAME + " TEXT, " + User.COL_PASSWORD + " TEXT, "
                + User.COL_SECURITY_QUESTION + " TEXT, "
                + User.COL_SECURITY_QUESTION_ANSWER + " TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
