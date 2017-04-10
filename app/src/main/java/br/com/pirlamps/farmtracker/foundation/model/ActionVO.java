package br.com.pirlamps.farmtracker.foundation.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by root-matheus on 09/03/17.
 */

public class ActionVO implements Serializable {

    public enum TypeEnum{
        MECANICOS,NUTRICAO,TRATOS,CONROLE_DOENCAS;
    }

    private String actionId;
    private TypeEnum type;
    private String name;
    private String cost;
    private String detail;
    private String date;

    public ActionVO(TypeEnum type, String name, String cost, String detail, String date) {
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.detail = detail;
        this.date = date;
    }

    public ActionVO() {
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
