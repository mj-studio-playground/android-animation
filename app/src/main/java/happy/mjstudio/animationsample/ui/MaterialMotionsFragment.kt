package happy.mjstudio.animationsample.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionManager
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
import happy.mjstudio.animationsample.R
import happy.mjstudio.animationsample.R.layout
import happy.mjstudio.animationsample.adapter.MaterialMotionsAdapter
import happy.mjstudio.animationsample.model.MaterialMotion
import happy.mjstudio.animationsample.widget.onDebounceClick
import kotlinx.android.synthetic.main.fragment_material_motions.*

class MaterialMotionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(layout.fragment_material_motions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("TAG", this.toString())
        configureRecyclerView()
        postponeEnterTransition()
        view.doOnPreDraw {
            startPostponedEnterTransition()
        }
        configureFab()
    }

    private fun configureFab() {
        fab onDebounceClick {
            showButton()
        }
        btn onDebounceClick {
            hideButton()
        }
    }

    private fun showButton() {
        TransitionManager.beginDelayedTransition(container, createMaterialContainerTransform(true))
        fab.isInvisible = true
        btn.isInvisible = false
    }

    private fun hideButton() {
        TransitionManager.beginDelayedTransition(container, createMaterialContainerTransform(false))
        fab.isInvisible = false
        btn.isInvisible = true
    }

    private fun createMaterialContainerTransform(showBtn: Boolean) = MaterialContainerTransform().apply {
        duration = 1000L
        startView = if (showBtn) fab else btn
        endView = if (showBtn) btn else fab
        addTarget(endView!!)
        scrimColor = Color.TRANSPARENT
        setAllContainerColors(Color.parseColor("#5829F2"))
        setPathMotion(MaterialArcMotion())
    }

    private fun configureRecyclerView() {
        list.adapter = MaterialMotionsAdapter(this::navigateDetail).apply {
            submitItems(
                listOf(
                    MaterialMotion("MaterialTransformContainer"),
                    MaterialMotion("MaterialElevationScale"),
                    MaterialMotion("MaterialSharedAxis"),
                    MaterialMotion("MaterialFadeThrough"),
                )
            )
        }
    }

    private fun navigateDetail(view: View, item: MaterialMotion) {
        when (item.text) {
            "MaterialTransformContainer" -> navigateContainerTransform(view, item)
            "MaterialElevationScale" -> navigateElevationScale()
            "MaterialSharedAxis" -> navigateSharedAxis()
            "MaterialFadeThrough" -> navigateFadeThrough()
        }
    }

    private fun navigateContainerTransform(view: View, item: MaterialMotion) {
        exitTransition = MaterialElevationScale(false).apply {
            duration = 3000L
        }
        reenterTransition = MaterialElevationScale(false).apply {
            duration = 3000L
        }

        val extras = FragmentNavigatorExtras(view to item.text)
        findNavController().navigate(
            MaterialMotionFragmentDirections.actionMaterialMotionFragmentToMaterialContainerTransformFragment(item.text),
            extras
        )
    }

    private fun navigateElevationScale() {
        exitTransition = MaterialElevationScale(true).apply {
            duration = 3000L
        }
        reenterTransition = MaterialElevationScale(false).apply {
            duration = 3000L
        }

        findNavController().navigate(R.id.action_materialMotionFragment_to_materialElevationScaleFragment)
    }

    private fun navigateSharedAxis() {
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true).apply {
            duration = 3000L
        }
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false).apply {
            duration = 3000L
        }

        findNavController().navigate(R.id.action_materialMotionFragment_to_materialSharedAxisFragment)
    }

    private fun navigateFadeThrough() {
        exitTransition = MaterialFadeThrough().apply {
            duration = 3000L
        }
        reenterTransition = MaterialFadeThrough().apply {
            duration = 3000L
        }

        findNavController().navigate(R.id.action_materialMotionFragment_to_materialFadeThroughFragment)
    }

}