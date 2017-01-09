package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import java.util.Calendar

import android.app.{DatePickerDialog, Dialog}
import android.content.Intent
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.helpA.PopHelpActivity01
import at.fh.swengb.resifoAndroid.activities.popUp.switchA.PopSwitchActivity01

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel02 extends AppCompatActivity {
  val datePicker: DatePicker = null
  var calendar: Calendar = null
  var dateView: TextView = null
  var year: Int = 0
  var month: Int = 0
  var day: Int = 0

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel02)
    dateView = findViewById(R.id.textView3).asInstanceOf[TextView]
    calendar = Calendar.getInstance
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    showDate(year, month + 1, day)


    val radioB1: RadioButton = findViewById(R.id.radioButton).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButton2).asInstanceOf[RadioButton]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val buttonView1: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val importantB2: EditText = findViewById(R.id.editText).asInstanceOf[EditText]


    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)



    buttonView1.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity01]))
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopHelpActivity01]))
      }

    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        if (radioB1.isChecked && !radioB2.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel03]))
        } else if (radioB2.isChecked && !radioB1.isChecked) {
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02a]))
        } else Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
      }
    })
  }

  @SuppressWarnings(Array("deprecation"))
  def setDate(view: View) {
    showDialog(999)
    Toast.makeText(getApplicationContext, "Datum wählen", Toast.LENGTH_SHORT).show
  }

  override protected def onCreateDialog(id: Int): Dialog = {
    if (id == 999) {
      return new DatePickerDialog(this, myDateListener, year, month, day)
    }
    return null
  }

  private val myDateListener: DatePickerDialog.OnDateSetListener = new DatePickerDialog.OnDateSetListener() {
    def onDateSet(arg0: DatePicker, arg1: Int, arg2: Int, arg3: Int) {
      showDate(arg1, arg2 + 1, arg3)
    }
  }

  private def showDate(year: Int, month: Int, day: Int) {
    dateView.setText(s"$day/$month/$year")
  }


}

