package basic.section3;

public class Lecture13 {
    private String address;
    private LivingRoom livingRoom;

    public Lecture13(String address, LivingRoom livingRoom) {
        this.address = address;
        this.livingRoom = livingRoom;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public static class LivingRoom{
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
    }
}
