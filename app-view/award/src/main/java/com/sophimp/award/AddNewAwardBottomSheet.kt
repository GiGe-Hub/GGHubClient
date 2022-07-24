package com.sophimp.award

import android.os.Bundle
import android.view.View
import com.sophimp.award.databinding.DialogAddAwardBinding
import com.sophimp.base.BaseBottomDialogFragment

class AddNewAwardBottomSheet : BaseBottomDialogFragment<DialogAddAwardBinding>() {
    override fun initBaseView(rootView: View, savedInstanceState: Bundle?) {
    }

    override fun bindView(): DialogAddAwardBinding {
        return DialogAddAwardBinding.inflate(layoutInflater)
    }
}