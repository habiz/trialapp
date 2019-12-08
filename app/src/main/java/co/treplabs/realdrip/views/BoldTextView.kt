package co.treplabs.realdrip.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

class BoldTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {
        applyTypeface(context, "retbold.ttf")

    }

    private fun applyTypeface(context: Context, d: String) {
        val tr = Typeface.createFromAsset(context.assets, d)
        typeface = tr
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyTypeface(context, "retbold.ttf")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyTypeface(context, "retbold.ttf")
    }
}
