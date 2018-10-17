// В этом примере будем строить граф и производить поиск в ширину по графу.
// Критерий поиска. Является ли человек продавцом манго?
// если является возврщаем человека. Если нет null
import java.util.*;

public class SearchWide
{
    HashMap<String, Person[]> graph = new HashMap<String, Person[]>(); 
    ArrayDeque<Person> searchDeque = new ArrayDeque<Person>();
    ArrayList<Person> searched = new ArrayList<Person>();
	
    public Person go(String key)
    {
        fillGraphTestData();
        addToQueue(graph.get(key));

        while (!searchDeque.isEmpty()) {
            Person p = searchDeque.poll();
            if (p.getSeller() == true) {
                return p;  
            } else {            
                addToQueue(graph.get(p.getName()));
            }
        }

        return null;
    }

    private void addToQueue(Person[] arr)
    {
        for (Person p : arr) {

            if (!searched.contains(p)) {
                searchDeque.offer(p);
                searched.add(p);
            }
        }
    }

    private void fillGraphTestData()
    {
        Person you = new Person("You", false);
        Person bob = new Person("Bob", false);
        Person alice = new Person("Alice", false);
        Person claire = new Person("Claire", false);
        Person anuj = new Person("Anuj", false);
        Person peggy = new Person("Peggy", false);
        Person thom = new Person("Thom", true);
        Person jonny = new Person("Jonny", true);

        Person[] youFriends = {bob, alice, claire};
        Person[] bobFriends = {anuj, peggy};
        Person[] aliceFriends = {peggy};
        Person[] claireFriends = {thom, jonny};
        Person[] anujFriends = {};
        Person[] peggyFriends = {};
        Person[] thomFriends = {};
        Person[] jonnyFriends = {};



        graph.put(you.getName(), youFriends);
        graph.put(bob.getName(), bobFriends);
        graph.put(alice.getName(), aliceFriends);
        graph.put(claire.getName(), claireFriends);
        graph.put(anuj.getName(), anujFriends);
        graph.put(peggy.getName(), peggyFriends);
        graph.put(thom.getName(), thomFriends);
        graph.put(jonny.getName(), jonnyFriends);  
    }
}