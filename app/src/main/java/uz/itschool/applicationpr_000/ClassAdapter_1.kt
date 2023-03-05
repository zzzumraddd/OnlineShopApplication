package uz.itschool.applicationpr_000

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ClassAdapter_1 (context: Activity, val arrayList:ArrayList<Products>):ArrayAdapter<Products>(context, R.layout.activity_drinks_item,arrayList){
    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater=LayoutInflater.from(context)
        var view:View=inflater.inflate(R.layout.activity_drinks_item, null)
        var imageView:ImageView=view.findViewById(R.id.id_img)
        var name_product:TextView=view.findViewById(R.id.id_name_product)
        var price_product:TextView=view.findViewById(R.id.id_price_product)
        var info_product:TextView=view.findViewById(R.id.id_info_product)
        imageView.setImageResource(arrayList[position].img)
        name_product.text=arrayList[position].name
        price_product.text= arrayList[position].price
        info_product.text=arrayList[position].info
        return view
    }
}