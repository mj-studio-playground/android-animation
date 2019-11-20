package happy.mjstudio.animationsample.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_lottie.*

/**
 * Created by mj on 20, November, 2019
 */
class LottieFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lottie,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lottieCopyright.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW).apply { data = Uri.parse("https://lottiefiles.com/11555-night-vs-day-slider?lang=en#") }
            )
        }
    }
}