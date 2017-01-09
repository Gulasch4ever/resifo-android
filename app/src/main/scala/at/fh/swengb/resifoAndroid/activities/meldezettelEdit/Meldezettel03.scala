package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.PopHelpActivity01

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel03 extends AppCompatActivity {

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

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel03.this,classOf[PopHelpActivity01]))
      }

    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (groupRadio.getCheckedRadioButtonId == -1) {
          Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
        }
        else {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel04]))
        }
      }
    })
  }
}
