package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.*
import happy.mjstudio.animationsample.R
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
            addTransition(ChangeTransform())
        }

        button_scene_1.setOnClickListener {
            showStatusBar()
            val scene = Scene.getSceneForLayout(root,
                R.layout.scene_1, context!!)

            TransitionManager.go(scene, transition)
        }
        button_scene_2.setOnClickListener {
            showStatusBar()
            val scene = Scene.getSceneForLayout(root,
                R.layout.scene_2, context!!)

            TransitionManager.go(scene, transition)
        }
        button_scene_3.setOnClickListener {
            hideStatusBar()
            val scene = Scene.getSceneForLayout(root,
                R.layout.scene_3, context!!)

            TransitionManager.go(scene, transition)
        }
    }

    private fun showStatusBar() {
        activity?.window?.decorView?.let {
            it.systemUiVisibility = it.systemUiVisibility and View.SYSTEM_UI_FLAG_FULLSCREEN.inv()
        }
    }
    private fun hideStatusBar() {
        activity?.window?.decorView?.let {
            it.systemUiVisibility = it.systemUiVisibility or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        showStatusBar()
    }
}