package datastructures;

public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    public class HashEntry {
        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashTable () { data = new HashEntry[INITIAL_SIZE]; }

    private int getIndex(String key) {
        // Get the hash code
        int hashCode = key.hashCode();
        System.out.println("hashCode = " + hashCode);

        // Convert to index
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        System.out.println("index = " + index);

        return index;
    }

    public void put (String key, String value) {

        // Get the index
        int index = getIndex(key);

        // Create the linked list entry
        HashEntry entry = new HashEntry(key, value);

        // If no entry is there - add it
        if(data[index] == null) {
            data[index] = entry;
        }
        // Else handle collision by adding to end of linked list
        else {
            HashEntry entries = data[index];
            // walk to the end
            while (entries.next != null) {
                entries = entries.next;
            }
            // add our new entry in
            entries.next = entry;
        }

    }

    public String get(String key) {
        // Get the index
        int index = getIndex(key);

        // Get the current list of entries
        HashEntry entries = data[index];

        // if we have existing entries against this key...
        if (entries != null) {
            // else walk chain until find a match
            while (!entries.key.equals(key) && entries.next != null) {
                entries = entries.next;
            }
            // then return it
            return entries.value;
        }

        // if we have no entries against this key...
        return null;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put("Spiderman", "206-3841");
        table.put("Thor", "333-2549");
        table.put("Captain America", "789-5541");
        table.put("Ant Man", "888-8415");
        table.put("The Hulk", "506-1548");
        table.put("Black Panther", "123-9999");
        table.put("Iron Man", "777-5468");
        System.out.println(table.toString());
    }
}
