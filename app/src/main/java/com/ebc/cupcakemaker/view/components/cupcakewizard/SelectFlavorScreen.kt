package com.ebc.cupcakemaker.view.components.cupcakewizard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.cupcakemaker.enumerators.ViewModelIDs
import com.ebc.cupcakemaker.staticdata.DataSource
import com.ebc.cupcakemaker.view.components.CustomSpacer
import com.ebc.cupcakemaker.viewmodel.CupcakeMakerViewModel

@Composable
fun SelectFlavorScreen(navContoller: NavController,
                       cupcakeMakerViewModel: CupcakeMakerViewModel) {
    //Text(text = "Flavors!!!!")

    val flavors = DataSource.flavorsKeys.map { key -> stringResource(key) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            flavors.forEach { flavor ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = cupcakeMakerViewModel.state.flavor == flavor,
                            onClick = {
                                cupcakeMakerViewModel.onValue(flavor, ViewModelIDs.Flavor.id)
                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = cupcakeMakerViewModel.state.flavor == flavor,
                        onClick = {
                            cupcakeMakerViewModel.onValue(flavor, ViewModelIDs.Flavor.id)
                        }
                    )
                    Text(flavor)
                }

            }
        }
        CustomSpacer(height = 16.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1F),
                onClick = {
                    cupcakeMakerViewModel.reset()
                    navContoller.popBackStack()
                }
            ) {
                Text("Cancelar")
            }
        }


    }


}