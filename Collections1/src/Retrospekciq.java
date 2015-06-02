import java.util.concurrent.CopyOnWriteArrayList;


public class Retrospekciq {
Iterator vs ListIterator(obhojda nazad, samo za list);
Comparator(sravnqva dve instancii) vs Comparable(svoistvo na dva elementa da se sravnqvat,sravnim sys sebe si,implements Comparable, compareTo );
Collection.sort(list, new TestComparator());
CopyOnWriteArrayList<E>;
Collection.getSyncList();

HashMap vs HashTable vs TreeMap(spored Compare ili Comparatora) vs LinkedHashMap(insertionOrder);

PriorityQueue;
Heap;
node.priority >parentNode.priority

offer
peak nai malyk prioritet
poll

HashTable(){
	hash function(object) -> chislo
	if object1 = object2 => hash1 = hash2
	if hash1 = hash2 !=> object1 = object2
}
}
HashSet vs TreeSet
