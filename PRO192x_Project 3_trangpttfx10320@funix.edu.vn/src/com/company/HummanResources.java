//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

class HumanResources {
    public HumanResources() {
    }
// Tạo list bộ phận
    public static void main(String[] args) {
        List<Department> departments = createDepartments();
        List<Staff> staffs = new ArrayList();
        boolean running = true;
// Quá trình hiển thị menu
        do {
            int selectedOption = showMenu();
            switch(selectedOption) {
                case 1:
                    showStaffList(staffs);
                    break;
                case 2:
                    showDepartmentList(departments);
                    break;
                case 3:
                    showStaffByDepartment(staffs);
                    break;
                case 4:
                    int createStaffOption = showAddStaffMenu();
                    addAStaff(departments, staffs, createStaffOption);
                    break;
                case 5:
                    searchStaffs(staffs);
                    break;
                case 6:
                    showAllStaffSalary(staffs);
                    break;
                case 7:
                    showAllStaffSalary(staffs, true);
                    break;
                case 8:
                    showAllStaffSalary(staffs, false);
                    break;
                default:
                    running = false;
            }
        } while(running);

    }
// Hiển thị menu
    public static int showMenu() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
        System.out.println("9. Thoát chương trình");
        Scanner inputReader = new Scanner(System.in);
        int selectedOption = inputReader.nextInt();
        return selectedOption;
    }
// Hiện thị add menu
    public static int showAddStaffMenu() {
        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên quản lý");
        Scanner inputReader = new Scanner(System.in);
        int selectedOption = inputReader.nextInt();
        return selectedOption;
    }
// Add thêm thông tin Nhân viên bt
    public static void addAStaff(List<Department> departments, List<Staff> staffs, int staffRole) {
        if (staffRole == 1) {
            staffs.add(addEmployee(departments));
        } else if (staffRole == 2) {
            staffs.add(addManager(departments));
        }

        System.out.println("=> Đã tạo nhân viên mới thành công!!!");
        System.out.println();
    }

    private static Employee addEmployee(List<Department> departments) {
        Scanner inputReader = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Nhập mã nhân viên:");
        String staffCode = inputReader.nextLine();
        employee.setStaffCode(staffCode);
        System.out.println("Nhập tên nhân viên:");
        String name = inputReader.nextLine();
        employee.setName(name);
        System.out.println("Nhập tuổi nhân viên:");
        int age = inputReader.nextInt();
        employee.setAge(age);
        System.out.println("Chọn bộ phận: (1: Sales, 2: Marketing, 3: Plan)");
        int departmentOption = inputReader.nextInt();
        switch(departmentOption) {
            case 1:
                Department department = departments.get(0);
                department.setNumberOfEmployees(department.getNumberOfEmployees() + 1);
                employee.setDepartment(department);
                break;
            case 2:
                ((Department)departments.get(1)).setNumberOfEmployees(((Department)departments.get(1)).getNumberOfEmployees() + 1);
                employee.setDepartment((Department)departments.get(1));
                break;
            case 3:
                ((Department)departments.get(2)).setNumberOfEmployees(((Department)departments.get(2)).getNumberOfEmployees() + 1);
                employee.setDepartment((Department)departments.get(2));
        }

        System.out.println("Nhập hệ số lương:");
        double salaryFactor = inputReader.nextDouble();
        employee.setSalaryFactor(salaryFactor);
        System.out.println("Nhập số giờ làm thêm:");
        int overTimeHours = inputReader.nextInt();
        employee.setOverTimeHours(overTimeHours);
        return employee;
    }
// Add thêm Manager
    private static Manager addManager(List<Department> departments) {
        Scanner inputReader = new Scanner(System.in);
        Manager manager = new Manager();
        System.out.println("Nhập mã nhân viên:");
        String staffCode = inputReader.nextLine();
        manager.setStaffCode(staffCode);
        System.out.println("Nhập tên nhân viên:");
        String name = inputReader.nextLine();
        manager.setName(name);
        System.out.println("Nhập tuổi nhân viên:");
        int age = inputReader.nextInt();
        manager.setAge(age);
        System.out.println("Chọn bộ phận: (1: Sales, 2: Marketing, 3: Plan)");
        int departmentOption = inputReader.nextInt();
        switch(departmentOption) {
            case 1:
                ((Department)departments.get(0)).setNumberOfEmployees(((Department)departments.get(0)).getNumberOfEmployees() + 1);
                manager.setDepartment((Department)departments.get(0));
                break;
            case 2:
                ((Department)departments.get(1)).setNumberOfEmployees(((Department)departments.get(1)).getNumberOfEmployees() + 1);
                manager.setDepartment((Department)departments.get(1));
                break;
            case 3:
                ((Department)departments.get(2)).setNumberOfEmployees(((Department)departments.get(2)).getNumberOfEmployees() + 1);
                manager.setDepartment((Department)departments.get(2));
        }

        System.out.println("Chọn chức vụ: (1: Trưởng Phòng Kinh Doanh, 2: Trưởng nhóm dự án, 3: Nhân viên)");
        int titleOption = inputReader.nextInt();
        switch(titleOption) {
            case 1:
                manager.setTitle(ManagerTitle.BUSINESS_LEADER);
                break;
            case 2:
                manager.setTitle(ManagerTitle.PROJECT_LEADER);
                break;
            case 3:
                manager.setTitle(ManagerTitle.NORMAL_STAFF);
        }

        System.out.println("Nhập hệ số lương:");
        double salaryFactor = inputReader.nextDouble();
        manager.setSalaryFactor(salaryFactor);
        return manager;
    }
