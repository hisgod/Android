package com.opensource.svgaplayer

import coil.ImageLoader
import coil.decode.DecodeResult
import coil.decode.Decoder
import coil.fetch.SourceResult
import coil.request.Options
import com.opensource.svgaplayer.proto.MovieEntity
import com.opensource.svgaplayer.utils.convertSVGA
import com.opensource.svgaplayer.utils.log.LogUtils
import okio.BufferedSource

class SVGADecoder(
    private val array: ByteArray,
    private val options: Options,
    private val imageLoader: ImageLoader
) : Decoder {
    private val TAG = javaClass.simpleName

    override suspend fun decode(): DecodeResult {
        val hashCode = array.contentHashCode().toString()
        LogUtils.error(TAG, "解析HashCode：${hashCode}")
//        val movieEntity = MovieEntityFactory.getMovieEntity(hashCode, array)

        val movieEntity = MovieEntity.ADAPTER.decode(array)
        val entity = SVGAVideoEntity(hashCode, options, imageLoader, movieEntity)
        val drawable = SVGADrawable(hashCode, entity, options, imageLoader)

//        withContext(Dispatchers.Main) {
//            val lifecycle = options.context.getLifecycle() ?: SVGALifecycle
//            lifecycle.addObserver(SVGAAudioManager)
//        }

//        withContext(Dispatchers.Main) {
//            val lifecycle = options.context.getLifecycle() ?: SVGALifecycle
//            lifecycle.addObserver(SVGAAudioManager)
//            lifecycle.addObserver(MovieEntityFactory)
//        }
        return DecodeResult(drawable, false)
    }

    class Factory : Decoder.Factory {
        override fun create(
            result: SourceResult,
            options: Options,
            imageLoader: ImageLoader
        ): Decoder? {
            //不加判断，导致普通图片加载失败
            if (!isSVGA(result.source.source())) {
                return null
            }
            return try {
                val convertByte = result.source.source().readByteArray().convertSVGA()
                SVGADecoder(convertByte, options, imageLoader)
            } catch (e: Exception) {
                null
            }
        }

        override fun equals(other: Any?) = other is Factory

        override fun hashCode() = javaClass.hashCode()

        private fun isSVGA(source: BufferedSource): Boolean {
            return source.buffer[0].toInt() == 120 && source.buffer[1].toInt() == -100
        }
    }

    companion object {
        const val REPEAT_COUNT_KEY = "svga#repeatCount"
        const val SVGA_RTL = "svga#rtl"
        const val SVGA_DYNAMIC = "svga#dynamic"
        const val ANIMATION_START_CALLBACK_KEY = "svga#animation_start_callback"
        const val ANIMATION_END_CALLBACK_KEY = "svga#animation_end_callback"
        const val ANIMATION_FRAME_CALLBACK_KEY = "svga#animation_frame_callback"
        const val ANIMATION_REPEAT_CALLBACK_KEY = "svga#animation_repeat_callback"
    }
}