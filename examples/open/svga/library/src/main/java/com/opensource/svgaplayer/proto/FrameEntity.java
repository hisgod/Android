// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: svga.proto at 115:1
package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

import java.io.IOException;
import java.util.List;

import okio.ByteString;

public final class FrameEntity extends Message<FrameEntity, FrameEntity.Builder> {
  public static final ProtoAdapter<FrameEntity> ADAPTER = new ProtoAdapter_FrameEntity();

  private static final long serialVersionUID = 0L;

  public static final Float DEFAULT_ALPHA = 0.0f;

  public static final String DEFAULT_CLIPPATH = "";

  /**
   * 透明度
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#FLOAT"
  )
  public final Float alpha;

  /**
   * 初始约束大小
   */
  @WireField(
      tag = 2,
      adapter = "com.opensource.svgaplayer.proto.Layout#ADAPTER"
  )
  public final Layout layout;

  /**
   * 2D 变换矩阵
   */
  @WireField(
      tag = 3,
      adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER"
  )
  public final Transform transform;

  /**
   * 遮罩路径，使用 SVG 标准 Path 绘制图案进行 Mask 遮罩。
   */
  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String clipPath;

  /**
   * 矢量元素列表
   */
  @WireField(
      tag = 5,
      adapter = "com.opensource.svgaplayer.proto.ShapeEntity#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<ShapeEntity> shapes;

  public FrameEntity(Float alpha, Layout layout, Transform transform, String clipPath, List<ShapeEntity> shapes) {
    this(alpha, layout, transform, clipPath, shapes, ByteString.EMPTY);
  }

  public FrameEntity(Float alpha, Layout layout, Transform transform, String clipPath, List<ShapeEntity> shapes, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.alpha = alpha;
    this.layout = layout;
    this.transform = transform;
    this.clipPath = clipPath;
    this.shapes = Internal.immutableCopyOf("shapes", shapes);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.alpha = alpha;
    builder.layout = layout;
    builder.transform = transform;
    builder.clipPath = clipPath;
    builder.shapes = Internal.copyOf("shapes", shapes);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof FrameEntity)) return false;
    FrameEntity o = (FrameEntity) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(alpha, o.alpha)
        && Internal.equals(layout, o.layout)
        && Internal.equals(transform, o.transform)
        && Internal.equals(clipPath, o.clipPath)
        && shapes.equals(o.shapes);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (alpha != null ? alpha.hashCode() : 0);
      result = result * 37 + (layout != null ? layout.hashCode() : 0);
      result = result * 37 + (transform != null ? transform.hashCode() : 0);
      result = result * 37 + (clipPath != null ? clipPath.hashCode() : 0);
      result = result * 37 + shapes.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (alpha != null) builder.append(", alpha=").append(alpha);
    if (layout != null) builder.append(", layout=").append(layout);
    if (transform != null) builder.append(", transform=").append(transform);
    if (clipPath != null) builder.append(", clipPath=").append(clipPath);
    if (!shapes.isEmpty()) builder.append(", shapes=").append(shapes);
    return builder.replace(0, 2, "FrameEntity{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<FrameEntity, Builder> {
    public Float alpha;

    public Layout layout;

    public Transform transform;

    public String clipPath;

    public List<ShapeEntity> shapes;

    public Builder() {
      shapes = Internal.newMutableList();
    }

    /**
     * 透明度
     */
    public Builder alpha(Float alpha) {
      this.alpha = alpha;
      return this;
    }

    /**
     * 初始约束大小
     */
    public Builder layout(Layout layout) {
      this.layout = layout;
      return this;
    }

    /**
     * 2D 变换矩阵
     */
    public Builder transform(Transform transform) {
      this.transform = transform;
      return this;
    }

    /**
     * 遮罩路径，使用 SVG 标准 Path 绘制图案进行 Mask 遮罩。
     */
    public Builder clipPath(String clipPath) {
      this.clipPath = clipPath;
      return this;
    }

    /**
     * 矢量元素列表
     */
    public Builder shapes(List<ShapeEntity> shapes) {
      Internal.checkElementsNotNull(shapes);
      this.shapes = shapes;
      return this;
    }

    @Override
    public FrameEntity build() {
      return new FrameEntity(alpha, layout, transform, clipPath, shapes, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_FrameEntity extends ProtoAdapter<FrameEntity> {
    ProtoAdapter_FrameEntity() {
      super(FieldEncoding.LENGTH_DELIMITED, FrameEntity.class);
    }

    @Override
    public int encodedSize(FrameEntity value) {
      return (value.alpha != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, value.alpha) : 0)
          + (value.layout != null ? Layout.ADAPTER.encodedSizeWithTag(2, value.layout) : 0)
          + (value.transform != null ? Transform.ADAPTER.encodedSizeWithTag(3, value.transform) : 0)
          + (value.clipPath != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value.clipPath) : 0)
          + ShapeEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, value.shapes)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, FrameEntity value) throws IOException {
      if (value.alpha != null) ProtoAdapter.FLOAT.encodeWithTag(writer, 1, value.alpha);
      if (value.layout != null) Layout.ADAPTER.encodeWithTag(writer, 2, value.layout);
      if (value.transform != null) Transform.ADAPTER.encodeWithTag(writer, 3, value.transform);
      if (value.clipPath != null) ProtoAdapter.STRING.encodeWithTag(writer, 4, value.clipPath);
      ShapeEntity.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.shapes);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public FrameEntity decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.alpha(ProtoAdapter.FLOAT.decode(reader)); break;
          case 2: builder.layout(Layout.ADAPTER.decode(reader)); break;
          case 3: builder.transform(Transform.ADAPTER.decode(reader)); break;
          case 4: builder.clipPath(ProtoAdapter.STRING.decode(reader)); break;
          case 5: builder.shapes.add(ShapeEntity.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public FrameEntity redact(FrameEntity value) {
      Builder builder = value.newBuilder();
      if (builder.layout != null) builder.layout = Layout.ADAPTER.redact(builder.layout);
      if (builder.transform != null) builder.transform = Transform.ADAPTER.redact(builder.transform);
      Internal.redactElements(builder.shapes, ShapeEntity.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
