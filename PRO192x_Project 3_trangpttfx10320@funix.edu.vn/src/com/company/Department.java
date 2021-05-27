package com.company;

import java.util.Objects;

public class Department {
    private String departmentCode;
    private String name;
    private int numberOfEmployees;

    public Department() {
    }
// Thông tin bộ phận
    public Department(String departmentCode, String name, int numberOfEmployees) {
        this.departmentCode = departmentCode;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }
// Nhận code bộ phân
    public String getDepartmentCode() {
        return this.departmentCode;
    }
// Set code bộ phận
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
// Nhận thông tin tên
    public String getName() {
        return this.name;
    }
// Đặt tên
    public void setName(String name) {
        this.name = name;
    }
// Lấy số lượng nhân viên
    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
    }
// Đặt số lượng nhân viên
    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String toString() {
        return String.format("Mã bộ phận: %s, Tên: %s, Số nhân viên: %d", this.departmentCode, this.name, this.numberOfEmployees);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Department that = (Department)o;
            return Objects.equals(this.departmentCode, that.departmentCode);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.departmentCode});
    }
}
