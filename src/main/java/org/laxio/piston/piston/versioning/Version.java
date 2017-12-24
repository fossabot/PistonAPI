package org.laxio.piston.piston.versioning;

import org.laxio.piston.piston.exception.versioning.VersionParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a version string
 * Format: [prefix-]major.minor[.patch][-suffix]
 */
public class Version {

    private static final Pattern pattern = Pattern.compile("((?<prefix>.*)-)?(?<major>[0-9]+)\\.(?<minor>[0-9]+)(\\.(?<patch>[0-9]+))?(-(?<suffix>.*))?");

    private String prefix;
    private int major;
    private int minor;
    private int patch;
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
     * @return The prefix of the version
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Gets the major version number of the version
     * @return The major version number
     */
    public int getMajor() {
        return major;
    }

    /**
     * Gets the minor version number of the version
     * @return The minor version number
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Gets the patch version number of the version
     * @return The patch version number, -1 if there is no patch version number
     */
    public int getPatch() {
        return patch;
    }

    /**
     * Gets the suffix of the version
     * @return The suffix of the version
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Returns if this version has a patch version number
     * @return True if patch is present, false otherwise
     */
    public boolean hasPatchVersion() {
        return patchVersion;
    }

    /**
     * Builds a version based on the supplied string
     * Format: [prefix-]major.minor[.patch][-suffix]
     *
     * @param string The string to build a version based on
     * @return A constructed Version based on the supplied string
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

            version.major = Integer.parseInt(matcher.group("major"));
            version.minor = Integer.parseInt(matcher.group("minor"));

            String patchStr = matcher.group("patch");
            version.patchVersion = patchStr != null;

            if (version.patchVersion)
                version.patch = Integer.parseInt(patchStr);
        }

        if (version == null)
            throw new VersionParseException("No matches found", string);

        return version;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.prefix != null) {
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

        if (this.suffix != null) {
            builder.append("-");
            builder.append(this.suffix);
        }

        return builder.toString();
    }

}
