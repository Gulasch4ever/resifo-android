package at.fh.swengb.resifoAndroid.view

import java.util.Calendar

import android.app.{DatePickerDialog, Dialog}
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel02a extends AppCompatActivity {

  val datePicker: DatePicker = null
  var calendar: Calendar = null
  var dateView: TextView = null
  var year: Int = 0
  var month: Int = 0
  var day: Int = 0

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel02a)
    dateView = findViewById(R.id.textView3).asInstanceOf[TextView]
    calendar = Calendar.getInstance
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    showDate(year, month + 1, day)

    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[Meldezettel03]))
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