package com.namespacermcw.arrestsearch.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.namespacermcw.arrestsearch.databinding.ItemBinding
import com.namespacermcw.arrestsearch.model.Record

class RecordsAdapter(): RecyclerView.Adapter<RecordsViewHolder>() {

    var records: List<Record> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecordsViewHolder {
        val view = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecordsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return records.size
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        return holder.bind(records[position])
    }

    fun updateList(newList: List<Record>) {
        Log.d("_WORK","upDateList was called")
        this.records = newList
        notifyDataSetChanged()
    }
}
/*
class RecordsViewHolder(itemView: @NonNull ItemBinding): RecyclerView.ViewHolder(itemView){
    private val photo:ImageView = itemView.findViewById(R.id.mugshot)
    //private val bookdate:TextView = itemView.findViewById(R.id.bookdate)
    private val charges:TextView = itemView.findViewById(R.id.charges)
    private val info: TextView = itemView.findViewById(R.id.info)

    fun bind(record: Record) {
        Glide.with(itemView.context).load(record.mugshot).into(photo)
        //bookdate.text = "Book Date: "+ record.bookDate
        charges.text = "Charges: " + record.charges
        info.text = "More Info: "+ record.moreInfoUrl
    }

}
*/
class RecordsViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var arrest: Record

    fun bind(record: Record){
        arrest = record

        with(binding) {
            mugshot.apply {
                Glide.with(itemView)
                    .load(arrest.mugshot)
                    .into(this)
            }
            charges.text = "Charges: " + record.charges
            info.text = "More Info: "+ record.moreInfoUrl
        }
    }
}