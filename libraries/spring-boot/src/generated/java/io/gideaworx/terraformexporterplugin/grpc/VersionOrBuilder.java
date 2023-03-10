// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: plugin.proto

package io.gideaworx.terraformexporterplugin.grpc;

public interface VersionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.gideaworx.tfexportplugin.Version)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 Major = 1;</code>
   * @return The major.
   */
  long getMajor();

  /**
   * <code>uint64 Minor = 2;</code>
   * @return The minor.
   */
  long getMinor();

  /**
   * <code>uint64 Patch = 3;</code>
   * @return The patch.
   */
  long getPatch();

  /**
   * <code>optional string Pre = 4;</code>
   * @return Whether the pre field is set.
   */
  boolean hasPre();
  /**
   * <code>optional string Pre = 4;</code>
   * @return The pre.
   */
  java.lang.String getPre();
  /**
   * <code>optional string Pre = 4;</code>
   * @return The bytes for pre.
   */
  com.google.protobuf.ByteString
      getPreBytes();

  /**
   * <code>optional string BuildMetadata = 5;</code>
   * @return Whether the buildMetadata field is set.
   */
  boolean hasBuildMetadata();
  /**
   * <code>optional string BuildMetadata = 5;</code>
   * @return The buildMetadata.
   */
  java.lang.String getBuildMetadata();
  /**
   * <code>optional string BuildMetadata = 5;</code>
   * @return The bytes for buildMetadata.
   */
  com.google.protobuf.ByteString
      getBuildMetadataBytes();
}
