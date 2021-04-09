package com.ugurcankaya.photoshare.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ugurcankaya.photoshare.Model.Post
import com.ugurcankaya.photoshare.R
import kotlinx.android.synthetic.main.reycler_row.view.*

class FeedRecyclerAdapter (val postlist : ArrayList<Post>): RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder>(){

    class PostHolder(itemview : View): RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.reycler_row,parent,false)
        return  PostHolder(view)

    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemView.recycler_row_kullanici_email.text = postlist[position].kullaniciEmail
        holder.itemView.recycler_row_yorum_text.text = postlist[position].KullaniciYorum
        Picasso.get().load(postlist[position].gorselUrl).into(holder.itemView.recycler_row_imageview)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}