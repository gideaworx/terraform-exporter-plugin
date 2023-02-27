// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: plugin.proto

package io.gideaworx.terraformexporterplugin.grpc;

/**
 * Protobuf type {@code io.gideaworx.tfexportplugin.ExportRequest}
 */
public final class ExportRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.gideaworx.tfexportplugin.ExportRequest)
    ExportRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExportRequest.newBuilder() to construct.
  private ExportRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExportRequest() {
    outputDirectory_ = "";
    pluginArgs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExportRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_ExportRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_ExportRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.gideaworx.terraformexporterplugin.grpc.ExportRequest.class, io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder.class);
  }

  public static final int OUTPUTDIRECTORY_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object outputDirectory_ = "";
  /**
   * <code>string OutputDirectory = 1;</code>
   * @return The outputDirectory.
   */
  @java.lang.Override
  public java.lang.String getOutputDirectory() {
    java.lang.Object ref = outputDirectory_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      outputDirectory_ = s;
      return s;
    }
  }
  /**
   * <code>string OutputDirectory = 1;</code>
   * @return The bytes for outputDirectory.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOutputDirectoryBytes() {
    java.lang.Object ref = outputDirectory_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      outputDirectory_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SKIPPROVIDEROUTPUT_FIELD_NUMBER = 2;
  private boolean skipProviderOutput_ = false;
  /**
   * <code>bool SkipProviderOutput = 2;</code>
   * @return The skipProviderOutput.
   */
  @java.lang.Override
  public boolean getSkipProviderOutput() {
    return skipProviderOutput_;
  }

  public static final int PLUGINARGS_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringList pluginArgs_;
  /**
   * <code>repeated string PluginArgs = 3;</code>
   * @return A list containing the pluginArgs.
   */
  public com.google.protobuf.ProtocolStringList
      getPluginArgsList() {
    return pluginArgs_;
  }
  /**
   * <code>repeated string PluginArgs = 3;</code>
   * @return The count of pluginArgs.
   */
  public int getPluginArgsCount() {
    return pluginArgs_.size();
  }
  /**
   * <code>repeated string PluginArgs = 3;</code>
   * @param index The index of the element to return.
   * @return The pluginArgs at the given index.
   */
  public java.lang.String getPluginArgs(int index) {
    return pluginArgs_.get(index);
  }
  /**
   * <code>repeated string PluginArgs = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the pluginArgs at the given index.
   */
  public com.google.protobuf.ByteString
      getPluginArgsBytes(int index) {
    return pluginArgs_.getByteString(index);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(outputDirectory_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, outputDirectory_);
    }
    if (skipProviderOutput_ != false) {
      output.writeBool(2, skipProviderOutput_);
    }
    for (int i = 0; i < pluginArgs_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, pluginArgs_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(outputDirectory_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, outputDirectory_);
    }
    if (skipProviderOutput_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, skipProviderOutput_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < pluginArgs_.size(); i++) {
        dataSize += computeStringSizeNoTag(pluginArgs_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getPluginArgsList().size();
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
    if (!(obj instanceof io.gideaworx.terraformexporterplugin.grpc.ExportRequest)) {
      return super.equals(obj);
    }
    io.gideaworx.terraformexporterplugin.grpc.ExportRequest other = (io.gideaworx.terraformexporterplugin.grpc.ExportRequest) obj;

    if (!getOutputDirectory()
        .equals(other.getOutputDirectory())) return false;
    if (getSkipProviderOutput()
        != other.getSkipProviderOutput()) return false;
    if (!getPluginArgsList()
        .equals(other.getPluginArgsList())) return false;
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
    hash = (37 * hash) + OUTPUTDIRECTORY_FIELD_NUMBER;
    hash = (53 * hash) + getOutputDirectory().hashCode();
    hash = (37 * hash) + SKIPPROVIDEROUTPUT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSkipProviderOutput());
    if (getPluginArgsCount() > 0) {
      hash = (37 * hash) + PLUGINARGS_FIELD_NUMBER;
      hash = (53 * hash) + getPluginArgsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest parseFrom(
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
  public static Builder newBuilder(io.gideaworx.terraformexporterplugin.grpc.ExportRequest prototype) {
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
   * Protobuf type {@code io.gideaworx.tfexportplugin.ExportRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.gideaworx.tfexportplugin.ExportRequest)
      io.gideaworx.terraformexporterplugin.grpc.ExportRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_ExportRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_ExportRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.gideaworx.terraformexporterplugin.grpc.ExportRequest.class, io.gideaworx.terraformexporterplugin.grpc.ExportRequest.Builder.class);
    }

    // Construct using io.gideaworx.terraformexporterplugin.grpc.ExportRequest.newBuilder()
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
      outputDirectory_ = "";
      skipProviderOutput_ = false;
      pluginArgs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.gideaworx.terraformexporterplugin.grpc.Plugin.internal_static_io_gideaworx_tfexportplugin_ExportRequest_descriptor;
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.ExportRequest getDefaultInstanceForType() {
      return io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.ExportRequest build() {
      io.gideaworx.terraformexporterplugin.grpc.ExportRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.gideaworx.terraformexporterplugin.grpc.ExportRequest buildPartial() {
      io.gideaworx.terraformexporterplugin.grpc.ExportRequest result = new io.gideaworx.terraformexporterplugin.grpc.ExportRequest(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(io.gideaworx.terraformexporterplugin.grpc.ExportRequest result) {
      if (((bitField0_ & 0x00000004) != 0)) {
        pluginArgs_ = pluginArgs_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.pluginArgs_ = pluginArgs_;
    }

    private void buildPartial0(io.gideaworx.terraformexporterplugin.grpc.ExportRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.outputDirectory_ = outputDirectory_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.skipProviderOutput_ = skipProviderOutput_;
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
      if (other instanceof io.gideaworx.terraformexporterplugin.grpc.ExportRequest) {
        return mergeFrom((io.gideaworx.terraformexporterplugin.grpc.ExportRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.gideaworx.terraformexporterplugin.grpc.ExportRequest other) {
      if (other == io.gideaworx.terraformexporterplugin.grpc.ExportRequest.getDefaultInstance()) return this;
      if (!other.getOutputDirectory().isEmpty()) {
        outputDirectory_ = other.outputDirectory_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getSkipProviderOutput() != false) {
        setSkipProviderOutput(other.getSkipProviderOutput());
      }
      if (!other.pluginArgs_.isEmpty()) {
        if (pluginArgs_.isEmpty()) {
          pluginArgs_ = other.pluginArgs_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensurePluginArgsIsMutable();
          pluginArgs_.addAll(other.pluginArgs_);
        }
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
            case 10: {
              outputDirectory_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              skipProviderOutput_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();
              ensurePluginArgsIsMutable();
              pluginArgs_.add(s);
              break;
            } // case 26
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

    private java.lang.Object outputDirectory_ = "";
    /**
     * <code>string OutputDirectory = 1;</code>
     * @return The outputDirectory.
     */
    public java.lang.String getOutputDirectory() {
      java.lang.Object ref = outputDirectory_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        outputDirectory_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string OutputDirectory = 1;</code>
     * @return The bytes for outputDirectory.
     */
    public com.google.protobuf.ByteString
        getOutputDirectoryBytes() {
      java.lang.Object ref = outputDirectory_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        outputDirectory_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string OutputDirectory = 1;</code>
     * @param value The outputDirectory to set.
     * @return This builder for chaining.
     */
    public Builder setOutputDirectory(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      outputDirectory_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string OutputDirectory = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearOutputDirectory() {
      outputDirectory_ = getDefaultInstance().getOutputDirectory();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string OutputDirectory = 1;</code>
     * @param value The bytes for outputDirectory to set.
     * @return This builder for chaining.
     */
    public Builder setOutputDirectoryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      outputDirectory_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private boolean skipProviderOutput_ ;
    /**
     * <code>bool SkipProviderOutput = 2;</code>
     * @return The skipProviderOutput.
     */
    @java.lang.Override
    public boolean getSkipProviderOutput() {
      return skipProviderOutput_;
    }
    /**
     * <code>bool SkipProviderOutput = 2;</code>
     * @param value The skipProviderOutput to set.
     * @return This builder for chaining.
     */
    public Builder setSkipProviderOutput(boolean value) {
      
      skipProviderOutput_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool SkipProviderOutput = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSkipProviderOutput() {
      bitField0_ = (bitField0_ & ~0x00000002);
      skipProviderOutput_ = false;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList pluginArgs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensurePluginArgsIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        pluginArgs_ = new com.google.protobuf.LazyStringArrayList(pluginArgs_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @return A list containing the pluginArgs.
     */
    public com.google.protobuf.ProtocolStringList
        getPluginArgsList() {
      return pluginArgs_.getUnmodifiableView();
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @return The count of pluginArgs.
     */
    public int getPluginArgsCount() {
      return pluginArgs_.size();
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @param index The index of the element to return.
     * @return The pluginArgs at the given index.
     */
    public java.lang.String getPluginArgs(int index) {
      return pluginArgs_.get(index);
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the pluginArgs at the given index.
     */
    public com.google.protobuf.ByteString
        getPluginArgsBytes(int index) {
      return pluginArgs_.getByteString(index);
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @param index The index to set the value at.
     * @param value The pluginArgs to set.
     * @return This builder for chaining.
     */
    public Builder setPluginArgs(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensurePluginArgsIsMutable();
      pluginArgs_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @param value The pluginArgs to add.
     * @return This builder for chaining.
     */
    public Builder addPluginArgs(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensurePluginArgsIsMutable();
      pluginArgs_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @param values The pluginArgs to add.
     * @return This builder for chaining.
     */
    public Builder addAllPluginArgs(
        java.lang.Iterable<java.lang.String> values) {
      ensurePluginArgsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, pluginArgs_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPluginArgs() {
      pluginArgs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string PluginArgs = 3;</code>
     * @param value The bytes of the pluginArgs to add.
     * @return This builder for chaining.
     */
    public Builder addPluginArgsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensurePluginArgsIsMutable();
      pluginArgs_.add(value);
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


    // @@protoc_insertion_point(builder_scope:io.gideaworx.tfexportplugin.ExportRequest)
  }

  // @@protoc_insertion_point(class_scope:io.gideaworx.tfexportplugin.ExportRequest)
  private static final io.gideaworx.terraformexporterplugin.grpc.ExportRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.gideaworx.terraformexporterplugin.grpc.ExportRequest();
  }

  public static io.gideaworx.terraformexporterplugin.grpc.ExportRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExportRequest>
      PARSER = new com.google.protobuf.AbstractParser<ExportRequest>() {
    @java.lang.Override
    public ExportRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<ExportRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExportRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.gideaworx.terraformexporterplugin.grpc.ExportRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

