// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.28.1
// 	protoc        v3.21.12
// source: plugin.proto

package proto

import (
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

type ExportRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	OutputDirectory    string   `protobuf:"bytes,1,opt,name=OutputDirectory,proto3" json:"OutputDirectory,omitempty"`
	SkipProviderOutput bool     `protobuf:"varint,2,opt,name=SkipProviderOutput,proto3" json:"SkipProviderOutput,omitempty"`
	PluginArgs         []string `protobuf:"bytes,3,rep,name=PluginArgs,proto3" json:"PluginArgs,omitempty"`
}

func (x *ExportRequest) Reset() {
	*x = ExportRequest{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[0]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *ExportRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*ExportRequest) ProtoMessage() {}

func (x *ExportRequest) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[0]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use ExportRequest.ProtoReflect.Descriptor instead.
func (*ExportRequest) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{0}
}

func (x *ExportRequest) GetOutputDirectory() string {
	if x != nil {
		return x.OutputDirectory
	}
	return ""
}

func (x *ExportRequest) GetSkipProviderOutput() bool {
	if x != nil {
		return x.SkipProviderOutput
	}
	return false
}

func (x *ExportRequest) GetPluginArgs() []string {
	if x != nil {
		return x.PluginArgs
	}
	return nil
}

type ImportDirective struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Resource string `protobuf:"bytes,1,opt,name=Resource,proto3" json:"Resource,omitempty"`
	Name     string `protobuf:"bytes,2,opt,name=Name,proto3" json:"Name,omitempty"`
	ID       string `protobuf:"bytes,3,opt,name=ID,proto3" json:"ID,omitempty"`
}

func (x *ImportDirective) Reset() {
	*x = ImportDirective{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[1]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *ImportDirective) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*ImportDirective) ProtoMessage() {}

func (x *ImportDirective) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[1]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use ImportDirective.ProtoReflect.Descriptor instead.
func (*ImportDirective) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{1}
}

func (x *ImportDirective) GetResource() string {
	if x != nil {
		return x.Resource
	}
	return ""
}

func (x *ImportDirective) GetName() string {
	if x != nil {
		return x.Name
	}
	return ""
}

func (x *ImportDirective) GetID() string {
	if x != nil {
		return x.ID
	}
	return ""
}

type Version struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Major         uint64  `protobuf:"varint,1,opt,name=Major,proto3" json:"Major,omitempty"`
	Minor         uint64  `protobuf:"varint,2,opt,name=Minor,proto3" json:"Minor,omitempty"`
	Patch         uint64  `protobuf:"varint,3,opt,name=Patch,proto3" json:"Patch,omitempty"`
	Pre           *string `protobuf:"bytes,4,opt,name=Pre,proto3,oneof" json:"Pre,omitempty"`
	BuildMetadata *string `protobuf:"bytes,5,opt,name=BuildMetadata,proto3,oneof" json:"BuildMetadata,omitempty"`
}

func (x *Version) Reset() {
	*x = Version{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[2]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *Version) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*Version) ProtoMessage() {}

func (x *Version) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[2]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use Version.ProtoReflect.Descriptor instead.
func (*Version) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{2}
}

func (x *Version) GetMajor() uint64 {
	if x != nil {
		return x.Major
	}
	return 0
}

func (x *Version) GetMinor() uint64 {
	if x != nil {
		return x.Minor
	}
	return 0
}

func (x *Version) GetPatch() uint64 {
	if x != nil {
		return x.Patch
	}
	return 0
}

func (x *Version) GetPre() string {
	if x != nil && x.Pre != nil {
		return *x.Pre
	}
	return ""
}

func (x *Version) GetBuildMetadata() string {
	if x != nil && x.BuildMetadata != nil {
		return *x.BuildMetadata
	}
	return ""
}

type CommandInfo struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Name        string   `protobuf:"bytes,1,opt,name=Name,proto3" json:"Name,omitempty"`
	Description string   `protobuf:"bytes,2,opt,name=Description,proto3" json:"Description,omitempty"`
	Summary     string   `protobuf:"bytes,3,opt,name=Summary,proto3" json:"Summary,omitempty"`
	Version     *Version `protobuf:"bytes,4,opt,name=Version,proto3" json:"Version,omitempty"`
}

func (x *CommandInfo) Reset() {
	*x = CommandInfo{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[3]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *CommandInfo) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*CommandInfo) ProtoMessage() {}

