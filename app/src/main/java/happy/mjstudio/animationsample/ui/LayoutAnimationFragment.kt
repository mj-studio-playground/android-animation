package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import happy.mjstudio.animationsample.R
import happy.mjstudio.animationsample.widget.onDebounceClick
import kotlinx.android.synthetic.main.fragment_layout_animation.*

class LayoutAnimationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //region Linear RecyclerView

        recyclerView.adapter = LayoutAnimationAdapter()

        button_start onDebounceClick {
            recyclerView.startLayoutAnimation()
        }

        //endregion

        //region ViewGroup


        val fallDownAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.item_animation_fall_down)
        flowContainer.layoutAnimation = LayoutAnimationController(fallDownAnim,1f).apply {
            this.order = LayoutAnimationController.ORDER_NORMAL
            this.start()
        }

        button_start_2 onDebounceClick {
            flowContainer.startLayoutAnimation()
        }

        //endregion


    }
}
