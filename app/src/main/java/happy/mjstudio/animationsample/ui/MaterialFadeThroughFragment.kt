package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import happy.mjstudio.animationsample.R

class MaterialFadeThroughFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_material_fade_through, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        enterTransition = MaterialFadeThrough().apply {
            duration = 3000L
        }
        returnTransition = MaterialFadeThrough().apply {
            duration = 3000L
        }
    }

}