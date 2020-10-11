package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.MaterialElevationScale
import happy.mjstudio.animationsample.R.layout
import happy.mjstudio.animationsample.adapter.MaterialMotionsAdapter
import happy.mjstudio.animationsample.model.MaterialMotion
import kotlinx.android.synthetic.main.fragment_material_motions.*

class MaterialMotionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(layout.fragment_material_motions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureRecyclerView()
        postponeEnterTransition()
        view.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    private fun configureRecyclerView() {
        list.adapter = MaterialMotionsAdapter(this::navigateDetail).apply {
            submitItems(
                listOf(
                    MaterialMotion("MaterialTransformContainer")
                )
            )
        }
    }

    private fun navigateDetail(view: View, item: MaterialMotion) {
        exitTransition = MaterialElevationScale(false)
        reenterTransition = MaterialElevationScale(false)

        val extras = FragmentNavigatorExtras(view to item.text)
        findNavController().navigate(
            MaterialMotionFragmentDirections.actionMaterialMotionFragmentToMaterialContainerTransformFragment(item.text),
            extras
        )
    }

}