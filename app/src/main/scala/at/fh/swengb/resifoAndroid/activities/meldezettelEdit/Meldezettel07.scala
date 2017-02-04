package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget.{Button, ImageView, TextView, Toast}
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.help.HelpActivity
import at.fh.swengb.resifoAndroid.db.DBHelper
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

/**
  * Created by laszlobalo on 03.01.17.
  */
class Meldezettel07 extends AppCompatActivity {

  //TODO fancy scrollVIEW
  //TODO buttons

  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel07)

    //TODO values for textViews and Edit Text

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

    //TODO buttons link
    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]





    val optinal = db.checkCorrects

    val function = db.functionMeldezettel

    if (function == 0) new AlertDialog.Builder(Meldezettel07.this)
      .setMessage("Sie müssen eine Funktion des Meldezettels wählen!")
      .setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {
        override def onClick(dialog: DialogInterface, which: Int): Unit = {
          val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel04])
          intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
          startActivity(intent)
          dialog.dismiss()
        }
      })
      .show()

    val item = db.readLast

    def buttonInvisible = {

      activity1Button.setVisibility(View.VISIBLE)
      activity2Button.setVisibility(View.VISIBLE)
      activity3Button.setVisibility(View.VISIBLE)
      activity4Button.setVisibility(View.VISIBLE)
      activity5Button.setVisibility(View.VISIBLE)
      activity6Button.setVisibility(View.VISIBLE)
      activity7Button.setVisibility(View.VISIBLE)

      if (!optinal.lift(2).contains(1)) {
        activity7Button.setVisibility(View.INVISIBLE)

        if (!optinal.lift(5).contains(1)) {
          activity6Button.setVisibility(View.INVISIBLE)
          if (function == 2) {
            activity5Button.setVisibility(View.INVISIBLE)
          }else if (function == 1) {
            activity5Button.setVisibility(View.INVISIBLE)
          }
        }
      }
    }

    def getDetails = {

      def standardTexts = {
        //TODO 1 - 10
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

        //TODO 11 - 15
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
          edit41.setText(item.firstStreet)
          edit42.setText(item.firstHouseNumber)
          edit43.setText(item.firstStairs)
          edit44.setText(item.firstDoor)
          edit45.setText(item.firstZipcode)
          edit46.setText(item.firstLocation)
          edit47.setText(item.immigrationCountry)

          // 5a ???
          if (list.lift(5).contains(1)) {
            edit51.setText(item.secondStreet)
            edit52.setText(item.secondHouseNumber)
            edit53.setText(item.secondStairs)
            edit54.setText(item.secondDoor)
            edit55.setText(item.secondZipcode)
            edit56.setText(item.secondLocation)
          }


        } else {
          edit51.setText(item.firstStreet)
          edit52.setText(item.firstHouseNumber)
          edit53.setText(item.firstStairs)
          edit54.setText(item.firstDoor)
          edit55.setText(item.firstZipcode)
          edit56.setText(item.firstLocation)
          edit57.setText(item.immigrationCountry)
          if (list.lift(5).contains(1)) {
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
          edit51.setText(item.thirdStreet)
          edit52.setText(item.thirdHouseNumber)
          edit53.setText(item.thirdStairs)
          edit54.setText(item.thirdDoor)
          edit55.setText(item.thirdZipcode)
          edit56.setText(item.thirdLocation)
          edit56.setText(item.condonedCountry)

        } else {
          edit41.setText(item.thirdStreet)
          edit42.setText(item.thirdHouseNumber)
          edit43.setText(item.thirdStairs)
          edit44.setText(item.thirdDoor)
          edit45.setText(item.thirdZipcode)
          edit46.setText(item.thirdLocation)
          edit46.setText(item.condonedCountry)
        }
      }

      def function3(int: Int, list: List[Int]) = {
        if (int == 2) {
          if (list.lift(5).contains(1)) {
            edit51.setText(item.firstStreet)
            edit52.setText(item.firstHouseNumber)
            edit53.setText(item.firstStairs)
            edit54.setText(item.firstDoor)
            edit55.setText(item.firstZipcode)
            edit56.setText(item.firstLocation)
            edit57.setText(item.immigrationCountry)

            edit61.setText(item.secondStreet)
            edit62.setText(item.secondHouseNumber)
            edit63.setText(item.secondStairs)
            edit64.setText(item.secondDoor)
            edit65.setText(item.secondZipcode)
            edit66.setText(item.secondLocation)

            edit71.setText(item.thirdStreet)
            edit72.setText(item.thirdHouseNumber)
            edit73.setText(item.thirdStairs)
            edit74.setText(item.thirdDoor)
            edit75.setText(item.thirdZipcode)
            edit76.setText(item.thirdLocation)
            edit77.setText(item.condonedCountry)

          } else {
            edit51.setText(item.firstStreet)
            edit52.setText(item.firstHouseNumber)
            edit53.setText(item.firstStairs)
            edit54.setText(item.firstDoor)
            edit55.setText(item.firstZipcode)
            edit56.setText(item.firstLocation)
            edit57.setText(item.immigrationCountry)

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
            edit41.setText(item.firstStreet)
            edit42.setText(item.firstHouseNumber)
            edit43.setText(item.firstStairs)
            edit44.setText(item.firstDoor)
            edit45.setText(item.firstZipcode)
            edit46.setText(item.firstLocation)
            edit47.setText(item.immigrationCountry)

            edit51.setText(item.secondStreet)
            edit52.setText(item.secondHouseNumber)
            edit53.setText(item.secondStairs)
            edit54.setText(item.secondDoor)
            edit55.setText(item.secondZipcode)
            edit56.setText(item.secondLocation)

            edit61.setText(item.thirdStreet)
            edit62.setText(item.thirdHouseNumber)
            edit63.setText(item.thirdStairs)
            edit64.setText(item.thirdDoor)
            edit65.setText(item.thirdZipcode)
            edit66.setText(item.thirdLocation)
            edit67.setText(item.condonedCountry)

          } else {
            edit41.setText(item.firstStreet)
            edit42.setText(item.firstHouseNumber)
            edit43.setText(item.firstStairs)
            edit44.setText(item.firstDoor)
            edit45.setText(item.firstZipcode)
            edit46.setText(item.firstLocation)
            edit47.setText(item.immigrationCountry)

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

      def function0 = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Sie müssen eine Funktion des Meldezettels wählen!")
          .setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel04])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }

      val optinal = db.checkCorrects
      standardTexts
      if (optinal.lift(2).contains(1)) optinal2a(function, optinal)
      else {
        //TODO 11 -> Familienstand
        text34.setText("Familienstand:")
        edit34.setText(item.familyStatus)

        function match {
          case 1 => function1(1, optinal)
          case 2 => function2(1, optinal)
          case 3 => function3(1, optinal)
          case _ => function0
        }
      }
    }

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[Meldezettel08]))

      }
    })

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel01])
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
      }
    })

    activity2Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel02])
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
      }
    })

    activity3Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (optinal.lift(2).contains(1)) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02a]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        } else startActivity(new Intent(getApplicationContext, classOf[Meldezettel03]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)

      }
    })

    activity4Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (optinal.lift(2).contains(1)) startActivity(new Intent(getApplicationContext, classOf[Meldezettel03]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        else if (function == 2) startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        else startActivity(new Intent(getApplicationContext, classOf[Meldezettel05]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)

      }
    })

    activity5Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (optinal.lift(2).contains(1)) {
          if (function == 2) startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
          else startActivity(new Intent(getApplicationContext, classOf[Meldezettel05]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        } else if (optinal.lift(5).contains(1)) startActivity(new Intent(getApplicationContext, classOf[Meldezettel05a]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        else startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)

      }
    })

    activity6Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (optinal.lift(2).contains(1)) {
          if (function == 2) startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
          else startActivity(new Intent(getApplicationContext, classOf[Meldezettel05a]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        } else startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]) addFlags Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
      }
    })



    getDetails
    buttonInvisible

  }
}

