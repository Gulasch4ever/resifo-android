package at.fh.swengb.resifoAndroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.{View, Window, WindowManager}
import android.view.View.OnClickListener
import android.widget.ImageView
import at.fh.swengb.resifoAndroid.activities.list.{Credits, ListActivity}
//import at.fh.swengb.resifoAndroid.activities.meldezettelEdit.TEST
import at.fh.swengb.resifoAndroid.db.DBHelper


/**
  * Created by laszlobalo on 31.12.16.
  */
class MainActivity extends AppCompatActivity {
  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//    db.upgradeDB

    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]
    val infoButton: ImageView = findViewById(R.id.infButton).asInstanceOf[ImageView]

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
      }
    })

    infoButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[Credits]))
      }
    })

  }
}