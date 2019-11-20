package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_layout_animation.*

class LayoutAnimationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_layout_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView.adapter =
            LayoutAnimationAdapter()

        button_start.setOnClickListener {
            recyclerView.startLayoutAnimation()
        }
    }
}
