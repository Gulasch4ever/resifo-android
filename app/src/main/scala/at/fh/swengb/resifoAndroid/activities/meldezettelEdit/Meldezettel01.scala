package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.list.Item
import at.fh.swengb.resifoAndroid.activities.popUp.helpA.PopHelpActivity01
import at.fh.swengb.resifoAndroid.activities.popUp.switchA._
import at.fh.swengb.resifoAndroid.db.DBHelper

/**
  * Created by laszlobalo on 31.12.16.
  */
class Meldezettel01 extends AppCompatActivity {

  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel01)

    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val radioB1: RadioButton = findViewById(R.id.radioButtonW).asInstanceOf[RadioButton]
    val radioB2: RadioButton = findViewById(R.id.radioButtonM).asInstanceOf[RadioButton]
    val importantB1: EditText = findViewById(R.id.editText2).asInstanceOf[EditText]
    val importantB2: EditText = findViewById(R.id.editText).asInstanceOf[EditText]
    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    val activity1Button: Button = findViewById(R.id.button1).asInstanceOf[Button]
    val activity2Button: Button = findViewById(R.id.button2).asInstanceOf[Button]
    val activity3Button: Button = findViewById(R.id.button3).asInstanceOf[Button]
    val activity4Button: Button = findViewById(R.id.button4).asInstanceOf[Button]
    val activity5Button: Button = findViewById(R.id.button5).asInstanceOf[Button]
    val activity6Button: Button = findViewById(R.id.button6).asInstanceOf[Button]
    val activity7Button: Button = findViewById(R.id.button7).asInstanceOf[Button]
    val activity8Button: Button = findViewById(R.id.button98).asInstanceOf[Button]
    val famVErsterEhe = findViewById(R.id.viewFamVErsterEhe).asInstanceOf[EditText]
    val akad = findViewById(R.id.viewAkad).asInstanceOf[EditText]


    importantB1.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
    importantB2.getBackground.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)

    def importantFill: Boolean = {
      if ((importantB1.getText.toString.trim == "") || (importantB2.getText.toString.trim == "")) {
        Toast.makeText(getApplicationContext, "Pflichtpfelder ausfüllen!", Toast
          .LENGTH_SHORT).show()
        return false
        } else return true
    }

      def importantCheck :Boolean = {
        if (radioB1.isChecked || radioB2.isChecked){
          return true
        }else {Toast.makeText(getApplicationContext, "männlich oder weiblich ausfüllen", Toast
          .LENGTH_SHORT).show()
        return false
        }
    }

    activity1Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivitySelf]))
      }
    })

    activity2Button.setOnClickListener(new OnClickListener {

      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity02]))
      }
    })

    activity3Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity03]))
      }
    })

    activity4Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity04]))
      }
    })

    activity5Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity05]))
      }
    })

    activity6Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity06]))
      }
    })

    activity7Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity07]))
      }
    })

    activity8Button.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopSwitchActivity08]))
      }
    })



    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        if (importantFill && importantCheck) {
          val item = new Item(importantB1.getText.toString, importantB2.getText.toString, famVErsterEhe.toString, akad.toString, if (radioB1.isChecked) "Frau" else "Herr")
          db.insertItem(item)
          startActivity(new Intent(getApplicationContext, classOf[Meldezettel02]))
        }
      }
    })

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel01.this, classOf[PopHelpActivity01]))
      }
    })
  }


}