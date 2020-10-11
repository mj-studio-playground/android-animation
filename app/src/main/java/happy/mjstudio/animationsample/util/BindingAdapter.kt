package happy.mjstudio.animationsample.util

import androidx.core.view.doOnLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel

@BindingAdapter("app:circle_shape", requireAll = false)
fun ShapeableImageView.setCircleShape(boolean: Boolean) {
    doOnLayout {
        val radius = width / 2f
        shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(radius)
    }
}