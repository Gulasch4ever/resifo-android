package at.fh.swengb.resifoAndroid.activities.list

import java.io.Serializable


/**
  * Created by laszlobalo on 31.12.16.
  */
class Item(val firstname: String, val lastname: String, val birthdate: String) extends Serializable{

  def vorName: String = firstname

  def getLastname: String = lastname

  def getBirthdate: String = birthdate

}
