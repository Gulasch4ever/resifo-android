package at.fh.swengb.resifoAndroid.db

import at.fh.swengb.resifoAndroid.activities.list.Item

import scala.collection.mutable.ListBuffer
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import at.fh.swengb.resifoAndroid.db.objects.{FinalItem, Item1}


class DBHelper(val context: Context) extends SQLiteOpenHelper(context, "MeldezettelInfo.db", null, 3) {

  override def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

  override def onCreate(db: SQLiteDatabase): Unit = {}

  private val DATABASE_VERSION: Int = 3
  private val DATABASE_NAME: String = "MeldezettelInfo.db"
  private val TABLE_NAME: String = "Meldezettel"

  val COLUMN_ID: String = "id"
  val COLUMN_VORNAME: String = "vorname"
  val COLUMN_NACHNAME: String = "nachname"
  val COLUMN_FAM_V_ERSTER_EHE: String = "fam_v_erster_ehe"
  val COLUMN_AKAD: String = "akad"
  val COLUMN_GESCHLECHT: String = "geschlecht"

  val COLUMN_BIRTHDATE = "geburtsdatum"
  val COLUMN_BIRTHPLACE = "geburtsort"
  val COLUMN_RELIGION = "religion"
  val COLUMN_ZMR = "zmr"
  val COLUMN_COUNTRY = "staat"

  val COLUMN_REISEART = "art"
  val COLUMN_REISENR = "nr"
  val COLUMN_REISEDATUM = "reisedatum"
  val COLUMN_BEHOERDE = "behoerde"

  def createTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID integer primary key, $COLUMN_NACHNAME text, $COLUMN_VORNAME text, $COLUMN_FAM_V_ERSTER_EHE text, $COLUMN_AKAD text," +
      s" $COLUMN_GESCHLECHT text, $COLUMN_BIRTHDATE text, $COLUMN_BIRTHPLACE text, $COLUMN_RELIGION text, $COLUMN_ZMR text, $COLUMN_COUNTRY text," +
      s"$COLUMN_REISEART text, $COLUMN_REISENR text, $COLUMN_REISEDATUM text, $COLUMN_BEHOERDE text)"
    db.execSQL(sql)
  }

  def upgradeDB: Unit = {
    dropTable
    createTable
  }

  def dropTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"DROP TABLE IF EXISTS $TABLE_NAME"
    db.execSQL(sql)
  }

  def readData: List[FinalItem] = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME"
    val cursor = db.rawQuery(sql, null)
    val listOfItems = new ListBuffer[FinalItem]()
    if (cursor.moveToFirst) {
      do {
        val nachname = cursor.getString(cursor.getColumnIndex(COLUMN_NACHNAME))
        val vorname = cursor.getString(cursor.getColumnIndex(COLUMN_VORNAME))
        val famVErsterEhe = cursor.getString(cursor.getColumnIndex(COLUMN_FAM_V_ERSTER_EHE))
        val akad = cursor.getString(cursor.getColumnIndex(COLUMN_AKAD))
        val gender = cursor.getString(cursor.getColumnIndex(COLUMN_GESCHLECHT))
        val geburtsdatum = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDATE))
        val geburtsort = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHPLACE))
        val religion = cursor.getString(cursor.getColumnIndex(COLUMN_RELIGION))
        val zmr = cursor.getString(cursor.getColumnIndex(COLUMN_ZMR))
        val country = cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY))
        val reiseArt = cursor.getString(cursor.getColumnIndex(COLUMN_REISEART))
        val reiseNr = cursor.getString(cursor.getColumnIndex(COLUMN_REISENR))
        val reiseDatum = cursor.getString(cursor.getColumnIndex(COLUMN_REISEDATUM))
        val reiseBehoerde = cursor.getString(cursor.getColumnIndex(COLUMN_BEHOERDE))
        listOfItems += new FinalItem(nachname, vorname, famVErsterEhe, akad, gender, geburtsort, geburtsdatum, religion, zmr, country, if (reiseArt == "") "keine Angabe" else reiseArt, if (reiseNr == "") "keine Angabe" else reiseNr, if (reiseDatum == "") "keine Angabe" else reiseDatum, if (reiseBehoerde == "") "keine Angabe" else reiseBehoerde)
      }
      while (cursor.moveToNext)
    }
    cursor.close
    val itemList = listOfItems.toList
    itemList
  }

  def getLastID: Int = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME"
    val cursor = db.rawQuery(sql, null)
    cursor.moveToLast
    val id = cursor.getString(cursor.getColumnIndex(COLUMN_ID))
    cursor.close
    id.toInt
  }

  def insertFirstPage: Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_NACHNAME, "")
    db.insert(TABLE_NAME, null, values)
  }

  def updatePage1(nachname: String, vorname: String, fam: String, akad: String, gender: String): Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_NACHNAME, nachname)
    values.put(COLUMN_VORNAME, vorname)
    values.put(COLUMN_FAM_V_ERSTER_EHE, fam)
    values.put(COLUMN_AKAD, akad)
    values.put(COLUMN_GESCHLECHT, gender)
    db.update(TABLE_NAME, values, null, null)
    db.close
  }

  def updatePage2(birthdate: String, birthplace: String, religion: String, zmr: String, country: String):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID

    val values = new ContentValues
    values.put(COLUMN_BIRTHDATE, birthdate)
    values.put(COLUMN_BIRTHPLACE, birthplace)
    values.put(COLUMN_RELIGION, religion)
    values.put(COLUMN_ZMR, zmr)
    values.put(COLUMN_COUNTRY, country)

    db.update(TABLE_NAME, values, null, null)
    db.close
  }

  def updatePage2a(staat: String, art: String, nr: String, datum: String, behoerde: String):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID

    val values = new ContentValues
    values.put(COLUMN_COUNTRY, staat)
    values.put(COLUMN_REISEART, art)
    values.put(COLUMN_REISENR, nr)
    values.put(COLUMN_REISEDATUM, datum)
    values.put(COLUMN_BEHOERDE, behoerde)

    db.update(TABLE_NAME, values, null, null)
    db.close
  }


  def deleteItem(vorname: String, nachname: String):Unit = {
    val db = this.getWritableDatabase
    val sql = s"DELETE FROM $TABLE_NAME WHERE $COLUMN_VORNAME = '$vorname' AND $COLUMN_NACHNAME = '$nachname'"
    db.execSQL(sql)
  }
}

