package com.estech.cocktailapp.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.estech.cocktailapp.databinding.ActivityLoginBinding
import com.estech.cocktailapp.shared_preferences.PrefHelper
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPrefHelper = PrefHelper(this)

        val textShader: Shader = LinearGradient(
            0f,
            0f,
            0f,
            220f,
            intArrayOf(Color.rgb(252, 75, 8), Color.rgb(255, 255, 0)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.textView.paint.shader = textShader

        binding.loginButton.setOnClickListener {
            with (binding) {
                if (myPrefHelper.getUsername() == "Usuario")
                    emailEditText.setText(myPrefHelper.getUsername())

                if (emailEditText.text.isNullOrEmpty() || passwordEditText.text.isNullOrEmpty()) {
                    emailEditText.error = "El campo email es obligatorio"
                    passwordEditText.error = "El campo password es obligatorio"
                } else if (emailEditText.text.toString() == "Usuario" && passwordEditText.text.toString() == "12345") {
                    myPrefHelper.putUsername("Usuario")
                    val time = Calendar.getInstance().time
                    val currDate = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(time)
                    myPrefHelper.putCurrDate(currDate)

                    val intent = Intent(this@Login, MainActivity::class.java)
                    intent.putExtra("user", emailEditText.text)
                    intent.putExtra("date", currDate)
                    startActivity(intent)
                    finish()
                } else {
                    val builder = AlertDialog.Builder(this@Login)
                    builder.setTitle("Error")
                    builder.setMessage("Usuario y contraseña incorrectos. Vuelve a intentarlo.")
                    builder.setNegativeButton("Cerrar", null)
                    builder.create().show()

                    emailEditText.error = "El campo usuario y contraseña son incorrectos"
                    passwordEditText.error = "El campo usuario y contraseña son incorrectos"
                }
            }
        }

        binding.accessButton.setOnClickListener {
            myPrefHelper.putUsername("Invitado")
            val time = Calendar.getInstance().time
            val currDate = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(time)
            myPrefHelper.putCurrDate(currDate)

            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}