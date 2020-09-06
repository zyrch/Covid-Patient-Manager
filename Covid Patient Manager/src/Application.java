import java.util.*;

public class Application {

    static Institutes institutes;
    static Camp camp;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        institutes = new Institutes();
        camp = new Camp();

        int NumberOfPatients = in.nextInt();
        int NumberOfAdmittedPatients = 0;
        for (int i = 0; i < NumberOfPatients; ++i) {
            String name = in.next();
            float temperature = in.nextFloat();
            int oxygen = in.nextInt();
            int age = in.nextInt();
            camp.addPatient(new Patient(name, temperature, oxygen, age));
        }

//       process queries

        while(NumberOfAdmittedPatients < NumberOfPatients) {
            int query;
            query = in.nextInt();
            if (query == 1) {
                NumberOfAdmittedPatients += addHealthCare();
            }else if (query == 2) {
                camp.removeAdmitted();
            }else if (query == 3) {
                institutes.removeInstitutes();
            }else if (query == 4) {
                camp.stillInCamp();
            }else if (query == 5) {
                institutes.admittingCurrently();
            }else if (query == 6) {
                String name = in.next();
                institutes.displayInstitute(name);
            }else if (query == 7) {
                int ID = in.nextInt();
                camp.displayPatient(ID);
            }else if (query == 8) {
                camp.displayAllPatient();
            }else if (query == 9) {
                String name = in.next();
                institutes.displayPatientOfInstitutes(name);
            }
        }

    }

    public static int addHealthCare() {

        String name = in.next();

        System.out.print("Temperature Criteria - ");
        int maxTemperature = in.nextInt();

        System.out.print("Oxygen Levels - ");
        int minOxygen = in.nextInt();

        System.out.print("Number of Available beds - ");
        int numberOfBeds = in.nextInt();

        institutes.addInstitute(new Institute(name, maxTemperature, minOxygen, numberOfBeds));
        Institute institute = institutes.getLast();

        institute.display();

        ArrayList<Patient> canAdd = camp.firstCriteria(minOxygen);
        canAdd = resize(canAdd, numberOfBeds);
        for (Patient patient : canAdd) {
            System.out.print("Recovery days for admitted patients ID " + patient.getID() + " - ");
            int recoveryTime = in.nextInt();
            patient.setRecoveryTime(recoveryTime);
            patient.setAdmitted(true);
        }
        institute.addPatients(canAdd);
        if (numberOfBeds > canAdd.size()) {
            int maxSize = numberOfBeds - canAdd.size();
            canAdd = camp.secondCriteria(maxTemperature);
            canAdd = resize(canAdd, maxSize);
            for (Patient patient : canAdd) {
                System.out.print("Recovery days for admitted patients ID " + patient.getID() + " - ");
                int recoveryTime = in.nextInt();
                patient.setRecoveryTime(recoveryTime);
                patient.setAdmitted(true);
            }
            institute.addPatients(canAdd);
        }
        return canAdd.size();
    }

    static ArrayList<Patient> resize(ArrayList<Patient> list, int maxSize) {
        if (list.size() <= maxSize) {
            return list;
        }
        ArrayList<Patient> fin = new ArrayList<>();
        for (Patient patient : list) {
            fin.add(patient);
            if (fin.size() == maxSize) break;
        }
        return fin;
    }

}
