package org.laxio.piston.piston.versioning;

import org.junit.jupiter.api.Test;
import org.laxio.piston.piston.exception.versioning.VersionParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests if the supplied input is being correctly read
 * @see Version
 */
class VersionTest {

    @Test
    void parse() {
        testFail("x.1", "Invalid major did not throw error");
        testFail("0.x", "Invalid minor version did not throw error");
        testFail("1", "Invalid version did not throw error");
        testFail(".2", "Invalid version did not throw error");

        testSuccess("1.2.3", 1, 2, 3);
        testSuccess("102.203", 102, 203);
        testSuccess("102.203.304", 102, 203, 304);
        testSuccess("prefix-0.2", "prefix", 0, 2, null);
        testSuccess("prefix-0.2-suffix", "prefix", 0, 2, "suffix");
        testSuccess("prefix-0.2-alpha.1.0.0", "prefix", 0, 2, "alpha.1.0.0");
        testSuccess("prefix-0.2.4-suffix", "prefix", 0, 2, 4, "suffix");
        testSuccess("prefix-0.2.4-alpha.1.0.0", "prefix", 0, 2, 4, "alpha.1.0.0");
    }

    private void testFail(String test, String failCase) {
        try {
            Version.parse(test);
            fail(failCase);
        } catch (VersionParseException ex) {
            // ignore, success
        }
    }

    private void testSuccess(String test, int major, int minor) {
        testSuccess(test, null, major, minor, null);
    }

    private void testSuccess(String test, int major, int minor, int patch) {
        testSuccess(test, null, major, minor, patch, null);
    }

    private void testSuccess(String test, String prefix, int major, int minor, String suffix) {
        testSuccess(test, prefix, major, minor, -1, suffix);
    }

    private void testSuccess(String test, String prefix, int major, int minor, int patch, String suffix) {
        try {
            Version v = Version.parse(test);

            checkString("Prefix does not match expected", prefix, v.getPrefix());
            checkString("Suffix does not match expected", suffix, v.getSuffix());

            if (v.getMajor() != major)
                fail("Major does not match expected: Expected " + major + ", " + v.getMajor());

            if (v.getMinor() != minor)
                fail("Minor does not match expected: Expected " + minor + ", " + v.getMinor());

            if (v.getPatch() != patch) {
                if (patch == -1) {
                    fail("Patch received when not expected: " + v.getPatch());
                } else {
                    if (v.getPatch() == -1) {
                        fail("Patch not received when expected: " + patch);
                    }

                    fail("Patch does not match expected: Expected " + major + ", " + v.getMajor());
                }
            }

            // success
        } catch (VersionParseException ex) {
            fail(ex);
        }
    }

    private String nullToString(String string) {
        if (string == null)
            return "null";

        return string;
    }

    private void checkString(String fail, String expected, String result) {
        if (expected == null && result != null) {
            fail(fail + ": Expected null, " + nullToString(result));
        } else if (expected != null && result == null) {
            fail(fail + ": Expected " + nullToString(expected) + ", null");
        }

        if (expected != null && result != null && !expected.equals(result))
            fail(fail + ": Expected " + expected + ", " + result);
    }

}