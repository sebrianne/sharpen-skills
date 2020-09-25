import java.util.ArrayList;

public class LinkedListPractice {

    static class Location {
        String name, address;
        Location next;

        public Location(String n, String a) {
            name = n;
            address = a;
            next = null;
        }
    }

    public static void main(String[] args) {
        String[] names = {"Bucks of Woodside", "SJSU", "Robert's Market"};
        String[] addresses = {"11 Woodside Road", "1 Washington Square", "32 Woodside Road"};

        Location head = new Location("Start", "0,0,0");
        Location dummy = head;

        for (int i = 0; i < 3; i++) {
            Location l = new Location(names[i], addresses[i]);
            dummy.next = l;
            dummy = dummy.next;
        }

        while (head != null) {
            System.out.println(head.address + " " + head.name);
            head = head.next;
        }
    }
}
