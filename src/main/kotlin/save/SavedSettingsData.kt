package save

import kotlinx.serialization.Serializable

@Serializable
data class SavedSettingsData(
    var screenScale: Double = 1.0
)