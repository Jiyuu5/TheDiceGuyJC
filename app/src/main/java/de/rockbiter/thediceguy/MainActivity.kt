package de.rockbiter.thediceguy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import de.rockbiter.thediceguy.ui.MainUi
import de.rockbiter.thediceguy.ui.theme.TheDiceGuyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheDiceGuyTheme {
               MainUi()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    TheDiceGuyTheme {
        MainUi()
    }
}