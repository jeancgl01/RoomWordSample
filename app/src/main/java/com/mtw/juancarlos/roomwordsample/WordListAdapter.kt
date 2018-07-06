package com.mtw.juancarlos.roomwordsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtw.juancarlos.roomwordsample.db.Word
import kotlinx.android.synthetic.main.recyclerview_item.view.*




class WordListAdapter(val context:Context) :RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){

    private var mWords: List<Word>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return WordViewHolder(layoutInflater.inflate(R.layout.recyclerview_item,parent,false))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (mWords !== null){
            holder.bind(mWords!![position])
        } else {
            holder.bind(Word("No Word"))
        }
    }

    override fun getItemCount(): Int{
      if (mWords!== null) {
          return mWords!!.size
      }
       return 0
    }

    fun setWords(words:List<Word>){
        mWords = words
        notifyDataSetChanged()
    }


    inner class WordViewHolder(itemView: View ):RecyclerView.ViewHolder(itemView){

        fun bind(word:Word){
            itemView.textView.text = word.mWord
        }
    }
}