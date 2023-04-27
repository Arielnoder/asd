package com.example.composetutorial

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme()
             {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Ariel","How you doing girl?"))

                }
            }
        }
    }
}
data class Message(val author: String, val body: String)

@Composable
 fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(R.drawable.btn_star_big_on),
            contentDescription = "Happy",
            modifier = Modifier
                .size(30.dp)
                .border(1.6.dp, MaterialTheme.colorScheme.primary, CircleShape)
                .clip(CircleShape)

        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium

            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = msg.body)
        }
    }

 }

@Preview
@Composable
fun PreviewMessageCard() {
    MaterialTheme() {
        Surface {
            MessageCard(msg = Message("Ariel", "How are you doing girl"))
        }
    }
}

  