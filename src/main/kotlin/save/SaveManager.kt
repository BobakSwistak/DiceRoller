package save

import kotlinx.serialization.encodeToString
import java.io.File

object SaveManager {
    private val settingsFile = File("settings.json")
    
    var currentSaveSettingsData = SavedSettingsData()
    
    fun saveSettings() {
        val text = json.encodeToString(currentSaveSettingsData)
        settingsFile.writeText(text)
    }
    
    fun loadSettings() {
        if (!settingsFile.exists()) return
        val text = settingsFile.readText()
        currentSaveSettingsData = json.decodeFromString<SavedSettingsData>(text)
    }
}