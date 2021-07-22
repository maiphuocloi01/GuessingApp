package com.example.guessinggame.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guessinggame.utils.GuessResult
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private val _result = MutableLiveData<GuessResult?>()
    val result: LiveData<GuessResult?>
        get() = _result

    private val _isRunning = MutableLiveData(false)
    val isRunning: LiveData<Boolean>
        get() = _isRunning

    private var generatedNumber = 0


    fun play(context: Context, getTextView: TextInputEditText, gameIsState: Boolean) {
        if (gameIsState) {
            compareGuess(context, getTextView)
        } else {
            newGame(getTextView)
        }
    }

    private fun newGame(guessTextView: TextInputEditText) {
        generatedNumber = generateRandom()

        guessTextView.isEnabled = true
        guessTextView.setText("")
        guessTextView.hint = ""

        _isRunning.value = true
        _result.value = GuessResult.GUESSING
    }

    private fun compareGuess(context: Context, guessEditText: TextInputEditText) {
        if (!validateGuessText(guessEditText.text.toString())) {
            guessEditText.error = "This field can not be empty"
            return
        }

        context.hideKeyboard(guessEditText)

        val guess = guessEditText.text.toString().toInt()
        when {
            guess > generatedNumber -> {
                _result.value = GuessResult.LOWER
                _isRunning.value = true
                Log.d("GameViewModel", "LOWER")
            }
            guess < generatedNumber -> {
                _result.value = GuessResult.HIGHER
                _isRunning.value = true
                Log.d("GameViewModel", "HIGHER")
            }
            else -> {
                _result.value = GuessResult.WIN
                guessEditText.isEnabled = false
                guessEditText.hint = "You Win!"
                _isRunning.value = false
                Log.d("GameViewModel", "WIN")
            }
        }
    }

    private fun generateRandom(): Int {
        return Random.nextInt(1, 10)
    }

    private fun validateGuessText(guessText: String): Boolean {
        return guessText.isNotEmpty()
    }

    fun Context.hideKeyboard(view: View) {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.apply {
            hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}