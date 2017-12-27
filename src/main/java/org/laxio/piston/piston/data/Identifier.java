package org.laxio.piston.piston.data;

public class Identifier {

    private String namespace;
    private String name;

    public Identifier(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    /**
     * Gets the namespace of this identifier
     *
     * @return The string namespace of this identifier
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Gets the name of this identifier
     *
     * @return The string name of this identifier
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the formatted identifier
     *
     * @return [namespace]:[name]
     */
    @Override
    public String toString() {
        return namespace + ":" + name;
    }

}
