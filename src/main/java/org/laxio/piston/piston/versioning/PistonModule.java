/*-
 * ========================LICENSE_START========================
 * Piston API
 * %%
 * Copyright (C) 2017 - 2018 Laxio
 * %%
 * This file is part of Piston, licensed under the MIT License (MIT).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * ========================LICENSE_END========================
 */
package org.laxio.piston.piston.versioning;

import org.json.JSONObject;
import org.laxio.piston.piston.util.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Represents a module used by the Piston system
 */
public class PistonModule {

    private String title;
    private Version version;
    private String vendor;
    private JSONObject json;

    public PistonModule(String title, Version version, String vendor) {
        this.title = title;
        this.version = version;
        this.vendor = vendor;
    }

    public PistonModule(String title, Version version, String vendor, JSONObject json) {
        this(title, version, vendor);
        this.json = json;
    }

    /**
     * Gets the title of this module
     *
     * @return The title of the module
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the version of this module
     *
     * @return The version of this module
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Gets the vendor of this module
     *
     * @return The vendor of this module
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Get the JSON object used to create this module
     *
     * @return The JSON object used to create this module
     */
    public JSONObject getJSON() {
        return json;
    }

    /**
     * Checks if this module has a reference JSON object
     *
     * @return true if this module has a JSON object, false otherwise
     */
    public boolean hasJSON() {
        return json != null;
    }

    /**
     * Builds a PistonModule based on the supplied class and reference tag
     *
     * @param cls The class to get the package name from
     * @param tag The prefix tag, usually Specification or Implementation
     *
     * @return A constructed PistonModule for the supplied arguments
     *
     * @throws IOException
     */
    public static PistonModule build(Class<?> cls, String tag) throws IOException {
        JSONObject json = getJSON(cls);
        return build(json, tag);
    }

    /**
     * Builds a PistonModule based on the supplied class and reference tag
     *
     * @param pkg The package name
     * @param tag The prefix tag, usually Specification or Implementation
     *
     * @return A constructed PistonModule for the supplied arguments
     *
     * @throws IOException
     */
    public static PistonModule build(String pkg, String tag) throws IOException {
        JSONObject json = getJSON("/" + ide() + pkg);
        return build(json, tag);
    }

    /**
     * Builds a JSON object based on the package name of the supplied class
     *
     * @param cls The class to get the package name from
     *
     * @return The JSON object for that class
     *
     * @throws IOException
     */
    private static JSONObject getJSON(Class<?> cls) throws IOException {
        return getJSON("/" + ide() + cls.getPackage().getName() + ".json");
    }

    /**
     * Builds a JSON object using the supplied path
     *
     * @param path The path
     *
     * @return The JSON object for the supplied path
     *
     * @throws IOException
     */
    private static JSONObject getJSON(String path) throws IOException {
        return new JSONObject(read(PistonModule.class.getResourceAsStream(path)));
    }

    /**
     * Builds a module using the supplied JSON object and tag
     *
     * @param json The JSON object to look in
     * @param tag  The prefix tag, usually Specification or Implementation
     *
     * @return A constructed module for the supplied parameters
     */
    private static PistonModule build(JSONObject json, String tag) {
        String title = json.getString(tag + "-Title");
        String version = json.getString(tag + "-Version");
        String vendor = json.getString(tag + "-Vendor");

        Version ver = Version.parse(version);
        return new PistonModule(title, ver, vendor, json);
    }

    /**
     * Translates a stream into a single string
     *
     * @param input The stream to translate
     *
     * @return The complete string
     *
     * @throws IOException
     */
    private static String read(InputStream input) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    /**
     * Returns the test prefix if ide mode is enabled
     *
     * @return "test-" if ide mode is enabled, otherwise ""
     */
    private static String ide() {
        return Environment.isIDE() ? "test-" : "";
    }

}
