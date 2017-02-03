package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.{DialogInterface, Intent}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.help.HelpActivity
import at.fh.swengb.resifoAndroid.db.DBHelper

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

    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]

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
        new AlertDialog.Builder(Meldezettel07 .this)
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
        new AlertDialog.Builder(Meldezettel07 .this)
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
          .show()      }
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
        new AlertDialog.Builder(Meldezettel07 .this)
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
  }
}

