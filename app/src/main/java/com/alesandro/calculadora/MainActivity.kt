package com.alesandro.calculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alesandro.calculadora.databinding.ActivityMainBinding

/**
 * Clase de la actividad principal de la aplicación
 */
class MainActivity : AppCompatActivity() {

    /**
     * Función que se ejecuta al crear la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.bt0
    }

}