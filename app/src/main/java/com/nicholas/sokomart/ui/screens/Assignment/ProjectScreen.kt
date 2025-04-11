package com.nicholas.sokomart.ui.screens.Assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectScreen()
        }
    }
}

@Composable
fun ProjectScreen() {
    Scaffold(
        bottomBar = { BottomNavBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = Color.Red,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
                .padding(16.dp)
                .background(Color.White
                )
        ) {
            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Hi Nick", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Here are your projects", fontSize = 16.sp, color = Color.Gray)
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFFFD37E), shape = CircleShape)
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Project Cards
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProjectCard("Cryptocurrency\nLanding Page", "12 tasks", Color(0xFF1F3C88))
                ProjectCard("Statistics\nDashboard", "12 tasks", Color(0xFFFF8B3B))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Personal Tasks
            Text("Personal Tasks", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))

            TaskItem("NDA Review for website project", "Today - 10pm", Color(0xFFFF7043))
            Spacer(modifier = Modifier.height(10.dp))
            TaskItem("Email Reply for Green Project", "Today - 10pm", Color(0xFF42A5F5))
        }
    }
}

@Composable
fun ProjectCard(title: String, tasks: String, color: Color) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(120.dp)
            .background(color, shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Column {
            Icon(Icons.Default.Build, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(tasks, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
        }
    }
}

@Composable
fun TaskItem(title: String, time: String, colorDot: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)


        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            Text(time, color = Color.Gray, fontSize = 12.sp)
        }

    }
}
//BottomNavbar
@Composable
fun BottomNavBar() {
    BottomAppBar(
        containerColor = Color.White,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.List, contentDescription = "Tasks")
            }
            Spacer(modifier = Modifier.width(48.dp)) // space for FAB
            IconButton(onClick = {}) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Person, contentDescription = "Profile")
            }
        }
    }
}
//End of BottomNavbar

@Preview(showBackground = true)
@Composable
fun PreviewProjectScreen() {
    ProjectScreen()
}