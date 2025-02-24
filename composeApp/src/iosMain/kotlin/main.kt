import androidx.compose.ui.window.ComposeUIViewController
import cat.itb.m78.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
