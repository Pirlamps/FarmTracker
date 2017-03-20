package br.com.pirlamps.farmtracker.foundation.model;

/**
 * Created by root-matheus on 16/03/17.
 */

public class CultureVO {

    private String cultureId;
    private String name;
    private String location;
    private String initialDate;
    private String finishDate;
    private Double budget;

    public CultureVO() {
    }

    public CultureVO(String cultureId, String name, String location, String initialDate, Double budget) {
        this.cultureId = cultureId;
        this.name = name;
        this.location = location;
        this.initialDate = initialDate;
        this.budget = budget;
    }

    public CultureVO(String cultureId, String name, String location, String initialDate, String finishDate, Double budget) {
        this.cultureId = cultureId;
        this.name = name;
        this.location = location;
        this.initialDate = initialDate;
        this.finishDate = finishDate;
        this.budget = budget;
    }

    public String getCultureId() {
        return cultureId;
    }

    public void setCultureId(String cultureId) {
        this.cultureId = cultureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
