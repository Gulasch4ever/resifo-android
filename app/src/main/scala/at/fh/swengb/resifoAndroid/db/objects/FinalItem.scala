package at.fh.swengb.resifoAndroid.db.objects

/**
  * Created by David on 11.01.2017.
  */
//TODO TERY
case class FinalItem(id: String, lastname: String, val firstname: String, val surnameBeforeFirstMarriage: String, val academicDegree: String, val gender: String,
                     val birthdate: String, val birthplace: String, val religion: String, val zmr: String, val nationality: String,
                     val traveldocumentType: String, val traveldocumentNumber: String, val traveldocumentDate: String, val traveldocumentAgency: String,
                     val familyStatus: String, val firstStreet: String, val firstHouseNumber: String, val firstStairs: String, val firstDoor: String,
                     val firstZipcode: String,firstLocation:String, val secondStreet: String, val secondHouseNumber: String, val secondStairs: String, val secondDoor: String,
                     val secondZipcode: String,secondLocation:String, val thirdStreet: String, val thirdHouseNumber: String, val thirdStairs: String, val thirdDoor: String,
                     thirdZipcode: String,thirdLocation:String, val immigrationCountry: String, val condonedCountry:String, val function: String,page1:String,page2:String,page2a:String,page3:String,page5:String,page5a:String,page6:String ) extends Serializable {

}



