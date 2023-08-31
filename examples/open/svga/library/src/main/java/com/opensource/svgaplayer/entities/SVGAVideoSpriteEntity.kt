package com.opensource.svgaplayer.entities

import com.opensource.svgaplayer.proto.SpriteEntity
import org.json.JSONObject

/**
 * Created by cuiminghui on 2016/10/17.
 */
internal class SVGAVideoSpriteEntity {

    val imageKey: String?

    val matteKey: String?

    val frames: List<SVGAVideoSpriteFrameEntity>

    constructor(obj: SpriteEntity) {
        this.imageKey = obj.imageKey
        this.matteKey = obj.matteKey
        var lastFrame: SVGAVideoSpriteFrameEntity? = null
        frames = obj.frames?.map {
            val frameItem = SVGAVideoSpriteFrameEntity(it)
            if (frameItem.shapes.isNotEmpty()) {
                frameItem.shapes.first().let {
                    if (it.isKeep) {
                        lastFrame?.let {
                            frameItem.shapes = it.shapes
                        }
                    }
                }
            }
            lastFrame = frameItem
            return@map frameItem
        } ?: listOf()

    }

}
