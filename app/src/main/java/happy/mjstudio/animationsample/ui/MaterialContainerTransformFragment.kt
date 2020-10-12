package happy.mjstudio.animationsample.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_material_container_transform.*

class MaterialContainerTransformFragment : Fragment() {
    private val args: MaterialContainerTransformFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_material_container_transform, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setTransition()
    }

    private fun setTransition() {
        cat.transitionName = args.itemText
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 3000L
            setAllContainerColors(Color.TRANSPARENT)
            scrimColor = Color.WHITE
            setPathMotion(MaterialArcMotion())
        }
    }
}