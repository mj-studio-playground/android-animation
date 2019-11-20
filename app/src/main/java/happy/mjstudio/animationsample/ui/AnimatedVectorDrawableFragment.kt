package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_animated_vector_drawable.*

class AnimatedVectorDrawableFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_animated_vector_drawable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button_start.setOnClickListener {
            val avd = AnimatedVectorDrawableCompat.create(context!!,
                R.drawable.avd
            )
            imageView.setImageDrawable(avd)

            (imageView.drawable as AnimatedVectorDrawableCompat).start()
        }
    }
}
