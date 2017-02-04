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
import at.fh.swengb.resifoAndroid.activities.list.{Item, ListActivity}
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 31.12.16.
  */
class Meldezettel01 extends AppCompatActivity {

  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel01)

    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val radioB1: RadioButton = findViewById(R.id.radioButtonW).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButtonM).asInstanceOf[RadioButton]
    val importantB1: EditText = findViewById(R.id.editText2).asInstanceOf[EditText]
    val importantB2: EditText = findViewById(R.id.editText).asInstanceOf[EditText]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val famVErsterEhe = findViewById(R.id.viewFamVErsterEhe).asInstanceOf[EditText]
    val akad = findViewById(R.id.viewAkad).asInstanceOf[EditText]


    importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    famVErsterEhe.getBackground.clearColorFilter()
    akad.getBackground.clearColorFilter()


    def importantFill: Boolean = {
      if ((importantB1.getText.toString.trim == "") || (importantB2.getText.toString.trim == "")) {
        Toast.makeText(getApplicationContext, "Pflichtpfelder ausfüllen!", Toast
          .LENGTH_SHORT).show()
        return false
      } else return true
    }

    def importantCheck: Boolean = {
      if (radioB1.isChecked || radioB2.isChecked) {
        return true
      } else {
        Toast.makeText(getApplicationContext, "männlich oder weiblich ausfüllen", Toast
          .LENGTH_SHORT).show()
        return false
      }
    }

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Sie befinden sich bereits auf der ersten Seite!")
          .setNegativeButton("Zurück", null)
          .show()
      }
    })

    activity2Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[Meldezettel02])
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
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[Meldezettel03])
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
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[Meldezettel04])
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
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[Meldezettel05])
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
        new AlertDialog.Builder(Meldezettel01 .this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[Meldezettel06])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel01.this)
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
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Wenn Sie die Seite verlassen werden die Daten der aktuellen Seite nicht gespeichert. Möchten Sie fortfahren?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[Meldezettel08])
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
        if (importantFill && importantCheck) {
          db.updatePage1(importantB1.getText.toString, importantB2.getText.toString, famVErsterEhe.getText.toString, akad.getText.toString, if (radioB1.isChecked) "Frau" else "Herr","1")
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02])
            .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel01.this)
          .setMessage("Benötigen Sie Hilfe?")
          .setNegativeButton("Nein", null)
          .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel01.this, classOf[HelpActivity])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)
              dialog.dismiss()
            }
          })
          .show()
      }
    })
  }
   override  def onBackPressed() {
     new AlertDialog.Builder(Meldezettel01.this)
       .setMessage("Wenn Sie diese Seite verlassen wird Ihr gesammter Meldezettel verworfen! Sind Sie sicher?")
       .setNegativeButton("Nein", null)
       .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
         override def onClick(dialog: DialogInterface, which: Int): Unit = {
           db.deleteItem(db.getLastID)
           val intent: Intent = new Intent(Meldezettel01.this, classOf[ListActivity])
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
           startActivity(intent)
           dialog.dismiss()
         }
       })
       .show()

  }

}