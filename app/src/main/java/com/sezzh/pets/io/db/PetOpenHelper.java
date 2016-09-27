package com.sezzh.pets.io.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sezzh.pets.io.models.Pet;

/**
 * Created by sezzh on 26/09/16.
 */
public class PetOpenHelper extends SQLiteOpenHelper {

    private SQLiteDatabase client;

    public PetOpenHelper(Context context, String name,
                         SQLiteDatabase.CursorFactory factory, int version) {
        super(
                context, DbConstants.DATABASE_NAME,
                factory, version
        );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbConstants.PET_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase
                .execSQL("DROP TABLE IF EXIST " + DbConstants.PET_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void createPet(Pet pet) {
        ContentValues values = new ContentValues();
        values.put("name", pet.getName());
        String query = String.format(
                "INSERT INTO %s (name) VALUES ('%s')",
                DbConstants.PET_TABLE_NAME, pet.getName()
        );
        client = getWritableDatabase();
        client.insert(DbConstants.PET_TABLE_NAME, null, values);
        client.close();

    }

    public Pet retrivePet(int id) {
        String error = "";
        Pet pet = new Pet();
        String query = String.format(
                "SELECT id, name FROM %s WHERE id=%d",
                DbConstants.PET_TABLE_NAME, id
        );
        client = getWritableDatabase();
        Cursor cursor = client.rawQuery(query, null);
        cursor.moveToFirst();
        try {
            int idIndex = cursor.getColumnIndexOrThrow("id");
            int nameIndex = cursor.getColumnIndexOrThrow("name");
            pet.setId(cursor.getInt(idIndex));
            pet.setName(cursor.getString(nameIndex));
        } catch (Exception e) {
            error = e.getMessage();
        }

        return pet;
    }

}
