package at.fh.swengb.resifoAndroid.activities.popUp.switchA

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 09.01.17.
  */
class PopSwitchActivitySelf extends Activity{
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pop_switch_view_self)

    val dm: DisplayMetrics = new DisplayMetrics
    getWindowManager.getDefaultDisplay.getMetrics(dm)
    val width: Int = dm.widthPixels
    val height: Int = dm.heightPixels
    getWindow.setLayout((width * .8).toInt, (height * .4).toInt)


  }
}
