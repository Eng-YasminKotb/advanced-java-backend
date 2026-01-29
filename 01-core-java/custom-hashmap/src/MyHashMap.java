public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY=16;
    private static final float DEFAULT_LOAD_FACTOR=0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private Node<K, V>[] table;


    // Constructor 1: No parameters
    public MyHashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
        // ↑ Calls Constructor 2 below


    }

    // Constructor 2: With parameters
    public MyHashMap(int capacity, float loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[capacity];
        this.size = 0;

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
        //Handling null keys
        if(key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
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
        size++;

        if( size > capacity * loadFactor){
            resize();
        }

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

    public void remove(K key){
        int index=hash(key);
        Node<K, V> node=table[index];
        Node<K, V> prev=null;

        while(node != null){
            if(node.key.equals(key)){

                if(prev == null){
                    table[index] = node.next;
                }
                else{
                    prev.next=node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }

    }

    private void resize(){
        int newCapacity = capacity * 2;
        Node<K, V>[]  newTable = new Node[newCapacity] ;

        for(int i = 0; i < capacity ; i++){
            Node<K, V> node=table[i];
            while (node != null){
                Node<K, V> next=node.next;
                int index = Math.abs(node.key.hashCode())  % newCapacity ;
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }


    public int size() {
        return size;
    }






}
