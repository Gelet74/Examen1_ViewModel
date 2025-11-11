package com.example.examen1_viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examen1_viewmodel.ui.appViewModel.AppViewModel


@Composable
fun AnadirPersona(viewModel: AppViewModel = viewModel(),
                    modifier : Modifier=Modifier) {
    Column(modifier = Modifier.padding(16.dp)
                              .fillMaxSize()
                              .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text= stringResource(R.string.anadir),
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(25.dp))

        Text (
            text = stringResource(R.string.codigo),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = viewModel.nombreSeleccionado,
            onValueChange = viewModel::actualizarNombre,
            label = {Text(stringResource(R.string.nombre)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.width(250.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text (
            text = stringResource(R.string.rol),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(4.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.alumno),
                contentDescription = null,
                modifier = Modifier .padding(end = 8.dp)
                    .size(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profesor),
                contentDescription = null,
                modifier = Modifier .padding(start = 8.dp)
                    .size(100.dp)
            )
        }
        


    }
}