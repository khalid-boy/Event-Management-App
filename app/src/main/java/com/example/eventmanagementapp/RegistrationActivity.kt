package com.example.eventmanagementapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegistrationActivity : AppCompatActivity() {
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
    }

    private fun validateEmail(email: String): Boolean {
        // Basic email validation
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        // Password must be at least 6 characters and include one number, one alphabet and one special character
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#\$%\^&\*])[A-Za-z\d!@#\$%\^&\*]{6,}$"
        return password.matches(passwordPattern.toRegex())
    }

    private fun registerUser(email: String, password: String) {
        if (!validateEmail(email)) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            return
        }

        if (!validatePassword(password)) {
            Toast.makeText(this, "Password must be at least 6 characters with one number, one alphabet, and one special character", Toast.LENGTH_LONG).show()
            return
        }

        // Proceed with the registration process
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
    }
}