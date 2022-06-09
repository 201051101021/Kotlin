package com.utcc.sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"
val COL_GENDER = "gender"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID +
                                                " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME +
                                                " VARCHAR(256)," + COL_AGE + " INTEGER," + COL_GENDER + " VARCHAR(256))"

        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, user.name)
        contentValues.put(COL_AGE, user.age)
        contentValues.put(COL_GENDER, user.gender)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    @SuppressLint("Range")
    fun readData(): MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val id: Int = 0
                val name: String = ""
                val age: Int = 0
                val gender: String = ""
                val user = User(id, name, age, gender)
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
                user.gender = result.getString(result.getColumnIndex(COL_GENDER))
                list.add(user)
            }
            while (result.moveToNext())
        }
        return list
    }

}

