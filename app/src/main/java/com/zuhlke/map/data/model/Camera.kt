package com.zuhlke.map.data.model

data class Camera(
    val camera_id: String,
    val image: String,
    val image_metadata: ImageMetadata,
    val location: Location,
    val timestamp: String
)