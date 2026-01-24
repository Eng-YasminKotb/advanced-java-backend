import javax.xml.bind.annotation.XmlType;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY=16;
    private static final float DEFAULT_LOAD_FACTOR=0.75f;

    private int capacity;
    private int size;
    private float loadFactor;
    private Node<K, V>[] table;


    // Constructor 1: No parameters
    public MyHashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
        // ↑ Calls Constructor 2 below


    }

    // Constructor 2: With parameters
    public MyHashMap(int capacity, float loadFactor){
        this.capacity=capacity;
        this.loadFactor=loadFactor;

    }


    private class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;

        Node(K key,V value){
            this.key=key;
            this.value=value;

        }
    }

    private int hash(K key){
        return key.hashCode() % capacity;
    }

    public void put(K key, V val){
        int index=hash(key);
        Node<K, V> node=table[index];

        while(node!=null){
            if(node.key.equals(key)){
                node.value=val;
                return;
            }
            node=node.next;
        }
        Node<K, V> newNode= new Node<>(key, val);
        newNode.next=table[index];
        table[index]=newNode;


    }
    public V get(K key){
        int index=hash(key);
        Node<K, V> node=table[index];
        while(node != null ){
            if(node.key.equals(key)){
                return node.value;
            }
            node=node.next;
        }
        return null;
    }






}
