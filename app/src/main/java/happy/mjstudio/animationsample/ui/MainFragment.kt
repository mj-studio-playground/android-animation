package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.theme.overlay.MaterialThemeOverlay
import com.google.android.material.transition.MaterialSharedAxis
import happy.mjstudio.animationsample.R
import happy.mjstudio.animationsample.widget.onDebounceClick
import kotlinx.android.synthetic.main.layout_main_content.*

class MainFragment : Fragment() {

    companion object {
        private val TAG = MainFragment::class.java.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false) as ViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button_xml onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_XMLAnimFragment)
        }

        button_animator onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_animatorFragment)
        }

        button_animatedvector onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_animatedVectorDrawableFragment)
        }

        button_layoutanimation onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_layoutAnimationFragment)
        }

        button_animatelayoutchanges onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_animateLayoutChangesFragment)
        }

        button_circlereveal onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_circleRevealFragment)
        }

        button_scene onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_sceneFragment)
        }

        button_constraint_set onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_constraintSetFragment)
        }

        button_lottie onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_lottieFragment)
        }

        button_material onDebounceClick {
            findNavController().navigate(R.id.action_mainFragment_to_materialMotionFragment)
        }
    }
}
