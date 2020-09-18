import java.util.ArrayList;

public class Camp {

    ArrayList<Patient> patients;

    Camp() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public int numberOfPatients() {
        return patients.size();
    }

    public ArrayList<Patient> firstCriteria(int minOxygen) {
        ArrayList<Patient> canAdd = new ArrayList<>();
        for (Patient patient : patients) {
            if (!patient.isAdmitted()) {
                // check the first criteria
                if (patient.getOxygen() >= minOxygen) {
                    canAdd.add(patient);
                }
            }
        }
        return canAdd;
    }

    public ArrayList<Patient> secondCriteria(int maxTemperature) {
        ArrayList<Patient> canAdd2 = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.isAdmitted() || patient.getTemperature() <= maxTemperature) {
                continue;
            }
            canAdd2.add(patient);
        }
        return canAdd2;
    }

    public void removeAdmitted() {
        System.out.println("Account ID of removed admitted patients");
        ArrayList<Patient> toRemove = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.isAdmitted()) {
                System.out.println(patient.getID());
                toRemove.add(patient);
            }
        }
        for (Patient patient : toRemove) {
            patients.remove(patient);
        }
    }

    public void stillInCamp() {
        int count = 0;
        for (Patient patient : patients) {
            if (!patient.isAdmitted()) {
                count++;
            }
        }
        System.out.println(count + " patients");
    }


    public void displayPatient(int ID) {
        for (Patient patient : patients) {
            if (patient.ID == ID) {
                patient.display();
                return;
            }
        }
        System.out.println("No Matching Patients");
    }

    public void displayAllPatient() {
        for (Patient patient : patients) {
            System.out.println(patient.getID() + " " + patient.getName());
        }
    }

}
