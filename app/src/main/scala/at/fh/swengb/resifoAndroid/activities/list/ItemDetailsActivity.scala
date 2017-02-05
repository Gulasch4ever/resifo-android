package at.fh.swengb.resifoAndroid.activities.list

import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.View.OnClickListener
import android.widget.{Button, ImageView, TextView}
import at.fh.swengb.resifoAndroid.{MainActivity, R}
import at.fh.swengb.resifoAndroid.activities.meldezettelEdit.{Meldezettel04, Meldezettel06, Meldezettel07}
import at.fh.swengb.resifoAndroid.db.DBHelper
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

class ItemDetailsActivity extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_item_details)

    val db = new DBHelper(this)

    val text11: TextView = findViewById(R.id.textView11).asInstanceOf[TextView]
    val text12: TextView = findViewById(R.id.textView12).asInstanceOf[TextView]
    val text13: TextView = findViewById(R.id.textView13).asInstanceOf[TextView]
    val text14: TextView = findViewById(R.id.textView14).asInstanceOf[TextView]
    val text15: TextView = findViewById(R.id.textView15).asInstanceOf[TextView]
    val text16: TextView = findViewById(R.id.textView16).asInstanceOf[TextView]
    val text17: TextView = findViewById(R.id.textView17).asInstanceOf[TextView]
    val text21: TextView = findViewById(R.id.textView21).asInstanceOf[TextView]
    val text22: TextView = findViewById(R.id.textView22).asInstanceOf[TextView]
    val text23: TextView = findViewById(R.id.textView23).asInstanceOf[TextView]
    val text24: TextView = findViewById(R.id.textView24).asInstanceOf[TextView]
    val text25: TextView = findViewById(R.id.textView25).asInstanceOf[TextView]
    val text26: TextView = findViewById(R.id.textView26).asInstanceOf[TextView]
    val text27: TextView = findViewById(R.id.textView27).asInstanceOf[TextView]
    val text31: TextView = findViewById(R.id.textView31).asInstanceOf[TextView]
    val text32: TextView = findViewById(R.id.textView32).asInstanceOf[TextView]
    val text33: TextView = findViewById(R.id.textView33).asInstanceOf[TextView]
    val text34: TextView = findViewById(R.id.textView34).asInstanceOf[TextView]
    val text35: TextView = findViewById(R.id.textView35).asInstanceOf[TextView]
    val text36: TextView = findViewById(R.id.textView36).asInstanceOf[TextView]
    val text37: TextView = findViewById(R.id.textView37).asInstanceOf[TextView]
    val text41: TextView = findViewById(R.id.textView41).asInstanceOf[TextView]
    val text42: TextView = findViewById(R.id.textView42).asInstanceOf[TextView]
    val text43: TextView = findViewById(R.id.textView43).asInstanceOf[TextView]
    val text44: TextView = findViewById(R.id.textView44).asInstanceOf[TextView]
    val text45: TextView = findViewById(R.id.textView45).asInstanceOf[TextView]
    val text46: TextView = findViewById(R.id.textView46).asInstanceOf[TextView]
    val text47: TextView = findViewById(R.id.textView47).asInstanceOf[TextView]
    val text51: TextView = findViewById(R.id.textView51).asInstanceOf[TextView]
    val text52: TextView = findViewById(R.id.textView52).asInstanceOf[TextView]
    val text53: TextView = findViewById(R.id.textView53).asInstanceOf[TextView]
    val text54: TextView = findViewById(R.id.textView54).asInstanceOf[TextView]
    val text55: TextView = findViewById(R.id.textView55).asInstanceOf[TextView]
    val text56: TextView = findViewById(R.id.textView56).asInstanceOf[TextView]
    val text57: TextView = findViewById(R.id.textView57).asInstanceOf[TextView]
    val text61: TextView = findViewById(R.id.textView61).asInstanceOf[TextView]
    val text62: TextView = findViewById(R.id.textView62).asInstanceOf[TextView]
    val text63: TextView = findViewById(R.id.textView63).asInstanceOf[TextView]
    val text64: TextView = findViewById(R.id.textView64).asInstanceOf[TextView]
    val text65: TextView = findViewById(R.id.textView65).asInstanceOf[TextView]
    val text66: TextView = findViewById(R.id.textView66).asInstanceOf[TextView]
    val text67: TextView = findViewById(R.id.textView67).asInstanceOf[TextView]
    val text71: TextView = findViewById(R.id.textView71).asInstanceOf[TextView]
    val text72: TextView = findViewById(R.id.textView72).asInstanceOf[TextView]
    val text73: TextView = findViewById(R.id.textView73).asInstanceOf[TextView]
    val text74: TextView = findViewById(R.id.textView74).asInstanceOf[TextView]
    val text75: TextView = findViewById(R.id.textView75).asInstanceOf[TextView]
    val text76: TextView = findViewById(R.id.textView76).asInstanceOf[TextView]
    val text77: TextView = findViewById(R.id.textView77).asInstanceOf[TextView]

    val edit11: TextView = findViewById(R.id.edit11).asInstanceOf[TextView]
    val edit12: TextView = findViewById(R.id.edit12).asInstanceOf[TextView]
    val edit13: TextView = findViewById(R.id.edit13).asInstanceOf[TextView]
    val edit14: TextView = findViewById(R.id.edit14).asInstanceOf[TextView]
    val edit15: TextView = findViewById(R.id.edit15).asInstanceOf[TextView]
    val edit16: TextView = findViewById(R.id.edit16).asInstanceOf[TextView]
    val edit17: TextView = findViewById(R.id.edit17).asInstanceOf[TextView]
    val edit21: TextView = findViewById(R.id.edit21).asInstanceOf[TextView]
    val edit22: TextView = findViewById(R.id.edit22).asInstanceOf[TextView]
    val edit23: TextView = findViewById(R.id.edit23).asInstanceOf[TextView]
    val edit24: TextView = findViewById(R.id.edit24).asInstanceOf[TextView]
    val edit25: TextView = findViewById(R.id.edit25).asInstanceOf[TextView]
    val edit26: TextView = findViewById(R.id.edit26).asInstanceOf[TextView]
    val edit27: TextView = findViewById(R.id.edit27).asInstanceOf[TextView]
    val edit31: TextView = findViewById(R.id.edit31).asInstanceOf[TextView]
    val edit32: TextView = findViewById(R.id.edit32).asInstanceOf[TextView]
    val edit33: TextView = findViewById(R.id.edit33).asInstanceOf[TextView]
    val edit34: TextView = findViewById(R.id.edit34).asInstanceOf[TextView]
    val edit35: TextView = findViewById(R.id.edit35).asInstanceOf[TextView]
    val edit36: TextView = findViewById(R.id.edit36).asInstanceOf[TextView]
    val edit37: TextView = findViewById(R.id.edit37).asInstanceOf[TextView]
    val edit41: TextView = findViewById(R.id.edit41).asInstanceOf[TextView]
    val edit42: TextView = findViewById(R.id.edit42).asInstanceOf[TextView]
    val edit43: TextView = findViewById(R.id.edit43).asInstanceOf[TextView]
    val edit44: TextView = findViewById(R.id.edit44).asInstanceOf[TextView]
    val edit45: TextView = findViewById(R.id.edit45).asInstanceOf[TextView]
    val edit46: TextView = findViewById(R.id.edit46).asInstanceOf[TextView]
    val edit47: TextView = findViewById(R.id.edit47).asInstanceOf[TextView]
    val edit51: TextView = findViewById(R.id.edit51).asInstanceOf[TextView]
    val edit52: TextView = findViewById(R.id.edit52).asInstanceOf[TextView]
    val edit53: TextView = findViewById(R.id.edit53).asInstanceOf[TextView]
    val edit54: TextView = findViewById(R.id.edit54).asInstanceOf[TextView]
    val edit55: TextView = findViewById(R.id.edit55).asInstanceOf[TextView]
    val edit56: TextView = findViewById(R.id.edit56).asInstanceOf[TextView]
    val edit57: TextView = findViewById(R.id.edit57).asInstanceOf[TextView]
    val edit61: TextView = findViewById(R.id.edit61).asInstanceOf[TextView]
    val edit62: TextView = findViewById(R.id.edit62).asInstanceOf[TextView]
    val edit63: TextView = findViewById(R.id.edit63).asInstanceOf[TextView]
    val edit64: TextView = findViewById(R.id.edit64).asInstanceOf[TextView]
    val edit65: TextView = findViewById(R.id.edit65).asInstanceOf[TextView]
    val edit66: TextView = findViewById(R.id.edit66).asInstanceOf[TextView]
    val edit67: TextView = findViewById(R.id.edit67).asInstanceOf[TextView]
    val edit71: TextView = findViewById(R.id.edit71).asInstanceOf[TextView]
    val edit72: TextView = findViewById(R.id.edit72).asInstanceOf[TextView]
    val edit73: TextView = findViewById(R.id.edit73).asInstanceOf[TextView]
    val edit74: TextView = findViewById(R.id.edit74).asInstanceOf[TextView]
    val edit75: TextView = findViewById(R.id.edit75).asInstanceOf[TextView]
    val edit76: TextView = findViewById(R.id.edit76).asInstanceOf[TextView]
    val edit77: TextView = findViewById(R.id.edit77).asInstanceOf[TextView]

      val exitButton: ImageView = findViewById(R.id.exitBtn).asInstanceOf[ImageView]
     val deleteButton: Button = findViewById(R.id.buttondelete).asInstanceOf[Button]



    val intent = getIntent
    val item: FinalItem = intent.getExtras.get("item").asInstanceOf[FinalItem]


    def checkCorrects: List[Int] = {

      val seite1 = if (item.page1 == null) 0 else 1
      val seite2 = if (item.page2 == null) 0 else 1
      val seite2a = if (item.page2a == null) 0 else 1
      val seite3 = if (item.page3 == null) 0 else 1
      val seite5 = if (item.page5 == null) 0 else 1
      val seite5a = if (item.page5a == null) 0 else 1
      val seite6 = if (item.page6 == null) 0 else 1

      val checkCorrect: List[Int] = List(seite1, seite2, seite2a, seite3, seite5, seite5a, seite6)

      println("##########################################"+checkCorrect)
      println(item.page1)
      println(item.page2)
      println(item.page2a)
      println(item.page3)
      println(item.page5)
      println(item.page6)

      checkCorrect

    }

    def functionMeldezettel: Int = {


      var functionM: Int = 0

      def checknull = {
        if (item.function == null) 0
      }

      val chNull = checknull
      var functionString = ""

      if (chNull == 0) functionM = 0
      else functionString = item.function

      functionString match {
        case "1" => functionM = functionString.toInt
        case "2" => functionM = functionString.toInt
        case "3" => functionM = functionString.toInt
        case _ => functionM = 0
      }
      println("function"+functionM)
      functionM
    }

    val optinal = checkCorrects
    val function = functionMeldezettel

    def getDetails = {

      def standardTexts = {
        text11.setText("Nachname:")
        text12.setText("Vorname:")
        text13.setText("Fam. v. ersten Ehe:")
        text14.setText("AKAD:")
        text15.setText("Geschlecht:")
        text21.setText("Geb. Datum:")
        text22.setText("Geb. Ort:")
        text23.setText("Religion:")
        text24.setText("ZMR:")
        text25.setText("Staatsangehörigkeit:")

        edit11.setText(item.lastname)
        edit12.setText(item.firstname)
        edit13.setText(item.surnameBeforeFirstMarriage)
        edit14.setText(item.academicDegree)
        edit15.setText(item.gender)
        edit21.setText(item.birthdate)
        edit22.setText(item.birthplace)
        edit23.setText(item.religion)
        edit24.setText(item.zmr)
        edit25.setText(item.nationality)

      }

      def optinal2a(int: Int, list: List[Int]) = {


        text31.setText("RD Art:")
        text32.setText("RD NR.:")
        text33.setText("RD Datum:")
        text34.setText("RD Behörde:")
        text44.setText("Familienstand:")

        edit31.setText(item.traveldocumentType)
        edit32.setText(item.traveldocumentNumber)
        edit33.setText(item.traveldocumentDate)
        edit34.setText(item.traveldocumentAgency)
        edit44.setText(item.familyStatus)

        int match {
          case 1 => function1(2, list) // mit 2a und anmelden
          case 2 => function2(2, list) // mit 2a und abmleden
          case 3 => function3(2, list)
        }

      }

      def function1(int: Int, list: List[Int]) = {
        // int = 1 => ohne 2a
        // int = 2 => mit 2a

        if (int == 1) {
          //anmelden ohne 2a


          text41.setText("Straße:")
          text42.setText("Haus Nr.:")
          text43.setText("Stiege:")
          text44.setText("Tür:")
          text45.setText("PLZ:")
          text46.setText("Ort:")
          text47.setText("Zuzug Staat:")

          edit41.setText(item.firstStreet)
          edit42.setText(item.firstHouseNumber)
          edit43.setText(item.firstStairs)
          edit44.setText(item.firstDoor)
          edit45.setText(item.firstZipcode)
          edit46.setText(item.firstLocation)
          edit47.setText(item.immigrationCountry)

          // 5a ???
          if (list.lift(5).contains(1)) {

            text51.setText("Straße:")
            text52.setText("Haus Nr.:")
            text53.setText("Stiege:")
            text54.setText("Tür:")
            text55.setText("PLZ:")
            text56.setText("Ort:")

            edit51.setText(item.secondStreet)
            edit52.setText(item.secondHouseNumber)
            edit53.setText(item.secondStairs)
            edit54.setText(item.secondDoor)
            edit55.setText(item.secondZipcode)
            edit56.setText(item.secondLocation)
          }


        } else {

          text51.setText("Straße:")
          text52.setText("Haus Nr.:")
          text53.setText("Stiege:")
          text54.setText("Tür:")
          text55.setText("PLZ:")
          text56.setText("Ort:")
          text57.setText("Zuzug Staat:")

          edit51.setText(item.firstStreet)
          edit52.setText(item.firstHouseNumber)
          edit53.setText(item.firstStairs)
          edit54.setText(item.firstDoor)
          edit55.setText(item.firstZipcode)
          edit56.setText(item.firstLocation)
          edit57.setText(item.immigrationCountry)

          if (list.lift(5).contains(1)) {


            text61.setText("Straße:")
            text62.setText("Haus Nr.:")
            text63.setText("Stiege:")
            text64.setText("Tür:")
            text65.setText("PLZ:")
            text66.setText("Ort:")

            edit61.setText(item.secondStreet)
            edit62.setText(item.secondHouseNumber)
            edit63.setText(item.secondStairs)
            edit64.setText(item.secondDoor)
            edit65.setText(item.secondZipcode)
            edit66.setText(item.secondLocation)
          }
        }
      }

      def function2(int: Int, list: List[Int]) = {

        if (int == 2) {


          text51.setText("Straße:")
          text52.setText("Haus Nr.:")
          text53.setText("Stiege:")
          text54.setText("Tür:")
          text55.setText("PLZ:")
          text56.setText("Ort:")
          text57.setText("Verzieh Staat:")

          edit51.setText(item.thirdStreet)
          edit52.setText(item.thirdHouseNumber)
          edit53.setText(item.thirdStairs)
          edit54.setText(item.thirdDoor)
          edit55.setText(item.thirdZipcode)
          edit56.setText(item.thirdLocation)
          edit57.setText(item.condonedCountry)

        } else {

          text41.setText("Straße:")
          text42.setText("Haus Nr.:")
          text43.setText("Stiege:")
          text44.setText("Tür:")
          text45.setText("PLZ:")
          text46.setText("Ort:")
          text47.setText("Verzieh Staat:")

          edit41.setText(item.thirdStreet)
          edit42.setText(item.thirdHouseNumber)
          edit43.setText(item.thirdStairs)
          edit44.setText(item.thirdDoor)
          edit45.setText(item.thirdZipcode)
          edit46.setText(item.thirdLocation)
          edit47.setText(item.condonedCountry)
        }
      }

      def function3(int: Int, list: List[Int]) = {
        if (int == 2) {
          if (list.lift(5).contains(1)) {


            text51.setText("Straße:")
            text52.setText("Haus Nr.:")
            text53.setText("Stiege:")
            text54.setText("Tür:")
            text55.setText("PLZ:")
            text56.setText("Ort:")
            text57.setText("Zuzug Staat:")

            edit51.setText(item.firstStreet)
            edit52.setText(item.firstHouseNumber)
            edit53.setText(item.firstStairs)
            edit54.setText(item.firstDoor)
            edit55.setText(item.firstZipcode)
            edit56.setText(item.firstLocation)
            edit57.setText(item.immigrationCountry)


            text61.setText("Straße:")
            text62.setText("Haus Nr.:")
            text63.setText("Stiege:")
            text64.setText("Tür:")
            text65.setText("PLZ:")
            text66.setText("Ort:")

            edit61.setText(item.secondStreet)
            edit62.setText(item.secondHouseNumber)
            edit63.setText(item.secondStairs)
            edit64.setText(item.secondDoor)
            edit65.setText(item.secondZipcode)
            edit66.setText(item.secondLocation)


            text71.setText("Straße:")
            text72.setText("Haus Nr.:")
            text73.setText("Stiege:")
            text74.setText("Tür:")
            text75.setText("PLZ:")
            text76.setText("Ort:")
            text77.setText("Verzieh Staat:")

            edit71.setText(item.thirdStreet)
            edit72.setText(item.thirdHouseNumber)
            edit73.setText(item.thirdStairs)
            edit74.setText(item.thirdDoor)
            edit75.setText(item.thirdZipcode)
            edit76.setText(item.thirdLocation)
            edit77.setText(item.condonedCountry)

          } else {


            text51.setText("Straße:")
            text52.setText("Haus Nr.:")
            text53.setText("Stiege:")
            text54.setText("Tür:")
            text55.setText("PLZ:")
            text56.setText("Ort:")
            text57.setText("Zuzug Staat:")

            edit51.setText(item.firstStreet)
            edit52.setText(item.firstHouseNumber)
            edit53.setText(item.firstStairs)
            edit54.setText(item.firstDoor)
            edit55.setText(item.firstZipcode)
            edit56.setText(item.firstLocation)
            edit57.setText(item.immigrationCountry)


            text61.setText("Straße:")
            text62.setText("Haus Nr.:")
            text63.setText("Stiege:")
            text64.setText("Tür:")
            text65.setText("PLZ:")
            text66.setText("Ort:")
            text67.setText("Verzieh Staat:")

            edit61.setText(item.thirdStreet)
            edit62.setText(item.thirdHouseNumber)
            edit63.setText(item.thirdStairs)
            edit64.setText(item.thirdDoor)
            edit65.setText(item.thirdZipcode)
            edit66.setText(item.thirdLocation)
            edit67.setText(item.condonedCountry)


          }
        } else {
          if (list.lift(5).contains(1)) {


            text41.setText("Straße:")
            text42.setText("Haus Nr.:")
            text43.setText("Stiege:")
            text44.setText("Tür:")
            text45.setText("PLZ:")
            text46.setText("Ort:")
            text47.setText("Zuzug Staat:")

            edit41.setText(item.firstStreet)
            edit42.setText(item.firstHouseNumber)
            edit43.setText(item.firstStairs)
            edit44.setText(item.firstDoor)
            edit45.setText(item.firstZipcode)
            edit46.setText(item.firstLocation)
            edit47.setText(item.immigrationCountry)


            text51.setText("Straße:")
            text52.setText("Haus Nr.:")
            text53.setText("Stiege:")
            text54.setText("Tür:")
            text55.setText("PLZ:")
            text56.setText("Ort:")

            edit51.setText(item.secondStreet)
            edit52.setText(item.secondHouseNumber)
            edit53.setText(item.secondStairs)
            edit54.setText(item.secondDoor)
            edit55.setText(item.secondZipcode)
            edit56.setText(item.secondLocation)


            text61.setText("Straße:")
            text62.setText("Haus Nr.:")
            text63.setText("Stiege:")
            text64.setText("Tür:")
            text65.setText("PLZ:")
            text66.setText("Ort:")
            text67.setText("Verzieh Staat:")


            edit61.setText(item.thirdStreet)
            edit62.setText(item.thirdHouseNumber)
            edit63.setText(item.thirdStairs)
            edit64.setText(item.thirdDoor)
            edit65.setText(item.thirdZipcode)
            edit66.setText(item.thirdLocation)
            edit67.setText(item.condonedCountry)

          } else {


            text41.setText("Straße:")
            text42.setText("Haus Nr.:")
            text43.setText("Stiege:")
            text44.setText("Tür:")
            text45.setText("PLZ:")
            text46.setText("Ort:")
            text47.setText("Zuzug Staat:")

            edit41.setText(item.firstStreet)
            edit42.setText(item.firstHouseNumber)
            edit43.setText(item.firstStairs)
            edit44.setText(item.firstDoor)
            edit45.setText(item.firstZipcode)
            edit46.setText(item.firstLocation)
            edit47.setText(item.immigrationCountry)


            text51.setText("Straße:")
            text52.setText("Haus Nr.:")
            text53.setText("Stiege:")
            text54.setText("Tür:")
            text55.setText("PLZ:")
            text56.setText("Ort:")
            text57.setText("Verzieh Staat:")

            edit51.setText(item.thirdStreet)
            edit52.setText(item.thirdHouseNumber)
            edit53.setText(item.thirdStairs)
            edit54.setText(item.thirdDoor)
            edit55.setText(item.thirdZipcode)
            edit56.setText(item.thirdLocation)
            edit57.setText(item.condonedCountry)
          }
        }
      }

      standardTexts
      if (optinal.lift(2).contains(1)) optinal2a(function, optinal)
      else {


        text34.setText("Familienstand:")
        edit34.setText(item.familyStatus)

        function match {
          case 1 => function1(1, optinal)
          case 2 => function2(1, optinal)
          case 3 => function3(1, optinal)
          case _ =>
        }
      }
    }


    exitButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
      }
    })

    deleteButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(ItemDetailsActivity.this)
          .setMessage("Wollen Sie den Meldezettel wirklich löschen?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              db.deleteItem(2,item.id)
              startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
              dialog.dismiss()
            }
          })
          .show()

      }
    })


    getDetails
  }
}

