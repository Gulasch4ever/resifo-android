package at.fh.swengb.resifoAndroid.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ListView
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 31.12.16.
  */
class ListActivity extends AppCompatActivity {

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)



    val fab = findViewById(R.id.fab).asInstanceOf[FloatingActionButton]
    fab.setOnClickListener(new View.OnClickListener() {
      def onClick(view: View) {
        startActivity(new Intent(getApplicationContext, classOf[Meldezettel01]))
      }
    })

    val listOfItems = List(new Item("David", "Mischak", "26-10-1994"),
      new Item("Klara", "Schöffmann", "21-05-1997"),
      new Item("David", "Mischak", "26-10-1994"),
      new Item("Klara", "Schöffmann", "21-05-1997"),
      new Item("David", "Mischak", "26-10-1994"),
      new Item("Klara", "Schöffmann", "21-05-1997"),
      new Item("David", "Mischak", "26-10-1994"),
      new Item("Klara", "Schöffmann", "21-05-1997"))
    val listView = findViewById(R.id.myEntryList).asInstanceOf[ListView]
    listView.setAdapter(new CustomAdapter(getApplicationContext, listOfItems))

  }

}


