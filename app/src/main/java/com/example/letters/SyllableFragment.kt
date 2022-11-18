package com.example.letters

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentSyllableBinding

class SyllableFragment :
    BindingFragment<FragmentSyllableBinding>(FragmentSyllableBinding::inflate) {

    private val generate: Generator by lazy {
        Generator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetters()
        setButton()

    }

    fun setButton() {
        binding.btnNewSellyable.setOnClickListener {
            getLetters()
        }

    }

    fun getLetters() {

        val query=(1..5).random()
        val letterFirst : Generator.Letter
        val letterSecond : Generator.Letter

        if (query > 3) {
            letterFirst = generate.generateLetter(0, 9)
            letterSecond = generate.generateLetter(10, 30)
        } else {
            letterSecond = generate.generateLetter(0, 9)
            letterFirst = generate.generateLetter(10, 30)
        }

        with(binding) {
            tvFirstLetter.text = letterFirst.name
            tvSecondLetter.text = letterSecond.name
            if (letterFirst.isVowel) {
                tvFirstLetter.setTextColor(Color.parseColor("#FF0000"))
                tvSecondLetter.setTextColor(Color.parseColor("#0729E6"))
            } else {
                tvSecondLetter.setTextColor(Color.parseColor("#FF0000"))
               if (letterSecond.isSoftening) {
                   tvFirstLetter.setTextColor(Color.parseColor("#01DD5D"))
               } else {
                   tvFirstLetter.setTextColor(Color.parseColor("#0729E6"))
               }
               }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = SyllableFragment()
    }
    override val viewModel: Any
        get() = TODO("Not yet implemented")
}