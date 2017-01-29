package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import java.util.Calendar

import android.app.{Activity, DatePickerDialog, Dialog}
import android.content.{DialogInterface, Intent}
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.helpA.PopHelpActivity01
import at.fh.swengb.resifoAndroid.activities.popUp.switchA.{PopSwitchActivity05, PopSwitchActivity06, PopSwitchActivity07, PopSwitchActivity08, _}
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 02.01.17.
  */
class Meldezettel02 extends AppCompatActivity {
  val db = new DBHelper(this)

  val datePicker: DatePicker = null
  var calendar: Calendar = null
  var dateView: TextView = null
  var year: Int = 0
  var month: Int = 0
  var day: Int = 0
  var currentDate: String = ""

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel02)
    dateView = findViewById(R.id.textView3).asInstanceOf[TextView]
    calendar = Calendar.getInstance
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    showDate(year, month + 1, day)

    val sameDate: String = s"$day/$month/$year"
    currentDate = ""

    val radioB1: RadioButton = findViewById(R.id.radioButton).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButton2).asInstanceOf[RadioButton]
    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val buttonView1: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val importantB2: EditText = findViewById(R.id.editText).asInstanceOf[EditText]
    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val religion: EditText = findViewById(R.id.editText3).asInstanceOf[EditText] //religion
    val zmr: EditText = findViewById(R.id.ZRMEingabe).asInstanceOf[EditText] //ZMR

    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    religion.getBackground.clearColorFilter()
    zmr.getBackground.clearColorFilter()

    def importantFill: Boolean = {
      if (importantB2.getText.toString.trim == "") {
        Toast.makeText(getApplicationContext, "Pflichtpfeld ausfüllen!", Toast
          .LENGTH_SHORT).show()
        false
      } else true
    }

    def timeChanged: Boolean = {
      if (currentDate == "") {
        Toast.makeText(getApplicationContext, "Sie haben das Datum noch nicht geändert!", Toast.LENGTH_SHORT).show()
        false
      }
      else true

    }

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        new AlertDialog.Builder(Meldezettel02.this)
          .setMessage("Hallo Laszlo")
          .setNegativeButton("no", null)
          .setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {
            override def onClick(dialog: DialogInterface, which: Int): Unit = {
              val intent: Intent = new Intent(Meldezettel02.this, classOf[Meldezettel01])
              intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
              startActivity(intent)

              dialog.dismiss()
            }
          })
          .show()

        //
      }
    })

    activity2Button.setOnClickListener(new OnClickListener {

      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivitySelf]))
      }
    })

    activity3Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity03]))
      }
    })

    activity4Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity04]))
      }
    })

    activity5Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity05]))
      }
    })

    activity6Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity06]))
      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity07]))
      }
    })

    activity8Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopSwitchActivity08]))
      }
    })



    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel02.this, classOf[PopHelpActivity01]))
      }

    })

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if ((radioB1.isChecked && !radioB2.isChecked) && timeChanged && importantFill) {
          val country = "Österreich"
          db.updatePage2(dateView.getText.toString, importantB2.getText.toString, religion.getText.toString, zmr.getText.toString, country)
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel03]).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        } else if (radioB2.isChecked && !radioB1.isChecked && timeChanged) {
          db.updatePage2(dateView.getText.toString, importantB2.getText.toString, religion.getText.toString, zmr.getText.toString, "")
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02a]))
        } else Toast.makeText(getApplicationContext, "eine Auswahl treffen", Toast.LENGTH_SHORT).show()
      }
    })
  }

  override def onBackPressed() {
    startActivity(new Intent(Meldezettel02.this, classOf[Meldezettel01]).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
  }

  @SuppressWarnings(Array("deprecation"))
  def setDate(view: View) {
    new DatePickerDialog(this, myDateListener, year, month, day).show()
    Toast.makeText(getApplicationContext, "Datum wählen", Toast.LENGTH_SHORT).show
  }

  private val myDateListener: DatePickerDialog.OnDateSetListener = new DatePickerDialog.OnDateSetListener() {
    def onDateSet(arg0: DatePicker, arg1: Int, arg2: Int, arg3: Int) {
      val newarg2 = arg2 + 1
      currentDate = s"$arg1/$newarg2/$arg3"
      showDate(arg1, arg2 + 1, arg3)
    }
  }

  private def showDate(year: Int, month: Int, day: Int) {
    dateView.setText(s"$day/$month/$year")
  }


}

