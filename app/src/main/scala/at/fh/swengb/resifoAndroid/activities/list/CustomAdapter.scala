package at.fh.swengb.resifoAndroid.activities.list

import android.content.Context
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{BaseAdapter, TextView}
import at.fh.swengb.resifoAndroid.R

/**
  * Created by laszlobalo on 31.12.16.
  */
class CustomAdapter(val context: Context, var listItems: List[Item]) extends BaseAdapter{

  override def getCount: Int = {
    listItems.size
  }

  override def getItem(position: Int):Item = {
    listItems(position)
  }

  override def getItemId(position: Int):Long = {
    position
  }

  def convertView(position: Int, value: View):View = {
    value.findViewById(R.id.viewFirstname).asInstanceOf[TextView].setText(getItem(position).firstname)
    value.findViewById(R.id.viewLastname).asInstanceOf[TextView].setText(getItem(position).lastname)
    value.findViewById(R.id.viewBirthdate).asInstanceOf[TextView].setText(getItem(position).birthdate)
    value
  }

  override def getView(position: Int, view: View, parent: ViewGroup):View = view match {
    case null => convertView(position, (LayoutInflater.from(context)).inflate(R.layout.item_view, null))
    case _ => convertView(position,view)
  }
}


