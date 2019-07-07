package com.example.tieubob.tracnghiem.question;



import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_PATH = "/data/data/com.example.tieubob.tracnghiem/databases/";
    public static String DB_NAME = "dbtracnghiem.sqlite";
    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    public void openDataBase() throws SQLException {
        Log.w("mylog","open");
        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void deleteDataBase() {
        String myPath = DB_PATH + DB_NAME;
        SQLiteDatabase.deleteDatabase(new File(myPath));
    }

    @Override
    public synchronized void close() {

        if (myDataBase != null)
            myDataBase.close();

        super.close();

    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //database chua ton tai
        }

        if (checkDB != null)
            checkDB.close();

        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {

        //mo db trong thu muc assets nhu mot input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        //duong dan den db se tao
        String outFileName = DB_PATH + DB_NAME;

        //mo db giong nhu mot output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //truyen du lieu tu inputfile sang outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Dong luon
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase(); //kiem tra db

        if (dbExist) {
            //khong lam gi ca, database da co roi
//            copyDataBase();
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase(); //chep du lieu
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
    //Lấy danh sách câu hỏi
    public ArrayList<Question> getQuestion(String num_exam, String subject){
        ArrayList<Question> lsData= new ArrayList<Question>();
        try {
            openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Toast.makeText(cont, "tesst" , Toast.LENGTH_SHORT).show();
        Log.w("mylog","truy van");

        Log.w("mylog","truy van 1");
        Cursor cursor= myDataBase.rawQuery("SELECT * FROM tracnghiem ",null);
        Log.w("mylog","getquestion");
        //        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Question item = new Question(cursor.getInt(0), cursor.getString(1),
//                    cursor.getString(2),cursor.getString(3),
//                    cursor.getString(4),cursor.getString(5),
//                    cursor.getString(6),cursor.getString(7),
//                    cursor.getString(8),cursor.getString(9),
//                    "");
//
//            lsData.add(item);
//            cursor.moveToNext();
//        }
//        cursor.close();
        //closeDatabase();
        return lsData;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//
//    public ArrayList<Question> getQuestion(String num_exam, String subject){
//        ArrayList<Question> lsData= new ArrayList<Question>();
////        openDatabase();
////        Toast.makeText(cont, "tesst" , Toast.LENGTH_SHORT).show();
//
//        SQLiteDatabase db= dbHelper.getReadableDatabase();
//        Cursor cursor= db.rawQuery("SELECT * FROM tracnghiem WHERE num_exam = '"+num_exam+"' AND subject='"+subject+"' ORDER BY random()",null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Question item = new Question(cursor.getInt(0), cursor.getString(1),
//                    cursor.getString(2),cursor.getString(3),
//                    cursor.getString(4),cursor.getString(5),
//                    cursor.getString(6),cursor.getString(7),
//                    cursor.getString(8),cursor.getString(9),
//                    "");
//
//            lsData.add(item);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        //closeDatabase();
//        return lsData;
//    }
}