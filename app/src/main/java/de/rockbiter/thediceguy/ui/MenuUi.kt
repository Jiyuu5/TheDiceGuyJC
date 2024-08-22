package de.rockbiter.thediceguy.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuUi(){
    Column (modifier = Modifier.padding(8.dp)){
      CenterAlignedTopAppBar(title = {
          Text(text = "Main Menu Settings")
      })
        MenuItemSwitch(title = "Enable dice auto roll",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        MenuItemSwitch(title = "Show colored score board",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }

}

@Composable
fun MenuItemSwitch(title: String, modifier: Modifier){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(text = title)
        Switch(checked = true, onCheckedChange = {  } )
    }

}



@Preview(showBackground = true)
@Composable
fun PreviewMenuUi(){
    MenuUi()
}