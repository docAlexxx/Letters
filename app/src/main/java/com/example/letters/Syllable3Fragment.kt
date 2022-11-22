package com.example.letters

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentSyllable3Binding

class Syllable3Fragment :
    BindingFragment<FragmentSyllable3Binding>(FragmentSyllable3Binding::inflate) {

    val duration = 1000L

    private val generate: Generator by lazy {
        Generator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetters()
        setButton()
        binding.tvLettercounter.text=sellyableCount3.toString()
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
        binding.btnNewLetter3.setOnClickListener {
            getLetters()
        }
        binding.fab.setOnClickListener {
            animateViews(0f,720f,0f,500f,-100f,100f)
            generate.countRiser("sellyable3")
            binding.tvLettercounter.text=sellyableCount3.toString()
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