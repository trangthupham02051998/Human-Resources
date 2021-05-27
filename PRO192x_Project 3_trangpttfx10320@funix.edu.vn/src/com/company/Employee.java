package com.company;

public class Employee extends Staff {
    private int overTimeHours;

    public Employee() {
    }
// Nhận thông tin làm ngoài giờ
    public int getOverTimeHours() {
        return this.overTimeHours;
    }
// Set thời gian làm ngoài giờ
    public void setOverTimeHours(int overTimeHours) {
        this.overTimeHours = overTimeHours;
    }
// Hiển thị thông tin
    public String displayInformation() {
        return String.format("Mã NV: %s, Tên: %s, Tuổi: %d, Bộ phận: %s", this.staffCode, this.name, this.age, this.department.getName());
    }
// Tính lương
    public double calculateSalary() {
        return this.salaryFactor * 3000000 + (double)(this.overTimeHours * 200000);
    }
}
