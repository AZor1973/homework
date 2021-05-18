package java1.lesson5;

public class PersonDemo {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89092665454", 70000, 30);
        persArray[1] = new Person("Petrov Petr", "Director", "petpetr@mailbox.com", "89256744787", 100000, 45);
        persArray[2] = new Person("Smirnov Sergey", "Developer", "sersmirn@mailbox.com", "89657558678", 70000, 25);
        persArray[3] = new Person("Semenov Semen", "Secretary", "semsem@mailbox.com", "89053664765", 30000, 28);
        persArray[4] = new Person("Pavlov Pavel", "Technician", "pavpav@mailbox.com", "89125116941", 50000, 41);

        for (Person person : persArray) {
            if (person.getAge() > 40) System.out.println(person);
        }
    }
}
