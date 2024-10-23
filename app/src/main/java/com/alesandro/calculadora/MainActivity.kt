package com.alesandro.calculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Clase de la actividad principal de la aplicación
 */
class MainActivity : AppCompatActivity() {

    /**
     * Función que se ejecuta al crear la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}