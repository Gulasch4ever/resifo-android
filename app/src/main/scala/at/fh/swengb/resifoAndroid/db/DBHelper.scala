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

  def createTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID integer primary key, $COLUMN_NACHNAME text, $COLUMN_VORNAME text, $COLUMN_FAM_V_ERSTER_EHE text, $COLUMN_AKAD text, $COLUMN_GESCHLECHT text, $COLUMN_BIRTHDATE text, $COLUMN_BIRTHPLACE text, $COLUMN_RELIGION text, $COLUMN_ZMR text, $COLUMN_COUNTRY text)"
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
        listOfItems += new FinalItem(nachname, vorname, famVErsterEhe, akad, gender, geburtsort, geburtsdatum, religion, zmr, country)
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

  def updateLastItem1(item: Item1):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID

    val geburtsdatum = item.geburtsdatum
    val geburtsort = item.geburtsort
    val religion = item.religion
    val zmr = item.zmr
    val country = item.country

    val values = new ContentValues
    values.put(COLUMN_BIRTHDATE, geburtsdatum)
    values.put(COLUMN_BIRTHPLACE, geburtsort)
    values.put(COLUMN_RELIGION, religion)
    values.put(COLUMN_ZMR, zmr)
    values.put(COLUMN_COUNTRY, country)

    db.update(TABLE_NAME, values, null, null)
    db.close

    //val sql = s"UPDATE $TABLE_NAME SET $COLUMN_BIRTHDATE = $geburtsdatum, $COLUMN_BIRTHPLACE = $geburtsort, $COLUMN_RELIGION = $religion, $COLUMN_ZMR = $zmr, $COLUMN_COUNTRY = $country WHERE $COLUMN_ID = $id"
  }

  def insertItem(item: Item): Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_NACHNAME, item.nachname)
    values.put(COLUMN_VORNAME, item.vorname)
    values.put(COLUMN_FAM_V_ERSTER_EHE, item.fam_v_erster_ehe)
    values.put(COLUMN_AKAD, item.akad)
    values.put(COLUMN_GESCHLECHT, item.gender)
    db.insert(TABLE_NAME, null, values)
  }

  def deleteItem(vorname: String, nachname: String):Unit = {
    val db = this.getWritableDatabase
    val sql = s"DELETE FROM $TABLE_NAME WHERE $COLUMN_VORNAME = '$vorname' AND $COLUMN_NACHNAME = '$nachname'"
    db.execSQL(sql)
  }
}

