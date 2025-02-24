
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import cat.itb.m78.exercices.App
import cat.itb.vnr.dam.m03.uf3.exercices.JokesScreen

fun main() = application {
    Window(
        title = "M78Exercices",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        //App()
        JokesScreen()
    }
}