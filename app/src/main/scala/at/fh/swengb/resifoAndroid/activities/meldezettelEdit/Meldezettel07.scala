package at.fh.swengb.resifoAndroid.activities.meldezettelEdit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.popUp.PopHelpActivity01

/**
  * Created by laszlobalo on 03.01.17.
  */
class Meldezettel07 extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.meldezettel07)

    val helpButton: Button = findViewById(R.id.buttonHilfe).asInstanceOf[Button]

    helpButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        startActivity(new Intent(Meldezettel07.this,classOf[PopHelpActivity01]))
      }

    })
  }
}

