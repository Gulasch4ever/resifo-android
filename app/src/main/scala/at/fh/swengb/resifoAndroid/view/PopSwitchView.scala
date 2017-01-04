package at.fh.swengb.resifoAndroid.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 04.01.17.
  */
class PopSwitchView extends Activity{
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pop_switch_view)

    val buttonView1: Button = findViewById(R.id.button1).asInstanceOf[Button]


    val dm: DisplayMetrics = new DisplayMetrics
    getWindowManager.getDefaultDisplay.getMetrics(dm)
    val width: Int = dm.widthPixels
    val height: Int = dm.heightPixels
    getWindow.setLayout((width * .8).toInt, (height * .6).toInt)

    buttonView1.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext,classOf[Meldezettel01]))
      }

    })

  }
}
