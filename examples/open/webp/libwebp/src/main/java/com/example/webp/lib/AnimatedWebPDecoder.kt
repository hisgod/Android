package com.example.webp.lib

import android.util.Log
import coil.ImageLoader
import coil.decode.DecodeResult
import coil.decode.Decoder
import coil.fetch.SourceResult
import coil.request.Options
import java.nio.ByteBuffer

class AnimatedWebPDecoder(
    private val result: SourceResult,
    private val options: Options,
    private val imageLoader: ImageLoader
) : Decoder {
    override suspend fun decode(): DecodeResult? {
        val bytes = result.source.source().readByteArray()
        val key = bytes.contentHashCode().toString()
        if (key.isNullOrEmpty()) {
            throw Exception("缓存Key获取失败")
        }
        Log.e("HLP", key)
        val byteBuffer = ByteBuffer.allocateDirect(bytes.size).put(bytes)
        val decoder = LibWebPAnimatedDecoder.create(key, byteBuffer, options.premultipliedAlpha)
        val drawable = AnimatedWebPDrawable(decoder, key, imageLoader)
        return DecodeResult(drawable, false)
    }

    class Factory : Decoder.Factory {
        override fun create(
            result: SourceResult,
            options: Options,
            imageLoader: ImageLoader
        ): Decoder? {
            //如果不是webp动图就返回null
            if (!DecodeUtils.isAnimatedWebP(result.source.source())) {
                return null
            }
            return AnimatedWebPDecoder(result, options, imageLoader)
        }

        override fun equals(other: Any?) = other is Factory

        override fun hashCode() = javaClass.hashCode()
    }
}