package com.sophimp.eeditor

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sophimp.eeditor.databinding.ItemEditTextBinding

/**
 * create by sfx on 2022/6/15 16:51
 */
class ExEditorAdapter(var datas : List<String>) : RecyclerView.Adapter<ExEditorAdapter.EditorHolder>() {

    var newLineListener : OnNewLineListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorHolder {
        return EditorHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_edit_text, parent, false))
    }

    override fun onBindViewHolder(holder: EditorHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class EditorHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding : ItemEditTextBinding = ItemEditTextBinding.bind(view)
        init {
            binding.etItem.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    if (s != null && s.isNotEmpty() && s[binding.etItem.selectionEnd - 1] == '\n') {
                        val lineHeight = binding.etItem.layout.height / binding.etItem.layout.lineCount
                        newLineListener?.onNewLine(absoluteAdapterPosition, binding.etItem.layout.getLineForOffset(binding.etItem.selectionEnd) * lineHeight)
                    }
                }

            })
        }
    }
}

interface OnNewLineListener {
    fun onNewLine(pos : Int, offset : Int)
}
