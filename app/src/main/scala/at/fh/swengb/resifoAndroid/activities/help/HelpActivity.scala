package at.fh.swengb.resifoAndroid.activities.help

/**
  * Created by laszlobalo on 29.01.17.
  */

import android.os.Bundle
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R

class HelpActivity extends AppCompatActivity {


  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.help_view)

    val backButton: Button = findViewById(R.id.button9).asInstanceOf[Button]

    backButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        onBackPressed()
      }
    })


  }
}
