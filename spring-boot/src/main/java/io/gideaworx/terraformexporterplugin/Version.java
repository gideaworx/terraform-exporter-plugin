/*
 * Copyright (c) 2023-2023 Josh Ghiloni <ghiloni@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.gideaworx.terraformexporterplugin;

import lombok.NonNull;

public record Version(long major, long minor, long patch, @NonNull String pre, @NonNull String buildMetadata) {
  public static final Version DEFAULT = new Version(0,0,0,"dev","");
  public static Version fromString(String vs) {
    String[] firstSplit = vs.split("-", 2);

    String[] mmp = firstSplit[0].split(".");

    long major = 0;
    long minor = 0;
    long patch = 0;
    String pre = "";
    String build = "";

    try {
      major = Long.parseLong(mmp[0]);
    } catch (NumberFormatException e) {
    }

    if (mmp.length > 1) {
      try {
        minor = Long.parseLong(mmp[1]);
      } catch (NumberFormatException e) {
      }
    }

    if (mmp.length > 2) {
      try {
        patch = Long.parseLong(mmp[2]);
      } catch (NumberFormatException e) {
      }
    }

    if (firstSplit.length > 1) {
      String[] prebuild = firstSplit[1].split(".", 2);
      pre = prebuild[0];
      if (prebuild.length > 1) {
        build = prebuild[1];
      }
    }

    return new Version(major, minor, patch, pre, build);
  }
}
