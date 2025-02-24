package dev.mateuy.teaching.compose.resumen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CounterApp2() {
   val viewModel = viewModel { CounterViewModel() }

   val counter1 = viewModel.counter1.value
   val counter2 = viewModel.counter2.value

   Marcador(counter1, counter2, viewModel::team1Scored, viewModel::team2Scored)
}

//fun CounterView2(){
@Composable
fun Marcador(counter1: Int, counter2: Int, team1Scored: () -> Unit, team2Scored: () -> Unit) {
    Row{
        Column{
            Text(counter1.toString())
            Button(onClick = team1Scored){
                Text("Score")
           }
        }
        Column{
            Text(counter2.toString())
            Button(onClick = team2Scored){
                Text("Score")
            }
        }
    }
}


class CounterViewModel : ViewModel(){
    val counter1 = mutableStateOf(0)
    val counter2 = mutableStateOf(0)

    fun team1Scored(){
        counter1.value += 1
    }

    fun team2Scored(){
        counter2.value += 1
    }
}