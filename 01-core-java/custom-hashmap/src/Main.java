public class Main {
    public static void main(String[] args) {

        System.out.println("=== Custom HashMap Full Example ===\n");
        MyHashMap<String, Integer> map= new MyHashMap();

        // 1. PUT operations
        System.out.println("1. Adding elements:");
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Diana", 28);
        map.put("Eve", 32);
        System.out.println("Added 5 elements");
        System.out.println("Size: " + map.size() + "\n");

        // 2. GET operations
        System.out.println("2. Retrieving elements:");
        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Bob's age: " + map.get("Bob"));
        System.out.println("Non-existent key: " + map.get("Frank") + "\n");

        // 3. UPDATE operation (put with existing key)
        System.out.println("3. Updating existing key:");
        System.out.println("Charlie's age before: " + map.get("Charlie"));
        map.put("Charlie", 36);
        System.out.println("Charlie's age after: " + map.get("Charlie") + "\n");


        // 4. REMOVE operation
        System.out.println("4. Removing elements:");
        System.out.println("Size before remove: " + map.size());
        map.remove("Bob");
        System.out.println("Removed Bob");
        System.out.println("Size after remove: " + map.size());
        System.out.println("Bob's age after removal: " + map.get("Bob") + "\n");

        // 5. Test collision handling (add many elements to trigger resize)
        System.out.println("5. Testing resize and collision handling:");
        System.out.println("Adding more elements to trigger resize...");
        for (int i = 0; i < 20; i++) {
            map.put(String.format("Person%d",i) , 20 + i);
        }
        System.out.println("Total size after bulk insert: " + map.size() + "\n");

        // 6. Verify all elements are still accessible
        System.out.println("6. Verifying elements after resize:");
        System.out.println("Alice: " + map.get("Alice"));
        System.out.println("Diana: " + map.get("Diana"));
        System.out.println("Person10: " + map.get("Person10"));
        System.out.println("Person19: " + map.get("Person19") + "\n");

        // 7. Test with different data types
        System.out.println("7. Using different data types:");
        MyHashMap<Integer, String> idToName = new MyHashMap<>();
        idToName.put(101, "John Doe");
        idToName.put(102, "Jane Smith");
        idToName.put(103, "Mike Johnson");

        System.out.println("Employee 101: " + idToName.get(101));
        System.out.println("Employee 102: " + idToName.get(102));
        System.out.println("Employee 103: " + idToName.get(103) + "\n");

        // 8. Custom objects as values
        System.out.println("8. Using custom objects:");

        MyHashMap<String, Person> personMap = new MyHashMap<>();
        personMap.put("emp1", new Person("John", 28));
        personMap.put("emp2", new Person("Sarah", 32));
        personMap.put("emp3", new Person("Tom", 25));

        Person emp1 = personMap.get("emp1");
        System.out.println("Employee 1: " + emp1);

        System.out.println("\n=== Custom HashMap Full Example Complete ===");
    }



    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}