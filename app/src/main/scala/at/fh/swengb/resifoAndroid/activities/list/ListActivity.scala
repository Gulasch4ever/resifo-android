package at.fh.swengb.resifoAndroid.activities.list

import android.content.{DialogInterface, Intent}
import android.database.Cursor
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.text.{Editable, TextWatcher}
import android.view.{SearchEvent, View}
import android.widget.{AdapterView, EditText, ListView, SearchView}
import at.fh.swengb.resifoAndroid.{MainActivity, R}
import at.fh.swengb.resifoAndroid.activities.meldezettelEdit.Meldezettel01
import at.fh.swengb.resifoAndroid.db.DBHelper
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

/**
  * Created by laszlobalo on 31.12.16.
  */
class ListActivity extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)

    //TODO Search bar verändert größe beim öffnen

    val db = new DBHelper(this)
//     db.restartTable
    db.createTable
    db.createFinalTable

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
  override  def onBackPressed() {
    new AlertDialog.Builder(ListActivity.this)
      .setMessage("Wollen Sie zur Startseite zurückkehren?")
      .setNegativeButton("Nein", null)
      .setPositiveButton("Ja", new android.content.DialogInterface.OnClickListener() {
        override def onClick(dialog: DialogInterface, which: Int): Unit = {
          val intent: Intent = new Intent(ListActivity.this, classOf[MainActivity])
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
          startActivity(intent)
          dialog.dismiss()
        }
      })
      .show()

  }
}


