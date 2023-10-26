package com.example.apprestaurante.RestauranteSqLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper (context: Context, factory: SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper (context, DATABASE_NAME, factory, DATABASE_VERSION) {


    companion object {

        private val DATABASE_NAME = "BD_Restaurante"
        private val DATABASE_VERSION = 1
        private val TABLA_USUARIOS = "USUARIO"
        private val COLUMN_ID = "IDUSER"
        private val COLUMN_CORREO = "CORREO"
        private val COLUMN_USUARIO = "USUARIO"
        private val COLUMN_CONTRASENA = "CONTRASENA"

    }

    override fun onCreate(db: SQLiteDatabase) {
       var queryCreateTable =
               ("CREATE TABLE " + TABLA_USUARIOS + " ( " +
                       COLUMN_ID + " INT PRIMARY KEY, " +
                       COLUMN_CORREO + " TEXT, " +
                       COLUMN_USUARIO + " TEXT, " +
                       COLUMN_CONTRASENA + " TEXT " + " )"
                       )
        db.execSQL(queryCreateTable)
    }

    fun CrearRegistro(correo:String, usuario:String, contrasena:String) {

        val values = ContentValues();
        values.put(COLUMN_USUARIO, usuario)
        values.put(COLUMN_CORREO, correo)
        values.put(COLUMN_CONTRASENA, contrasena)
        val db = this.writableDatabase
        db.insert(TABLA_USUARIOS,null, values)
        db.close()
    }

    fun ListarTodosRegistros() : Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLA_USUARIOS, null)
    }

    fun Acceder(usuario:String, contrasena: String) : Cursor? {
        val db = this.readableDatabase
        val sql = "SELECT * FROM " + TABLA_USUARIOS + " WHERE " + COLUMN_USUARIO + " = '" + usuario + "' AND " +
                    COLUMN_CONTRASENA + " = '" + contrasena + "' "
        return db.rawQuery(sql, null)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}