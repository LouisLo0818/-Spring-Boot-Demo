package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "crime_data")
public class crime {  // Capitalized class name
    @Id
    @Column(name = "dr_no")
    private String drNo;

    @Column(name = "date_rptd", length = 50)
    private String dateRptd;

    @Column(name = "date_occ", length = 50)
    private String dateOcc; // Changed to non-static

    @Column(name = "time_occ", length = 50)
    private String timeOcc;

    @Column(name = "area", length = 50)
    private String area;

    @Column(name = "area_name", length = 50)
    private String areaName;

    @Column(name = "rpt_dist_no", length = 50)
    private String rptDistNo;

    @Column(name = "crm_cd_desc")
    private String crmCdDesc;

    @Column(name = "vict_age", length = 50)
    private String victAge;

    @Column(name = "vict_sex", length = 50)
    private String victSex;

    @Column(name = "vict_descent", length = 50)
    private String victDescent;

    @Column(name = "premis_cd", length = 50)
    private String premisCd;

    @Column(name = "premis_desc", length = 50)
    private String premisDesc;

    @Column(name = "weapon_used_cd", length = 50)
    private String weaponUsedCd;

    @Column(name = "weapon_desc", length = 50)
    private String weaponDesc;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "status_desc", length = 50)
    private String statusDesc;

    // Getters and Setters
    public String getDrNo() {
        return drNo;
    }

    public void setDrNo(String drNo) {
        this.drNo = drNo; // No need for null checks
    }

    public String getDateRptd() {
        return dateRptd;
    }

    public void setDateRptd(String dateRptd) {
        this.dateRptd = dateRptd;
    }

    public String getDateOcc() {
        return dateOcc;
    }

    public void setDateOcc(String dateOcc) {
        this.dateOcc = dateOcc;
    }

    public String getTimeOcc() {
        return timeOcc;
    }

    public void setTimeOcc(String timeOcc) {
        this.timeOcc = timeOcc;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRptDistNo() {
        return rptDistNo;
    }

    public void setRptDistNo(String rptDistNo) {
        this.rptDistNo = rptDistNo;
    }

    public String getCrmCdDesc() {
        return crmCdDesc;
    }

    public void setCrmCdDesc(String crmCdDesc) {
        this.crmCdDesc = crmCdDesc;
    }

    public String getVictAge() {
        return victAge;
    }

    public void setVictAge(String victAge) {
        this.victAge = victAge;
    }

    public String getVictSex() {
        return victSex;
    }

    public void setVictSex(String victSex) {
        this.victSex = victSex;
    }

    public String getVictDescent() {
        return victDescent;
    }

    public void setVictDescent(String victDescent) {
        this.victDescent = victDescent;
    }

    public String getPremisCd() {
        return premisCd;
    }

    public void setPremisCd(String premisCd) {
        this.premisCd = premisCd;
    }

    public String getPremisDesc() {
        return premisDesc;
    }

    public void setPremisDesc(String premisDesc) {
        this.premisDesc = premisDesc;
    }

    public String getWeaponUsedCd() {
        return weaponUsedCd;
    }

    public void setWeaponUsedCd(String weaponUsedCd) {
        this.weaponUsedCd = weaponUsedCd;
    }

    public String getWeaponDesc() {
        return weaponDesc;
    }

    public void setWeaponDesc(String weaponDesc) {
        this.weaponDesc = weaponDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}