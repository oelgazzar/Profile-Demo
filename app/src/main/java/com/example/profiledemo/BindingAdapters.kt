package com.example.profiledemo

import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import io.getstream.avatarview.AvatarView
import io.getstream.avatarview.coil.loadImage
import kotlin.math.min


@BindingAdapter("roundedImage")
fun ImageView.setRoundedImage(image: Drawable) {
    var srcBitmap = image.toBitmap(200, 200)

//    val width = 100
//    val height = (100f*srcBitmap.height/srcBitmap.width).toInt()

    val width = srcBitmap.width
    val height = srcBitmap.height
    val outBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

    val canvas = Canvas(outBitmap)
    val path = Path()
    path.addCircle(
        width / 2f,
        height / 2f,
        min(width, height) / 2f,
        Path.Direction.CCW
    )

    canvas.clipPath(path)
    canvas.drawBitmap(
        srcBitmap,
        Rect(0, 0, width, height),
        Rect(0, 0, width, height),
        null
    )

    setImageBitmap(outBitmap)
}

@BindingAdapter("image")
fun AvatarView.setImage(image: Drawable) {
    loadImage(image)
}
