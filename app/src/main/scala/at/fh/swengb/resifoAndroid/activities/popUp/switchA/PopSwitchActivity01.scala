package at.fh.swengb.resifoAndroid.activities.popUp.switchA

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
  * Created by laszlobalo on 04.01.17.
  */
class PopSwitchActivity01 extends Activity{
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.pop_switch_view_01)




    val dm: DisplayMetrics = new DisplayMetrics
    getWindowManager.getDefaultDisplay.getMetrics(dm)
    val width: Int = dm.widthPixels
    val height: Int = dm.heightPixels
    getWindow.setLayout((width * .8).toInt, (height * .6).toInt)

    val buttonWechseln: Button = findViewById(R.id.button).asInstanceOf[Button]
    buttonWechseln.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext,classOf[Meldezettel01]))
      }

    })

    val buttonAbbrechen: Button = findViewById(R.id.buttonAbbrechen).asInstanceOf[Button]
    buttonAbbrechen.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        onBackPressed()
      }

    })

  }
}
