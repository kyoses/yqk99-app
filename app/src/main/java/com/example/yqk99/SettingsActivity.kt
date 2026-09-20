package com.example.yqk99

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var etUrl: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        etUrl = findViewById(R.id.etUrl)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val currentUrl = getSharedPreferences(MainActivity.PREFS_NAME, Context.MODE_PRIVATE)
            .getString(MainActivity.KEY_URL, getString(R.string.default_url)) ?: getString(R.string.default_url)
        etUrl.setText(currentUrl)
        etUrl.setSelection(currentUrl.length)

        btnSave.setOnClickListener {
            val input = etUrl.text.toString().trim()
            if (isValidUrl(input)) {
                getSharedPreferences(MainActivity.PREFS_NAME, Context.MODE_PRIVATE).edit()
                    .putString(MainActivity.KEY_URL, input)
                    .apply()
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, getString(R.string.url_invalid), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidUrl(input: String): Boolean {
        if (input.isBlank()) return false
        return try {
            val uri = Uri.parse(input)
            val scheme = uri.scheme?.lowercase()
            (scheme == "http" || scheme == "https") && !uri.host.isNullOrEmpty()
        } catch (e: Exception) {
            false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}