package at.fh.swengb.resifoAndroid.activities.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.View.OnClickListener
import android.widget.{Button, EditText}
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.db.DBHelper
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

class ModificationActivity extends AppCompatActivity {

  val db = new DBHelper(this)

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_modification)
    val toolbar = findViewById(R.id.toolbar).asInstanceOf[Toolbar]
    setSupportActionBar(toolbar)
    val save = findViewById(R.id.saveButton).asInstanceOf[Button]
    val del = findViewById(R.id.delButton).asInstanceOf[Button]

    val intent = getIntent
    val item: FinalItem = intent.getExtras.get("item").asInstanceOf[FinalItem]

    val salutation = findViewById(R.id.modSalutation).asInstanceOf[EditText]
    salutation.setText(item.gender)

    val firstname = findViewById(R.id.modFirstname).asInstanceOf[EditText]
    firstname.setText(item.firstname)

    val lastname = findViewById(R.id.modLastname).asInstanceOf[EditText]
    lastname.setText(item.lastname)

    val surnameBeforeFirstMarriage: EditText = findViewById(R.id.modSurnameBeforeFirstMarriage).asInstanceOf[EditText]
    surnameBeforeFirstMarriage.setText(item.surnameBeforeFirstMarriage)

    val academicDegree: EditText = findViewById(R.id.modAcademicDegree).asInstanceOf[EditText]
    academicDegree.setText(item.academicDegree)

    val birthdate: EditText = findViewById(R.id.modBirthdate).asInstanceOf[EditText]
    birthdate.setText(item.birthdate)

    val birthplace: EditText = findViewById(R.id.modBirthplace).asInstanceOf[EditText]
    birthplace.setText(item.birthplace)

    val religion: EditText = findViewById(R.id.modReligion).asInstanceOf[EditText]
    religion.setText(item.religion)

    val ZMR: EditText = findViewById(R.id.modZMR).asInstanceOf[EditText]
    ZMR.setText(item.zmr)

    val nationality: EditText = findViewById(R.id.modNationality).asInstanceOf[EditText]
    nationality.setText(item.nationality)

    val traveldocumentType: EditText = findViewById(R.id.modTraveldocumentType).asInstanceOf[EditText]
    traveldocumentType.setText(item.traveldocumentType)

    val traveldocumentDate: EditText = findViewById(R.id.modTraveldocumentDate).asInstanceOf[EditText]
    traveldocumentDate.setText(item.traveldocumentDate)

    val traveldocumentAgency: EditText = findViewById(R.id.modTraveldocumentAgency).asInstanceOf[EditText]
    traveldocumentAgency.setText(item.traveldocumentAgency)

    val familyStatus: EditText = findViewById(R.id.modFamilyStatus).asInstanceOf[EditText]
    familyStatus.setText(item.familyStatus)

    save.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {

        db.updateItem(item.id.toString,
          firstname.getText.toString,
          lastname.getText.toString,
          surnameBeforeFirstMarriage.getText.toString,
          academicDegree.getText.toString,
          birthdate.getText.toString,
          birthplace.getText.toString,
          religion.getText.toString,
          ZMR.getText.toString,
          nationality.getText.toString,
          traveldocumentType.getText.toString,
          traveldocumentDate.getText.toString,
          traveldocumentAgency.getText.toString,
          familyStatus.getText.toString)

        startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
      }
    })

    del.setOnClickListener(new OnClickListener {
      def onClick(v: View): Unit = {
        db.deleteItem(item.id)
        startActivity(new Intent(getApplicationContext, classOf[ListActivity]))
      }
    })




  }
}
