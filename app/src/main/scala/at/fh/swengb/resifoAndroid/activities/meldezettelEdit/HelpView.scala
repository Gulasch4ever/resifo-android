package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

/**
  * Created by laszlobalo on 29.01.17.
  */

import android.content.Intent
import android.graphics.{Color, PorterDuff}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget._
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.list.{Item, ListActivity}
import at.fh.swengb.resifoAndroid.db.DBHelper

class HelpView extends AppCompatActivity {


  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.help_view)

  }
}
