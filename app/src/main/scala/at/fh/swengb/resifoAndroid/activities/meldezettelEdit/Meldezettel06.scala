package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.PopHelpActivity01

/**
  * Created by laszlobalo on 03.01.17.
  */
class Meldezettel06 extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel06)

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
    val importantB5: EditText = findViewById(R.id.AdPLZ).asInstanceOf[EditText]
    val importantB6: EditText = findViewById(R.id.AdOrt).asInstanceOf[EditText]


    importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB5.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB6.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    editTextStaat.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)

    importantB3.getBackground.clearColorFilter()
    importantB4.getBackground.clearColorFilter()

    helpButton.setOnClickListener(new OnClickListener {


      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel06.this, classOf[PopHelpActivity01]))
      }

    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (radioB3.isChecked || radioB4.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel07]))
        } else Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
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

