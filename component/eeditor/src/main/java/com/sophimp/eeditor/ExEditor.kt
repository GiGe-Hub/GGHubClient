package com.sophimp.eeditor

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * 1. Base on RecyclerView to realize EditText
 * 2. each EditText map to each paragraph, map to each item
 * 3. customize function:
 *      long click menu: copy, cut, move cursor
 *      draw multi paragraph selection area
 * 4. focus management
 * create by sfx on 2022/6/15 11:02
 */
class ExEditor(ctx: Context, attr: AttributeSet?) : RecyclerView(ctx, attr) {

    constructor(ctx: Context) : this(ctx, null)

}