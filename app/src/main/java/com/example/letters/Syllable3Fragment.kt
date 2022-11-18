package com.example.letters

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentSyllable3Binding

class Syllable3Fragment :
    BindingFragment<FragmentSyllable3Binding>(FragmentSyllable3Binding::inflate) {

    private val generate: Generator by lazy {
        Generator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetters()
        setButton()
    }

    fun setButton() {
        binding.btnNewLetter3.setOnClickListener {
            getLetters()
        }

    }

    fun getLetters() {


        val letterFirst = generate.generateLetter(10, 30)
        val letterSecond = generate.generateLetter(0, 9)
        val letterThird = generate.generateLetter(10, 30)


        with(binding) {
            tvFirstLetter3.text = letterFirst.name
            tvSecondLetter3.text = letterSecond.name
            tvThirdLetter3.text = letterThird.name

            tvSecondLetter3.setTextColor(Color.parseColor("#FF0000"))
            tvThirdLetter3.setTextColor(Color.parseColor("#0729E6"))

            if (letterSecond.isSoftening) {
                tvFirstLetter3.setTextColor(Color.parseColor("#01DD5D"))
            } else {
                tvFirstLetter3.setTextColor(Color.parseColor("#0729E6"))
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = Syllable3Fragment()
    }

    override val viewModel: Any
        get() = TODO("Not yet implemented")
}