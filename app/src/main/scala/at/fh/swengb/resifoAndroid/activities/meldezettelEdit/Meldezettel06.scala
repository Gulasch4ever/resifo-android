package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.{DialogInterface, Intent}
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.help.HelpActivity
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 03.01.17.
  */
class Meldezettel06 extends AppCompatActivity {

  val db = new DBHelper(this)

  //TODO auto google address


  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel06)


    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val radioB3: RadioButton = findViewById(R.id.radioAd3).asInstanceOf[RadioButton]
    val radioB4: RadioButton = findViewById(R.id.radioAd4).asInstanceOf[RadioButton]
    val textStaat: TextView = findViewById(R.id.AdStaat).asInstanceOf[TextView]
    val editTextStaat: EditText = findViewById(R.id.AdStaatN).asInstanceOf[EditText]

    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]

    val importantB1: EditText = findViewById(R.id.AdStrasse).asInstanceOf[EditText]
    val importantB2: EditText = findViewById(R.id.AdHausnr).asInstanceOf[EditText]
    val importantB3: EditText = findViewById(R.id.AdStiege).asInstanceOf[EditText]
    val importantB4: EditText = findViewById(R.id.AdTuer).asInstanceOf[EditText]
    val importantB5: EditText = findViewById(R.id.editText7).asInstanceOf[EditText]
    val importantB6: EditText = findViewById(R.id.AdOrt).asInstanceOf[EditText]

    val function = db.functionMeldezettel.toString
    if (function == "0") new AlertDialog.Builder(Meldezettel06.this)
      .setMessage("Sie müssen eine Funktion des Meldezettels wählen!")
      .setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {
        override def onClick(dialog: DialogInterface, which: Int): Unit = {
          val intent: Intent = new Intent(Meldezettel06.this, classOf[Meldezettel04])
          intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
          startActivity(intent)
          dialog.dismiss()
        }
      })
      .show()

    def colorImportant = {
      textStaat.setVisibility(View.INVISIBLE)
      editTextStaat.setVisibility(View.INVISIBLE)

      importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
      importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
      importantB5.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
      importantB6.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
      editTextStaat.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)

      importantB3.getBackground.clearColorFilter()
      importantB4.getBackground.clearColorFilter()
    }

  colorImportant


    def noP = {
      Toast.makeText(getApplicationContext, "Pflichtpfelder bearbeiten!", Toast
        .LENGTH_SHORT).show()
    }

    def importantFill(int: Int): Boolean = {

      int match {
        case 1 => if ((importantB1.getText.toString.trim == "")
          || (importantB2.getText.toString.trim == "")
          || (importantB5.getText.toString.trim == "")
          || (importantB6.getText.toString.trim == "")) {
          false
        } else true
        case 2 => if ((importantB1.getText.toString.trim == "")
          || (importantB2.getText.toString.trim == "")
          || (importantB5.getText.toString.trim == "")
          || (importantB6.getText.toString.trim == ""
          || editTextStaat.getText.toString.trim == "")) {
          false
        }
        else true
        case _ => false
      }
    }

    def importantCheck: Boolean = {
      if (radioB3.isChecked || radioB4.isChecked) {
        if (radioB3.isChecked) importantFill(2) else importantFill(1)
      } else false
    }

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel06.this, classOf[Meldezettel01])
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
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel06.this, classOf[Meldezettel02])
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
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel06.this, classOf[Meldezettel06])
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
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel06.this, classOf[Meldezettel04])
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
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel06.this, classOf[Meldezettel05])
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
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Sie befinden sich bereits auf der ersten Seite!")
          .setNegativeButton("Zurück", null)
          .show()
      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              startActivity(new Intent(getApplicationContext, classOf[Meldezettel07]))

            }
          })
          .show()
      }
    })

    activity8Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              startActivity(new Intent(getApplicationContext, classOf[Meldezettel08]))

            }
          })
          .show()
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel06.this)
          .setMessage("Benötigen Sie Hilfe?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel06.this, classOf[HelpActivity])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (importantCheck) {
          db.updatePage6(importantB1.getText.toString, importantB2.getText.toString, importantB3.getText.toString, importantB4.
            getText.toString, importantB5.getText.toString, importantB6.getText.toString, editTextStaat.getText.toString, "1")
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel07]))
        } else noP
      }
    })

    radioB3.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        radioB4.setChecked(false)
        textStaat.setVisibility(View.VISIBLE)
        editTextStaat.setVisibility(View.VISIBLE)
      }
    })

    radioB4.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        radioB3.setChecked(false)
        textStaat.setVisibility(View.INVISIBLE)
        editTextStaat.setVisibility(View.INVISIBLE)
      }
    })

  }
}

