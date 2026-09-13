package save

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

val json = Json {
    prettyPrint = false
    encodeDefaults = false
    ignoreUnknownKeys = true      // tolerate forward-compatible changes
    classDiscriminator = "type"   // makes polymorphic sealed classes include "type":"door" etc.
    serializersModule = SerializersModule {
        // If you ever need custom polymorphic registrations, add them here.
    }
}