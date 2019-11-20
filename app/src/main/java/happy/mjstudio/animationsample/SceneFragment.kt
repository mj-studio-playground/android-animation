package happy.mjstudio.animationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.*
import kotlinx.android.synthetic.main.fragment_scene.*

class SceneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scene, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val root = scene_root as ViewGroup
        val transition = TransitionSet().apply {
            addTransition(Fade())
            addTransition(ChangeBounds())
            addTransition(ChangeClipBounds())
            addTransition(ChangeImageTransform())
        }

        button_scene_1.setOnClickListener {
            val scene = Scene.getSceneForLayout(root, R.layout.scene_1, context!!)

            TransitionManager.go(scene, transition)
        }
        button_scene_2.setOnClickListener {
            val scene = Scene.getSceneForLayout(root, R.layout.scene_2, context!!)

            TransitionManager.go(scene, transition)
        }
        button_scene_3.setOnClickListener {
            val scene = Scene.getSceneForLayout(root, R.layout.scene_3, context!!)

            TransitionManager.go(scene, transition)
        }
    }
}