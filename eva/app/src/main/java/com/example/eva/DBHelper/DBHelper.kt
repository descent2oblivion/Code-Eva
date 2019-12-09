package com.example.eva.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.eva.Model.Code

class DBHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {
    companion object{
        private val DATABASE_VER=1
        private val DATABASE_NAME="PM.db"
        private val TABLE_NAME="ACode"
        private val COL_ID="Id"
        private val COL_TITLE="Title"
        private val COL_DESC="Description"
        private val COL_CODE="Code"
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY:String = ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_TITLE TEXT,$COL_DESC TEXT,$COL_CODE TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    val allCode:List<Code>
        get(){
            val lstCode = ArrayList<Code>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db: SQLiteDatabase = this.writableDatabase
            val cursor: Cursor = db.rawQuery(selectQuery,null)
            if (cursor.moveToFirst())
            {
                do {
                    val Code = Code()
                    Code.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    Code.titulo = cursor.getString(cursor.getColumnIndex(COL_TITLE))
                    Code.descripcion = cursor.getString(cursor.getColumnIndex(COL_DESC))
                    Code.codigo = cursor.getString(cursor.getColumnIndex(COL_CODE))

                    lstCode.add(Code)
                }while (cursor.moveToNext())
            }
            db.close()
            return lstCode
        }

    fun addCode(cod: Code)
    {
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_TITLE,cod.titulo)
        values.put(COL_DESC,cod.descripcion)
        values.put(COL_CODE,cod.codigo)


        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    fun updateCode(cod: Code):Int
    {
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID,cod.id)
        values.put(COL_TITLE,cod.titulo)
        values.put(COL_DESC,cod.descripcion)
        values.put(COL_DESC,cod.codigo)


        return db.update(TABLE_NAME,values,"$COL_ID=?", arrayOf(cod.id.toString()))
    }

    fun deleteCode(cod: Code)
    {
        val db: SQLiteDatabase = this.writableDatabase
        db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(cod.id.toString()))
        db.close()
    }
}