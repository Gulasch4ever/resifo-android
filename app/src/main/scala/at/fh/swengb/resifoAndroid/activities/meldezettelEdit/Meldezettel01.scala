package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.{PopHelpActivity01, PopSwitchActivity01}

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
    val buttonView1: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val importantB1: EditText = findViewById(R.id.editText2).asInstanceOf[EditText]
    val importantB2: EditText = findViewById(R.id.editText).asInstanceOf[EditText]


    importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)

    buttonView1.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
      startActivity(new Intent(Meldezettel01.this,classOf[PopSwitchActivity01]))
      }
    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (radioB1.isChecked || radioB2.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02]))
        } else Toast.makeText(getApplicationContext, "männlich oder weiblich auswählen", Toast.LENGTH_SHORT).show()
      }
    })

    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopHelpActivity01]))
      }

    })


  }
}