package com.example.letters

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentSyllableBinding

class SyllableFragment :
    BindingFragment<FragmentSyllableBinding>(FragmentSyllableBinding::inflate) {

    private val duration = 1000L

    private val generate: Generator by lazy {
        Generator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetters()
        setButton()
        binding.tvLettercounter.text=sellyableCount.toString()
    }

    fun animateViews(
        start: Float,
        rotate: Float,
        startMove: Float,
        endMove: Float,
        midMove:Float,
        midMove2:Float,
    ) {
        ObjectAnimator.ofFloat(binding.dinoImageview, View.ROTATION, start, rotate)
            .setDuration(duration).start()
        ObjectAnimator.ofFloat(binding.dinoImageview, View.TRANSLATION_X, startMove, endMove,startMove)
            .setDuration(duration).start()
        ObjectAnimator.ofFloat(binding.dinoImageview, View.TRANSLATION_Y, startMove, midMove,startMove,midMove2,startMove)
            .setDuration(duration).start()
    }


    fun setButton() {
        binding.btnNewSellyable.setOnClickListener {
            getLetters()
        }
        binding.fab.setOnClickListener {
            animateViews(0f,720f,0f,500f,-100f,100f)
            generate.countRiser("sellyable")
            binding.tvLettercounter.text=sellyableCount.toString()
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