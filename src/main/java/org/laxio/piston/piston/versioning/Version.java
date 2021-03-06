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

import org.laxio.piston.piston.exception.versioning.VersionParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a version string
 * Format: [prefix-]major.minor[.patch][-suffix]
 */
public class Version implements Comparable<Version> {

    private static final Pattern pattern = Pattern.compile("((?<prefix>.*)-)?(?<major>[0-9]+)\\.(?<minor>[0-9]+)(\\.(?<patch>[0-9]+))?(-(?<suffix>.*))?");

    private String prefix;
    private int major;
    private int minor;
    private int patch = -1;
    private String suffix;

    private boolean patchVersion;

    /**
     * Private construction
     */
    private Version() {
        // empty
    }

    /**
     * Gets the prefix of the version
     *
     * @return The prefix of the version
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Gets the major version number of the version
     *
     * @return The major version number
     */
    public int getMajor() {
        return major;
    }

    /**
     * Gets the minor version number of the version
     *
     * @return The minor version number
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Gets the patch version number of the version
     *
     * @return The patch version number, -1 if there is no patch version number
     */
    public int getPatch() {
        return patch;
    }

    /**
     * Gets the suffix of the version
     *
     * @return The suffix of the version
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Returns if this version has a patch version number
     *
     * @return True if patch is present, false otherwise
     */
    public boolean hasPatchVersion() {
        return patchVersion;
    }

    @Override
    public int compareTo(Version v) {
        if (this.major != v.major)
            return this.major - v.major;
        else if (this.minor != v.minor)
            return this.minor - v.minor;
        else if (this.patch != v.patch)
            return this.patch - v.patch;

        return 0;
    }

    /**
     * Checks if this version has a greater semver value than the supplied version
     *
     * @param version The version to check against
     *
     * @return True if this version has greater value than the supplied version, false otherwise
     */
    public boolean isGreaterThan(Version version) {
        return this.compareTo(version) > 0;
    }

    /**
     * Checks if this version and the supplied version have matching values
     *
     * @param version The version to check against
     *
     * @return true if the versions have equal value, otherwise false
     */
    public boolean isEqualTo(Version version) {
        return this.compareTo(version) == 0;
    }

    /**
     * Checks if this version has a lesser semver value than the supplied version
     *
     * @param version The version to check against
     *
     * @return True if this version has lesser value than the supplied version, false otherwise
     */
    public boolean isLessThan(Version version) {
        return this.compareTo(version) < 0;
    }

    @Override
    public String toString() {
        return toString(true);
    }

    public String toString(boolean labels) {
        StringBuilder builder = new StringBuilder();

        if (this.prefix != null && labels) {
            builder.append(this.prefix);
            builder.append("-");
        }

        builder.append(this.major);
        builder.append(".");
        builder.append(this.minor);

        if (this.patchVersion) {
            builder.append(".");
            builder.append(this.patch);
        }

        if (this.suffix != null && labels) {
            builder.append("-");
            builder.append(this.suffix);
        }

        return builder.toString();
    }

    /**
     * Builds a version based on the supplied string
     * Format: [prefix-]major.minor[.patch][-suffix]
     *
     * @param string The string to build a version based on
     *
     * @return A constructed Version based on the supplied string
     *
     * @throws VersionParseException Thrown when there is an issue parsing the given string into a valid version
     */
    public static Version parse(String string) {
        Matcher matcher = pattern.matcher(string);
        Version version = null;

        while (matcher.find()) {
            if (version != null)
                throw new VersionParseException("Too many matches", string);

            version = new Version();
            version.prefix = matcher.group("prefix");
            version.suffix = matcher.group("suffix");

            String majorStr = matcher.group("major");
            if (majorStr == null)
                throw new VersionParseException("No major version", string);

            try {
                version.major = Integer.parseInt(majorStr);
            } catch (NumberFormatException ex) {
                throw new VersionParseException("Major version could not be parsed into integer", ex, string);
            }

            String minorStr = matcher.group("minor");
            if (minorStr == null)
                throw new VersionParseException("No minor version", string);

            try {
                version.minor = Integer.parseInt(minorStr);
            } catch (NumberFormatException ex) {
                throw new VersionParseException("Minor version could not be parsed into integer", ex, string);
            }

            String patchStr = matcher.group("patch");
            version.patchVersion = patchStr != null;

            if (version.patchVersion)
                version.patch = Integer.parseInt(patchStr);
        }

        if (version == null)
            throw new VersionParseException("No matches found", string);

        return version;
    }

}
