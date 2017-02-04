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
    //###########################################
    val text1: TextView = findViewById(R.id.textView2).asInstanceOf[TextView]
    val textAKAD: TextView = findViewById(R.id.textView4).asInstanceOf[TextView]
    val textNachname: TextView = findViewById(R.id.textView1).asInstanceOf[TextView]
    val textFamErsteEhe: TextView = findViewById(R.id.textView3).asInstanceOf[TextView]
    val textGeschlecht: TextView = findViewById(R.id.textView5).asInstanceOf[TextView]
    val textGebDatum: TextView = findViewById(R.id.textView6).asInstanceOf[TextView]
    val textGebOrt: TextView = findViewById(R.id.textView7).asInstanceOf[TextView]
    val textReligion: TextView = findViewById(R.id.textView8).asInstanceOf[TextView]
    val textZRM: TextView = findViewById(R.id.textView9).asInstanceOf[TextView]
    val textStaatsangehörigkeit: TextView = findViewById(R.id.textView10).asInstanceOf[TextView]
    val textRDArt: TextView = findViewById(R.id.textView11).asInstanceOf[TextView]
    val textRDNr: TextView = findViewById(R.id.textView12).asInstanceOf[TextView]
    val textRDDatum: TextView = findViewById(R.id.textView13).asInstanceOf[TextView]
    val textRDBehörde: TextView = findViewById(R.id.textView14).asInstanceOf[TextView]
    val textFamilienstand: TextView = findViewById(R.id.textView15).asInstanceOf[TextView]
    val text1Straße: TextView = findViewById(R.id.textView16).asInstanceOf[TextView]
    val text1HausNr: TextView = findViewById(R.id.textView17).asInstanceOf[TextView]
    val text1Stiege: TextView = findViewById(R.id.textView18).asInstanceOf[TextView]
    val text1Tür: TextView = findViewById(R.id.textView19).asInstanceOf[TextView]
    val text1PLZ: TextView = findViewById(R.id.textView20).asInstanceOf[TextView]
    val text1Ort: TextView = findViewById(R.id.textView21).asInstanceOf[TextView]
    val textZuzugStaat: TextView = findViewById(R.id.textView22).asInstanceOf[TextView]
    val text2Straße: TextView = findViewById(R.id.textView23).asInstanceOf[TextView]
    val text2HausNr: TextView = findViewById(R.id.textView24).asInstanceOf[TextView]
    val text2Stiege: TextView = findViewById(R.id.textView25).asInstanceOf[TextView]
    val text2Tür: TextView = findViewById(R.id.textView26).asInstanceOf[TextView]
    val text2PLZ: TextView = findViewById(R.id.textView27).asInstanceOf[TextView]
    val text2Ort: TextView = findViewById(R.id.textView28).asInstanceOf[TextView]
    val text3Straße: TextView = findViewById(R.id.textView29).asInstanceOf[TextView]
    val text3HausNr: TextView = findViewById(R.id.textView30).asInstanceOf[TextView]
    val text3Stiege: TextView = findViewById(R.id.textView31).asInstanceOf[TextView]
    val text3Tür: TextView = findViewById(R.id.textView32).asInstanceOf[TextView]
    val text3PLZ: TextView = findViewById(R.id.textView33).asInstanceOf[TextView]
    val text3Ort: TextView = findViewById(R.id.textView34).asInstanceOf[TextView]
    val textVerziehStaat: TextView = findViewById(R.id.textView35).asInstanceOf[TextView]

    val edit1: TextView = findViewById(R.id.nachname).asInstanceOf[TextView]
    val vorname: TextView = findViewById(R.id.vorname).asInstanceOf[TextView]
    val famErsteEhe: TextView = findViewById(R.id.famErsteEhe).asInstanceOf[TextView]
    val akad: TextView = findViewById(R.id.akad).asInstanceOf[TextView]
    val geschlecht: TextView = findViewById(R.id.geschlecht).asInstanceOf[TextView]
    val gebDatum: TextView = findViewById(R.id.gebDatum).asInstanceOf[TextView]
    val gebOrt: TextView = findViewById(R.id.gebOrt).asInstanceOf[TextView]
    val religion: TextView = findViewById(R.id.religion).asInstanceOf[TextView]
    val zrm: TextView = findViewById(R.id.zrm).asInstanceOf[TextView]
    val staatsangehörigkeit: TextView = findViewById(R.id.staatsangehörigkeit).asInstanceOf[TextView]
    val rdArt: TextView = findViewById(R.id.rdArt).asInstanceOf[TextView]
    val rdNr: TextView = findViewById(R.id.rdNr).asInstanceOf[TextView]
    val rdDatum: TextView = findViewById(R.id.rdDatum).asInstanceOf[TextView]
    val rdBehörde: TextView = findViewById(R.id.rdBehoerde).asInstanceOf[TextView]
    val familienstand: TextView = findViewById(R.id.familienstand).asInstanceOf[TextView]
    val straße1: TextView = findViewById(R.id.strasse1).asInstanceOf[TextView]
    val hausNr1: TextView = findViewById(R.id.hausNr1).asInstanceOf[TextView]
    val stiege1: TextView = findViewById(R.id.stiege1).asInstanceOf[TextView]
    val tür1: TextView = findViewById(R.id.tuer1).asInstanceOf[TextView]
    val plz1: TextView = findViewById(R.id.plz1).asInstanceOf[TextView]
    val ort1: TextView = findViewById(R.id.ort1).asInstanceOf[TextView]
    val zuzugStaat: TextView = findViewById(R.id.zuzugStaat).asInstanceOf[TextView]
    val straße2: TextView = findViewById(R.id.strasse2).asInstanceOf[TextView]
    val hausNr2: TextView = findViewById(R.id.hausNr2).asInstanceOf[TextView]
    val stiege2: TextView = findViewById(R.id.stiege2).asInstanceOf[TextView]
    val tür2: TextView = findViewById(R.id.tuer2).asInstanceOf[TextView]
    val plz2: TextView = findViewById(R.id.plz2).asInstanceOf[TextView]
    val ort2: TextView = findViewById(R.id.ort2).asInstanceOf[TextView]
    val straße3: TextView = findViewById(R.id.strasse3).asInstanceOf[TextView]
    val hausNr3: TextView = findViewById(R.id.hausNr3).asInstanceOf[TextView]
    val stiege3: TextView = findViewById(R.id.stiege3).asInstanceOf[TextView]
    val tür3: TextView = findViewById(R.id.tuer3).asInstanceOf[TextView]
    val plz3: TextView = findViewById(R.id.plz3).asInstanceOf[TextView]
    val ort3: TextView = findViewById(R.id.ort3).asInstanceOf[TextView]
    val verziehStaat: TextView = findViewById(R.id.verziehStaat).asInstanceOf[TextView]

    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]

    val function = db.functionMeldezettel

    def setInvisble = {

//      textVorname.setText("")
//      textAKAD.setText("")
//      textNachname.setText("")
//      textFamErsteEhe.setText("")
//      textGeschlecht.setText("")
//      textGebDatum.setText("")
//      textGebOrt.setText("")
//      textReligion.setText("")
//      textZRM.setText("")
//      textStaatsangehörigkeit.setText("")
      textRDArt.setText("")
      textRDNr.setText("")
      textRDDatum.setText("")
      textRDBehörde.setText("")
      textFamilienstand.setText("")
      text1Straße.setText("")
      text1HausNr.setText("")
      text1Stiege.setText("")
      text1Tür.setText("")
      text1PLZ.setText("")
      text1Ort.setText("")
      textZuzugStaat.setText("")
      text2Straße.setText("")
      text2HausNr.setText("")
      text2Stiege.setText("")
      text2Tür.setText("")
      text2PLZ.setText("")
      text2Ort.setText("")
      text3Straße.setText("")
      text3HausNr.setText("")
      text3Stiege.setText("")
      text3Tür.setText("")
      text3PLZ.setText("")
      text3Ort.setText("")
      textVerziehStaat.setText("")

      nachname.setText("")
      vorname.setText("")
      famErsteEhe.setText("")
      akad.setText("")
      geschlecht.setText("")
      gebDatum.setText("")
      gebOrt.setText("")
      religion.setText("")
      zrm.setText("")
      staatsangehörigkeit.setText("")
      rdArt.setText("")
      rdNr.setText("")
      rdDatum.setText("")
      rdBehörde.setText("")

      familienstand.setText("")

      straße1.setText("")
      hausNr1.setText("")
      stiege1.setText("")
      tür1.setText("")
      plz1.setText("")
      ort1.setText("")
      zuzugStaat.setText("")
      straße2.setText("")
      hausNr2.setText("")
      stiege2.setText("")
      tür2.setText("")
      plz2.setText("")
      ort2.setText("")
      straße3.setText("")
      hausNr3.setText("")
      stiege3.setText("")
      tür3.setText("")
      plz3.setText("")
      ort3.setText("")
      verziehStaat.setText("")

    }

    setInvisble

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


    def getDetails = {

      def standardTexts = {
        //TODO 1 - 10
        nachname.setText(item.lastname)
        vorname.setText(item.firstname)
        famErsteEhe.setText(item.surnameBeforeFirstMarriage)
        akad.setText(item.academicDegree)
        geschlecht.setText(item.gender)
        gebDatum.setText(item.birthdate)
        gebOrt.setText(item.birthplace)
        religion.setText(item.religion)
        zrm.setText(item.zmr)
        staatsangehörigkeit.setText(item.nationality)

      }

      def optinal2a(int: Int, list: List[Int]) = {

        //TODO 11 - 15

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
          //TODO 12-18
          rdNr.setText(item.firstStreet)
          rdDatum.setText(item.firstHouseNumber)
          rdBehörde.setText(item.firstStairs)
          familienstand.setText(item.firstDoor)
          stra.setText(item.firstZipcode)
          ort1.setText(item.firstLocation)
          zuzugStaat.setText(item.immigrationCountry)

          // 5a ???
          if (list.lift(5).contains(1)) {
            //TODO 19-24
            ???
          }


        } else {
          //TODO 16 - 22
          if (list.lift(5).contains(1)) {
            //TODO 23-28

          }

        }


      }

      def function2(int: Int, list: List[Int]) = {
        //TODO 16
        if (int == 2) {
          //TODO 16-22 -> 22 verzieh
        } else {
          //TODO 12-18
        }
      }

      def function3(int: Int, list: List[Int]) = {
        if (int == 2) {
          if (list.lift(5).contains(1)) {
            //TODO 16 -35
          } else {
            //TODO 16- 29
          }
        } else {
          if (list.lift(5).contains(1)) {
            //TODO 12-31
          } else {
            //TODO 12-25
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
        textRDArt.setText("Familienstand:")
        rdArt.setText(item.familyStatus)

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
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel01])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity2Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel02])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity3Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel07])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity4Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel04])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity5Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel05])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity6Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel06])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Sie befinden sich bereits auf der ersten Seite!")
          .setNegativeButton("Zurück", null)
          .show()
      }
    })

    activity8Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[Meldezettel08])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel07.this)
          .setMessage("Benötigen Sie Hilfe?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel07.this, classOf[HelpActivity])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    getDetails

  }
}

