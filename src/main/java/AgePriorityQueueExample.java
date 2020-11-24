import person.PersonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

public class AgePriorityQueueExample {
    private static final String[] firstNames = {"Omar", "Slim", "Stringer", "Avon", "Jimmy", "Keema"};

    private static final String[] lastNames = {"Little", "Charles", "Bell", "Barskdale", "McNulty", "Greggs"};

    private static PersonDTO getRandomPerson() {
        Random random = new Random();
        PersonDTO person = new PersonDTO(firstNames[random.nextInt(firstNames.length)],
                lastNames[random.nextInt(lastNames.length)]);
        person.setAge(random.nextInt(100));
        return person;
    }

    public static void main(String[] args) {
        PriorityQueue<PersonDTO> agePQ = new PriorityQueue<>();
        List<PersonDTO> persons = new ArrayList<>();
        IntStream.range(0, 5).forEach(a -> persons.add(getRandomPerson()));
        persons.stream().forEach(p -> {
            System.out.println(p.toString());
        });
        persons.stream().forEach(p -> {
            agePQ.offer(p);
        });
        System.out.println("Polling the queue now");
        while(!agePQ.isEmpty()) {
            System.out.println(agePQ.poll().toString());
        }
    }
}
