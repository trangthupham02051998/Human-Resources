package com.company;
// Hàm chức danh Manager
public enum ManagerTitle {
    BUSINESS_LEADER("Trưởng Phòng Kinh Doanh", 8000000.0D),
    PROJECT_LEADER("Trưởng nhóm dự án", 5000000.0D),
    NORMAL_STAFF("Nhân Viên", 6000000.0D);

    private final String name;
    private final double responsibilitySalary;

    private ManagerTitle(String name, double responsibilitySalary) {
        this.name = name;
        this.responsibilitySalary = responsibilitySalary;
    }

    public String getName() {
        return this.name;
    }

    public double getResponsibilitySalary() {
        return this.responsibilitySalary;
    }
}
