package com.abc.nerolac.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.abc.nerolac.DB.DBHelper;
import com.abc.nerolac.utility.Constants;

/**
 * Created by abc on 09-Jan-17.
 */
public class User  {

    public static final String TABLE_NAME = "User";
    public static final String COL_USER_ID = "UserId";
    public static final String COL_EMAIL_ID = "EmailId";
    public static final String COL_USER_NAME = "UserName";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_SECURITY_QUESTION = "SecurityQuestion";
    public static final String COL_SECURITY_QUESTION_ANSWER = "SecurityQuestionAnswer";

    private int userId;
    private String emailID;
    private String userName;
    private String userPassword;
    private String securityQuestion;
    private String securityQuestionAnswer;

    public String getForgotPassword(Context context,String userName,String securityQuestion,String securityAnswer)
    {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String query = "select * from " + TABLE_NAME + " WHERE "
                + COL_USER_NAME + " = '" + userName + "' and "
                + COL_SECURITY_QUESTION + " = '" + securityQuestion + "' and "
                + COL_SECURITY_QUESTION_ANSWER + " = '" + securityAnswer + "'";

        Cursor cursor = database.rawQuery(query, null);

        //Cursor cursor=db.query("LOGIN", null, " SECURITYHINT=?", new String[]{security}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }

        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(COL_USER_NAME));
        String question = cursor.getString(cursor.getColumnIndex(COL_SECURITY_QUESTION));
        String answer = cursor.getString(cursor.getColumnIndex(COL_SECURITY_QUESTION_ANSWER));

        String password ="";

        if(securityAnswer.equals(answer))
        {
            password= cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
            cursor.close();
        }
        return password;
    }

    public boolean authenticate(Context context) {

        boolean result = true;
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String query = "select * from " + TABLE_NAME + " WHERE "
                + COL_USER_NAME + " = '" + userName + "' and "
                + COL_PASSWORD + " = '" + userPassword + "'";
        /*
        String query = " select * from " + TABLE_NAME + " where " + COL_USER_NAME + " = '" + userName + "' and "
                + COL_PASSWORD + " = '" + userPassword + "'";
        */
        Cursor cursor = database.rawQuery(query,null);
        if(!cursor.isAfterLast()) {
            cursor.moveToNext();

            String userName = cursor.getString(cursor.getColumnIndex(COL_USER_NAME));
            int userId = cursor.getInt(cursor.getColumnIndex(COL_USER_ID));

            /*PreferenceManager.getDefaultSharedPreferences(context).edit()
                    .putString(Constants.LOGIN_USER_NAME,userName)
                    .commit();*/

            result = true;

            /*if(rememberMe == true) {
                PreferenceManager.getDefaultSharedPreferences(context).edit().
                putBoolean(Constants.LOGIN_STATUS,true).
                putString(Constants.LOGIN_USER_NAME,userName).
                putInt(Constants.LOGIN_USER_ID,userId).commit();
            }*/
        } else {
            result = false;
        }

        database.close();
        return result;
    }

    public boolean insert(Context context) {

        boolean result = true;

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // select * from table where userName = 'amit';
        String query = "select * from " + TABLE_NAME + " where "
                + COL_USER_NAME + " = '"+ userName +"'";

        Cursor cursor = db.rawQuery(query, null);

        if(!cursor.isAfterLast()) {
            Toast.makeText(context,"User already exixt",Toast.LENGTH_SHORT).show();
            result = false;
        }else {
            /*
            String insertQuery = " insert into "+ TABLE_NAME +"("+COL_USER_FULL_NAME+","+COL_USER_NAME+","+COL_USER_PASSWORD+"," +
                ""+COL_USER_Confirm_Password+") values("+editFullName.getText().toString()+","+editUserName.getText().toString()+"," +
                ""+editPassword.getText().toString()+","+editConfirmPassword.getText().toString()+");";

            db.execSQL(insertQuery);
            */

            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_EMAIL_ID, emailID);
            contentValues.put(COL_USER_NAME, userName);
            contentValues.put(COL_PASSWORD, userPassword);
            contentValues.put(COL_SECURITY_QUESTION,securityQuestion);
            contentValues.put(COL_SECURITY_QUESTION_ANSWER,securityQuestionAnswer);
            /*
            if(userPassword == userPassword) {
                contentValues.put(COL_CONFIRM_PASSWORD, userConfirmPassword);
            }else {
                Toast.makeText(context,"password is not matching",Toast.LENGTH_LONG).show();
            }
            */


            db.insert(TABLE_NAME, null, contentValues);
            result = true;
        }
        db.close();
        return result;
    }

    public User() {
    }

    public User(int userId, String emailID, String userName, String userPassword, String securityQuestion, String securityQuestionAnswer) {
        this.userId = userId;
        this.emailID = emailID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAnswer = securityQuestionAnswer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }

    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }
}
