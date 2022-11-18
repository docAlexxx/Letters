package com.example.letters

import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentSyllable3Binding

class Syllable3Fragment :
    BindingFragment<FragmentSyllable3Binding>(FragmentSyllable3Binding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        @JvmStatic
        fun newInstance() = Syllable3Fragment()
    }
    override val viewModel: Any
        get() = TODO("Not yet implemented")
}