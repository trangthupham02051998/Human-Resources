package com.company;

public class Manager extends Staff {
    private ManagerTitle title;

    public Manager() {
    }

    public ManagerTitle getTitle() {
        return this.title;
    }

    public void setTitle(ManagerTitle title) {
        this.title = title;
    }

    public String displayInformation() {
        return String.format("Mã NV: %s, Tên: %s, Tuổi: %d, Chức vụ: %s, Bộ phận: %s", this.staffCode, this.name, this.age, this.title.getName(), this.department.getName());
    }

    public double calculateSalary() {
        return this.salaryFactor * 5000000.0D + this.title.getResponsibilitySalary();
    }
}
