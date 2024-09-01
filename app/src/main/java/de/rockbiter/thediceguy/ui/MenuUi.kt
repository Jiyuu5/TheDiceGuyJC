package de.rockbiter.thediceguy.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.ui.window.Dialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rockbiter.thediceguy.R

@Composable
fun MenuUi(versionHistoryText: String, menuViewModel: MenuViewModel){

    val menuUiState by menuViewModel.uiState.collectAsState()

    Column (modifier = Modifier.padding(8.dp)){

          Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
              .padding(8.dp)
              .fillMaxWidth()){
              Text(text = "Main Menu Settings", fontSize = 24.sp)
              IconButton(
                  onClick = { menuViewModel.openVersionHistory() }) {
                  Icon(
                      painter = painterResource(id = R.drawable.more_vert_32),
                      contentDescription = "Main Menu Options"
                  )
              }
          }

        MenuItemSwitch(title = "Dice auto roll",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        MenuItemSwitch(title = "Colored score board",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        if (menuUiState.isVersionHistoryOpen) {
            Dialog(onDismissRequest = { menuViewModel.closeVersionHistory() }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp)

                ) {
                    Text(text = versionHistoryText)
                }
            }
        }
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
    MenuUi(versionHistoryText = "Test", MenuViewModel())
}