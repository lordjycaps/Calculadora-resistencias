package com.example.calculadoraresistencias.src.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calculadoraresistencias.src.model.CalculosResistencia

// Mapa para asociar colores en texto con el color visual en Compose
val colorMap = mapOf(
    "Negro" to Color.Black,
    "Marrón" to Color(0xFF6D4C41),
    "Rojo" to Color.Red,
    "Naranja" to Color(0xFFFF9800),
    "Amarillo" to Color.Yellow,
    "Verde" to Color.Green,
    "Azul" to Color.Blue,
    "Violeta" to Color(0xFF9C27B0),
    "Gris" to Color.Gray,
    "Blanco" to Color.White,
    "Oro" to Color(0xFFFFD700),
    "Plata" to Color(0xFFC0C0C0)
)

@Composable
fun ResistenciaCalculatorView() {
    val calculosResistencia = CalculosResistencia()
    val colores = listOf("Negro", "Marrón", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
    val multiplicadores = listOf("Negro", "Marrón", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco", "Oro", "Plata")
    val tolerancias = listOf("Oro", "Plata", "Rojo", "Marrón")

    var selectedBand1 by remember { mutableStateOf(colores[0]) }
    var selectedBand2 by remember { mutableStateOf(colores[0]) }
    var selectedMultiplier by remember { mutableStateOf(multiplicadores[0]) }
    var selectedTolerancia by remember { mutableStateOf(tolerancias[0]) } // Añadir variable para la tolerancia
    var resultado by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text("Seleccione los colores de la resistencia", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(80.dp)
                .shadow(
                    elevation = 4.dp, // Tamaño de la sombra
                    shape = RoundedCornerShape(15.dp), // Radio del borde
                    clip = true
                )
                .border(
                    width = 1.dp,
                    color = Color.Gray, // Color del borde
                    shape = RoundedCornerShape(15.dp) // Radio del borde
                )
                .background(
                    color = Color(0xFFfbd69a),
                    shape = RoundedCornerShape(15.dp) // Radio del fondo
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(30.dp) // Ancho de la banda de color
                        .height(80.dp)
                        .background(colorMap[selectedBand1] ?: Color.Transparent)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .width(30.dp) // Ancho de la banda de color
                        .height(80.dp)
                        .background(colorMap[selectedBand2] ?: Color.Transparent)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .width(30.dp) // Ancho de la banda de color
                        .height(80.dp)
                        .background(colorMap[selectedMultiplier] ?: Color.Transparent)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .width(30.dp) // Ancho de la banda de color
                        .height(80.dp)
                        .background(colorMap[selectedTolerancia] ?: Color.Transparent)
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Resistencia: $resultado Ω", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Visualización de la Primera Banda
        Text(text = "Seleccione")
        DropdownMenu(
            label = "Primera Banda",
            options = colores,
            selectedOption = selectedBand1,
            onOptionSelected = { selectedBand1 = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Visualización de la Segunda Banda
        Text(text = "Seleccione")
        DropdownMenu(
            label = "Segunda Banda",
            options = colores,
            selectedOption = selectedBand2,
            onOptionSelected = { selectedBand2 = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Visualización del Multiplicador
        Text(text = "Seleccione")
        DropdownMenu(
            label = "Multiplicador",
            options = multiplicadores,
            selectedOption = selectedMultiplier,
            onOptionSelected = { selectedMultiplier = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Visualización de la Tolerancia
        Text(text = "Seleccione la Tolerancia")
        DropdownMenu(
            label = "Tolerancia",
            options = tolerancias,
            selectedOption = selectedTolerancia,
            onOptionSelected = { selectedTolerancia = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            resultado = calculosResistencia.calcularResistencia(selectedBand1, selectedBand2, selectedMultiplier)
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Dibujo de resistencia
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu(label: String, options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            label = { Text(text = label) },
            readOnly = true,
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
