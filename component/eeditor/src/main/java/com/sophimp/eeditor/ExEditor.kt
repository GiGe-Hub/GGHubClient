package com.sophimp.eeditor

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * 1. Base on RecyclerView to realize EditText
 * 2. each paragraph is individual item, map to each EditText
 * 3. customize function:
 *      long click menu: copy, cut, move cursor
 *      draw multi paragraph selection area
 * 4. focus management
 * create by sfx on 2022/6/15 11:02
 */
class ExEditor(ctx: Context, attr: AttributeSet?) : RecyclerView(ctx, attr) {

    constructor(ctx: Context) : this(ctx, null)

    var gestureHelper = GestureDetector(ctx, object : GestureDetector.SimpleOnGestureListener() {
        override fun onLongPress(e: MotionEvent?) {
            super.onLongPress(e)
        }
    })

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        return super.onTouchEvent(e)
    }
}