package at.fh.swengb.resifoAndroid.db

import scala.collection.mutable.ListBuffer
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

class DBHelper(val context: Context) extends SQLiteOpenHelper(context, "MeldezettelInfo.db", null, 3) {

  override def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

  override def onCreate(db: SQLiteDatabase): Unit = {}

  private val DATABASE_VERSION: Int = 3
  private val DATABASE_NAME: String = "MeldezettelInfo.db"
  private val TABLE_NAME: String = "Meldezettel"

  private val COLUMN_ID: String = "id"
  private val COLUMN_FIRSTNAME: String = "firstname"
  private val COLUMN_LASTNAME: String = "lastname"
  private val COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE: String = "surnameBeforeFirstMarriage"
  private val COLUMN_ACADEMIC_DEGREE: String = "academicDegree"
  private val COLUMN_GENDER: String = "gender"
  private val COLUMN_BIRTHDATE = "birthdate"
  private val COLUMN_BIRTHPLACE = "birthplace"
  private val COLUMN_RELIGION = "religion"
  private val COLUMN_ZMR = "zmr"
  private val COLUMN_NATIONALITY = "nationality"
  private val COLUMN_TRAVELDOCUMENT_TYPE = "traveldocumentType"
  private val COLUMN_TRAVELDOCUMENT_NUMBER = "traveldocumentNumber"
  private val COLUMN_TRAVELDOCUMENT_DATE = "traveldocumentDate"
  private val COLUMN_TRAVELDOCUMENT_AGENCY = "traveldocumentAgency"
  private val COLUMN_FAMILY_STATUS = "familyStatus"
  private val COLUMN_FIRST_STREET = "firstStreet"
  private val COLUMN_FIRST_HOUSENUMBER = "firstHousenumber"
  private val COLUMN_FIRST_STAIRS = "firstStairs"
  private val COLUMN_FIRST_DOOR = "firstDoor"
  private val COLUMN_FIRST_ZIPCODE = "firstZipcode"
  private val COLUMN_FIRST_LOCATION = "firstLocation"
  private val COLUMN_IMMIGRATION_COUNTRY = "immigrationCountry"


