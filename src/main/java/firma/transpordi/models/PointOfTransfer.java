package firma.transpordi.models;


public class PointOfTransfer {

    private String address;
    private String openHoursBegin; // change later to more appropriate type
    private String openHoursEnd; // change later to more appropriate type
    private String active; // change later to more appropriate type
    private String name;
    private String score; // change later to more appropriate type

    public PointOfTransfer() {

    }

    public PointOfTransfer(String address, String openHoursBegin, String openHoursEnd, String active, String name, String score) {
        this.address = address;
        this.openHoursBegin = openHoursBegin;
        this.openHoursEnd = openHoursEnd;
        this.active = active;
        this.name = name;
        this.score = score;
    }

    public PointOfTransfer(String address, String active, String name, String score) {
        this.address = address;
        this.active = active;
        this.name = name;
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenHoursBegin() {
        return openHoursBegin;
    }

    public void setOpenHoursBegin(String openHoursBegin) {
        this.openHoursBegin = openHoursBegin;
    }

    public String getOpenHoursEnd() {
        return openHoursEnd;
    }

    public void setOpenHoursEnd(String openHoursEnd) {
        this.openHoursEnd = openHoursEnd;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
