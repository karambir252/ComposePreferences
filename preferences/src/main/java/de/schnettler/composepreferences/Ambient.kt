package de.schnettler.composepreferences

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableAmbient
import androidx.compose.runtime.Providers
import androidx.compose.runtime.ambientOf
import com.tfcporciuncula.flow.FlowSharedPreferences

val PreferenceAmbient: ProvidableAmbient<FlowSharedPreferences> =
    ambientOf { error("No preferences found") }

@Composable
fun ProvidePreferences(
    sharedPreferences: FlowSharedPreferences,
    content: @Composable () -> Unit
) {
    Providers(PreferenceAmbient provides sharedPreferences) {
        content()
    }
}