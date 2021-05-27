package com.company;

public abstract class Staff implements ICalculator {
    protected String staffCode;
    protected String name;
    protected int age;
    protected double salaryFactor;
    protected String joinedDate;
    protected Department department;
    protected int leaveDays;

    public Staff() {
    }
// Hiển thị thông tin
    public abstract String displayInformation();
// Nhận thông tin Staff
    public String getStaffCode() {
        return this.staffCode;
    }
// Đặt code Staff
    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }
// Nhận thông tin tên Staff
    public String getName() {
        return this.name;
    }
//Đặt tên Staff
    public void setName(String name) {
        this.name = name;
    }
// Nhận thông tin tuổi Staff
    public int getAge() {
        return this.age;
    }
// Đặt tuổi Staff
    public void setAge(int age) {
        this.age = age;
    }
//    Nhận thông tin lương Staff
    public double getSalaryFactor() {
        return this.salaryFactor;
    }
// Set thông tin lương
    public void setSalaryFactor(double salaryFactor) {
        this.salaryFactor = salaryFactor;
    }
// Nhận thông tin ngày tham gia
    public String getJoinedDate() {
        return this.joinedDate;
    }
//Set thông tin ngày tham gia
    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }
// Nhận thông tin bộ phận
    public Department getDepartment() {
        return this.department;
    }
// Set thông tin bộ phận
    public void setDepartment(Department department) {
        this.department = department;
    }
// Nhận thông tin ngày phép
    public int getLeaveDays() {
        return this.leaveDays;
    }
// Set thông tin ngày phép
    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }
}
