package com.opensource.svgaplayer

import android.widget.ImageView
import coil.decode.DecodeUtils
import coil.request.ImageRequest
import coil.request.Parameters
import okio.BufferedSource

fun Parameters.svgaRepeatCount(): Int? = value(SVGADecoder.REPEAT_COUNT_KEY)

fun ImageRequest.Builder.svgaRepeatCount(repeatCount: Int): ImageRequest.Builder {
    return setParameter(SVGADecoder.REPEAT_COUNT_KEY, repeatCount)
}

fun ImageRequest.Builder.onSvgaAnimationStart(callback: (() -> Unit)?): ImageRequest.Builder {
    return setParameter(SVGADecoder.ANIMATION_START_CALLBACK_KEY, callback)
}

fun Parameters.svgaAnimationStartCallback(): (() -> Unit)? =
    value(SVGADecoder.ANIMATION_END_CALLBACK_KEY)

fun ImageRequest.Builder.onSvgaAnimationEnd(callback: (() -> Unit)?): ImageRequest.Builder {
    return setParameter(SVGADecoder.ANIMATION_END_CALLBACK_KEY, callback)
}

fun Parameters.svgaAnimationEndCallback(): (() -> Unit)? =
    value(SVGADecoder.ANIMATION_END_CALLBACK_KEY)

fun ImageRequest.Builder.onSvgaAnimationFrame(callback: ((frame: Int) -> Unit)?): ImageRequest.Builder {
    return setParameter(SVGADecoder.ANIMATION_FRAME_CALLBACK_KEY, callback)
}

fun Parameters.svgaAnimationFrameCallback(): ((frame: Int) -> Unit)? =
    value(SVGADecoder.ANIMATION_FRAME_CALLBACK_KEY)

fun Parameters.svgaFlip(): Boolean? = value(SVGADecoder.FLIP_KEY)

fun ImageRequest.Builder.svgaFlip(value: Boolean): ImageRequest.Builder {
    return setParameter(SVGADecoder.FLIP_KEY, value)
}

//fun Parameters.svgaResume(): ((value: Int) -> Unit)? = value(SVGADecoder.RESUME_KEY)
//
//fun ImageRequest.Builder.svgaResume(value: (frame: Int) -> Unit): ImageRequest.Builder {
//    return setParameter(SVGADecoder.FLIP_KEY, value)
//}