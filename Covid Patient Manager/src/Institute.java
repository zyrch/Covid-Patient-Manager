import java.util.ArrayList;

public class Institute {
    String name;
    int maxTemperature;
    int minOxygen;
    int numberOfBeds;
    boolean admissionStatus;
    ArrayList<Patient> patients;

    public Institute(String name, int maxTemperature, int minOxygen, int numberOfBeds) {
        this.name = name;
        this.maxTemperature = maxTemperature;
        this.minOxygen = minOxygen;
        this.numberOfBeds = numberOfBeds;
        this.admissionStatus = true;
        this.patients = new ArrayList<>();
    }

    public void display() {
        System.out.println(name);
        System.out.println("Temperature should be <= " + maxTemperature);
        System.out.println("Oxygen levels should be >= " + minOxygen);
        System.out.println("Number of Available beds - " + numberOfBeds);
        if (admissionStatus) {
            System.out.println("Admission Statue - OPEN");
        } else {
            System.out.println("Admission Statue - CLOSED");
        }
    }

    public void addPatients(ArrayList<Patient> canAdd) {
        for (Patient patient : canAdd) {
            // setting institute
            patient.setInstitute(this);
            // adding patient to the institute
            this.patients.add(patient);
        }
        this.setAdmissionStatus(canAdd.size() < numberOfBeds);
    }

    public void displayPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.getName() + ", recovery time is " + patient.getRecoveryTime() + " days");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(boolean admissionStatus) {
        this.admissionStatus = admissionStatus;
    }
}
