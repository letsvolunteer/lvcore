/*
 * This file is generated by jOOQ.
 */
package io.lvcore.db.model.tables.tables.records;


import io.lvcore.db.model.tables.tables.EventVolunteers;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EventVolunteersRecord extends TableRecordImpl<EventVolunteersRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 678447997;

    /**
     * Setter for <code>lvcore.EVENT_VOLUNTEERS.event_id</code>.
     */
    public void setEventId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>lvcore.EVENT_VOLUNTEERS.event_id</code>.
     */
    public String getEventId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>lvcore.EVENT_VOLUNTEERS.user_id</code>.
     */
    public void setUserId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>lvcore.EVENT_VOLUNTEERS.user_id</code>.
     */
    public String getUserId() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return EventVolunteers.EVENT_VOLUNTEERS.EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return EventVolunteers.EVENT_VOLUNTEERS.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventVolunteersRecord value1(String value) {
        setEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventVolunteersRecord value2(String value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventVolunteersRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EventVolunteersRecord
     */
    public EventVolunteersRecord() {
        super(EventVolunteers.EVENT_VOLUNTEERS);
    }

    /**
     * Create a detached, initialised EventVolunteersRecord
     */
    public EventVolunteersRecord(String eventId, String userId) {
        super(EventVolunteers.EVENT_VOLUNTEERS);

        set(0, eventId);
        set(1, userId);
    }
}