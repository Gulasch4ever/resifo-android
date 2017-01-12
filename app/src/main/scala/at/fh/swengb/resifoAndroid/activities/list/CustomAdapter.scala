package at.fh.swengb.resifoAndroid.activities.list

import android.content.Context
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{BaseAdapter, TextView}
import at.fh.swengb.resifoAndroid.R
import at.fh.swengb.resifoAndroid.db.objects.FinalItem

/**
  * Created by laszlobalo on 31.12.16.
  */
class CustomAdapter(val context: Context, var listItems: List[FinalItem]) extends BaseAdapter{

  override def getCount: Int = {
    listItems.size
  }

  override def getItem(position: Int):FinalItem = {
    listItems(position)
  }

  override def getItemId(position: Int):Long = {
    position
  }

  def convertView(position: Int, value: View):View = {
    value.findViewById(R.id.viewNachname).asInstanceOf[TextView].setText(getItem(position).nachname)
    value.findViewById(R.id.viewVorname).asInstanceOf[TextView].setText(getItem(position).vorname)
    value.findViewById(R.id.viewAkad).asInstanceOf[TextView].setText(getItem(position).akad)
    value
  }

  override def getView(position: Int, view: View, parent: ViewGroup):View = view match {
    case null => convertView(position, (LayoutInflater.from(context)).inflate(R.layout.item_view, null))
    case _ => convertView(position,view)
  }
}