func (x *CommandInfo) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[3]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use CommandInfo.ProtoReflect.Descriptor instead.
func (*CommandInfo) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{3}
}

func (x *CommandInfo) GetName() string {
	if x != nil {
		return x.Name
	}
	return ""
}

func (x *CommandInfo) GetDescription() string {
	if x != nil {
		return x.Description
	}
	return ""
}

func (x *CommandInfo) GetSummary() string {
	if x != nil {
		return x.Summary
	}
	return ""
}

func (x *CommandInfo) GetVersion() *Version {
	if x != nil {
		return x.Version
	}
	return nil
}

type PluginInfo struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Version  *Version       `protobuf:"bytes,1,opt,name=Version,proto3" json:"Version,omitempty"`
	Provides []*CommandInfo `protobuf:"bytes,2,rep,name=Provides,proto3" json:"Provides,omitempty"`
}

func (x *PluginInfo) Reset() {
	*x = PluginInfo{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[4]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *PluginInfo) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*PluginInfo) ProtoMessage() {}

func (x *PluginInfo) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[4]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use PluginInfo.ProtoReflect.Descriptor instead.
func (*PluginInfo) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{4}
}

func (x *PluginInfo) GetVersion() *Version {
	if x != nil {
		return x.Version
	}
	return nil
}

func (x *PluginInfo) GetProvides() []*CommandInfo {
	if x != nil {
		return x.Provides
	}
	return nil
}

type ExportResponse struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Directives []*ImportDirective `protobuf:"bytes,1,rep,name=Directives,proto3" json:"Directives,omitempty"`
}

func (x *ExportResponse) Reset() {
	*x = ExportResponse{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[5]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *ExportResponse) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*ExportResponse) ProtoMessage() {}

func (x *ExportResponse) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[5]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use ExportResponse.ProtoReflect.Descriptor instead.
func (*ExportResponse) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{5}
}

func (x *ExportResponse) GetDirectives() []*ImportDirective {
	if x != nil {
		return x.Directives
	}
	return nil
}

type Empty struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields
}

func (x *Empty) Reset() {
	*x = Empty{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[6]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *Empty) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*Empty) ProtoMessage() {}

func (x *Empty) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[6]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use Empty.ProtoReflect.Descriptor instead.
func (*Empty) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{6}
}

type SingleString struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Value string `protobuf:"bytes,1,opt,name=Value,proto3" json:"Value,omitempty"`
}

func (x *SingleString) Reset() {
	*x = SingleString{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[7]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *SingleString) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*SingleString) ProtoMessage() {}

func (x *SingleString) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[7]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use SingleString.ProtoReflect.Descriptor instead.
func (*SingleString) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{7}
}

func (x *SingleString) GetValue() string {
	if x != nil {
		return x.Value
	}
	return ""
}

type PluginRequest struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Name    string         `protobuf:"bytes,1,opt,name=Name,proto3" json:"Name,omitempty"`
	Request *ExportRequest `protobuf:"bytes,2,opt,name=Request,proto3" json:"Request,omitempty"`
}

func (x *PluginRequest) Reset() {
	*x = PluginRequest{}
	if protoimpl.UnsafeEnabled {
		mi := &file_plugin_proto_msgTypes[8]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *PluginRequest) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*PluginRequest) ProtoMessage() {}

