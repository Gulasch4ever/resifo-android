package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
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

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel03.this,classOf[PopHelpActivity01]))
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
