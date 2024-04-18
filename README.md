package client;

import entity.Facility;
import entity.Status;
import implement.FacilityDAO;
import implement.PersonDAO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @description
 * @author: nktng,
 * @date:18/04/2024,
 */



public class Client {
    private static final String URL = "rmi://FIL:8611/";

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        FacilityDAO facilityDAO = (FacilityDAO) Naming.lookup(URL + "facilityDAO");
        PersonDAO personDAO = (PersonDAO) Naming.lookup(URL + "personDAO");

        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Vui lòng chọn một trong các lựa chọn sau:");
            System.out.println("1. Hiển thị danh sách nhân viên bảo trì khi biết tên cơ sở vật chất.");
            System.out.println("2. Cập nhật thông tin cơ sở vật chất.");
            System.out.println("3. Thống kê số lần bảo trì của cơ sở vật chất.");
            System.out.println("4. Thoát.");
            System.out.println("Nhập lựa chọn của bạn: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Nhập tên cơ sở vật chất: ");
                    String name = scanner.next();
                    personDAO.getMaintenanceWorkers(name).forEach(person -> {
                        System.out.println(person);
                    });
                    break;
                case 2:
                    System.out.println("Nhập id cơ sở: ");
                    String id = scanner.next();
                    Facility facility = facilityDAO.getFacilityById(id);
                    System.out.println("Nhập mô tả: ");
                    String description = scanner.next();
                    System.out.println("Nhập giá: ");
                    double price = scanner.nextDouble();
                    System.out.println("Nhập trạng thái (AVAILABLE, IN_USE, UNDER_MAINTENANCE, BROKEN): ");
                    String inputStatus = scanner.next();
                        Status status = inputStatus.equals("AVAILABLE") ? Status.AVAILABLE :
                                        inputStatus.equals("IN_USE") ? Status.IN_USE :
                                        inputStatus.equals("UNDER_MAINTENANCE") ? Status.UNDER_MAINTENANCE : Status.BROKEN;
                    System.out.println("Nhập vị trí: ");
                    String location = scanner.next();
                    facility.setDescription(description);
                    facility.setPrice(price);
                    facility.setStatus(status);
                    facility.setLocation(location);
                    facilityDAO.updateFacility(facility);
                    break;
                case 3:
                    Map<Facility, Long> map = facilityDAO.countMaintenance();
                    map.entrySet().forEach(entry -> {
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    });
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
}
