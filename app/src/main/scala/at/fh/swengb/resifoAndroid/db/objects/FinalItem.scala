package at.fh.swengb.resifoAndroid.db.objects

/**
  * Created by David on 11.01.2017.
  */
class FinalItem(val id: String, val lastname: String, val firstname: String, val surnameBeforeFirstMarriage: String, val academicDegree: String, val gender: String,
                val birthdate: String, val birthplace: String, val religion: String, val zmr: String, val nationality: String,
                val traveldocumentType: String, val traveldocumentNumber: String, val traveldocumentDate: String, val traveldocumentAgency: String,
                val familyStatus: String, val firstStreet: String, val firstHouseNumber: String, val firstStairs: String, val firstDoor: String,
                val firstZipcode: String, val immigrationCountry: String) extends Serializable {

}


