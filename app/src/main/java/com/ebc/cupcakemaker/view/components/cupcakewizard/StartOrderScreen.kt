package com.ebc.cupcakemaker.view.components.cupcakewizard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.cupcakemaker.R
import com.ebc.cupcakemaker.staticdata.DataSource
import com.ebc.cupcakemaker.view.components.CustomSpacer
import com.ebc.cupcakemaker.view.components.TitleMedium
import com.ebc.cupcakemaker.viewmodel.CupcakeMakerViewModel

@Composable
fun StartOrderScreen(navContoller: NavController,
                     cupcakeMakerViewModel: CupcakeMakerViewModel) {
    //Text(text = "StartOrderScreen")

    var quantityOptions = DataSource.quantityOptions

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomSpacer(height = 100.dp)
            Image(
                painter = painterResource(R.drawable.cupcake),
                contentDescription = stringResource(R.string.sample_cupcake),
                modifier = Modifier.width(300.dp)
            )
            CustomSpacer(height = 16.dp)
            TitleMedium(stringResource(R.string.order_cupcakes))

            CustomSpacer(height = 8.dp)
            TitleMedium(stringResource(R.string.cupcake_price, cupcakeMakerViewModel.state.price))
            CustomSpacer(height = 8.dp)

        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

        }
    }
}