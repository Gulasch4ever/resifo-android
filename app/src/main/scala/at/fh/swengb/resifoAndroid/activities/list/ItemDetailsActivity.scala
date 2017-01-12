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

  val db = new DBHelper(this)

  def deleteItem(vorname: String, nachname: String):Unit = db.deleteItem(vorname, nachname)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_item_details)
    val toolbar: Toolbar = findViewById(R.id.toolbar).asInstanceOf[Toolbar]
    setSupportActionBar(toolbar)

    val intent = getIntent
    val item: FinalItem = intent.getExtras.get("item").asInstanceOf[FinalItem]

    val delButton: Button = findViewById(R.id.delButton).asInstanceOf[Button]

    delButton.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        deleteItem(item.vorname, item.nachname)
        startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
      }
    })

    val gender: TextView = findViewById(R.id.showAnrede).asInstanceOf[TextView]
    gender.setText(item.gender)

    val vorname: TextView = findViewById(R.id.showVorname).asInstanceOf[TextView]
    vorname.setText(item.vorname)

    val nachname: TextView = findViewById(R.id.showNachname).asInstanceOf[TextView]
    nachname.setText(item.nachname)

    val famVErsterEhe: TextView = findViewById(R.id.showFamVErsterEhe).asInstanceOf[TextView]
    famVErsterEhe.setText(item.fam_v_erster_ehe)

    val akad: TextView = findViewById(R.id.showAkad).asInstanceOf[TextView]
    akad.setText(item.akad)

    val gebDatum: TextView = findViewById(R.id.showGebdatum).asInstanceOf[TextView]
    gebDatum.setText(item.geburtsdatum)

    val gebOrt: TextView = findViewById(R.id.showGebort).asInstanceOf[TextView]
    gebOrt.setText(item.geburtsort)

    val religion: TextView = findViewById(R.id.showReligion).asInstanceOf[TextView]
    religion.setText(item.religion)

    val ZMR: TextView = findViewById(R.id.showZMR).asInstanceOf[TextView]
    ZMR.setText(item.zmr)

    val staat: TextView = findViewById(R.id.showStaat).asInstanceOf[TextView]
    staat.setText(item.country)

    val reiseArt: TextView = findViewById(R.id.showReiseArt).asInstanceOf[TextView]
    reiseArt.setText(item.reiseArt)

    val reiseDatum: TextView = findViewById(R.id.showDatum).asInstanceOf[TextView]
    reiseDatum.setText(item.reiseDatum)

    val behoerde: TextView = findViewById(R.id.showBehoerde).asInstanceOf[TextView]
    behoerde.setText(item.behoerde)
  }
}

