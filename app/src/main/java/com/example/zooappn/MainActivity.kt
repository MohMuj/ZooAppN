package com.example.zooappn

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animalticket.view.*

class MainActivity : AppCompatActivity() {

    var listofanimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listofanimals.add(Animal("Baboon","Baboon lives in the zoo",R.drawable.baboon,false))
        listofanimals.add(Animal("Bulldog","Bulldog lives in the zoo",R.drawable.bulldog,false))
        listofanimals.add(Animal("panda","Panda lives in the zoo",R.drawable.panda,true))
        listofanimals.add(Animal("Swallow","Swallow lives in the zoo",R.drawable.swallow_bird,false))
        listofanimals.add(Animal("Tiger","Tiger lives in the zoo",R.drawable.white_tiger,true))
        listofanimals.add(Animal("Zebra","Zebra lives in the zoo",R.drawable.zebra,false))
        adapter = AnimalsAdapter( this, listofanimals)
        listv.adapter = adapter


    }
}
class AnimalsAdapter:BaseAdapter{
   var listofanimals = ArrayList<Animal>()
    var context:Context?= null
    constructor(context:Context, listofanimals:ArrayList<Animal>):super(){
        this.listofanimals = listofanimals
        this.context = context
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val animal = listofanimals[p0]
        if(animal.killer!!){
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myview = inflator.inflate(R.layout.animalticketkiller,null)
            myview.namet.text = animal.name!!
            myview.dest.text = animal.des!!
            myview.imagee.setImageResource(animal.image!!)
            myview.imagee.setOnClickListener {
                val intent = Intent (context,AnimalInfo::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                context!!.startActivity(intent)
            }
            return myview










            return myview
        }else{
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var myview = inflator.inflate(R.layout.animalticket,null)
        myview.namet.text = animal.name!!
        myview.dest.text = animal.des!!
        myview.imagee.setImageResource(animal.image!!)

            myview.imagee.setOnClickListener {
                val intent = Intent (context,AnimalInfo::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                context!!.startActivity(intent)
            }
            return myview



        }}

    override fun getItem(p0: Int): Any {
        return listofanimals[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listofanimals.count()
    }

}
