package com.example.calculadoraresistencias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadoraresistencias.src.screen.ResistenciaCalculatorView
import com.example.calculadoraresistencias.src.utils.TopAppBarSample
import com.example.calculadoraresistencias.ui.theme.CalculadoraResistenciasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //plantilla de colores
            CalculadoraResistenciasTheme{
                //contenido
                TopAppBarSample()
                ResistenciaCalculatorView()
            }

        }
    }
}

