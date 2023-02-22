package com.nisaefendioglu.recentearthquakes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.recentearthquakes.databinding.RecItemBinding
import com.nisaefendioglu.recentearthquakes.model.EarthquakeModelItem

class EarthquakeAdapter : RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder>() {

    private var placeList: ArrayList<EarthquakeModelItem?> = arrayListOf()

    fun setList(newList: List<EarthquakeModelItem?>) {
        this.placeList.clear()
        this.placeList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class EarthquakeViewHolder(val binding: RecItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        return EarthquakeViewHolder(
            RecItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val place = placeList[position]
        holder.binding.tvLocation.text = place?.lokasyon
        holder.binding.tvHour.text = "Saat: ${place?.dateHour}"
        holder.binding.tvDate.text = "Tarih : ${place?.dateStamp}"
        holder.binding.tvMag.text = place?.mag.toString()
        holder.binding.tvDepth.text = "Derinlik : ${place?.depth.toString()}"
    }

    override fun getItemCount(): Int = placeList.size

}