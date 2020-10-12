package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialElevationScale
import happy.mjstudio.animationsample.R

class MaterialElevationScaleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_material_elevation_scale, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        enterTransition = MaterialElevationScale(true).apply {
            duration = 3000L
        }
        returnTransition = MaterialElevationScale(true).apply {
            duration = 3000L
        }
    }

}