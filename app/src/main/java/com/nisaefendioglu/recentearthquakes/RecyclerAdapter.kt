package com.nisaefendioglu.recentearthquakes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.recentearthquakes.model.EarthquakeModelItem

class RecyclerAdapter(private val context: Context, private var list: MutableList<EarthquakeModelItem>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rec_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val earthquake = list.get(position)
        holder.textView?.text = earthquake.buyukluk
        holder.textView2?.text = earthquake.yer
        holder.textView3?.text = earthquake.sehir
        holder.textView4?.text = "Derinlik :" + earthquake.derinlik
        holder.textView6?.text = "Saat :" + earthquake.saat
        holder.textView7?.text = "Tarih :" +earthquake.tarih
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var textView: TextView
        var textView2: TextView
        var textView3: TextView
        var textView4: TextView
        var textView6: TextView
        var textView7: TextView

        init{
            textView = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)
            textView3 = itemView.findViewById(R.id.textView3)
            textView4 = itemView.findViewById(R.id.textView4)
            textView6 = itemView.findViewById(R.id.textView6)
            textView7 = itemView.findViewById(R.id.textView7)
        }


    }
}