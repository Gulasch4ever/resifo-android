package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.help.HelpActivity
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel03 extends AppCompatActivity {

  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel03)

    val groupRadio: RadioGroup = findViewById(R.id.option).asInstanceOf[RadioGroup]
    val radioB1: RadioButton = findViewById(R.id.radioButton).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButton2).asInstanceOf[RadioButton]
    val radioB3: RadioButton = findViewById(R.id.radioButton3).asInstanceOf[RadioButton]
    val radioB4: RadioButton = findViewById(R.id.radioButton4).asInstanceOf[RadioButton]
    val radioB5: RadioButton = findViewById(R.id.radioButton5).asInstanceOf[RadioButton]
    val radioB6: RadioButton = findViewById(R.id.radioButton6).asInstanceOf[RadioButton]
    val radioB7: RadioButton = findViewById(R.id.radioButton7).asInstanceOf[RadioButton]
    val radioB8: RadioButton = findViewById(R.id.radioButton8).asInstanceOf[RadioButton]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]

    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]


    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[Meldezettel01])
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
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[Meldezettel02])
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
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Sie befinden sich bereits auf der dritten Seite!")
          .setNegativeButton("Zurück", null)
          .show()
      }
    })

    activity4Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[Meldezettel04])
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
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[Meldezettel05])
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
        new AlertDialog.Builder(Meldezettel03 .this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[Meldezettel06])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[Meldezettel07])
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
        startActivity(new Intent(Meldezettel03.this, classOf[Meldezettel08]))
      }
    })


    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel03.this)
          .setMessage("Benötigen Sie Hilfe?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel03.this, classOf[HelpActivity])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })

    def nextActivity: Unit = {
      startActivity(new Intent(getApplicationContext, classOf[Meldezettel04]))
    }

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (groupRadio.getCheckedRadioButtonId == -1) {
          Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
        }
        else {
          if (radioB1.isChecked) db.updatePage3("ledig");nextActivity
          if (radioB2.isChecked) db.updatePage3("verheiratet");nextActivity
          if (radioB3.isChecked) db.updatePage3("in eingetragener Partnerschaft lebend");nextActivity
          if (radioB4.isChecked) db.updatePage3("geschieden");nextActivity
          if (radioB5.isChecked) db.updatePage3("Ehe aufgehoben oder für nichtig erklärt");nextActivity
          if (radioB6.isChecked) db.updatePage3("eingetragene Ehe aufgelöst oder für nichtig erklärt");nextActivity
          if (radioB7.isChecked) db.updatePage3("verwitwet");nextActivity
          if (radioB8.isChecked) db.updatePage3("hinterbliebener eingetragener Partnerschaft");nextActivity
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel04]))
        }
      }
    })
  }
}