func (x *PluginRequest) ProtoReflect() protoreflect.Message {
	mi := &file_plugin_proto_msgTypes[8]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use PluginRequest.ProtoReflect.Descriptor instead.
func (*PluginRequest) Descriptor() ([]byte, []int) {
	return file_plugin_proto_rawDescGZIP(), []int{8}
}

func (x *PluginRequest) GetName() string {
	if x != nil {
		return x.Name
	}
	return ""
}

func (x *PluginRequest) GetRequest() *ExportRequest {
	if x != nil {
		return x.Request
	}
	return nil
}

var File_plugin_proto protoreflect.FileDescriptor

var file_plugin_proto_rawDesc = []byte{
	0x0a, 0x0c, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x06,
	0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x22, 0x89, 0x01, 0x0a, 0x0d, 0x45, 0x78, 0x70, 0x6f, 0x72,
	0x74, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12, 0x28, 0x0a, 0x0f, 0x4f, 0x75, 0x74, 0x70,
	0x75, 0x74, 0x44, 0x69, 0x72, 0x65, 0x63, 0x74, 0x6f, 0x72, 0x79, 0x18, 0x01, 0x20, 0x01, 0x28,
	0x09, 0x52, 0x0f, 0x4f, 0x75, 0x74, 0x70, 0x75, 0x74, 0x44, 0x69, 0x72, 0x65, 0x63, 0x74, 0x6f,
	0x72, 0x79, 0x12, 0x2e, 0x0a, 0x12, 0x53, 0x6b, 0x69, 0x70, 0x50, 0x72, 0x6f, 0x76, 0x69, 0x64,
	0x65, 0x72, 0x4f, 0x75, 0x74, 0x70, 0x75, 0x74, 0x18, 0x02, 0x20, 0x01, 0x28, 0x08, 0x52, 0x12,
	0x53, 0x6b, 0x69, 0x70, 0x50, 0x72, 0x6f, 0x76, 0x69, 0x64, 0x65, 0x72, 0x4f, 0x75, 0x74, 0x70,
	0x75, 0x74, 0x12, 0x1e, 0x0a, 0x0a, 0x50, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x41, 0x72, 0x67, 0x73,
	0x18, 0x03, 0x20, 0x03, 0x28, 0x09, 0x52, 0x0a, 0x50, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x41, 0x72,
	0x67, 0x73, 0x22, 0x51, 0x0a, 0x0f, 0x49, 0x6d, 0x70, 0x6f, 0x72, 0x74, 0x44, 0x69, 0x72, 0x65,
	0x63, 0x74, 0x69, 0x76, 0x65, 0x12, 0x1a, 0x0a, 0x08, 0x52, 0x65, 0x73, 0x6f, 0x75, 0x72, 0x63,
	0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x08, 0x52, 0x65, 0x73, 0x6f, 0x75, 0x72, 0x63,
	0x65, 0x12, 0x12, 0x0a, 0x04, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x02, 0x20, 0x01, 0x28, 0x09, 0x52,
	0x04, 0x4e, 0x61, 0x6d, 0x65, 0x12, 0x0e, 0x0a, 0x02, 0x49, 0x44, 0x18, 0x03, 0x20, 0x01, 0x28,
	0x09, 0x52, 0x02, 0x49, 0x44, 0x22, 0xa7, 0x01, 0x0a, 0x07, 0x56, 0x65, 0x72, 0x73, 0x69, 0x6f,
	0x6e, 0x12, 0x14, 0x0a, 0x05, 0x4d, 0x61, 0x6a, 0x6f, 0x72, 0x18, 0x01, 0x20, 0x01, 0x28, 0x04,
	0x52, 0x05, 0x4d, 0x61, 0x6a, 0x6f, 0x72, 0x12, 0x14, 0x0a, 0x05, 0x4d, 0x69, 0x6e, 0x6f, 0x72,
	0x18, 0x02, 0x20, 0x01, 0x28, 0x04, 0x52, 0x05, 0x4d, 0x69, 0x6e, 0x6f, 0x72, 0x12, 0x14, 0x0a,
	0x05, 0x50, 0x61, 0x74, 0x63, 0x68, 0x18, 0x03, 0x20, 0x01, 0x28, 0x04, 0x52, 0x05, 0x50, 0x61,
	0x74, 0x63, 0x68, 0x12, 0x15, 0x0a, 0x03, 0x50, 0x72, 0x65, 0x18, 0x04, 0x20, 0x01, 0x28, 0x09,
	0x48, 0x00, 0x52, 0x03, 0x50, 0x72, 0x65, 0x88, 0x01, 0x01, 0x12, 0x29, 0x0a, 0x0d, 0x42, 0x75,
	0x69, 0x6c, 0x64, 0x4d, 0x65, 0x74, 0x61, 0x64, 0x61, 0x74, 0x61, 0x18, 0x05, 0x20, 0x01, 0x28,
	0x09, 0x48, 0x01, 0x52, 0x0d, 0x42, 0x75, 0x69, 0x6c, 0x64, 0x4d, 0x65, 0x74, 0x61, 0x64, 0x61,
	0x74, 0x61, 0x88, 0x01, 0x01, 0x42, 0x06, 0x0a, 0x04, 0x5f, 0x50, 0x72, 0x65, 0x42, 0x10, 0x0a,
	0x0e, 0x5f, 0x42, 0x75, 0x69, 0x6c, 0x64, 0x4d, 0x65, 0x74, 0x61, 0x64, 0x61, 0x74, 0x61, 0x22,
	0x88, 0x01, 0x0a, 0x0b, 0x43, 0x6f, 0x6d, 0x6d, 0x61, 0x6e, 0x64, 0x49, 0x6e, 0x66, 0x6f, 0x12,
	0x12, 0x0a, 0x04, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x4e,
	0x61, 0x6d, 0x65, 0x12, 0x20, 0x0a, 0x0b, 0x44, 0x65, 0x73, 0x63, 0x72, 0x69, 0x70, 0x74, 0x69,
	0x6f, 0x6e, 0x18, 0x02, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0b, 0x44, 0x65, 0x73, 0x63, 0x72, 0x69,
	0x70, 0x74, 0x69, 0x6f, 0x6e, 0x12, 0x18, 0x0a, 0x07, 0x53, 0x75, 0x6d, 0x6d, 0x61, 0x72, 0x79,
	0x18, 0x03, 0x20, 0x01, 0x28, 0x09, 0x52, 0x07, 0x53, 0x75, 0x6d, 0x6d, 0x61, 0x72, 0x79, 0x12,
	0x29, 0x0a, 0x07, 0x56, 0x65, 0x72, 0x73, 0x69, 0x6f, 0x6e, 0x18, 0x04, 0x20, 0x01, 0x28, 0x0b,
	0x32, 0x0f, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x56, 0x65, 0x72, 0x73, 0x69, 0x6f,
	0x6e, 0x52, 0x07, 0x56, 0x65, 0x72, 0x73, 0x69, 0x6f, 0x6e, 0x22, 0x68, 0x0a, 0x0a, 0x50, 0x6c,
	0x75, 0x67, 0x69, 0x6e, 0x49, 0x6e, 0x66, 0x6f, 0x12, 0x29, 0x0a, 0x07, 0x56, 0x65, 0x72, 0x73,
	0x69, 0x6f, 0x6e, 0x18, 0x01, 0x20, 0x01, 0x28, 0x0b, 0x32, 0x0f, 0x2e, 0x70, 0x6c, 0x75, 0x67,
	0x69, 0x6e, 0x2e, 0x56, 0x65, 0x72, 0x73, 0x69, 0x6f, 0x6e, 0x52, 0x07, 0x56, 0x65, 0x72, 0x73,
	0x69, 0x6f, 0x6e, 0x12, 0x2f, 0x0a, 0x08, 0x50, 0x72, 0x6f, 0x76, 0x69, 0x64, 0x65, 0x73, 0x18,
	0x02, 0x20, 0x03, 0x28, 0x0b, 0x32, 0x13, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x43,
	0x6f, 0x6d, 0x6d, 0x61, 0x6e, 0x64, 0x49, 0x6e, 0x66, 0x6f, 0x52, 0x08, 0x50, 0x72, 0x6f, 0x76,
	0x69, 0x64, 0x65, 0x73, 0x22, 0x49, 0x0a, 0x0e, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74, 0x52, 0x65,
	0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x12, 0x37, 0x0a, 0x0a, 0x44, 0x69, 0x72, 0x65, 0x63, 0x74,
	0x69, 0x76, 0x65, 0x73, 0x18, 0x01, 0x20, 0x03, 0x28, 0x0b, 0x32, 0x17, 0x2e, 0x70, 0x6c, 0x75,
	0x67, 0x69, 0x6e, 0x2e, 0x49, 0x6d, 0x70, 0x6f, 0x72, 0x74, 0x44, 0x69, 0x72, 0x65, 0x63, 0x74,
	0x69, 0x76, 0x65, 0x52, 0x0a, 0x44, 0x69, 0x72, 0x65, 0x63, 0x74, 0x69, 0x76, 0x65, 0x73, 0x22,
	0x07, 0x0a, 0x05, 0x45, 0x6d, 0x70, 0x74, 0x79, 0x22, 0x24, 0x0a, 0x0c, 0x53, 0x69, 0x6e, 0x67,
	0x6c, 0x65, 0x53, 0x74, 0x72, 0x69, 0x6e, 0x67, 0x12, 0x14, 0x0a, 0x05, 0x56, 0x61, 0x6c, 0x75,
	0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x05, 0x56, 0x61, 0x6c, 0x75, 0x65, 0x22, 0x54,
	0x0a, 0x0d, 0x50, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12,
	0x12, 0x0a, 0x04, 0x4e, 0x61, 0x6d, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x4e,
	0x61, 0x6d, 0x65, 0x12, 0x2f, 0x0a, 0x07, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x18, 0x02,
	0x20, 0x01, 0x28, 0x0b, 0x32, 0x15, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x45, 0x78,
	0x70, 0x6f, 0x72, 0x74, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x52, 0x07, 0x52, 0x65, 0x71,
	0x75, 0x65, 0x73, 0x74, 0x32, 0xa7, 0x01, 0x0a, 0x0d, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74, 0x43,
	0x6f, 0x6d, 0x6d, 0x61, 0x6e, 0x64, 0x12, 0x39, 0x0a, 0x06, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74,
	0x12, 0x15, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74,
	0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x1a, 0x16, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e,
	0x2e, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x22,
	0x00, 0x12, 0x2c, 0x0a, 0x04, 0x49, 0x6e, 0x66, 0x6f, 0x12, 0x0d, 0x2e, 0x70, 0x6c, 0x75, 0x67,
	0x69, 0x6e, 0x2e, 0x45, 0x6d, 0x70, 0x74, 0x79, 0x1a, 0x13, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69,
	0x6e, 0x2e, 0x43, 0x6f, 0x6d, 0x6d, 0x61, 0x6e, 0x64, 0x49, 0x6e, 0x66, 0x6f, 0x22, 0x00, 0x12,
	0x2d, 0x0a, 0x04, 0x48, 0x65, 0x6c, 0x70, 0x12, 0x0d, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e,
	0x2e, 0x45, 0x6d, 0x70, 0x74, 0x79, 0x1a, 0x14, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e,
	0x53, 0x69, 0x6e, 0x67, 0x6c, 0x65, 0x53, 0x74, 0x72, 0x69, 0x6e, 0x67, 0x22, 0x00, 0x32, 0xac,
	0x01, 0x0a, 0x0c, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74, 0x50, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x12,
	0x39, 0x0a, 0x06, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74, 0x12, 0x15, 0x2e, 0x70, 0x6c, 0x75, 0x67,
	0x69, 0x6e, 0x2e, 0x50, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74,
	0x1a, 0x16, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x45, 0x78, 0x70, 0x6f, 0x72, 0x74,
	0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x22, 0x00, 0x12, 0x34, 0x0a, 0x04, 0x48, 0x65,
	0x6c, 0x70, 0x12, 0x14, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x53, 0x69, 0x6e, 0x67,
	0x6c, 0x65, 0x53, 0x74, 0x72, 0x69, 0x6e, 0x67, 0x1a, 0x14, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69,
	0x6e, 0x2e, 0x53, 0x69, 0x6e, 0x67, 0x6c, 0x65, 0x53, 0x74, 0x72, 0x69, 0x6e, 0x67, 0x22, 0x00,
	0x12, 0x2b, 0x0a, 0x04, 0x49, 0x6e, 0x66, 0x6f, 0x12, 0x0d, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69,
	0x6e, 0x2e, 0x45, 0x6d, 0x70, 0x74, 0x79, 0x1a, 0x12, 0x2e, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e,
	0x2e, 0x50, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x49, 0x6e, 0x66, 0x6f, 0x22, 0x00, 0x42, 0x6d, 0x0a,
	0x29, 0x69, 0x6f, 0x2e, 0x67, 0x69, 0x64, 0x65, 0x61, 0x77, 0x6f, 0x72, 0x78, 0x2e, 0x74, 0x65,
	0x72, 0x72, 0x61, 0x66, 0x6f, 0x72, 0x6d, 0x65, 0x78, 0x70, 0x6f, 0x72, 0x74, 0x65, 0x72, 0x70,
	0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2e, 0x67, 0x72, 0x70, 0x63, 0x50, 0x01, 0x5a, 0x3e, 0x67, 0x69,
	0x74, 0x68, 0x75, 0x62, 0x2e, 0x63, 0x6f, 0x6d, 0x2f, 0x67, 0x69, 0x64, 0x65, 0x61, 0x77, 0x6f,
	0x72, 0x78, 0x2f, 0x74, 0x65, 0x72, 0x72, 0x61, 0x66, 0x6f, 0x72, 0x6d, 0x2d, 0x65, 0x78, 0x70,
	0x6f, 0x72, 0x74, 0x65, 0x72, 0x2d, 0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2f, 0x67, 0x6f, 0x2d,
	0x70, 0x6c, 0x75, 0x67, 0x69, 0x6e, 0x2f, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x62, 0x06, 0x70, 0x72,
	0x6f, 0x74, 0x6f, 0x33,
}

var (
	file_plugin_proto_rawDescOnce sync.Once
	file_plugin_proto_rawDescData = file_plugin_proto_rawDesc
)

func file_plugin_proto_rawDescGZIP() []byte {
	file_plugin_proto_rawDescOnce.Do(func() {
		file_plugin_proto_rawDescData = protoimpl.X.CompressGZIP(file_plugin_proto_rawDescData)
	})
	return file_plugin_proto_rawDescData
}

var file_plugin_proto_msgTypes = make([]protoimpl.MessageInfo, 9)
var file_plugin_proto_goTypes = []interface{}{
	(*ExportRequest)(nil),   // 0: plugin.ExportRequest
	(*ImportDirective)(nil), // 1: plugin.ImportDirective
	(*Version)(nil),         // 2: plugin.Version
	(*CommandInfo)(nil),     // 3: plugin.CommandInfo
	(*PluginInfo)(nil),      // 4: plugin.PluginInfo
	(*ExportResponse)(nil),  // 5: plugin.ExportResponse
	(*Empty)(nil),           // 6: plugin.Empty
	(*SingleString)(nil),    // 7: plugin.SingleString
	(*PluginRequest)(nil),   // 8: plugin.PluginRequest
}
var file_plugin_proto_depIdxs = []int32{
	2,  // 0: plugin.CommandInfo.Version:type_name -> plugin.Version
	2,  // 1: plugin.PluginInfo.Version:type_name -> plugin.Version
	3,  // 2: plugin.PluginInfo.Provides:type_name -> plugin.CommandInfo
	1,  // 3: plugin.ExportResponse.Directives:type_name -> plugin.ImportDirective
	0,  // 4: plugin.PluginRequest.Request:type_name -> plugin.ExportRequest
	0,  // 5: plugin.ExportCommand.Export:input_type -> plugin.ExportRequest
	6,  // 6: plugin.ExportCommand.Info:input_type -> plugin.Empty
	6,  // 7: plugin.ExportCommand.Help:input_type -> plugin.Empty
	8,  // 8: plugin.ExportPlugin.Export:input_type -> plugin.PluginRequest
	7,  // 9: plugin.ExportPlugin.Help:input_type -> plugin.SingleString
	6,  // 10: plugin.ExportPlugin.Info:input_type -> plugin.Empty
	5,  // 11: plugin.ExportCommand.Export:output_type -> plugin.ExportResponse
	3,  // 12: plugin.ExportCommand.Info:output_type -> plugin.CommandInfo
	7,  // 13: plugin.ExportCommand.Help:output_type -> plugin.SingleString
	5,  // 14: plugin.ExportPlugin.Export:output_type -> plugin.ExportResponse
	7,  // 15: plugin.ExportPlugin.Help:output_type -> plugin.SingleString
	4,  // 16: plugin.ExportPlugin.Info:output_type -> plugin.PluginInfo
	11, // [11:17] is the sub-list for method output_type
	5,  // [5:11] is the sub-list for method input_type
	5,  // [5:5] is the sub-list for extension type_name
	5,  // [5:5] is the sub-list for extension extendee
	0,  // [0:5] is the sub-list for field type_name
}

func init() { file_plugin_proto_init() }
func file_plugin_proto_init() {
	if File_plugin_proto != nil {
		return
	}
	if !protoimpl.UnsafeEnabled {
		file_plugin_proto_msgTypes[0].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*ExportRequest); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[1].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*ImportDirective); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[2].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*Version); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[3].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*CommandInfo); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[4].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*PluginInfo); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[5].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*ExportResponse); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[6].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*Empty); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[7].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*SingleString); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_plugin_proto_msgTypes[8].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*PluginRequest); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
	}
	file_plugin_proto_msgTypes[2].OneofWrappers = []interface{}{}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_plugin_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   9,
			NumExtensions: 0,
			NumServices:   2,
		},
		GoTypes:           file_plugin_proto_goTypes,
		DependencyIndexes: file_plugin_proto_depIdxs,
		MessageInfos:      file_plugin_proto_msgTypes,
	}.Build()
	File_plugin_proto = out.File
	file_plugin_proto_rawDesc = nil
	file_plugin_proto_goTypes = nil
	file_plugin_proto_depIdxs = nil
}
