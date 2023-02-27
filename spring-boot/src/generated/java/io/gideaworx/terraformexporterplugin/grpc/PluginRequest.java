// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: plugin.proto

package io.gideaworx.terraformexporterplugin.grpc;

/**
 * Protobuf type {@code io.gideaworx.tfexportplugin.PluginRequest}
 */
public final class PluginRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.gideaworx.tfexportplugin.PluginRequest)
    PluginRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PluginRequest.newBuilder() to construct.
  private PluginRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PluginRequest() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PluginRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_PluginRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_PluginRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.gideaworx.terraformexporterplugin.grpc.PluginRequest.class, io.gideaworx.terraformexporterplugin.grpc.PluginRequest.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   * <code>string Name = 1;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string Name = 1;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REQUEST_FIELD_NUMBER = 2;
  private io.gideaworx.terraformexporterplugin.grpc.ExportRequest request_;
  /**
   * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
   * @return Whether the request field is set.
   */
  @java.lang.Override
  public boolean hasRequest() {
    return request_ != null;
  }
  /**
   * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
   * @return The request.
   */
  @java.lang.Override
  public io.gideaworx.terraformexporterplugin.grpc.ExportRequest getRequest() {
    return request_ == null ? io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance() : request_;
  }
  /**
   * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
   */
  @java.lang.Override
  public io.gideaworx.terraformexporterplugin.grpc.ExportRequestOrBuilder getRequestOrBuilder() {
    return request_ == null ? io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance() : request_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (request_ != null) {
      output.writeMessage(2, getRequest());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (request_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getRequest());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.gideaworx.terraformexporterplugin.grpc.PluginRequest)) {
      return super.equals(obj);
    }
    io.gideaworx.terraformexporterplugin.grpc.PluginRequest other = (io.gideaworx.terraformexporterplugin.grpc.PluginRequest) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (hasRequest() != other.hasRequest()) return false;
    if (hasRequest()) {
      if (!getRequest()
          .equals(other.getRequest())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    if (hasRequest()) {
      hash = (37 * hash) + REQUEST_FIELD_NUMBER;
      hash = (53 * hash) + getRequest().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.gideaworx.terraformexporterplugin.grpc.PluginRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code io.gideaworx.tfexportplugin.PluginRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.gideaworx.tfexportplugin.PluginRequest)
      io.gideaworx.terraformexporterplugin.grpc.PluginRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_PluginRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_PluginRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.gideaworx.terraformexporterplugin.grpc.PluginRequest.class, io.gideaworx.terraformexporterplugin.grpc.PluginRequest.Builder.class);
    }

    // Construct using io.gideaworx.terraformexporterplugin.grpc.PluginRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      name_ = "";
      request_ = null;
      if (requestBuilder_ != null) {
        requestBuilder_.dispose();
        requestBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_PluginRequest_descriptor;
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.PluginRequest getDefaultInstanceForType() {
      return io.gideaworx.terraformexporterplugin.grpc.PluginRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.PluginRequest build() {
      io.gideaworx.terraformexporterplugin.grpc.PluginRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.PluginRequest buildPartial() {
      io.gideaworx.terraformexporterplugin.grpc.PluginRequest result = new io.gideaworx.terraformexporterplugin.grpc.PluginRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(io.gideaworx.terraformexporterplugin.grpc.PluginRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.name_ = name_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.request_ = requestBuilder_ == null
            ? request_
            : requestBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.gideaworx.terraformexporterplugin.grpc.PluginRequest) {
        return mergeFrom((io.gideaworx.terraformexporterplugin.grpc.PluginRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.gideaworx.terraformexporterplugin.grpc.PluginRequest other) {
      if (other == io.gideaworx.terraformexporterplugin.grpc.PluginRequest.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasRequest()) {
        mergeRequest(other.getRequest());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              name_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getRequestFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <code>string Name = 1;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string Name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string Name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private io.gideaworx.terraformexporterplugin.grpc.ExportRequest request_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.gideaworx.terraformexporterplugin.grpc.ExportRequest, io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder, io.gideaworx.terraformexporterplugin.grpc.ExportRequestOrBuilder> requestBuilder_;
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     * @return Whether the request field is set.
     */
    public boolean hasRequest() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     * @return The request.
     */
    public io.gideaworx.terraformexporterplugin.grpc.ExportRequest getRequest() {
      if (requestBuilder_ == null) {
        return request_ == null ? io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance() : request_;
      } else {
        return requestBuilder_.getMessage();
      }
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    public Builder setRequest(io.gideaworx.terraformexporterplugin.grpc.ExportRequest value) {
      if (requestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        request_ = value;
      } else {
        requestBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    public Builder setRequest(
        io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder builderForValue) {
      if (requestBuilder_ == null) {
        request_ = builderForValue.build();
      } else {
        requestBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    public Builder mergeRequest(io.gideaworx.terraformexporterplugin.grpc.ExportRequest value) {
      if (requestBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          request_ != null &&
          request_ != io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance()) {
          getRequestBuilder().mergeFrom(value);
        } else {
          request_ = value;
        }
      } else {
        requestBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    public Builder clearRequest() {
      bitField0_ = (bitField0_ & ~0x00000002);
      request_ = null;
      if (requestBuilder_ != null) {
        requestBuilder_.dispose();
        requestBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    public io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder getRequestBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    public io.gideaworx.terraformexporterplugin.grpc.ExportRequestOrBuilder getRequestOrBuilder() {
      if (requestBuilder_ != null) {
        return requestBuilder_.getMessageOrBuilder();
      } else {
        return request_ == null ?
            io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance() : request_;
      }
    }
    /**
     * <code>.io.gideaworx.tfexportplugin.ExportRequest Request = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.gideaworx.terraformexporterplugin.grpc.ExportRequest, io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder, io.gideaworx.terraformexporterplugin.grpc.ExportRequestOrBuilder> 
        getRequestFieldBuilder() {
      if (requestBuilder_ == null) {
        requestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.gideaworx.terraformexporterplugin.grpc.ExportRequest, io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder, io.gideaworx.terraformexporterplugin.grpc.ExportRequestOrBuilder>(
                getRequest(),
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      return requestBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:io.gideaworx.tfexportplugin.PluginRequest)
  }

  // @@protoc_insertion_point(class_scope:io.gideaworx.tfexportplugin.PluginRequest)
  private static final io.gideaworx.terraformexporterplugin.grpc.PluginRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.gideaworx.terraformexporterplugin.grpc.PluginRequest();
  }

  public static io.gideaworx.terraformexporterplugin.grpc.PluginRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PluginRequest>
      PARSER = new com.google.protobuf.AbstractParser<PluginRequest>() {
    @java.lang.Override
    public PluginRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<PluginRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PluginRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.gideaworx.terraformexporterplugin.grpc.PluginRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

