// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: plugin.proto

package io.gideaworx.terraformexporterplugin.grpc;

/**
 * Protobuf type {@code io.gideaworx.tfexportplugin.Version}
 */
public final class Version extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.gideaworx.tfexportplugin.Version)
    VersionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Version.newBuilder() to construct.
  private Version(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Version() {
    pre_ = "";
    buildMetadata_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Version();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_Version_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_Version_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.gideaworx.terraformexporterplugin.grpc.Version.class, io.gideaworx.terraformexporterplugin.grpc.Version.Builder.class);
  }

  private int bitField0_;
  public static final int MAJOR_FIELD_NUMBER = 1;
  private long major_ = 0L;
  /**
   * <code>uint64 Major = 1;</code>
   * @return The major.
   */
  @java.lang.Override
  public long getMajor() {
    return major_;
  }

  public static final int MINOR_FIELD_NUMBER = 2;
  private long minor_ = 0L;
  /**
   * <code>uint64 Minor = 2;</code>
   * @return The minor.
   */
  @java.lang.Override
  public long getMinor() {
    return minor_;
  }

  public static final int PATCH_FIELD_NUMBER = 3;
  private long patch_ = 0L;
  /**
   * <code>uint64 Patch = 3;</code>
   * @return The patch.
   */
  @java.lang.Override
  public long getPatch() {
    return patch_;
  }

  public static final int PRE_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object pre_ = "";
  /**
   * <code>optional string Pre = 4;</code>
   * @return Whether the pre field is set.
   */
  @java.lang.Override
  public boolean hasPre() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string Pre = 4;</code>
   * @return The pre.
   */
  @java.lang.Override
  public java.lang.String getPre() {
    java.lang.Object ref = pre_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      pre_ = s;
      return s;
    }
  }
  /**
   * <code>optional string Pre = 4;</code>
   * @return The bytes for pre.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPreBytes() {
    java.lang.Object ref = pre_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      pre_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BUILDMETADATA_FIELD_NUMBER = 5;
  @SuppressWarnings("serial")
  private volatile java.lang.Object buildMetadata_ = "";
  /**
   * <code>optional string BuildMetadata = 5;</code>
   * @return Whether the buildMetadata field is set.
   */
  @java.lang.Override
  public boolean hasBuildMetadata() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional string BuildMetadata = 5;</code>
   * @return The buildMetadata.
   */
  @java.lang.Override
  public java.lang.String getBuildMetadata() {
    java.lang.Object ref = buildMetadata_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      buildMetadata_ = s;
      return s;
    }
  }
  /**
   * <code>optional string BuildMetadata = 5;</code>
   * @return The bytes for buildMetadata.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBuildMetadataBytes() {
    java.lang.Object ref = buildMetadata_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      buildMetadata_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (major_ != 0L) {
      output.writeUInt64(1, major_);
    }
    if (minor_ != 0L) {
      output.writeUInt64(2, minor_);
    }
    if (patch_ != 0L) {
      output.writeUInt64(3, patch_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, pre_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, buildMetadata_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (major_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, major_);
    }
    if (minor_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, minor_);
    }
    if (patch_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, patch_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, pre_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, buildMetadata_);
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
    if (!(obj instanceof io.gideaworx.terraformexporterplugin.grpc.Version)) {
      return super.equals(obj);
    }
    io.gideaworx.terraformexporterplugin.grpc.Version other = (io.gideaworx.terraformexporterplugin.grpc.Version) obj;

    if (getMajor()
        != other.getMajor()) return false;
    if (getMinor()
        != other.getMinor()) return false;
    if (getPatch()
        != other.getPatch()) return false;
    if (hasPre() != other.hasPre()) return false;
    if (hasPre()) {
      if (!getPre()
          .equals(other.getPre())) return false;
    }
    if (hasBuildMetadata() != other.hasBuildMetadata()) return false;
    if (hasBuildMetadata()) {
      if (!getBuildMetadata()
          .equals(other.getBuildMetadata())) return false;
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
    hash = (37 * hash) + MAJOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMajor());
    hash = (37 * hash) + MINOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMinor());
    hash = (37 * hash) + PATCH_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPatch());
    if (hasPre()) {
      hash = (37 * hash) + PRE_FIELD_NUMBER;
      hash = (53 * hash) + getPre().hashCode();
    }
    if (hasBuildMetadata()) {
      hash = (37 * hash) + BUILDMETADATA_FIELD_NUMBER;
      hash = (53 * hash) + getBuildMetadata().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.Version parseFrom(
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
  public static Builder newBuilder(io.gideaworx.terraformexporterplugin.grpc.Version prototype) {
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
   * Protobuf type {@code io.gideaworx.tfexportplugin.Version}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.gideaworx.tfexportplugin.Version)
      io.gideaworx.terraformexporterplugin.grpc.VersionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_Version_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_Version_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.gideaworx.terraformexporterplugin.grpc.Version.class, io.gideaworx.terraformexporterplugin.grpc.Version.Builder.class);
    }

    // Construct using io.gideaworx.terraformexporterplugin.grpc.Version.newBuilder()
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
      major_ = 0L;
      minor_ = 0L;
      patch_ = 0L;
      pre_ = "";
      buildMetadata_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_Version_descriptor;
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.Version getDefaultInstanceForType() {
      return io.gideaworx.terraformexporterplugin.grpc.Version.getDefaultInstance();
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.Version build() {
      io.gideaworx.terraformexporterplugin.grpc.Version result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.Version buildPartial() {
      io.gideaworx.terraformexporterplugin.grpc.Version result = new io.gideaworx.terraformexporterplugin.grpc.Version(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(io.gideaworx.terraformexporterplugin.grpc.Version result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.major_ = major_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.minor_ = minor_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.patch_ = patch_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.pre_ = pre_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.buildMetadata_ = buildMetadata_;
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof io.gideaworx.terraformexporterplugin.grpc.Version) {
        return mergeFrom((io.gideaworx.terraformexporterplugin.grpc.Version)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.gideaworx.terraformexporterplugin.grpc.Version other) {
      if (other == io.gideaworx.terraformexporterplugin.grpc.Version.getDefaultInstance()) return this;
      if (other.getMajor() != 0L) {
        setMajor(other.getMajor());
      }
      if (other.getMinor() != 0L) {
        setMinor(other.getMinor());
      }
      if (other.getPatch() != 0L) {
        setPatch(other.getPatch());
      }
      if (other.hasPre()) {
        pre_ = other.pre_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      if (other.hasBuildMetadata()) {
        buildMetadata_ = other.buildMetadata_;
        bitField0_ |= 0x00000010;
        onChanged();
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
            case 8: {
              major_ = input.readUInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              minor_ = input.readUInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              patch_ = input.readUInt64();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              pre_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            case 42: {
              buildMetadata_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000010;
              break;
            } // case 42
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

    private long major_ ;
    /**
     * <code>uint64 Major = 1;</code>
     * @return The major.
     */
    @java.lang.Override
    public long getMajor() {
      return major_;
    }
    /**
     * <code>uint64 Major = 1;</code>
     * @param value The major to set.
     * @return This builder for chaining.
     */
    public Builder setMajor(long value) {
      
      major_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 Major = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMajor() {
      bitField0_ = (bitField0_ & ~0x00000001);
      major_ = 0L;
      onChanged();
      return this;
    }

    private long minor_ ;
    /**
     * <code>uint64 Minor = 2;</code>
     * @return The minor.
     */
    @java.lang.Override
    public long getMinor() {
      return minor_;
    }
    /**
     * <code>uint64 Minor = 2;</code>
     * @param value The minor to set.
     * @return This builder for chaining.
     */
    public Builder setMinor(long value) {
      
      minor_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 Minor = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMinor() {
      bitField0_ = (bitField0_ & ~0x00000002);
      minor_ = 0L;
      onChanged();
      return this;
    }

    private long patch_ ;
    /**
     * <code>uint64 Patch = 3;</code>
     * @return The patch.
     */
    @java.lang.Override
    public long getPatch() {
      return patch_;
    }
    /**
     * <code>uint64 Patch = 3;</code>
     * @param value The patch to set.
     * @return This builder for chaining.
     */
    public Builder setPatch(long value) {
      
      patch_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 Patch = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPatch() {
      bitField0_ = (bitField0_ & ~0x00000004);
      patch_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object pre_ = "";
    /**
     * <code>optional string Pre = 4;</code>
     * @return Whether the pre field is set.
     */
    public boolean hasPre() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>optional string Pre = 4;</code>
     * @return The pre.
     */
    public java.lang.String getPre() {
      java.lang.Object ref = pre_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pre_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string Pre = 4;</code>
     * @return The bytes for pre.
     */
    public com.google.protobuf.ByteString
        getPreBytes() {
      java.lang.Object ref = pre_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pre_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string Pre = 4;</code>
     * @param value The pre to set.
     * @return This builder for chaining.
     */
    public Builder setPre(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      pre_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>optional string Pre = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPre() {
      pre_ = getDefaultInstance().getPre();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>optional string Pre = 4;</code>
     * @param value The bytes for pre to set.
     * @return This builder for chaining.
     */
    public Builder setPreBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      pre_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    private java.lang.Object buildMetadata_ = "";
    /**
     * <code>optional string BuildMetadata = 5;</code>
     * @return Whether the buildMetadata field is set.
     */
    public boolean hasBuildMetadata() {
      return ((bitField0_ & 0x00000010) != 0);
    }
    /**
     * <code>optional string BuildMetadata = 5;</code>
     * @return The buildMetadata.
     */
    public java.lang.String getBuildMetadata() {
      java.lang.Object ref = buildMetadata_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        buildMetadata_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string BuildMetadata = 5;</code>
     * @return The bytes for buildMetadata.
     */
    public com.google.protobuf.ByteString
        getBuildMetadataBytes() {
      java.lang.Object ref = buildMetadata_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        buildMetadata_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string BuildMetadata = 5;</code>
     * @param value The buildMetadata to set.
     * @return This builder for chaining.
     */
    public Builder setBuildMetadata(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      buildMetadata_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>optional string BuildMetadata = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearBuildMetadata() {
      buildMetadata_ = getDefaultInstance().getBuildMetadata();
      bitField0_ = (bitField0_ & ~0x00000010);
      onChanged();
      return this;
    }
    /**
     * <code>optional string BuildMetadata = 5;</code>
     * @param value The bytes for buildMetadata to set.
     * @return This builder for chaining.
     */
    public Builder setBuildMetadataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      buildMetadata_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:io.gideaworx.tfexportplugin.Version)
  }

  // @@protoc_insertion_point(class_scope:io.gideaworx.tfexportplugin.Version)
  private static final io.gideaworx.terraformexporterplugin.grpc.Version DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.gideaworx.terraformexporterplugin.grpc.Version();
  }

  public static io.gideaworx.terraformexporterplugin.grpc.Version getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Version>
      PARSER = new com.google.protobuf.AbstractParser<Version>() {
    @java.lang.Override
    public Version parsePartialFrom(
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

  public static com.google.protobuf.Parser<Version> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Version> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.gideaworx.terraformexporterplugin.grpc.Version getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

