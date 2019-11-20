package happy.mjstudio.animationsample

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_animate_layout_changes.*

class AnimateLayoutChangesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_animate_layout_changes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button_visible.setOnClickListener {
            imageView.visibility = View.VISIBLE
        }
        button_gone.setOnClickListener {
            imageView.visibility = View.GONE
        }
        // 이 코드를 삽입하면 Visibility 뿐만 아니라 크기 변화에도 대응할 수 있다.
        (this.view as ViewGroup).layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }
}
