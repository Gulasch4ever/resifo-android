package at.fh.swengb.resifoAndroid.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 03.01.17.
  */
class Meldezettel08 extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel08)

    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]
    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel08.this,classOf[PopHelpView1]))
      }

    })

  }
}
