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


class MovieListAdapter(
    private val itemClickListener: OnClickItem<Result>
) :
    RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {

    private val list = ArrayList<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MovieItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]?:return

        holder.setData(item)


    }


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
                movieName.text = result.display_title?:na
                movieThumbnail.setImageUri(result.multimedia?.src)
            }
        }

    }


    fun setData(tempList: List<Result>?) {
        list.clear()
        tempList?.run(list::addAll)
        Logger.debug("::::::::::::::::::::::::::::::::::::::::${list.size}")
        notifyDataSetChanged()
    }


}
