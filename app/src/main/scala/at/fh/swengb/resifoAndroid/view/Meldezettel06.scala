package at.fh.swengb.resifoAndroid.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R

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
    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel06.this, classOf[PopHelpView1]))
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

