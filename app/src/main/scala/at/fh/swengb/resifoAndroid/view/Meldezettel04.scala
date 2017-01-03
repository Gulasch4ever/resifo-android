package at.fh.swengb.resifoAndroid.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.{ImageView, RadioButton, Toast}
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel04 extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel04)

    val radioB1: RadioButton = findViewById(R.id.radioButton1).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButton2).asInstanceOf[RadioButton]
    val radioB3: RadioButton = findViewById(R.id.radioButton3).asInstanceOf[RadioButton]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (radioB1.isChecked || radioB3.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel05]))
        } else if (radioB2.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel06]))
        } else Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
      }
    })
  }
}
