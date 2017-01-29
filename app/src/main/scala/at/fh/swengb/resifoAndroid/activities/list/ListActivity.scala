package at.fh.swengb.resifoAndroid.activities.list

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{AdapterView, ListView}
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.activities.meldezettelEdit.Meldezettel01
import at.fh.swengb.resifoAndroid.db.DBHelper
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

/**
  * Created by laszlobalo on 31.12.16.
  */
class ListActivity extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)

    val db = new DBHelper(this)
//    db.restartTable
     db.createTable

    setContentView(R.layout.activity_list)

    val listOfItems  = db.readData
    val listView  = findViewById(R.id.myEntryList).asInstanceOf[ListView]
    val adapter = new CustomAdapter(getApplicationContext, listOfItems)
    listView.setAdapter(adapter)

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      override def onItemClick(parent: AdapterView[_], view: View, position: Int, id: Long): Unit = {
        val selectedItem = adapter.getItem(position)
        val intent = new Intent(view.getContext, classOf[ItemDetailsActivity])
        intent.putExtra("item",selectedItem)
        startActivity(intent)
      }
    })

    val fab = findViewById(R.id.fab).asInstanceOf[FloatingActionButton]
    fab.setOnClickListener(new View.OnClickListener() {
      def onClick(view: View) {
        db.insertFirstPage
        startActivity(new Intent(getApplicationContext, classOf[Meldezettel01]))
      }
    })
  }

}


