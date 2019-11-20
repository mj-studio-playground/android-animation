package happy.mjstudio.animationsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_constraint_set.*

class ConstraintSetFragment : Fragment() {

    private lateinit var constraintSet1 : ConstraintSet
    private lateinit var constraintSet2 : ConstraintSet

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_constraint_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        constraintSet1 = ConstraintSet().apply {
            clone(container)
            this.clear(R.id.ios)
            this.connect(R.id.ios,ConstraintSet.LEFT,0,ConstraintSet.LEFT)
            this.constrainWidth(R.id.ios,300)
            this.setDimensionRatio(R.id.ios,"1:1")
        }

        constraintSet2 = ConstraintSet().apply {
            clone(container)
            this.clear(R.id.ios)
            this.connect(R.id.ios,ConstraintSet.RIGHT,0,ConstraintSet.RIGHT)
            this.constrainWidth(R.id.ios,400)
            this.setDimensionRatio(R.id.ios,"1:1")
        }

        set1.setOnClickListener {
            TransitionManager.beginDelayedTransition(container)
            constraintSet1.applyTo(container)
        }

        set2.setOnClickListener {
            TransitionManager.beginDelayedTransition(container)
            constraintSet2.applyTo(container)
        }
    }
}