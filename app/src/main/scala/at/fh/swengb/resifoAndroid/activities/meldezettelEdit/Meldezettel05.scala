package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.helpA.PopHelpActivity01
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel05 extends AppCompatActivity {

  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel05)

    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val radioB1: RadioButton = findViewById(R.id.radioAd1).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioAd2).asInstanceOf[RadioButton]
    val radioB3: RadioButton = findViewById(R.id.radioAd3).asInstanceOf[RadioButton]
    val radioB4: RadioButton = findViewById(R.id.radioAd4).asInstanceOf[RadioButton]
    val textAusland: TextView = findViewById(R.id.AdAusland).asInstanceOf[TextView]
    val textStaat: TextView = findViewById(R.id.AdStaat).asInstanceOf[TextView]
    val editTextStaat: EditText = findViewById(R.id.AdStaatN).asInstanceOf[EditText]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]

    val importantB1: EditText = findViewById(R.id.AdStrasse).asInstanceOf[EditText]
    val importantB2: EditText = findViewById(R.id.AdHausnr).asInstanceOf[EditText]
    val importantB3: EditText = findViewById(R.id.AdStiege).asInstanceOf[EditText]
    val importantB4: EditText = findViewById(R.id.AdTuer).asInstanceOf[EditText]
    val importantB5: EditText = findViewById(R.id.AdPLZ).asInstanceOf[EditText]
    val importantB6: EditText = findViewById(R.id.AdOrt).asInstanceOf[EditText]


    importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB3.getBackground.clearColorFilter()
    importantB4.getBackground.clearColorFilter()
    importantB5.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB6.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    editTextStaat.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)


    helpButton.setOnClickListener(new OnClickListener {

      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel05.this, classOf[PopHelpActivity01]))
      }

    })


    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (radioB1.isChecked && (radioB3.isChecked || radioB4.isChecked)) {
          db.updatePage5(importantB1.getText.toString, importantB2.getText.toString, importantB3.getText.toString, importantB4.
            getText.toString, importantB5.getText.toString, importantB6.getText.toString, editTextStaat.getText.toString)
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel07]))
        } else if (radioB2.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel05a]))
        } else Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
      }
    })

    radioB1.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        textAusland.setVisibility(View.VISIBLE)
        radioB3.setVisibility(View.VISIBLE)
        radioB4.setVisibility(View.VISIBLE)
      }
    })
    radioB2.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        radioB3.setChecked(false)
        radioB4.setChecked(false)
        textAusland.setVisibility(View.INVISIBLE)
        radioB3.setVisibility(View.INVISIBLE)
        radioB4.setVisibility(View.INVISIBLE)
        textStaat.setVisibility(View.INVISIBLE)
        editTextStaat.setVisibility(View.INVISIBLE)
      }
    })
    radioB3.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        textStaat.setVisibility(View.VISIBLE)
        editTextStaat.setVisibility(View.VISIBLE)
      }
    })
    radioB4.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        textStaat.setVisibility(View.INVISIBLE)
        editTextStaat.setVisibility(View.INVISIBLE)
      }
    })

  }

}
