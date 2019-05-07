package io.micronaut.data.model.query;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.model.query.factory.Projections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A list of projections
 */
class DefaultProjectionList implements ProjectionList {

    private List<Query.Projection> projections = new ArrayList(3);

    public List<Query.Projection> getProjectionList() {
        return Collections.unmodifiableList(projections);
    }

    @Override
    public ProjectionList add(@NonNull Query.Projection p) {
        projections.add(p);
        return this;
    }

    public ProjectionList id() {
        add(Projections.id());
        return this;
    }

    public ProjectionList count() {
        add(Projections.count());
        return this;
    }

    public ProjectionList countDistinct(String property) {
        add(Projections.countDistinct(property));
        return this;
    }

    @Override
    public ProjectionList groupProperty(String property) {
        add(Projections.groupProperty(property));
        return this;
    }

    public boolean isEmpty() {
        return projections.isEmpty();
    }

    public ProjectionList distinct() {
        add(Projections.distinct());
        return this;
    }

    public ProjectionList distinct(String property) {
        add(Projections.distinct(property));
        return this;
    }

    public ProjectionList rowCount() {
        return count();
    }

    /**
     * A projection that obtains the value of a property of an entity
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public ProjectionList property(String name) {
        add(Projections.property(name));
        return this;
    }

    /**
     * Computes the sum of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public ProjectionList sum(String name) {
        add(Projections.sum(name));
        return this;
    }

    /**
     * Computes the min value of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public ProjectionList min(String name) {
        add(Projections.min(name));
        return this;
    }

    /**
     * Computes the max value of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public ProjectionList max(String name) {
        add(Projections.max(name));
        return this;
    }

    /**
     * Computes the average value of a property
     *
     * @param name The name of the property
     * @return The PropertyProjection instance
     */
    public ProjectionList avg(String name) {
        add(Projections.avg(name));
        return this;
    }
}