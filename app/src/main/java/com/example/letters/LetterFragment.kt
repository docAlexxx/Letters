package com.example.letters

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentLetterBinding

class LetterFragment : BindingFragment<FragmentLetterBinding>(FragmentLetterBinding::inflate) {

    private val generate: Generator by lazy {
        Generator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetter()
        setButton()

    }

    fun setButton() {
        binding.btnNewLetter.setOnClickListener {
            getLetter()
        }

    }

    fun getLetter() {
        val letter = generate.generateLetter(0, 32)
        with(binding) {
            tvLetter.text = letter.name
            if (letter.isVowel) {
                tvLetter.setTextColor(Color.parseColor("#FF0000"))
            } else {
                tvLetter.setTextColor(Color.parseColor("#0729E6"))
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = LetterFragment()
    }

    override val viewModel: Any
        get() = TODO("Not yet implemented")
}