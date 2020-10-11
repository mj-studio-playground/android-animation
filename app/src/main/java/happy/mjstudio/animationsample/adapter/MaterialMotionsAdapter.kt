package happy.mjstudio.animationsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.animationsample.databinding.ItemMaterialMotionBinding
import happy.mjstudio.animationsample.model.MaterialMotion
import happy.mjstudio.animationsample.widget.onDebounceClick

class MaterialMotionsAdapter(private val onClickListener: (view: View, item: MaterialMotion) -> Unit) :
    ListAdapter<MaterialMotion, MaterialMotionsAdapter.MaterialMotionsHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<MaterialMotion>() {
            override fun areItemsTheSame(oldItem: MaterialMotion, newItem: MaterialMotion): Boolean {
                return oldItem.text == newItem.text
            }

            override fun areContentsTheSame(oldItem: MaterialMotion, newItem: MaterialMotion): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun submitItems(items: List<MaterialMotion>) {
        submitList(items)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialMotionsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMaterialMotionBinding.inflate(inflater, parent, false)

        return MaterialMotionsHolder(binding)
    }


    override fun onBindViewHolder(holder: MaterialMotionsHolder, position: Int) = holder.bind(getItem(position))


    inner class MaterialMotionsHolder(private val binding: ItemMaterialMotionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MaterialMotion) {
            binding.img.transitionName = item.text
            binding.item = item
            binding.executePendingBindings()
            binding.root onDebounceClick {
                onClickListener(binding.img, item)
            }
        }
    }
}