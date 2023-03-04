// Original file: ../plugin.proto

import type { Long } from '@grpc/proto-loader';

export interface Version {
  'Major'?: (number | string | Long);
  'Minor'?: (number | string | Long);
  'Patch'?: (number | string | Long);
  'Pre'?: (string);
  'BuildMetadata'?: (string);
  '_Pre'?: "Pre";
  '_BuildMetadata'?: "BuildMetadata";
}

export interface Version__Output {
  'Major': (string);
  'Minor': (string);
  'Patch': (string);
  'Pre'?: (string);
  'BuildMetadata'?: (string);
  '_Pre': "Pre";
  '_BuildMetadata': "BuildMetadata";
}
