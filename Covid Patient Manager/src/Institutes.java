import java.util.ArrayList;

public class Institutes {

    ArrayList<Institute> institutes;

    Institutes() {
        institutes = new ArrayList<>();
    }

    public void removeInstitutes() {
        System.out.println("Accounts removed of Institute whose admission is closed");

        ArrayList<Institute> toRemove = new ArrayList<>();
        for (Institute institute : institutes) {
            if (!institute.isAdmissionStatus()) {
                System.out.println(institute.getName());
                toRemove.add(institute);
            }
        }

        for (Institute institute : toRemove) {
            institutes.remove(institute);
        }
    }

    public void admittingCurrently() {
        int count = 0;
        for (Institute institute : institutes) {
            if (institute.isAdmissionStatus()) {
                count++;
            }
        }
        System.out.println(count +  " institutes are admitting patients currently");
    }

    public void displayInstitute(String name) {
        for (Institute institute : institutes) {
            if (institute.getName().equals(name)) {
                institute.display();
                return;
            }
        }
        System.out.println("Record Does Not Exists");
    }

    public void displayPatientOfInstitutes(String name) {

        for (Institute institute : institutes) {
            System.out.println(institute.getName());
            if (institute.getName().equals(name)) {
                institute.displayPatients();
            }
        }
    }

    public void addInstitute(Institute institute) {
        institutes.add(institute);
    }

    public Institute getLast() {
        return institutes.get(institutes.size() - 1);
    }

}
