package at.fh.swengb.resifoAndroid.activities.popUp.helpA

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.meldezettelEdit.Meldezettel01

/**
  * Created by laszlobalo on 03.01.17.
  */
class PopHelpActivity01 extends Activity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pop_help_view1)

    val dm: DisplayMetrics = new DisplayMetrics
    getWindowManager.getDefaultDisplay.getMetrics(dm)
    val width: Int = dm.widthPixels
    val height: Int = dm.heightPixels
    getWindow.setLayout((width * .8).toInt, (height * .7).toInt)

    val buttonAbbrechen: Button = findViewById(R.id.button8).asInstanceOf[Button]
      buttonAbbrechen.setOnClickListener(new OnClickListener {
        def onClick(v: View): Unit = {
          onBackPressed()
        }

    })
  }
}
