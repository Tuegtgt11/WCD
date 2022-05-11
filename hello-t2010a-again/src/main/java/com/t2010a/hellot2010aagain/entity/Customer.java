package com.t2010a.hellot2010aagain.entity;

import java.time.LocalDateTime;

public class Customer {
    private String Id;
    private String Name;
    private String Phone;
    private String Image;
    private LocalDateTime DOB;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Customer(String id, String name, String phone, String image, LocalDateTime DOB, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.Id = id;
        this.Name = name;
        this.Phone = phone;
        this.Image = image;
        this.DOB = DOB;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Customer(String id, String name, String phone, String image, LocalDateTime DOB) {
        this.Id = id;
        this.Name = name;
        this.Phone = phone;
        this.Image = image;
        this.DOB = DOB;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(){

    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Image='" + Image + '\'' +
                ", DOB=" + DOB +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public LocalDateTime getDOB() {
        return DOB;
    }

    public void setDOB(LocalDateTime DOB) {
        this.DOB = DOB;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}