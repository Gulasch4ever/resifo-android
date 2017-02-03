package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget.{Button, TextView, Toast}
import at.fh.swengb.resifoAndroid.activities.list.ListActivity
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 03.01.17.
  */
class Meldezettel08 extends AppCompatActivity {

  val db = new DBHelper(this)


  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel08)

    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val saveButton: Button = findViewById(R.id.buttonSave).asInstanceOf[Button]

    val textFunktion: TextView = findViewById(R.id.textFunktion).asInstanceOf[TextView]
    val textGeht: TextView = findViewById(R.id.textGeht).asInstanceOf[TextView]

    val textSeite1: TextView = findViewById(R.id.textSeite1).asInstanceOf[TextView]
    val textSeite2: TextView = findViewById(R.id.textSeite2).asInstanceOf[TextView]
    val textSeite3: TextView = findViewById(R.id.textSeite3).asInstanceOf[TextView]
    val textSeite4: TextView = findViewById(R.id.textSeite4).asInstanceOf[TextView]
    val textSeite5: TextView = findViewById(R.id.textSeite5).asInstanceOf[TextView]
    val textSeite6: TextView = findViewById(R.id.textSeite6).asInstanceOf[TextView]
    val textSeite7: TextView = findViewById(R.id.textSeite7).asInstanceOf[TextView]

    val textSeiteA: TextView = findViewById(R.id.textSeiteA).asInstanceOf[TextView]
    val textSeiteB: TextView = findViewById(R.id.textSeiteB).asInstanceOf[TextView]
    val textSeiteC: TextView = findViewById(R.id.textSeiteC).asInstanceOf[TextView]
    val textSeiteD: TextView = findViewById(R.id.textSeiteD).asInstanceOf[TextView]
    val textSeiteE: TextView = findViewById(R.id.textSeiteE).asInstanceOf[TextView]
    val textSeiteF: TextView = findViewById(R.id.textSeiteF).asInstanceOf[TextView]
    val textSeiteG: TextView = findViewById(R.id.textSeiteG).asInstanceOf[TextView]


    def setInvisible = {

      textSeite5.setText("")
      textSeite6.setText("")
      textSeite7.setText("")
      textSeiteA.setText("")
      textSeiteB.setText("")
      textSeiteC.setText("")
      textSeiteD.setText("")
      textSeiteE.setText("")
      textSeiteF.setText("")
      textSeiteG.setText("")
      textGeht.setText("")
    }

    def autoCorrect = {

      setInvisible

      var valid: Boolean = true

      def standardCheck(list: List[Int]) = {
        list.lift(0) match {
          case Some(0) => textSeiteA.setText("Nein!")
            valid = false
          case Some(1) => textSeiteA.setText("Ja!")
          case _ => println("penis")

        }
        list.lift(1) match {
          case Some(0) => textSeiteB.setText("Nein!")
            valid = false
          case Some(1) => textSeiteB.setText("Ja!")
          case _ => println("penis")

        }
        list.lift(2) match {
          case Some(0) => textSeiteC.setText("Nein!")
          case Some(1) => textSeiteC.setText("Ja!")
          case _ => println("penis")

        }
        list.lift(3) match {
          case Some(0) => textSeiteD.setText("Nein!")
            valid = false

          case Some(1) => textSeiteD.setText("Ja!")
          case _ => println("penis")
        }
      }

      def finalCheck = {


        valid match {
          case true => textGeht.setText("Der Meldezettel ist korrekt!")
          case false => textGeht.setText("Der Meldezettel ist ungültig!")
        }

      }



      def function1(list: List[Int]) = {

        textSeite5.setText("Seite 5:")
        textSeite6.setText("Seite 5a (Optinal):")
        textFunktion.setText("Anmelden")


        standardCheck(list)


        list.lift(4) match {
          case Some(0) => textSeiteE.setText("Nein!")
            valid = false

          case Some(1) => textSeiteE.setText("Ja!")
          case _ => println("penis")

        }
        list.lift(5) match {
          case Some(0) => textSeiteF.setText("Nein!")
          case Some(1) => textSeiteF.setText("Ja!")
          case _ => println("penis")

        }

        finalCheck
      }
      def function2(list: List[Int]) = {

        textFunktion.setText("Abmelden")
        textSeite5.setText("Seite 6:")

        standardCheck(list)


        list.lift(6) match {
          case Some(0) => textSeiteE.setText("Nein!")
            valid = false

          case Some(1) => textSeiteE.setText("Ja!")
          case _ => println("penis")

        }
        finalCheck
      }

      def function3(list: List[Int]) = {

        textFunktion.setText("Anmelden und Abmelden")
        textSeite5.setText("Seite 5:")
        textSeite6.setText("Seite 5a (Optinal):")
        textSeite7.setText("Seite 6:")

        standardCheck(list)


        list.lift(4) match {
          case Some(0) => textSeiteE.setText("Nein!")
            valid = false

          case Some(1) => textSeiteE.setText("Ja!")
          case _ => println("penis")

        }
        list.lift(5) match {
          case Some(0) => textSeiteF.setText("Nein!")
          case Some(1) => textSeiteF.setText("Ja!")
          case _ => println("penis")

        }
        list.lift(6) match {
          case Some(0) => textSeiteG.setText("Nein!")
            valid = false

          case Some(1) => textSeiteG.setText("Ja!")
          case _ => println("penis")

        }
        finalCheck

      }

      def functionNo = {

        valid = false
        textSeite1.setText("")
        textSeite2.setText("")
        textSeite3.setText("")
        textSeite4.setText("")

        textFunktion.setText("Keine Funktion gewählt!!!")
        finalCheck
      }

      val corrects = db.checkCorrects
      val function = db.functionMeldezettel


      function match {
        case 1 => function1(corrects)
        case 2 => function2(corrects)
        case 3 => function3(corrects)
        case _ => functionNo
      }
    }

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 1 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel01])
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
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 2 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel02])
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
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 3 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel03])
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
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 4 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel04])
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
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 5 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel05])
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
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 6 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel06])
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
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Möchten SIe auf die 7 Seite wechseln?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel08.this, classOf[Meldezettel07])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    activity8Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel08.this)
          .setMessage("Sie befinden sich bereits auf der ersten Seite!")
          .setNegativeButton("Zurück", null)
          .show()
      }
    })



    saveButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        //TODO
        //db.insertFinal
        startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
      }

    })

    autoCorrect
  }
}
