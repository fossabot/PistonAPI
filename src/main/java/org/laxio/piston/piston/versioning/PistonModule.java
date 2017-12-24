package org.laxio.piston.piston.versioning;

/**
 * Represents a module used by the Piston system
 */
public class PistonModule {

    private String title;
    private Version version;
    private String vendor;

    public PistonModule(String title, Version version, String vendor) {
        this.title = title;
        this.version = version;
        this.vendor = vendor;
    }

    /**
     * Gets the title of this module
     * @return The title of the module
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the version of this module
     * @return The version of this module
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Gets the vendor of this module
     * @return The vendor of this module
     */
    public String getVendor() {
        return vendor;
    }

}
