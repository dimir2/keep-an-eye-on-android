package edu.keepaneye.rickandmorty.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import edu.keepaneye.rickandmorty.data.entities.Character
import edu.keepaneye.rickandmorty.databinding.ItemCharacterBinding

class CharactersAdapter(private val listener: CharacterItemListener) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    interface CharacterItemListener {
        fun onClickedCharacter(characterId: Int)
    }

    private val items = ArrayList<Character>()

    fun setItems(items: ArrayList<Character>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class CharacterViewHolder(
    private val itemBinding: ItemCharacterBinding,
    private val listener: CharactersAdapter.CharacterItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var character: Character

    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: Character) {
        this.character = item
        itemBinding.name.text = item.name
        itemBinding.speciesAndStatus.text = """${item.species} - ${item.status}"""
        Glide.with(itemBinding.root)
            .load(item.image)
            .transform(CircleCrop())
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedCharacter(character.id)
    }
}
