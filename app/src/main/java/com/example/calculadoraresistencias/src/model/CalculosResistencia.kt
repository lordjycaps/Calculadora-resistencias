package com.example.calculadoraresistencias.src.model

class CalculosResistencia {

    // Mapa que asocia colores con su valor numérico
    private val colorToValue = mapOf(
        "Negro" to 0,
        "Marrón" to 1,
        "Rojo" to 2,
        "Naranja" to 3,
        "Amarillo" to 4,
        "Verde" to 5,
        "Azul" to 6,
        "Violeta" to 7,
        "Gris" to 8,
        "Blanco" to 9
    )

    // Mapa que asocia colores con su multiplicador
    private val multiplier = mapOf(
        "Negro" to 1.0,
        "Marrón" to 10.0,
        "Rojo" to 100.0,
        "Naranja" to 1_000.0,
        "Amarillo" to 10_000.0,
        "Verde" to 100_000.0,
        "Azul" to 1_000_000.0,
        "Violeta" to 10_000_000.0,
        "Gris" to 100_000_000.0,
        "Blanco" to 1_000_000_000.0,
        "Oro" to 0.1,
        "Plata" to 0.01
    )

    // Función que calcula la resistencia en base a las bandas de color y el multiplicador
    fun calcularResistencia(banda1: String, banda2: String, multiplicador: String): Double {
        val valor1 = colorToValue[banda1] ?: 0 // Si no se encuentra el color, por defecto usa 0
        val valor2 = colorToValue[banda2] ?: 0 // Si no se encuentra el color, por defecto usa 0
        val mult = multiplier[multiplicador] ?: 1.0 // Si no se encuentra el multiplicador, usa 1.0 por defecto

        // Cálculo de la resistencia: (valor1 * 10 + valor2) * multiplicador
        return (valor1 * 10 + valor2) * mult
    }
}

