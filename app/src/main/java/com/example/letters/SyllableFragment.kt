package com.example.letters

import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentSyllableBinding

class SyllableFragment :
    BindingFragment<FragmentSyllableBinding>(FragmentSyllableBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        @JvmStatic
        fun newInstance() = SyllableFragment()
    }
    override val viewModel: Any
        get() = TODO("Not yet implemented")
}