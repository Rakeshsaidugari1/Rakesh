public class TestFanApp {
    public static void main(String[] args) {
        
        Fan defaultFan = new Fan();
        
        Fan customFan = new Fan(Fan.FAST, true, 10.0, "blue");

        System.out.println("Default Fan: " + defaultFan.toString());
        System.out.println("Custom Fan: " + customFan.toString());
    }
}
