package com.TestApp.example.TestApp.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long student_id;
    @Column(name = "student_name")
    private String student_name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_no")
    private String contact_no;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public Student(Long student_id, String student_name, String address, String email, String contact_no) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.address = address;
        this.email = email;
        this.contact_no = contact_no;
    }
    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact_no='" + contact_no + '\'' +
                '}';
    }
}
