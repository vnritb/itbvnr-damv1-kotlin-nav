package dev.mateuy.teaching.compose.resumen

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/*  ************************
            Model
    ************************
 */

private sealed interface Screen {
    data object Screen1 : Screen
    data object Screen2 : Screen
    data class Screen3(val message: String) : Screen
}

private class ManualNavAppViewModel : ViewModel() {
    val currentScreen = mutableStateOf<Screen>(Screen.Screen1)

    fun navigateTo(screen: Screen) {
        currentScreen.value = screen
    }
}

/*  ************************
            Vista
    ************************
 */


@Composable
fun ManualNav2() {
    //val pan=2
    val viewModel = viewModel { ManualNavAppViewModel() }
    val currentScreen = viewModel.currentScreen.value
    when (currentScreen){
        //if (pan==1){
        Screen.Screen1 -> Pantalla1(
            navigateToScreen2 = { viewModel.navigateTo(Screen.Screen2) }
        )
        //}else{
        is Screen.Screen2 -> Pantalla2(
            navigateToScreen3 = { viewModel.navigateTo(Screen.Screen3(it)) }
        )
        is Screen.Screen3 -> Pantalla3(currentScreen.message)
    }

}

//Pantalla 1
@Composable
fun Pantalla1(navigateToScreen2: ()-> Unit){
    Column() {
        Text("Pantalla1")
        Button(onClick = navigateToScreen2) {
            Text("Go To screen2")
        }
    }
}

//Pantalla 2
@Composable
fun Pantalla2(navigateToScreen3: (String)-> Unit){
    var text by remember{ mutableStateOf("") }
    Column() {
        Text("Pantalla2")
        TextField(text, onValueChange = { text = it })
        Button(onClick = { navigateToScreen3(text) }) {
            Text("Go to Screen 3")
        }
    }
}

//Pantalla 3
@Composable
fun Pantalla3(message: String){
    Column() {
        Text("Pantalla3")
        Text(message)
    }
}

