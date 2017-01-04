package at.fh.swengb.resifoAndroid.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 31.12.16.
  */
class Meldezettel01 extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel01)


    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val radioB1: RadioButton = findViewById(R.id.radioButtonW).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButtonM).asInstanceOf[RadioButton]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (radioB1.isChecked || radioB2.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02]))
        } else Toast.makeText(getApplicationContext, "männlich oder weiblich auswählen", Toast.LENGTH_SHORT).show()
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this,classOf[PopHelpView1]))
      }

    })
  }
}