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
    val db = new DBHelper(this)
    setContentView(R.layout.activity_item_details)
    val toolbar: Toolbar = findViewById(R.id.toolbar).asInstanceOf[Toolbar]
    setSupportActionBar(toolbar)

    val intent = getIntent
    val item: FinalItem = intent.getExtras.get("item").asInstanceOf[FinalItem]
    println(item.immigrationCountry)
    val modButton: Button = findViewById(R.id.modButton).asInstanceOf[Button]

    modButton.setOnClickListener(new OnClickListener {
      def onClick(view: View): Unit = {
        val intent = new Intent(view.getContext, classOf[ModificationActivity])
        intent.putExtra("item",item)
        startActivity(intent)
      }
    })

    val salutation: TextView = findViewById(R.id.showSalutation).asInstanceOf[TextView]
    salutation.setText(item.gender)

    val firstname: TextView = findViewById(R.id.showFirstname).asInstanceOf[TextView]
    firstname.setText(item.firstname)

    val lastname: TextView = findViewById(R.id.showLastname).asInstanceOf[TextView]
    lastname.setText(item.lastname)

    val surnameBeforeFirstMarriage: TextView = findViewById(R.id.showSurnameBeforeFirstMarriage).asInstanceOf[TextView]
    surnameBeforeFirstMarriage.setText(item.surnameBeforeFirstMarriage)

    val academicDegree: TextView = findViewById(R.id.showAcademicDegree).asInstanceOf[TextView]
    academicDegree.setText(item.academicDegree)

    val birthdate: TextView = findViewById(R.id.showBirthdate).asInstanceOf[TextView]
    birthdate.setText(item.birthdate)

    val birthplace: TextView = findViewById(R.id.showBirthplace).asInstanceOf[TextView]
    birthplace.setText(item.birthplace)

    val religion: TextView = findViewById(R.id.showReligion).asInstanceOf[TextView]
    religion.setText(item.religion)

    val ZMR: TextView = findViewById(R.id.showZMR).asInstanceOf[TextView]
    ZMR.setText(item.zmr)

    val nationality: TextView = findViewById(R.id.showNationality).asInstanceOf[TextView]
    nationality.setText(item.nationality)

    val traveldocumentType: TextView = findViewById(R.id.showTraveldocumentType).asInstanceOf[TextView]
    traveldocumentType.setText(item.traveldocumentType)

    val traveldocumentDate: TextView = findViewById(R.id.showTraveldocumentDate).asInstanceOf[TextView]
    traveldocumentDate.setText(item.traveldocumentDate)

    val traveldocumentAgency: TextView = findViewById(R.id.showTraveldocumentAgency).asInstanceOf[TextView]
    traveldocumentAgency.setText(item.traveldocumentAgency)

    val familyStatus: TextView = findViewById(R.id.showFamilyStatus).asInstanceOf[TextView]
    familyStatus.setText(item.familyStatus)

    val firstStreet: TextView = findViewById(R.id.showFirstStreet).asInstanceOf[TextView]
    firstStreet.setText(item.firstStreet)

    val firstHouseNumber: TextView = findViewById(R.id.showHouseNumber).asInstanceOf[TextView]
    firstHouseNumber.setText(item.firstHouseNumber)

    val firstStairs: TextView = findViewById(R.id.showFirstStairs).asInstanceOf[TextView]
    firstStairs.setText(item.firstStairs)

    val firstZipcode: TextView = findViewById(R.id.showFirstZipcode).asInstanceOf[TextView]
    firstZipcode.setText(item.firstZipcode)

    val firstDoor: TextView = findViewById(R.id.showFirstDoor).asInstanceOf[TextView]
    firstDoor.setText(item.firstDoor)

    val immigrationCountry: TextView = findViewById(R.id.showImmigrationCountry).asInstanceOf[TextView]
    immigrationCountry.setText(item.immigrationCountry)
  }
}