  def createTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID integer primary key, $COLUMN_LASTNAME text, $COLUMN_FIRSTNAME text," +
      s" $COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE text, $COLUMN_ACADEMIC_DEGREE text," +
      s" $COLUMN_GENDER text, $COLUMN_BIRTHDATE text, $COLUMN_BIRTHPLACE text, $COLUMN_RELIGION text, $COLUMN_ZMR text, $COLUMN_NATIONALITY text," +
      s"$COLUMN_TRAVELDOCUMENT_TYPE text, $COLUMN_TRAVELDOCUMENT_NUMBER text, $COLUMN_TRAVELDOCUMENT_DATE text, $COLUMN_TRAVELDOCUMENT_AGENCY text," +
      s" $COLUMN_FAMILY_STATUS text, $COLUMN_FIRST_STREET text, $COLUMN_FIRST_HOUSENUMBER text, " +
      s"$COLUMN_FIRST_STAIRS text, $COLUMN_FIRST_DOOR text, $COLUMN_FIRST_ZIPCODE text, $COLUMN_FIRST_LOCATION text, $COLUMN_IMMIGRATION_COUNTRY text)"
    db.execSQL(sql)
  }

  def restartTable: Unit = {
    dropTable
    createTable
  }

  def dropTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"DROP TABLE IF EXISTS $TABLE_NAME"
    db.execSQL(sql)
  }

  """ This function provides the ListView with its entries """.stripMargin

  def readData: List[FinalItem] = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME"
    val cursor = db.rawQuery(sql, null)
    val listOfItems = new ListBuffer[FinalItem]()
    if (cursor.moveToFirst) {
      do {
        val id = cursor.getString(cursor.getColumnIndex(COLUMN_ID))
        val lastname = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME))
        val firstname = cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME))
        val surnameBeforeFirstMarriage = cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE))
        val academicDegree = cursor.getString(cursor.getColumnIndex(COLUMN_ACADEMIC_DEGREE))
        val gender = cursor.getString(cursor.getColumnIndex(COLUMN_GENDER))
        val birthdate = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDATE))
        val birthplace = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHPLACE))
        val religion = cursor.getString(cursor.getColumnIndex(COLUMN_RELIGION))
        val zmr = cursor.getString(cursor.getColumnIndex(COLUMN_ZMR))
        val nationality = cursor.getString(cursor.getColumnIndex(COLUMN_NATIONALITY))
        val traveldocumentType = cursor.getString(cursor.getColumnIndex(COLUMN_TRAVELDOCUMENT_TYPE))
        val traveldocumentNumber = cursor.getString(cursor.getColumnIndex(COLUMN_TRAVELDOCUMENT_NUMBER))
        val traveldocumentDate = cursor.getString(cursor.getColumnIndex(COLUMN_TRAVELDOCUMENT_DATE))
        val traveldocumentAgency = cursor.getString(cursor.getColumnIndex(COLUMN_TRAVELDOCUMENT_AGENCY))
        val familyStatus = cursor.getString(cursor.getColumnIndex(COLUMN_FAMILY_STATUS))
        val firstStreet = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_STREET))
        val firstHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_HOUSENUMBER))
        val firstStairs = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_STAIRS))
        val firstDoor = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_DOOR))
        val firstZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_ZIPCODE))
        val immigrationCountry = cursor.getString(cursor.getColumnIndex(COLUMN_IMMIGRATION_COUNTRY))

        listOfItems += new FinalItem(id, lastname, firstname, surnameBeforeFirstMarriage, academicDegree, gender, birthdate, birthplace, religion, zmr,
          nationality, if (traveldocumentType == "") "" else traveldocumentType, if (traveldocumentNumber == "") "" else traveldocumentNumber,
          if (traveldocumentDate == "") "" else traveldocumentDate, if (traveldocumentAgency == "") "" else traveldocumentAgency, familyStatus,
          firstStreet, firstHouseNumber, firstStairs, firstDoor, firstZipcode, immigrationCountry)
      }
      while (cursor.moveToNext)
    }
    cursor.close
    val itemList = listOfItems.toList
    itemList
  }


  private def getLastID: String = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME"
    val cursor = db.rawQuery(sql, null)
    cursor.moveToLast
    val id = cursor.getString(cursor.getColumnIndex(COLUMN_ID))
    cursor.close
    id.toString
  }

  def insertFirstPage: Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_LASTNAME, "")
    db.insert(TABLE_NAME, null, values)
  }

  def updatePage1(lastname: String, firstname: String, surnameBeforeFirstMarriage: String, academicDegree: String, gender: String): Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    val id = getLastID
    values.put(COLUMN_LASTNAME, lastname)
    values.put(COLUMN_FIRSTNAME, firstname)
    values.put(COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE, surnameBeforeFirstMarriage)
    values.put(COLUMN_ACADEMIC_DEGREE, academicDegree)
    values.put(COLUMN_GENDER, gender)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close

  }

  def updatePage2(birthdate: String, birthplace: String, religion: String, zmr: String, nationality: String):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_BIRTHDATE, birthdate)
    values.put(COLUMN_BIRTHPLACE, birthplace)
    values.put(COLUMN_RELIGION, religion)
    values.put(COLUMN_ZMR, zmr)
    values.put(COLUMN_NATIONALITY, nationality)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage2a(nationality: String, traveldocumentType: String, traveldocumentNumber: String, traveldocumentDate: String, traveldocumentAgency: String):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_NATIONALITY, nationality)
    values.put(COLUMN_TRAVELDOCUMENT_TYPE, traveldocumentType)
    values.put(COLUMN_TRAVELDOCUMENT_NUMBER, traveldocumentNumber)
    values.put(COLUMN_TRAVELDOCUMENT_DATE, traveldocumentDate)
    values.put(COLUMN_TRAVELDOCUMENT_AGENCY, traveldocumentAgency)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage3(familyStatus: String):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_FAMILY_STATUS, familyStatus)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage5(firstSreet: String, firstHouseNumber: String, firstStairs: String, firstDoor: String, firstZipcode: String, firstLocation: String, immigrationCountry: String):Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_FIRST_STREET, firstSreet)
    values.put(COLUMN_FIRST_HOUSENUMBER, firstHouseNumber)
    values.put(COLUMN_FIRST_STAIRS, firstStairs)
    values.put(COLUMN_FIRST_DOOR, firstDoor)
    values.put(COLUMN_FIRST_ZIPCODE, firstZipcode)
    values.put(COLUMN_FIRST_LOCATION, firstLocation)
    values.put(COLUMN_IMMIGRATION_COUNTRY, immigrationCountry)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  """ This procedure updates the Meldezettelformular afterwards """.stripMargin

  def updateItem(id: String, firstname: String, lastname: String, surnameBeforeFirstMarriage: String, academicDegree: String, birthdate: String, birthplace: String,
                 religion: String,zmr: String, nationality: String, traveldocumentType: String, traveldocumentDate: String, traveldocumentAgency: String, familyStatus: String):Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_FIRSTNAME, firstname)
    values.put(COLUMN_LASTNAME, lastname)
    values.put(COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE, surnameBeforeFirstMarriage)
    values.put(COLUMN_ACADEMIC_DEGREE, academicDegree)
    values.put(COLUMN_BIRTHDATE, birthdate)
    values.put(COLUMN_BIRTHPLACE, birthplace)
    values.put(COLUMN_RELIGION, religion)
    values.put(COLUMN_ZMR, zmr)
    values.put(COLUMN_NATIONALITY, nationality)
    values.put(COLUMN_TRAVELDOCUMENT_TYPE, traveldocumentType)
    values.put(COLUMN_TRAVELDOCUMENT_DATE, traveldocumentDate)
    values.put(COLUMN_TRAVELDOCUMENT_AGENCY, traveldocumentAgency)
    values.put(COLUMN_FAMILY_STATUS, familyStatus)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  """ This procedure deletes an item """.stripMargin

  def deleteItem(id: String):Unit = {
    val db = this.getWritableDatabase
    db.delete(TABLE_NAME, "id = ?", Array(id))
    db.close
  }
}
