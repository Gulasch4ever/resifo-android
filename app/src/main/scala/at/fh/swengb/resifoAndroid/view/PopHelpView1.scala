package at.fh.swengb.resifoAndroid.view

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 03.01.17.
  */
class PopHelpView1 extends Activity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pop_help_view1)

    val dm: DisplayMetrics = new DisplayMetrics
    getWindowManager.getDefaultDisplay.getMetrics(dm)
    val width: Int = dm.widthPixels
    val height: Int = dm.heightPixels
    getWindow.setLayout((width * .8).toInt, (height * .6).toInt)

  }
}
