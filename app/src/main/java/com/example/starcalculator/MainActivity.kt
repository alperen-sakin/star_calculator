package com.example.starcalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.starcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.floor
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val stars: MutableList<EditText> = mutableListOf()
    private var modifier: Double = 0.0
    private var arch1 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        stars.addAll(
            listOf(
                binding.starEdittext1,
                binding.starEdittext2,
                binding.starEdittext3,
                binding.starEdittext4,
                binding.starEdittext5,
                binding.starEdittext6,
                binding.starEdittext7,
                binding.starEdittext8,
                binding.starEdittext9,
                binding.starEdittext10
            )
        )

        setAll()
        calculate()
        doGreenOrRed()

    }

    private fun setAll() {
        binding.setAllStarsEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()) {
                    binding.setAllStarsEditText.setBackgroundResource(R.drawable.red_border)

                } else {
                    binding.setAllStarsEditText.setBackgroundResource(R.drawable.green_border)
                }
                for (star in stars) {
                    star.text = binding.setAllStarsEditText.text

                }


            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun calculate() {
        binding.calculateButton.setOnClickListener {
            val starsValues: MutableList<Double> = mutableListOf()
            arch1 = getAchievement()
            for (starValue in stars) {
                starsValues.add(starValue.text.toString().toDouble())

            }

            val desired = binding.TargetStarEditText.text.toString().toDoubleOrNull() ?: 0.0

            arch1 = getAchievement()
            val master171 = binding.starsCostsMasterEditText.text.toString().toDoubleOrNull() ?: 1.0
            val mlpt = 1 - (arch1 / 100)
            var gsAmount = 0.0
            var magAmount = 0.0
            var fragmentAmount = 0.0
            val scrapyardMul = scrapyardModifier()
            var ek = ' '

            stars.forEach { starEditText ->
                val star = starEditText.text.toString().toDoubleOrNull() ?: 0.0

                if (star < desired) {
                    for (index in star.toInt() until desired.toInt()) {
                        gsAmount += gsCost(index.toDouble(), scrapyardMul)
                        magAmount += magnetCost(index.toDouble(), scrapyardMul)
                        fragmentAmount += fragmentCost(index.toDouble(), scrapyardMul)
                    }
                }
            }
            when {
                magAmount <= 1e6 -> {
                    ek = ' '
                }
                magAmount < 1e9 -> {
                    magAmount/=1e6
                    ek = 'a'
                }
                magAmount < 1e12 -> {
                    magAmount/=1e9
                    ek = 'b'
                }
                magAmount < 1e15 -> {
                    magAmount/=1e12
                    ek = 'c'
                }
                magAmount < 1e18 -> {
                    magAmount/=1e15
                    ek = 'd'
                }
                magAmount < 1e21 -> {
                    magAmount/=1e18
                    ek = 'e'
                }
                magAmount < 1e24 -> {
                    magAmount/=1e21
                    ek = 'f'
                }
                magAmount < 1e27 -> {
                    magAmount/=1e24
                    ek = 'g'
                }
                magAmount < 1e30 -> {
                    magAmount/=1e27
                    ek = 'h'
                }
                magAmount < 1e33 -> {
                    magAmount/=1e30
                    ek = 'i'
                }
                magAmount < 1e36 -> {
                    magAmount/=1e33
                    ek = 'j'
                }
                magAmount < 1e39 -> {
                    magAmount/=1e36
                    ek = 'k'
                }
                magAmount < 1e42 -> {
                    magAmount/=1e39
                    ek = 'l'
                }
                magAmount < 1e45 -> {
                    magAmount/=1e42
                    ek = 'm'
                }

            }

            gsAmount *= mlpt * master171
            binding.requiredGoldenScrapTextview.text = formatNumber(gsAmount)

            magAmount *= mlpt * master171
            binding.requiredMagnetTextview.text = "${formatNumber(magAmount)} $ek"

            fragmentAmount *= mlpt * master171
            binding.requiredStarFragmentTextview.text = formatNumber(fragmentAmount)
        }
    }

    private fun scrapyardModifier(): Double {
        binding.scrapyardEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val level = binding.scrapyardEditText.text.toString().toDoubleOrNull() ?: 0.0

                if (level > 200) {
                    modifier = (level - 200) * 4 + 300
                } else {
                    modifier = level
                    if (level > 100) {
                        modifier = (level - 100) * 2 + 100
                    }
                }


            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        return modifier - 1

    }

    private fun gsCost(starLevel: Double, scrapyardMul: Double): Double {
        var cost = 100000 * (starLevel - 10) + 250000 //adjust for first 10 stars
        if (starLevel >= 20) cost *= 1.3
        if (starLevel >= 30) cost *= 1.3
        if (starLevel >= 60) cost *= 1.3
        if (starLevel >= 80) cost *= 1.3
        if (starLevel >= 90) cost *= 1.3
        if (starLevel >= 100) cost *= 1.3
        if (starLevel >= 150) cost *= 1.1
        if (starLevel >= 160) cost *= 1.1
        if (starLevel >= 170) cost *= 1.1
        if (starLevel >= 180) cost *= 1.1
        if (starLevel >= 190) cost *= 1.1
        if (starLevel >= 200) cost *= 1.1
        if (starLevel >= 210) cost *= 1.1
        if (starLevel >= 220) cost *= 1.1
        if (starLevel >= 230) cost *= 1.1
        if (starLevel >= 250) cost *= 1.1
        if (starLevel >= 300) cost *= 1.1
        if (starLevel >= 350) cost *= 1.1
        if (starLevel >= 400) cost *= 1.1
        if (starLevel >= 450) cost *= 1.1
        if (starLevel >= 500) cost *= 1.1
        if (starLevel >= 550) cost *= 1.1
        return floor((cost * 100) / (scrapyardMul + 100))
    }

    private fun magnetCost(starLevel: Double, scrapyardMul: Double): Double {
        var cost = 250 * (starLevel - 10) + 1000 //adjust for first 10 stars
        if (starLevel >= 12) cost *= 0.98
        if (starLevel >= 13) cost *= 0.98
        if (starLevel >= 14) cost *= 0.98
        if (starLevel >= 15) cost *= 0.98
        if (starLevel >= 16) cost *= 0.98
        if (starLevel >= 17) cost *= 0.98
        if (starLevel >= 18) cost *= 0.98
        if (starLevel >= 19) cost *= 0.98
        if (starLevel >= 20) cost *= 0.98
        if (starLevel >= 21) cost *= 0.98
        if (starLevel >= 22) cost *= 0.98
        if (starLevel >= 23) cost *= 0.98
        if (starLevel >= 70) cost *= 1.04
        if (starLevel >= 75) cost *= 1.04
        if (starLevel >= 80) cost *= 1.06
        if (starLevel >= 85) cost *= 1.06
        if (starLevel >= 90) cost *= 1.06
        if (starLevel >= 94) cost *= 1.06
        if (starLevel >= 96) cost *= 1.06
        if (starLevel >= 98) cost *= 1.05
        if (starLevel >= 100) cost *= 1.05
        if (starLevel >= 105) cost *= 1.05
        if (starLevel >= 110) cost *= 1.05
        if (starLevel >= 115) cost *= 1.03
        if (starLevel >= 120) cost *= 1.05
        if (starLevel >= 125) cost *= 1.05
        if (starLevel >= 130) cost *= 1.05
        if (starLevel >= 135) cost *= 1.05
        if (starLevel >= 140) cost *= 1.05
        if (starLevel >= 145) cost *= 1.05
        if (starLevel >= 150) cost *= 1.05
        if (starLevel >= 160) cost *= 1.05
        if (starLevel >= 180) cost *= 1.05
        if (starLevel >= 190) cost *= 1.05
        if (starLevel >= 200) cost *= 1.05
        if (starLevel >= 210) cost *= 1.05
        if (starLevel >= 220) cost *= 1.05
        if (starLevel >= 230) cost *= 1.035
        if (starLevel >= 250) cost *= 1.1
        if (starLevel >= 270) cost *= 1.14
        if (starLevel >= 290) cost *= 1.15
        if (starLevel >= 300) cost *= 1.04
        if (starLevel >= 310) cost *= 1.1
        if (starLevel >= 330) cost *= 1.1
        if (starLevel >= 350) cost *= 1.05
        if (starLevel >= 370) cost *= 1.1
        if (starLevel >= 390) cost *= 1.018
        if (starLevel >= 410) cost *= 1.1
        if (starLevel >= 430) cost *= 1.1
        if (starLevel >= 450) cost *= 1.06
        if (starLevel >= 470) cost *= 1.1
        if (starLevel >= 490) cost *= 1.05
        if (starLevel >= 510) cost *= 1.09
        if (starLevel >= 530) cost *= 1.09
        if (starLevel >= 550) cost *= 1.09
        if (starLevel >= 570) cost *= 1.09
        if (starLevel >= 590) cost *= 1.07
        if (starLevel >= 610) cost *= 1.1
        if (starLevel >= 630) cost *= 1.1
        if (starLevel >= 650) cost *= 1.1
        if (starLevel >= 670) cost *= 1.07
        if (starLevel >= 690) cost *= 1.05
        if (starLevel >= 710) cost *= 1.1
        if (starLevel >= 810) cost *= 1.1
        if (starLevel >= 910) cost *= 1.1
        if (starLevel >= 1010) cost *= 1.1
        if (starLevel >= 1020) cost *= 1.1
        if (starLevel >= 1090) cost *= 1.1
        if (starLevel >= 1110) cost *= 1.3
        if (starLevel >= 1120) cost *= 1.1
        if (starLevel >= 1130) cost *= 1.1
        if (starLevel >= 1210) cost *= 1.3
        if (starLevel >= 1260) cost *= 1.18
        if (starLevel >= 1285) cost *= 1.18
        if (starLevel >= 1310) cost *= 1.36
        if (starLevel >= 1360) cost *= 1.36
        if (starLevel >= 1410) cost *= 1.37
        if (starLevel >= 1460) cost *= 1.37
        if (starLevel >= 1510) cost *= 1.3
        if (starLevel >= 1560) cost *= 1.269
        if (starLevel >= 1610) cost *= 1.1
        if (starLevel >= 1660) cost *= 1.1
        if (starLevel >= 1710) cost *= 1.3
        if (starLevel >= 1760) cost *= 1.269
        if (starLevel >= 1810) cost *= 1.1
        if (starLevel >= 1860) cost *= 1.1.pow(floor((starLevel - 1810) / 50))
        return floor(cost * 100 / (scrapyardMul + 100))
    }

    private fun fragmentCost(starLevel: Double, scrapyardMul: Double): Double {
        var cost = 4 + (starLevel - 10) //adjust for first 10 stars
        if (starLevel >= 60) cost *= 1.05
        if (starLevel >= 70) cost *= 1.05
        if (starLevel >= 75) cost *= 1.05
        if (starLevel >= 80) cost *= 1.05
        if (starLevel >= 85) cost *= 1.05
        if (starLevel >= 90) cost *= 1.05
        if (starLevel >= 94) cost *= 1.05
        if (starLevel >= 96) cost *= 1.05
        if (starLevel >= 98) cost *= 1.05
        if (starLevel >= 100) cost *= 1.1
        if (starLevel >= 110) cost *= 1.05
        if (starLevel >= 115) cost *= 1.05
        if (starLevel >= 120) cost *= 1.05
        if (starLevel >= 125) cost *= 1.05
        if (starLevel >= 130) cost *= 1.05
        if (starLevel >= 140) cost *= 1.05
        if (starLevel >= 150) cost *= 1.05
        if (starLevel >= 160) cost *= 1.05
        if (starLevel >= 170) cost *= 1.05
        if (starLevel >= 180) cost *= 1.05
        if (starLevel >= 190) cost *= 1.05
        if (starLevel >= 200) cost *= 1.05
        if (starLevel >= 210) cost *= 1.3
        if (starLevel >= 260) cost *= 1.3
        if (starLevel >= 310) cost *= 1.4
        if (starLevel >= 410) cost *= 1.4
        if (starLevel >= 510) cost *= 1.4
        if (starLevel >= 610) cost *= 1.2
        if (starLevel >= 710) cost *= 1.1
        if (starLevel >= 810) cost *= 1.1
        if (starLevel >= 910) cost *= 1.1
        if (starLevel >= 1010) cost *= 1.1
        return floor((cost * 100) / (scrapyardMul + 100))
    }

    private fun formatNumber(number: Double): String {
        return NumberFormat.getNumberInstance(Locale("en", "En")).format(number)
    }

    private fun doGreenOrRed(){
        binding.starsCostsAchievementEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()){binding.starsCostsAchievementEditText.setBackgroundResource(R.drawable.red_border)}
                else{binding.starsCostsAchievementEditText.setBackgroundResource(R.drawable.green_border)}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.starsCostsMasterEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()){binding.starsCostsMasterEditText.setBackgroundResource(R.drawable.red_border)}
                else{binding.starsCostsMasterEditText.setBackgroundResource(R.drawable.green_border)}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.scrapyardEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()){binding.scrapyardEditText.setBackgroundResource(R.drawable.red_border)}
                else{binding.scrapyardEditText.setBackgroundResource(R.drawable.green_border)}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.TargetStarEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()){binding.TargetStarEditText.setBackgroundResource(R.drawable.red_border)}
                else{binding.TargetStarEditText.setBackgroundResource(R.drawable.green_border)}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun getAchievement():Double{
        return binding.starsCostsAchievementEditText.text.toString().toDoubleOrNull() ?: 0.0
    }


}

//
