package happy.mjstudio.animationsample.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_circle_reveal.*

class CircleRevealFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_circle_reveal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_start.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 21) {

                ViewAnimationUtils.createCircularReveal(
                    circleView,
                    circleView.width / 2,
                    circleView.height / 2,
                    10f,
                    500f
                ).apply {
                    duration = 3000L
                    start()
                }
            }
        }
    }
}
