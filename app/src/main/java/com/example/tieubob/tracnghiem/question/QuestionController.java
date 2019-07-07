package com.example.tieubob.tracnghiem.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;
    Context cont;
    public QuestionController(Context context) {
        dbHelper= new DBHelper(context);
 //       cont = context;
    }

    //Lấy danh sách câu hỏi
    public ArrayList<Question> getQuestion(String num_exam, String subject){
        ArrayList<Question> lsData= new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM tracnghiem ",null);
                cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Question item = new Question(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),
                    cursor.getString(6),cursor.getString(7),
                    cursor.getString(8),cursor.getString(9),
                    "");

            lsData.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return lsData;
    }
    //Lấy danh sách câu hỏi theo câu hỏi...
    public Cursor getSearchQuestion(String subject,String key) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tracnghiem WHERE question LIKE '%"+key+"%' AND subject LIKE '%"+subject+"%'",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    //Lấy danh sách câu hỏi theo môn học
    public Cursor getQuestionBySubject(String key) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tracnghiem WHERE subject LIKE '%"+key+"%'",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
