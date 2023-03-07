package plugin

//go:generate protoc -I .. --go_out=paths=source_relative:proto --go-grpc_out=paths=source_relative:proto ../plugin.proto
