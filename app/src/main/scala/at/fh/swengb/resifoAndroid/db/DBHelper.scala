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
  private val TABLE_NAME_Final: String = "MeldezettelFINAL" //TODO

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

  private val COLUMN_SECOND_STREET = "secondStreet"
  private val COLUMN_SECOND_HOUSENUMBER = "secondHousenumber"
  private val COLUMN_SECOND_STAIRS = "secondStairs"
  private val COLUMN_SECOND_DOOR = "secondDoor"
  private val COLUMN_SECOND_ZIPCODE = "secondZipcode"
  private val COLUMN_SECOND_LOCATION = "secondLocation"

  private val COLUMN_THIRD_STREET = "thirdStreet"
  private val COLUMN_THIRD_HOUSENUMBER = "thirdHousenumber"
  private val COLUMN_THIRD_STAIRS = "thirdStairs"
  private val COLUMN_THIRD_DOOR = "thirdDoor"
  private val COLUMN_THIRD_ZIPCODE = "thirdZipcode"
  private val COLUMN_THIRD_LOCATION = "thirdLocation"

  private val COLUMN_IMMIGRATION_COUNTRY = "immigrationCountry"
  private val COLUMN_CONDONED_COUNTRY = "condonedCountry"

  private val COLUMN_FUNCTION = "function"

  //diese Einträge sinfd nur für EDIT Table
  //##########################################

  private val COLUMN_Seite1: String = "seitea"
  private val COLUMN_Seite2: String = "seiteb"
  private val COLUMN_Seite2a: String = "seitec"
  private val COLUMN_Seite3: String = "seited"
  private val COLUMN_Seite5: String = "seitee"
  private val COLUMN_Seite5a: String = "seitef"
  private val COLUMN_Seite6: String = "seiteg"

  //##########################################


  def createTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID integer primary key, $COLUMN_LASTNAME text, $COLUMN_FIRSTNAME text," +
      s" $COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE text, $COLUMN_ACADEMIC_DEGREE text," +
      s" $COLUMN_GENDER text, $COLUMN_BIRTHDATE text, $COLUMN_BIRTHPLACE text, $COLUMN_RELIGION text, $COLUMN_ZMR text, $COLUMN_NATIONALITY text," +
      s"$COLUMN_TRAVELDOCUMENT_TYPE text, $COLUMN_TRAVELDOCUMENT_NUMBER text, $COLUMN_TRAVELDOCUMENT_DATE text, $COLUMN_TRAVELDOCUMENT_AGENCY text," +
      s" $COLUMN_FAMILY_STATUS text, $COLUMN_FIRST_STREET text, $COLUMN_FIRST_HOUSENUMBER text, " +
      s"$COLUMN_FIRST_STAIRS text, $COLUMN_FIRST_DOOR text, $COLUMN_FIRST_ZIPCODE text, $COLUMN_FIRST_LOCATION text, $COLUMN_SECOND_STREET text, " +
      s"$COLUMN_SECOND_HOUSENUMBER text, $COLUMN_SECOND_STAIRS text, $COLUMN_SECOND_DOOR text, $COLUMN_SECOND_ZIPCODE text, $COLUMN_SECOND_LOCATION text, " +
      s"$COLUMN_THIRD_STREET text, $COLUMN_THIRD_HOUSENUMBER text, $COLUMN_THIRD_STAIRS text, $COLUMN_THIRD_DOOR text, $COLUMN_THIRD_ZIPCODE text, $COLUMN_THIRD_LOCATION text," +
      s"$COLUMN_IMMIGRATION_COUNTRY text, $COLUMN_CONDONED_COUNTRY text, $COLUMN_FUNCTION text,$COLUMN_Seite1 text, $COLUMN_Seite2 text," +
      s"$COLUMN_Seite2a text, $COLUMN_Seite3 text, $COLUMN_Seite5 text, $COLUMN_Seite5a text, $COLUMN_Seite6 text)"
    db.execSQL(sql)
  }

  def createFinalTable: Unit = {
    val db = this.getWritableDatabase
    val sql = s"CREATE TABLE IF NOT EXISTS $TABLE_NAME_Final ($COLUMN_ID integer primary key, $COLUMN_LASTNAME text, $COLUMN_FIRSTNAME text," +
      s" $COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE text, $COLUMN_ACADEMIC_DEGREE text," +
      s" $COLUMN_GENDER text, $COLUMN_BIRTHDATE text, $COLUMN_BIRTHPLACE text, $COLUMN_RELIGION text, $COLUMN_ZMR text, $COLUMN_NATIONALITY text," +
      s"$COLUMN_TRAVELDOCUMENT_TYPE text, $COLUMN_TRAVELDOCUMENT_NUMBER text, $COLUMN_TRAVELDOCUMENT_DATE text, $COLUMN_TRAVELDOCUMENT_AGENCY text," +
      s" $COLUMN_FAMILY_STATUS text, $COLUMN_FIRST_STREET text, $COLUMN_FIRST_HOUSENUMBER text, " +
      s"$COLUMN_FIRST_STAIRS text, $COLUMN_FIRST_DOOR text, $COLUMN_FIRST_ZIPCODE text, $COLUMN_FIRST_LOCATION text, $COLUMN_SECOND_STREET text, " +
      s"$COLUMN_SECOND_HOUSENUMBER text, $COLUMN_SECOND_STAIRS text, $COLUMN_SECOND_DOOR text, $COLUMN_SECOND_ZIPCODE text, $COLUMN_SECOND_LOCATION text, " +
      s"$COLUMN_THIRD_STREET text, $COLUMN_THIRD_HOUSENUMBER text, $COLUMN_THIRD_STAIRS text, $COLUMN_THIRD_DOOR text, $COLUMN_THIRD_ZIPCODE text, $COLUMN_THIRD_LOCATION text," +
      s"$COLUMN_IMMIGRATION_COUNTRY text, $COLUMN_CONDONED_COUNTRY text, $COLUMN_FUNCTION text,$COLUMN_Seite1 text, $COLUMN_Seite2 text," +
      s"$COLUMN_Seite2a text, $COLUMN_Seite3 text, $COLUMN_Seite5 text, $COLUMN_Seite5a text, $COLUMN_Seite6 text)"
    db.execSQL(sql)
  }

  def transaction: Unit = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME" //TODO FINAL
    val cursor = db.rawQuery(sql, null)
    cursor.moveToLast
    //copy last line from Edit-table
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
    val firstLocation = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_LOCATION))


    val secondStreet = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_STREET))
    val secondHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_HOUSENUMBER))
    val secondStairs = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_STAIRS))
    val secondDoor = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_DOOR))
    val secondZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_ZIPCODE))
    val secondLocation = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_LOCATION))


    val thirdStreet = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_STREET))
    val thirdHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_HOUSENUMBER))
    val thirdStairs = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_STAIRS))
    val thirdDoor = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_DOOR))
    val thirdZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_ZIPCODE))
    val thirdLocation = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_LOCATION))

    val immigrationCountry = cursor.getString(cursor.getColumnIndex(COLUMN_IMMIGRATION_COUNTRY))
    val condonedCountry = cursor.getString(cursor.getColumnIndex(COLUMN_CONDONED_COUNTRY))
    val function = cursor.getString(cursor.getColumnIndex(COLUMN_FUNCTION))
    val page1 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite1))
    val page2 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite2))
    val page2a = cursor.getString(cursor.getColumnIndex(COLUMN_Seite2a))
    val page3 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite3))
    val page5 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite5))
    val page5a = cursor.getString(cursor.getColumnIndex(COLUMN_Seite5a))
    val page6 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite6))

    cursor.close

    //Deletes all rows from Edit-table
    db.execSQL("delete from " + TABLE_NAME);

    //write data
    val dbWrite = getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_LASTNAME, lastname)
    values.put(COLUMN_FIRSTNAME, firstname)
    values.put(COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE, surnameBeforeFirstMarriage)
    values.put(COLUMN_ACADEMIC_DEGREE, academicDegree)
    values.put(COLUMN_GENDER, gender)
    values.put(COLUMN_BIRTHDATE, birthdate)
    values.put(COLUMN_BIRTHPLACE, birthplace)
    values.put(COLUMN_RELIGION, religion)
    values.put(COLUMN_ZMR, zmr)
    values.put(COLUMN_NATIONALITY, nationality)
    values.put(COLUMN_NATIONALITY, nationality)
    values.put(COLUMN_TRAVELDOCUMENT_TYPE, traveldocumentType)
    values.put(COLUMN_TRAVELDOCUMENT_NUMBER, traveldocumentNumber)
    values.put(COLUMN_TRAVELDOCUMENT_DATE, traveldocumentDate)
    values.put(COLUMN_TRAVELDOCUMENT_AGENCY, traveldocumentAgency)
    values.put(COLUMN_FAMILY_STATUS, familyStatus)
    values.put(COLUMN_FIRST_STREET, firstStreet)
    values.put(COLUMN_FIRST_HOUSENUMBER, firstHouseNumber)
    values.put(COLUMN_FIRST_STAIRS, firstStairs)
    values.put(COLUMN_FIRST_DOOR, firstDoor)
    values.put(COLUMN_FIRST_ZIPCODE, firstZipcode)
    values.put(COLUMN_FIRST_LOCATION, firstLocation)
    values.put(COLUMN_IMMIGRATION_COUNTRY, immigrationCountry)
    values.put(COLUMN_SECOND_STREET, secondStreet)
    values.put(COLUMN_SECOND_HOUSENUMBER, secondHouseNumber)
    values.put(COLUMN_SECOND_STAIRS, secondStairs)
    values.put(COLUMN_SECOND_DOOR, secondDoor)
    values.put(COLUMN_SECOND_ZIPCODE, secondZipcode)
    values.put(COLUMN_SECOND_LOCATION, secondLocation)
    values.put(COLUMN_THIRD_STREET, thirdStreet)
    values.put(COLUMN_THIRD_HOUSENUMBER, thirdHouseNumber)
    values.put(COLUMN_THIRD_STAIRS, thirdStairs)
    values.put(COLUMN_THIRD_DOOR, thirdDoor)
    values.put(COLUMN_THIRD_ZIPCODE, thirdZipcode)
    values.put(COLUMN_THIRD_LOCATION, thirdLocation)
    values.put(COLUMN_Seite1, page1)
    values.put(COLUMN_Seite2, page2)
    values.put(COLUMN_Seite2a, page2a)
    values.put(COLUMN_Seite3, page3)
    values.put(COLUMN_Seite5, page5)
    values.put(COLUMN_Seite5a, page5a)
    values.put(COLUMN_Seite6, page6)
    values.put(COLUMN_FUNCTION, function)


    dbWrite.insert(TABLE_NAME_Final, null, values)
    dbWrite.close
  }

  def functionMeldezettel: Int = {

    val db = this.getReadableDatabase
    var sql = ""

      sql = s"SELECT * FROM $TABLE_NAME"


      val cursor = db.rawQuery(sql, null)
      cursor.moveToLast
      var functionM: Int = 0

      def checknull = {
        if (cursor.getString(cursor.getColumnIndex(COLUMN_FUNCTION)) == null) 0
      }

      val chNull = checknull
      var functionString = ""

      if (chNull == 0) functionM = 0
      else functionString = cursor.getString(cursor.getColumnIndex(COLUMN_FUNCTION))
      cursor.close()

      functionString match {
        case "1" => functionM = functionString.toInt
        case "2" => functionM = functionString.toInt
        case "3" => functionM = functionString.toInt
        case _ => functionM = 0
      }
      functionM
    }




  def checkCorrects: List[Int] = {

    val db = this.getReadableDatabase
    var sql = ""


      sql = s"SELECT * FROM $TABLE_NAME"

    val cursor = db.rawQuery(sql, null)
    cursor.moveToLast

    val seite1 = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite1)) == null) 0 else 1
    val seite2 = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite2)) == null) 0 else 1
    val seite2a = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite2a)) == null) 0 else 1
    val seite3 = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite3)) == null) 0 else 1
    val seite5 = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite5)) == null) 0 else 1
    val seite5a = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite5a)) == null) 0 else 1
    val seite6 = if (cursor.getString(cursor.getColumnIndex(COLUMN_Seite6)) == null) 0 else 1
    cursor.close()

    val checkCorrect: List[Int] = List(seite1, seite2, seite2a, seite3, seite5, seite5a, seite6)
    checkCorrect


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
    val sql = s"SELECT * FROM $TABLE_NAME_Final" //TODO FINAL
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
        val firstLocation = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_LOCATION))


        val secondStreet = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_STREET))
        val secondHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_HOUSENUMBER))
        val secondStairs = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_STAIRS))
        val secondDoor = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_DOOR))
        val secondZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_ZIPCODE))
        val secondLocation = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_LOCATION))


        val thirdStreet = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_STREET))
        val thirdHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_HOUSENUMBER))
        val thirdStairs = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_STAIRS))
        val thirdDoor = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_DOOR))
        val thirdZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_ZIPCODE))
        val thirdLocation = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_LOCATION))

        val immigrationCountry = cursor.getString(cursor.getColumnIndex(COLUMN_IMMIGRATION_COUNTRY))
        val condonedCountry = cursor.getString(cursor.getColumnIndex(COLUMN_CONDONED_COUNTRY))
        val function = cursor.getString(cursor.getColumnIndex(COLUMN_FUNCTION))
        val page1 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite1))
        val page2 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite2))
        val page2a = cursor.getString(cursor.getColumnIndex(COLUMN_Seite2a))
        val page3 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite3))
        val page5 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite5))
        val page5a = cursor.getString(cursor.getColumnIndex(COLUMN_Seite5a))
        val page6 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite6))

        listOfItems += new FinalItem(id, lastname, firstname, surnameBeforeFirstMarriage, academicDegree, gender, birthdate, birthplace, religion, zmr,
          nationality, if (traveldocumentType == "") "" else traveldocumentType, if (traveldocumentNumber == "") "" else traveldocumentNumber,
          if (traveldocumentDate == "") "" else traveldocumentDate, if (traveldocumentAgency == "") "" else traveldocumentAgency, familyStatus,
          firstStreet, firstHouseNumber, firstStairs, firstDoor, firstZipcode, firstLocation, secondStreet, secondHouseNumber, secondStairs, secondDoor, secondZipcode, secondLocation,
          thirdStreet, thirdHouseNumber, thirdStairs, thirdDoor, thirdZipcode, thirdLocation, immigrationCountry, condonedCountry, function,page1,page2,page2a,page3,page5,page5a,page6)
      }
      while (cursor.moveToNext)
    }
    cursor.close
    val itemList = listOfItems.toList
    itemList
  }

  def readLast: FinalItem = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME"
    val cursor = db.rawQuery(sql, null)
    cursor.moveToLast
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
    val firstLocation = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_LOCATION))


    val secondStreet = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_STREET))
    val secondHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_HOUSENUMBER))
    val secondStairs = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_STAIRS))
    val secondDoor = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_DOOR))
    val secondZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_ZIPCODE))
    val secondLocation = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_LOCATION))


    val thirdStreet = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_STREET))
    val thirdHouseNumber = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_HOUSENUMBER))
    val thirdStairs = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_STAIRS))
    val thirdDoor = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_DOOR))
    val thirdZipcode = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_ZIPCODE))
    val thirdLocation = cursor.getString(cursor.getColumnIndex(COLUMN_THIRD_LOCATION))

    val immigrationCountry = cursor.getString(cursor.getColumnIndex(COLUMN_IMMIGRATION_COUNTRY))
    val condonedCountry = cursor.getString(cursor.getColumnIndex(COLUMN_CONDONED_COUNTRY))
    val function = cursor.getString(cursor.getColumnIndex(COLUMN_FUNCTION))

    val page1 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite1))
    val page2 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite2))
    val page2a = cursor.getString(cursor.getColumnIndex(COLUMN_Seite2a))
    val page3 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite3))
    val page5 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite5))
    val page5a = cursor.getString(cursor.getColumnIndex(COLUMN_Seite5a))
    val page6 = cursor.getString(cursor.getColumnIndex(COLUMN_Seite6))

    val item = new FinalItem(id, lastname, firstname, surnameBeforeFirstMarriage, academicDegree, gender, birthdate, birthplace, religion, zmr,
      nationality, if (traveldocumentType == "") "" else traveldocumentType, if (traveldocumentNumber == "") "" else traveldocumentNumber,
      if (traveldocumentDate == "") "" else traveldocumentDate, if (traveldocumentAgency == "") "" else traveldocumentAgency, familyStatus,
      firstStreet, firstHouseNumber, firstStairs, firstDoor, firstZipcode, firstLocation, secondStreet, secondHouseNumber, secondStairs, secondDoor, secondZipcode, secondLocation,
      thirdStreet, thirdHouseNumber, thirdStairs, thirdDoor, thirdZipcode, thirdLocation, immigrationCountry, condonedCountry, function,page1,page2,page2a,page3,page5,page5a,page6)

    cursor.close


    item
  }

  def getLastID: String = {
    val db = this.getReadableDatabase
    val sql = s"SELECT * FROM $TABLE_NAME"
    val cursor = db.rawQuery(sql, null)
    cursor.moveToLast
    val id = cursor.getString(cursor.getColumnIndex(COLUMN_ID))
    cursor.close
    id.toString
  }


  //TODO insert Fertigen Meldezettel in MeldezettelFinal
  def insertFinal(item: FinalItem): Unit = {
    ???
  }

  //TODO LiSTVIEW löschen aller tabellen der Meldezettel Table


  //  //TODO wenn ein vorhandener Meldezettel bearbeitet wird -> nur wenn genug Zeit
  //  def updateFinal: Unit = {
  //    //check auf ID
  //    ???
  //  }

  //TODO
  def search: Unit = {
    ???
  }

  //SEARCH

  def insertFirstPage: Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    values.put(COLUMN_LASTNAME, "")
    db.insert(TABLE_NAME, null, values)
  }

  def updatePage1(lastname: String, firstname: String, surnameBeforeFirstMarriage: String, academicDegree: String, gender: String, seite1: String): Unit = {
    val db = this.getWritableDatabase
    val values = new ContentValues
    val id = getLastID
    values.put(COLUMN_LASTNAME, lastname)
    values.put(COLUMN_FIRSTNAME, firstname)
    values.put(COLUMN_SURNAME_BEFORE_FIRST_MARRIAGE, surnameBeforeFirstMarriage)
    values.put(COLUMN_ACADEMIC_DEGREE, academicDegree)
    values.put(COLUMN_GENDER, gender)
    values.put(COLUMN_Seite1, seite1)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
  }

  def updatePage2(birthdate: String, birthplace: String, religion: String, zmr: String, nationality: String, seite2: String): Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_BIRTHDATE, birthdate)
    values.put(COLUMN_BIRTHPLACE, birthplace)
    values.put(COLUMN_RELIGION, religion)
    values.put(COLUMN_ZMR, zmr)
    values.put(COLUMN_NATIONALITY, nationality)
    values.put(COLUMN_Seite2, seite2)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage2a(nationality: String, traveldocumentType: String, traveldocumentNumber: String, traveldocumentDate: String, traveldocumentAgency: String, seite2a: String): Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_NATIONALITY, nationality)
    values.put(COLUMN_TRAVELDOCUMENT_TYPE, traveldocumentType)
    values.put(COLUMN_TRAVELDOCUMENT_NUMBER, traveldocumentNumber)
    values.put(COLUMN_TRAVELDOCUMENT_DATE, traveldocumentDate)
    values.put(COLUMN_TRAVELDOCUMENT_AGENCY, traveldocumentAgency)
    values.put(COLUMN_Seite2a, seite2a)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage3(familyStatus: String, seite3: String): Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_FAMILY_STATUS, familyStatus)
    values.put(COLUMN_Seite3, seite3)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage4(functionMel: String): Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_FUNCTION, functionMel)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage5(firstSreet: String, firstHouseNumber: String, firstStairs: String, firstDoor: String, firstZipcode: String, firstLocation: String, immigrationCountry: String, seite5: String): Unit = {
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
    values.put(COLUMN_Seite5, seite5)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  def updatePage5a(secondSreet: String, secondHouseNumber: String, secondStairs: String, secondDoor: String, secondZipcode: String, secondLocation: String, immigrationCountry: String, seite5a: String): Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_SECOND_STREET, secondSreet)
    values.put(COLUMN_SECOND_HOUSENUMBER, secondHouseNumber)
    values.put(COLUMN_SECOND_STAIRS, secondStairs)
    values.put(COLUMN_SECOND_DOOR, secondDoor)
    values.put(COLUMN_SECOND_ZIPCODE, secondZipcode)
    values.put(COLUMN_SECOND_LOCATION, secondLocation)
    values.put(COLUMN_IMMIGRATION_COUNTRY, immigrationCountry)
    values.put(COLUMN_Seite5a, seite5a)
    db.update(TABLE_NAME, values, "id = ?", Array(id))

    db.close
  }

  def updatePage6(thirdSreet: String, thirdHouseNumber: String, thirdStairs: String, thirdDoor: String, thirdZipcode: String, thirdLocation: String, immigrationCountry: String, seite6: String): Unit = {
    val db = this.getWritableDatabase
    val id = getLastID
    val values = new ContentValues
    values.put(COLUMN_THIRD_STREET, thirdSreet)
    values.put(COLUMN_THIRD_HOUSENUMBER, thirdHouseNumber)
    values.put(COLUMN_THIRD_STAIRS, thirdStairs)
    values.put(COLUMN_THIRD_DOOR, thirdDoor)
    values.put(COLUMN_THIRD_ZIPCODE, thirdZipcode)
    values.put(COLUMN_THIRD_LOCATION, thirdLocation)
    values.put(COLUMN_CONDONED_COUNTRY, immigrationCountry)
    values.put(COLUMN_Seite6, seite6)
    db.update(TABLE_NAME, values, "id = ?", Array(id))
    db.close
  }

  """ This procedure updates the Meldezettelformular afterwards """.stripMargin

  def updateItem(id: String, firstname: String, lastname: String, surnameBeforeFirstMarriage: String, academicDegree: String, birthdate: String, birthplace: String,
                 religion: String, zmr: String, nationality: String, traveldocumentType: String, traveldocumentDate: String, traveldocumentAgency: String, familyStatus: String): Unit = {
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

  def deleteItem(int: Int,id: String): Unit = {
    val db = this.getWritableDatabase
    if (int == 1) {
      db.delete(TABLE_NAME, "id = ?", Array(id))
    } else db.delete(TABLE_NAME_Final, "id = ?", Array(id))

    db.close
  }
}
