package com.lowe.movies.ui.movieList.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lowe.movies.R
import com.lowe.movies.common.setImageUri
import com.lowe.movies.dataSource.Result
import com.lowe.movies.databinding.MovieItemLayoutBinding
import com.lowe.movies.listener.OnClickItem
import com.lowe.movies.utils.Logger
/*
* Adapter set list data in movie item layout
*
* @param itemClickListener , It handle item click listener and notify to UI(Activity)
*
* */
class MovieListAdapter(
    private val itemClickListener: OnClickItem<Result>
) :
    RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {

    // Movie list
    private val list = ArrayList<Result>()

    /*
    * this method set layout in Holder
    * @param parent View group helps in view initialization
    * @param viewType you can access multi layout in one View Holder with the help view type
    * @return ViewHolder for UI return
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MovieItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    /*
    * It's return item count
    * according count set data in list
    * */
    override fun getItemCount(): Int = list.size

    /*
    * this is override method
    * it's provide Holder and position for data set in UI
    * */
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position] ?: return

        holder.setData(item)
    }

    /*
    * MyViewHolder hold the UI and reuse previous UI
    *
    * And set the data in UI
    * click listener add in view holder
    * */
    inner class MyViewHolder(private val binding: MovieItemLayoutBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {

        @SuppressLint("SetTextI18n")
        fun setData(result: Result) {
            binding.run {

                body.setOnClickListener {
                    itemClickListener.onClick(result)
                }
                val na = itemView.context.getString(R.string.n_a)
                movieName.text = result.display_title ?: na
                movieThumbnail.setImageUri(result.multimedia?.src)
            }
        }
    }

    /*
    * update list data item
    * @param tempList tempList is result collection
    *
    * after update the list then notify adapter
    * */
    fun setData(tempList: List<Result>?) {
        list.clear()
        tempList?.run(list::addAll)
        Logger.debug("::::::::::::::::::::::::::::::::::::::::${list.size}")
        notifyDataSetChanged()
    }
}
