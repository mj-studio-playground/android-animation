package happy.mjstudio.animationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false) as ViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button_animator.setOnClickListener {
            val directions = MainFragmentDirections.asd(duration = 1000L, time = 500)
            findNavController().navigate(directions)
        }
        button_animatedvector.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_animatedVectorDrawableFragment)
        }
        button_layoutanimation.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_layoutAnimationFragment)
        }
        button_animatelayoutchanges.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_animateLayoutChangesFragment)
        }
        button_circlereveal.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_circleRevealFragment)
        }
        button_scene.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_sceneFragment)
        }
        button_constraint_set.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_constraintSetFragment)
        }
    }
}
