package co.treplabs.realdrip.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet


class TextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {
        applyTypeface(context, "ret.ttf")
    }

    private fun applyTypeface(context: Context, d: String) {
        val tr = Typeface.createFromAsset(getContext().assets, d)
        typeface = tr
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyTypeface(context, "ret.ttf")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyTypeface(context, "ret.ttf")
    }


}
