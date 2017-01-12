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
import at.fh.swengb.resifoAndroid.activities.popUp.switchA.{PopSwitchActivity06, PopSwitchActivity07, PopSwitchActivity08, _}
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel02a extends AppCompatActivity {

  val db = new DBHelper(this)
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
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val importantB2: EditText = findViewById(R.id.editText4).asInstanceOf[EditText]
    val importantB1: EditText = findViewById(R.id.editText5).asInstanceOf[EditText]
    val importantB3: EditText = findViewById(R.id.editText6).asInstanceOf[EditText]
    val importantB4: EditText = findViewById(R.id.editText8).asInstanceOf[EditText]

    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]

    importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB3.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB4.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity01]))
      }
    })

    activity2Button.setOnClickListener(new OnClickListener {

      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivitySelf]))
      }
    })

    activity3Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity03]))
      }
    })

    activity4Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity04]))
      }
    })

    activity5Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity05]))
      }
    })

    activity6Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity06]))
      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity07]))
      }
    })

    activity8Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopSwitchActivity08]))
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02a.this, classOf[PopHelpActivity01]))
      }

    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        db.updatePage2a(importantB2.getText.toString, importantB1.getText.toString, importantB3.getText.toString, dateView.getText.toString,importantB4.getText.toString)

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