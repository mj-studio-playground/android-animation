package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import happy.mjstudio.animationsample.R
import happy.mjstudio.animationsample.widget.onDebounceClick
import kotlinx.android.synthetic.main.fragment_xml_anim.*

/**
 * Created by mj on 10, December, 2019
 */
class XMLAnimFragment : Fragment() {

    companion object {
        private val TAG = XMLAnimFragment::class.java.simpleName
    }

    private lateinit var fadeInAnim : Animation
    private lateinit var fadeOutAnim : Animation
    private lateinit var scaleUpAnim : Animation
    private lateinit var scaleDownAnim : Animation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_xml_anim, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Fade
        fadeInAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.fade_in)
        fadeOutAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.fade_out)

        button_fade_in onDebounceClick {
            Snackbar.make(xmlContainer,"alpha : ${imagefade.alpha}",Snackbar.LENGTH_SHORT).show()
            imagefade.startAnimation(fadeInAnim)
        }

        button_fade_out onDebounceClick {
            Snackbar.make(xmlContainer,"alpha : ${imagefade.alpha}",Snackbar.LENGTH_SHORT).show()
            imagefade.startAnimation(fadeOutAnim)
        }

        //Scale
        scaleUpAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.scale_up)
        scaleDownAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.scale_down)

        button_scale_up onDebounceClick {
            Snackbar.make(xmlContainer,"scale : ${imageScale.scaleX}",Snackbar.LENGTH_SHORT).show()
            imageScale.startAnimation(scaleUpAnim)
        }

        button_scale_down onDebounceClick {
            Snackbar.make(xmlContainer,"scale : ${imageScale.scaleX}",Snackbar.LENGTH_SHORT).show()
            imageScale.startAnimation(scaleDownAnim)
        }

    }

}