package com.yuanlrc.entity;


import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.Timestamp;

public class se_business_opportunity {
    long id;
    long customer_id;
    String bo_name;
    Date bo_date;
    String bo_status;
    String bo_follow_status;
    String bo_editor;
    String bo_template;
    String bo_responsible;
    BigDecimal bo_amount;
    Date bo_expect_date;
    String bo_notes;
    Timestamp create_time;
    Timestamp update_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getBo_name() {
        return bo_name;
    }

    public void setBo_name(String bo_name) {
        this.bo_name = bo_name;
    }

    public Date getBo_date() {
        return bo_date;
    }

    public void setBo_date(Date bo_date) {
        this.bo_date = bo_date;
    }

    public String getBo_status() {
        return bo_status;
    }

    public void setBo_status(String bo_status) {
        this.bo_status = bo_status;
    }

    public String getBo_follow_status() {
        return bo_follow_status;
    }

    public void setBo_follow_status(String bo_follow_status) {
        this.bo_follow_status = bo_follow_status;
    }

    public String getBo_editor() {
        return bo_editor;
    }

    public void setBo_editor(String bo_editor) {
        this.bo_editor = bo_editor;
    }

    public String getBo_template() {
        return bo_template;
    }

    public void setBo_template(String bo_template) {
        this.bo_template = bo_template;
    }

    public String getBo_responsible() {
        return bo_responsible;
    }

    public void setBo_responsible(String bo_responsible) {
        this.bo_responsible = bo_responsible;
    }

    public BigDecimal getBo_amount() {
        return bo_amount;
    }

    public void setBo_amount(BigDecimal bo_amount) {
        this.bo_amount = bo_amount;
    }

    public Date getBo_expect_date() {
        return bo_expect_date;
    }

    public void setBo_expect_date(Date bo_expect_date) {
        this.bo_expect_date = bo_expect_date;
    }

    public String getBo_notes() {
        return bo_notes;
    }

    public void setBo_notes(String bo_notes) {
        this.bo_notes = bo_notes;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }
}
