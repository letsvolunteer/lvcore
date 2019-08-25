/*
 * This file is generated by jOOQ.
 */
package io.lvcore.db.model.tables.tables.records;


import io.lvcore.db.model.tables.tables.User;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record8<String, String, String, String, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -1381320339;

    /**
     * Setter for <code>lvcore.USER.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>lvcore.USER.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>lvcore.USER.email</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>lvcore.USER.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>lvcore.USER.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>lvcore.USER.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>lvcore.USER.external_id</code>.
     */
    public void setExternalId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>lvcore.USER.external_id</code>.
     */
    public String getExternalId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>lvcore.USER.id_provider</code>.
     */
    public void setIdProvider(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>lvcore.USER.id_provider</code>.
     */
    public String getIdProvider() {
        return (String) get(4);
    }

    /**
     * Setter for <code>lvcore.USER.properties</code>.
     */
    public void setProperties(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>lvcore.USER.properties</code>.
     */
    public String getProperties() {
        return (String) get(5);
    }

    /**
     * Setter for <code>lvcore.USER.created_on</code>.
     */
    public void setCreatedOn(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>lvcore.USER.created_on</code>.
     */
    public Timestamp getCreatedOn() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>lvcore.USER.modified_on</code>.
     */
    public void setModifiedOn(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>lvcore.USER.modified_on</code>.
     */
    public Timestamp getModifiedOn() {
        return (Timestamp) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, String, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, String, String, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return User.USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return User.USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return User.USER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return User.USER.EXTERNAL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return User.USER.ID_PROVIDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return User.USER.PROPERTIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return User.USER.CREATED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return User.USER.MODIFIED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getExternalId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getIdProvider();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getProperties();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getModifiedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getExternalId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getIdProvider();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getProperties();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getCreatedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getModifiedOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(String value) {
        setExternalId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(String value) {
        setIdProvider(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(String value) {
        setProperties(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value7(Timestamp value) {
        setCreatedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value8(Timestamp value) {
        setModifiedOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(String value1, String value2, String value3, String value4, String value5, String value6, Timestamp value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(String id, String email, String name, String externalId, String idProvider, String properties, Timestamp createdOn, Timestamp modifiedOn) {
        super(User.USER);

        set(0, id);
        set(1, email);
        set(2, name);
        set(3, externalId);
        set(4, idProvider);
        set(5, properties);
        set(6, createdOn);
        set(7, modifiedOn);
    }
}
