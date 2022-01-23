package com.pjurado.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

import com.pjurado.navegacion.ui.theme.NavegacionTheme

class MainActivity : ComponentActivity() {
    var directorio: ArrayList<Persona> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            llenaDirectorio()
            //val navController = remember
            NavegacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    listaContactos(directorio)
                }
            }
        }
    }

    private fun llenaDirectorio() {
        for (i in 1..10) {
            directorio.add(
                Persona(
                    "Persona $i",
                    "$i$i$i$i$i$i$i$i$i",
                    "persona$i@gmail.com",
                    "https://randomfox.ca/images/$i.jpg"
                    //"https://source.unsplash.com/category/nature/"
                )
            )
        }
    }
}

@Composable
private fun listaContactos(directorio: ArrayList<Persona>) {
    LazyColumn {
        items(directorio) { persona ->
            cardPersona(persona)
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun cardPersona(persona: Persona) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(150.dp)
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .padding(8.dp),
                painter = rememberImagePainter(persona.foto),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .height(150.dp)
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = persona.nombre)
                Text(text = persona.telefono)
                Text(text = persona.email)
            }
        }
    }
}

