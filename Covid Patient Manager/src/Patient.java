public class Patient {
    static int nextId = 1;
    int ID;
    String name;
    float temperature;
    int oxygen;
    int age;
    boolean isAdmitted;
    int recoveryTime;
    Institute institute;

    Patient(String name, float temperature, int oxygen, int age) {
        this.name = name;
        this.temperature = temperature;
        this.oxygen = oxygen;
        this.age = age;
        this.ID = nextId++;
    }

    public void display() {
        System.out.println(name);
        System.out.println("Temperature is " + temperature);
        System.out.println("Oxygen level is " + oxygen);
        System.out.print("Admission States - ");
        if (isAdmitted) {
            System.out.println("Admitted");
            System.out.println("Admitting Institute - " + institute.name);
        }else {
            System.out.println("Not Admitted");
        }
    }

    public void setAdmitted(boolean admitted) {
        isAdmitted = admitted;
    }

    public boolean isAdmitted() {
        return isAdmitted;
    }

    public int getOxygen() {
        return oxygen;
    }

    public float getTemperature() {
        return temperature;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(int recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

}
