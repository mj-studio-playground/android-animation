package happy.mjstudio.animationsample.ui

import android.animation.*
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import happy.mjstudio.animationsample.R
import kotlinx.android.synthetic.main.fragment_animator.*

class AnimatorFragment : Fragment() {

    private var valueAnimator: ValueAnimator? = null

    companion object {
        const val DEFAULT_DURATION = 300L
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        imageView.elevation = 24f
        imageView.setBackgroundColor(Color.WHITE)

        //region ValueAnimator
        valueAnimator = ValueAnimator.ofFloat(0f, 360f).apply {
            addUpdateListener { animation ->
                val value = animation?.animatedValue as? Float ?: throw NullPointerException()
                imageView.x = value * 2
                imageView.rotationX = value
                imageView.rotationY = value
            }
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            duration = DEFAULT_DURATION * 4
            start()
        }
        //endregion

        //region ObjectAnimator
        ObjectAnimator.ofFloat(imageView2, "x", 0f, 1000f).apply {

            interpolator = LinearInterpolator() // AccelerateDecelerateInterpolator 가 원래 Default임
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            duration = DEFAULT_DURATION
            start()
        }
        //endregion

        //region ViewPropertyAnimator
        /**
         * 초기 위치가 설정안돼있을 때 y를 움직이면 (0, 0)부터 시작해서 GlobalLayoutListener를 설정
         *
         * 뒤에 By 가 붙으면 현재 값으로부터 움직임 (current value = offset)
         */
        imageView3.doOnLayout {
            imageView3.animate().x(500f).apply {
                duration = 3000L

                this.setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {

                        this@apply.setListener(null) // 리스너를 해제해줘야 함

                        if (imageView3 != null)
                            imageView3.animate().xBy(-500f).apply {
                                duration = 1500L
                                start()
                            }
                    }
                })
                start()
            }
        }


        //endregion

        //region AnimatorSet

        val animator1 = ObjectAnimator.ofFloat(imageView4, "x", 0f, 500f).apply {
            duration = 5000L
        }
        val animator2 = ObjectAnimator.ofFloat(imageView5, "x", 0f, 500f).apply {
            duration = 2000L
        }

        AnimatorSet().apply {
            this.playSequentially(animator1, animator2)

            start()
        }

        //endregion
    }

    override fun onDestroyView() {
        super.onDestroyView()
        valueAnimator?.cancel()
    }
}
