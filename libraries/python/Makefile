PYTHON := $(shell command -v python3 2>/dev/null)
ifeq (,$(PYTHON))
	PYTHON := $(shell command -v python 2>/dev/null)
	ifeq (,$(PYTHON))
		$(error "Neither python3 nor python exist on $(PATH), ensure it does before attempting again")
	endif
endif

POETRY := $(shell command -v poetry 2>/dev/null)
ifeq (,$(POETRY))
	$(error "poetry not found on $(PATH)")
endif

.PHONY: clean build generate prep regenerate clean-gen

DIST := dist
SRC := src

clean: regenerate
	rm -fr $(DIST)

clean-gen:
	rm -fr $(SRC)/generated

generate: $(SRC)/generated/%.py

regenerate: clean-gen generate

build: prep $(SRC)/generated/%.py $(DIST)/terraform_exporter_plugin-%-py3-none-any.whl

prep:
	$(POETRY) install

$(SRC)/generated/%.py:
	mkdir -p $(SRC)/generated
	$(PYTHON) -m grpc_tools.protoc -I.. --python_out=$(SRC)/generated --pyi_out=$(SRC)/generated --grpc_python_out=$(SRC)/generated ../plugin.proto

$(DIST)/terraform_exporter_plugin-%-py3-none-any.whl:
	$(POETRY) build

bump-version-%:
	$(POETRY) version $*