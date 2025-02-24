package cat.itb.m78


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.p2.samples.squa
import dev.mateuy.teaching.compose.resumen.CounterApp2

@Composable
internal fun App() = AppTheme {
    Box(Modifier.fillMaxSize()){
//        Text("Your app goes here!!!", Modifier.align(Alignment.Center))
        //CounterApp2()
        squa()
    }
}
