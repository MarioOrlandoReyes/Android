package com.example.mario.myapplication


import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val conext:Context,val hobbies: List<Hobby>) :RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(conext).inflate(R.layout.list_item,p0,false)
        return  MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby,p1)

    }

    inner class MyViewHolder(itemsView:View) : RecyclerView.ViewHolder(itemsView){
        var currentHobby : Hobby? = null
        var currentPosition : Int = 0
        init {
            itemsView.setOnClickListener{
                Toast.makeText(conext,currentHobby!!.title+" Clicked!!",Toast.LENGTH_SHORT).show()
            }
            itemsView.imgShare.setOnClickListener {
                val message = "My hobby is: "+currentHobby!!.title
                val intent =  Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,message)
                intent.type = "text/plain"
                conext.startActivity(Intent.createChooser(intent,"Share to:"))
            }
        }
        fun setData(hobby: Hobby?,pos:Int){
            itemView.txvTitle.text = hobby!!.title
            this.currentHobby = hobby
            this.currentPosition = pos
        }
     }
}