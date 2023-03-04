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

/**
 * Exports data from a data source and writes terraform HCL files
 */
public interface TerraformExporter {
  /**
   * Perform an export from a data source into HCL files. This should also write a
   * terraform file defining the provider
   * that will be used for writing data back to the data source in the future,
   * unless <code>skipProviderOutput</code> is
   * true (it is false by default).
   * 
   * @param outputDirectory    the directory into which HCL files should be
   *                           written. To be idiomatic terraform, the files
   *                           should all be output to the same directory
   * @param skipProviderOutput if true, skip writing the provider definition file
   * @param arguments          a list of {@link java.lang.String}. These will come
   *                           from the CLI call, and can be considered like an
   *                           argv array
   * 
   * @return a list of resources, names, and IDs exported
   */
  public Iterable<ImportDirective> export(String outputDirectory, boolean skipProviderOutput,
      Iterable<String> arguments);
}
