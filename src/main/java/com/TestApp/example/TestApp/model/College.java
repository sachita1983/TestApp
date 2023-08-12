package com.TestApp.example.TestApp.model;

import javax.persistence.*;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long collegeId;
    @Column(name = "collegeName")
    private String collegeName;
    @Column(name = "collegeAddress")
    private String collegeAddress;
    @Column(name = "collegeEmail")
    private String collegeEmail;
    @Column(name = "collegeContactNo")
    private String collegeContactNo;
    @Column(name = "collegeBuilding")
    private String collegeBulding;
    @Column(name = "collegeColor")
    private String collegeColor;

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public String getCollegeContactNo() {
        return collegeContactNo;
    }

    public void setCollegeContactNo(String collegeContactNo) {
        this.collegeContactNo = collegeContactNo;
    }

    public String getCollegeBulding() {
        return collegeBulding;
    }

    public College(Long collegeId, String collegeName, String collegeAddress, String collegeEmail, String collegeContactNo) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.collegeAddress = collegeAddress;
        this.collegeEmail = collegeEmail;
        this.collegeContactNo = collegeContactNo;

    }
    public College(){
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", collegeAddress='" + collegeAddress + '\'' +
                ", collegeEmail='" + collegeEmail + '\'' +
                ", collegeContactNo='" + collegeContactNo + '\'' +
                '}';
    }
}