//     Tạo bộ phận
    public static List<Department> createDepartments() {
        List<Department> departments = new ArrayList();
        Department sDepartment = new Department("s", "Sales", 0);
        Department marketingDepartment = new Department("mk", "Marketing", 0);
        Department planDepartment = new Department("p", "Plan", 0);
        departments.add(sDepartment);
        departments.add(marketingDepartment);
        departments.add(planDepartment);
        return departments;
    }
// Hiện thị danh sách Staff
    public static void showStaffList(List<Staff> staffs) {
        System.out.println();
        System.out.println("Danh sách nhân viên:");
        if (staffs.isEmpty()) {
            System.out.println("<Hiện chưa có nhân viên nào>");
        } else {
            Iterator itor = staffs.iterator();

            while(itor.hasNext()) {
                Staff staff = (Staff)itor.next();
                System.out.printf(" - %s%n", staff.displayInformation());
            }
        }

        System.out.println();
    }
// Hiện thị nhân viên theo bộ phận
    public static void showStaffByDepartment(List<Staff> staffs) {
        HashMap<Department, List<Staff>> staffsByDepartment = new HashMap();
        Iterator itor = staffs.iterator();

        while(itor.hasNext()) {
            Staff staff = (Staff)itor.next();
            if (staff.getDepartment() != null) {
                List<Staff> temp = (List)staffsByDepartment.getOrDefault(staff.getDepartment(), new ArrayList());
                temp.add(staff);
                staffsByDepartment.put(staff.getDepartment(), temp);
            }
        }

        itor = staffsByDepartment.entrySet().iterator();

        while(itor.hasNext()) {
            Entry<Department, List<Staff>> entry = (Entry)itor.next();
            System.out.println();
            System.out.printf("Department: %s%n", ((Department)entry.getKey()).getName());
            itor = ((List) entry.getValue()).iterator();

            while(itor.hasNext()) {
                Staff staff = (Staff)itor.next();
                System.out.printf(" - %s%n", staff.displayInformation());
            }

            System.out.println();
        }

    }
// Hiện thị danh sách bộ phận
    public static void showDepartmentList(List<Department> departments) {
        System.out.println();
        System.out.println("Danh sách bộ phận:");
        Iterator itor = departments.iterator();

        while(itor.hasNext()) {
            Department department = (Department)itor.next();
            System.out.printf("- %s%n", department);
        }

        System.out.println();
    }
// Tìm kiếm thông tin nhân viên
    public static void searchStaffs(List<Staff> staffs) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println();
        System.out.println("Tìm kiếm nhân viên (mã nhân viên hoặc tên nhân viên):");
        String searchTerm = inputReader.nextLine();
        List<Staff> searchedStaffs = new ArrayList();
        Iterator itor = staffs.iterator();

        while(true) {
            Staff staff;
            do {
                if (!itor.hasNext()) {
                    if (searchedStaffs.isEmpty()) {
                        System.out.println("Không tìm thấy nhân viên nào!!!");
                    } else {
                        System.out.printf("Tìm thấy %d nhân viên:%n", searchedStaffs.size());
                        itor = searchedStaffs.iterator();

                        while(itor.hasNext()) {
                            staff = (Staff)itor.next();
                            System.out.printf(" - %s%n", staff.displayInformation());
                        }
                    }

                    System.out.println();
                    return;
                }

                staff = (Staff)itor.next();
            } while(!staff.getStaffCode().equalsIgnoreCase(searchTerm) && !staff.getName().contains(searchTerm));

            searchedStaffs.add(staff);
        }
    }
// Show thông tin lương toàn bộ Staff
    public static void showAllStaffSalary(List<Staff> staffs, boolean sortAsc) {
        List<Staff> temp = new ArrayList(staffs);
        if (sortAsc) {
            temp.sort((o1, o2) -> {
                return (int)(o2.calculateSalary() - o1.calculateSalary());
            });
        } else {
            temp.sort((o1, o2) -> {
                return (int)(o1.calculateSalary() - o2.calculateSalary());
            });
        }

        showAllStaffSalary(temp);
    }

    public static void showAllStaffSalary(List<Staff> staffs) {
        System.out.println();
        System.out.println("Bảng lương nhân viên:");
        Iterator itor = staffs.iterator();

        while(itor.hasNext()) {
            Staff staff = (Staff)itor.next();
            System.out.printf("- Tên: %s - Lương: %.02f%n", staff.getName(), staff.calculateSalary());
        }

        System.out.println();
    }
}
