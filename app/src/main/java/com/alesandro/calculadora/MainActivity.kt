package com.alesandro.calculadora

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alesandro.calculadora.databinding.ActivityMainBinding

/**
 * Clase de la actividad principal de la aplicación
 *
 * @author Alesandro Quirós Gobbato
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private var firstNumber = 0.0
    private var secondNumber = 0.0
    private var operation: String? = null

    /**
     * Función que se ejecuta al crear la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        operation = null
        // Creo los bindings para los botones
        binding.bt0.setOnClickListener(this)
        binding.bt1.setOnClickListener(this)
        binding.bt2.setOnClickListener(this)
        binding.bt3.setOnClickListener(this)
        binding.bt4.setOnClickListener(this)
        binding.bt5.setOnClickListener(this)
        binding.bt6.setOnClickListener(this)
        binding.bt7.setOnClickListener(this)
        binding.bt8.setOnClickListener(this)
        binding.bt9.setOnClickListener(this)
        binding.btComma.setOnClickListener(this)
        binding.btPlus.setOnClickListener(this)
        binding.btMinus.setOnClickListener(this)
        binding.btMul.setOnClickListener(this)
        binding.btDiv.setOnClickListener(this)
        binding.btEqual.setOnClickListener(this)
        binding.btClear.setOnClickListener(this)
    }

    /**
     * Función que asigna los botones a la función de onNumberPressed
     */
    override fun onClick(view: View?) {
        when(view) {
            binding.bt0 -> {
                onNumberPressed("0")
            }
            binding.bt1 -> {
                onNumberPressed("1")
            }
            binding.bt2 -> {
                onNumberPressed("2")
            }
            binding.bt3 -> {
                onNumberPressed("3")
            }
            binding.bt4 -> {
                onNumberPressed("4")
            }
            binding.bt5 -> {
                onNumberPressed("5")
            }
            binding.bt6 -> {
                onNumberPressed("6")
            }
            binding.bt7 -> {
                onNumberPressed("7")
            }
            binding.bt8 -> {
                onNumberPressed("8")
            }
            binding.bt9 -> {
                onNumberPressed("9")
            }
            binding.btComma -> {
                onNumberPressed(",")
            }
            binding.btPlus -> {
                onOperationPressed("+")
            }
            binding.btMinus -> {
                onOperationPressed("-")
            }
            binding.btMul -> {
                onOperationPressed("*")
            }
            binding.btDiv -> {
                onOperationPressed("/")
            }
            binding.btEqual -> {
                onEqualPress()
            }
            binding.btClear -> {
                onClearPress()
            }
        }
    }

    /**
     * Función para cuando se pulsa uno de los botones numéricos de la calculadora
     */
    private fun onNumberPressed(number: String) {
        renderScreen(number)
        checkOperation()
    }

    /**
     * Función que muestra en pantalla el número pulsado
     */
    private fun renderScreen(number: String) {
        val result = if (binding.screen.text == "0" && number != ",") {
            number
        } else {
            "${binding.screen.text}${number}"
        }
        binding.screen.text = result
    }

    /**
     * Función que comprueba las operaciones
     */
    private fun checkOperation() {
        if (operation == null) {
            firstNumber = binding.screen.text.toString().toDouble()
        } else {
            secondNumber = binding.screen.text.toString().toDouble()
        }
    }

    /**
     * Función para cuando se pulsa uno de los botones de las operaciones de la calculadora
     */
    private fun onOperationPressed(operation: String) {
        this.operation = operation
        firstNumber = binding.screen.text.toString().toDouble()
        binding.screen.text = "0"
    }

    /**
     * Función para cuando se pulsa el botón del igual de la calculadora
     */
    private fun onEqualPress() {
        val result = when(operation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> 0
        }
        operation = null
        firstNumber = result.toDouble()
        secondNumber = 0.0
        binding.screen.text = if (result.toString().endsWith(".0")) {
            result.toString().replace(".0", "")
        } else {
            "%.2f".format(result)
        }
    }

    /**
     * Función para cuando se pulsa el botón de clear de la calculadora
     */
    private fun onClearPress() {
        //
    }

}