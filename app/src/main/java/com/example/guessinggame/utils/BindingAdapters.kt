package com.example.guessinggame.utils

import android.content.Context
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.guessinggame.R

@BindingAdapter("app:state", "android:context")
fun gameRunning(button: Button, isRunning: Boolean, context: Context) {
    when (isRunning) {
        true -> button.text = context.getString(R.string.guess)
        false -> button.text = context.getString(R.string.new_game)
    }
}
@BindingAdapter("app:resultText", "android:context")
fun resultText(textView: TextView, result: GuessResult?, context: Context) {
    result?.let { _result ->
        when (_result) {
            GuessResult.HIGHER -> textView.text = context.getString(R.string.higher)
            GuessResult.LOWER -> textView.text = context.getString(R.string.lower)
            GuessResult.WIN -> textView.text = context.getString(R.string.you_win)
            GuessResult.GUESSING -> textView.text = ""
        }
    }
}
@BindingAdapter("app:resultImage")
fun resultImage(imageView: ImageView, result: GuessResult?) {
    result?.let { _result ->
        when (_result) {
            GuessResult.HIGHER -> imageView.setImageResource(R.drawable.arrow_up)
            GuessResult.LOWER -> imageView.setImageResource(R.drawable.arrow_down)
            GuessResult.WIN -> imageView.setImageResource(R.drawable.trophy)
            GuessResult.GUESSING -> imageView.setImageDrawable(null)
        }
    }
}