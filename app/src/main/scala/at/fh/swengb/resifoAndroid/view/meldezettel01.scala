package at.fh.swengb.resifoAndroid.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 31.12.16.
  */
class Meldezettel01 extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel01)


    val nextButton: ImageView = findViewById(R.id.nxtButton).asInstanceOf[ImageView]

    nextButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(getApplicationContext, classOf[Meldezettel02]))
      }
    })

  }
}