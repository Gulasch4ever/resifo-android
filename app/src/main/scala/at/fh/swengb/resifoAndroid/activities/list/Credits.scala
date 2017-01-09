package at.fh.swengb.resifoAndroid.activities.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import at.fh.swengb.resifoAndroid.{MainActivity, R}

/**
  * Created by laszlobalo on 31.12.16.
  */
class Credits extends Activity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_credits)

    val exitButton: ImageView = findViewById(R.id.exitBtn).asInstanceOf[ImageView]

    exitButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[MainActivity]))
      }
    })
  }
}
