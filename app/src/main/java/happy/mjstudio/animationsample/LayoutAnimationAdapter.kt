package happy.mjstudio.animationsample

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layoutanimation.view.*

class LayoutAnimationAdapter : RecyclerView.Adapter<LayoutAnimationAdapter.LayoutAnimationViewHolder>() {

    private val sampleItems = generateSequence("A") { (it[0] + 1).toString() }.take(26).toList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LayoutAnimationViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_layoutanimation, p0, false)

        return LayoutAnimationViewHolder(view)
    }

    override fun getItemCount() = sampleItems.size

    override fun onBindViewHolder(p0: LayoutAnimationViewHolder, p1: Int) {
        p0.tv.text = sampleItems[p1]
    }

    inner class LayoutAnimationViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tv = v.textView
    }
}