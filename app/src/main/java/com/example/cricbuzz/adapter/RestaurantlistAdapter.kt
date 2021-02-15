package com.example.cricbuzz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzz.BR
import com.example.cricbuzz.databinding.RestaurantAdapterRowBinding
import com.example.localdatabase.models.Restaurant

class RestaurantlistAdapter(
    val context: Context,
    private val itemList: List<Restaurant>
) : RecyclerView.Adapter<RestaurantlistAdapter.Myhandler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myhandler {
        val restaurantAdapterRowBinding =
            RestaurantAdapterRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return Myhandler(restaurantAdapterRowBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: Myhandler, position: Int) {

        holder.bind(itemList.get(position))
    }

    class Myhandler(val binding: RestaurantAdapterRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: Restaurant) {
            binding.restaurantdatamodel = entity
            binding.setVariable(BR.restaurantdatamodel, entity)
            binding.executePendingBindings()
        }
    }
}