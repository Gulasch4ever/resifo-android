package at.fh.swengb.resifoAndroid.activities.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.View.OnClickListener
import android.widget.{Button, TextView}
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.db.DBHelper
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

class ItemDetailsActivity extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_item_details)

    val db = new DBHelper(this)


  }
}

