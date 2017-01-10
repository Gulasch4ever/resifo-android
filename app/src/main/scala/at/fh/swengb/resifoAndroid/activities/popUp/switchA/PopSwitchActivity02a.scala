package at.fh.swengb.resifoAndroid.activities.popUp.switchA

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.meldezettelEdit.{Meldezettel01, Meldezettel02a}

/**
  * Created by laszlobalo on 09.01.17.
  */
class PopSwitchActivity02a extends Activity{
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pop_switch_view_02a)

    val buttonWechseln: Button = findViewById(R.id.button).asInstanceOf[Button]


    val dm: DisplayMetrics = new DisplayMetrics
    getWindowManager.getDefaultDisplay.getMetrics(dm)
    val width: Int = dm.widthPixels
    val height: Int = dm.heightPixels
    getWindow.setLayout((width * .8).toInt, (height * .4).toInt)


    buttonWechseln.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext,classOf[Meldezettel02a]))
      }

    })


  }
}
