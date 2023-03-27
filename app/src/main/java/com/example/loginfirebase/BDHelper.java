package com.example.loginfirebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
    Context context;
    private static String BD_NAME = "user.db";
    private static int BD_VERSION = 1;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] byteImage;
    private static String createTableQuery = "Create table LoginUser(username TEXT" + ",email TEXT" + ",image BLOB)";

    public BDHelper(@Nullable Context context){
        super(context, BD_NAME, null, BD_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void storeData(ModelClass modelClass){
        SQLiteDatabase database = this.getWritableDatabase();
        Bitmap bitmapImage = modelClass.getImage();
        byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byteImage = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", modelClass.getName());
        contentValues.put("email", modelClass.getEmail());
        contentValues.put("image", byteImage);

        long checkQuery = database.insert("Loginuser", null, contentValues);

        if (checkQuery != -1){
            Toast.makeText(context, "Guardado Exitosamente", Toast.LENGTH_SHORT).show();
            database.close();
        }else{
            Toast.makeText(context, "Valio madre", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor getUser(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from LoginUser", null);
        return cursor;
    }
}

