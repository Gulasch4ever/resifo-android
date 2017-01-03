package at.fh.swengb.resifoAndroid.db

/**
  * Created by laszlobalo on 30.12.16.
  */

import scala.collection.mutable.ArrayBuffer
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

object DBHelper {
  private val DATABASE_VERSION: Int = 1
  val DATABASE_NAME: String = "MeldezettelInfo.db"
  val MELDEZETTEL_TABLE_NAME: String = "Meldezettel"
  val MELDEZETTEL_COLUMN_ID: String = "id"
  val MELDEZETTEL_COLUMN_VORNAME: String = "vorName"
  val MELDEZETTEL_COLUMN_NACHNAME: String = "nachName"
  val MELDEZETTEL_COLUMN_GEBDATUM: String = "gebDatum"
  val MELDEZETTEL_COLUMN_ADRESSE: String = "adresse"
}

class DBHelper(val context: Context) extends SQLiteOpenHelper(context, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION) {

  def onCreate(db: SQLiteDatabase) {
    db.execSQL("CREATE TABLE Meldezettel " + "(id integer primary key, vorName text, nachName text, gebDatum text,adresse text)")
  }

  def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    db.execSQL("DROP TABLE IF EXISTS Meldezettel")
    onCreate(db)
  }

  def insertMeldezettel(vorName: String, nachName: String, gebDatum: String, adresse: String): Boolean = {
    val db: SQLiteDatabase = this.getWritableDatabase
    val contentValues: ContentValues = new ContentValues
    contentValues.put("vorName", vorName)
    contentValues.put("nachName", nachName)
    contentValues.put("gebDatum", gebDatum)
    contentValues.put("adresse", adresse)
    db.insert("Meldezettel", null, contentValues)
    return true
  }

  def getData(id: Int): Cursor = {
    val db: SQLiteDatabase = this.getReadableDatabase
    val res: Cursor = db.rawQuery("select * from Meldezettel where id=" + id + "", null)
    return res
  }

  def numberOfRows: Int = {
    val db: SQLiteDatabase = this.getReadableDatabase
    val numRows: Int = DatabaseUtils.queryNumEntries(db, DBHelper.MELDEZETTEL_TABLE_NAME).toInt
    return numRows
  }

  def updateMeldezettel(id: Integer, vorName: String, nachName: String, gebDatum: String, adresse: String): Boolean = {
    val db: SQLiteDatabase = this.getWritableDatabase
    val contentValues: ContentValues = new ContentValues
    contentValues.put("vorName", vorName)
    contentValues.put("nachName", nachName)
    contentValues.put("gebDatum", gebDatum)
    contentValues.put("adresse", adresse)
    db.update("Meldezettel", contentValues, "id = ? ", Array[String](Integer.toString(id)))
    return true
  }

  def deleteMeldezettel(id: Integer): Integer = {
    val db: SQLiteDatabase = this.getWritableDatabase
    return db.delete("contacts", "id = ? ", Array[String](Integer.toString(id)))
  }

  def getAllCotacts: ArrayBuffer[String] = {
    val arrayList: ArrayBuffer[String] = new ArrayBuffer[String]
    val db: SQLiteDatabase = this.getReadableDatabase
    val res: Cursor = db.rawQuery("select * from Meldezettel", null)
    res.moveToFirst
    while (res.isAfterLast == false) {
      {
        arrayList += res.getString(res.getColumnIndex(DBHelper.MELDEZETTEL_COLUMN_VORNAME))
        res.moveToNext
      }
    }
    return arrayList
  }
}

