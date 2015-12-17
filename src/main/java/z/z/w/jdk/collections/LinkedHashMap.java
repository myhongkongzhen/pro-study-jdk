/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.jdk.collections;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.jdk.collections.LinkedHashMap
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-17 16:35
 *   LastChange: 2015-12-17 16:35
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;

/**
 * <p>Hash table and linked list implementation of the <tt>Map</tt> interface,
 * map接口的哈希表與鏈錶實現
 * with predictable iteration order.  This implementation differs from
 * 可預測迭代順序
 * <tt>HashMap</tt> in that it maintains a doubly-linked list running through
 * 這個實現與hashmap的不同在於維護一個雙向鏈錶在他的entries過程中
 * all of its entries.  This linked list defines the iteration ordering,
 * which is normally the order in which keys were inserted into the map
 *  這個鏈錶定義了迭代器順序，通常為鍵值插入map的順序
 * (<i>insertion-order</i>).  Note that insertion order is not affected
 * if a key is <i>re-inserted</i> into the map.  (A key <tt>k</tt> is
 * 注意插入順序是不受影響的如果吃重複插入的鍵值
 * reinserted into a map <tt>m</tt> if <tt>m.put(k, v)</tt> is invoked when
 * <tt>m.containsKey(k)</tt> would return <tt>true</tt> immediately prior to
 * the invocation.)
 *
 * <p>This implementation spares its clients from the unspecified, generally
 * 這個實現備用他的客戶端從未指定的，通常混亂的排序由hashmap，hashtable提供的
 * chaotic ordering provided by {@link java.util.HashMap} (and {@link Hashtable}),
 * without incurring the increased cost associated with {@link TreeMap}.  It
 * 不會導致增長消耗關聯TreeMap
 * can be used to produce a copy of a map that has the same order as the
 * 如果用於生產一個拷貝的map，他有相同的順序與原始的
 * original, regardless of the original map's implementation:
 * 而無論原始的map的實現
 * <pre>
 *     void foo(Map m) {
 *         Map copy = new LinkedHashMap(m);
 *         ...
 *     }
 * </pre>
 * This technique is particularly useful if a module takes a map on input,
 * 這個技術部分用於如果一個模塊輸入map，拷貝他，並且返回的最新的結果順序由這個拷貝定義
 * copies it, and later returns results whose order is determined by that of
 * the copy.  (Clients generally appreciate having things returned in the same
 * 客戶端通常鑒別他們地窖的順序返回
 * order they were presented.)
 *
 * <p>A special {@link #LinkedHashMap(int,float,boolean) constructor} is
 * 一個特指的linkedhashmap的構造方法
 * provided to create a linked hash map whose order of iteration is the order
 * 提供創建一個鏈錶的hashmap他的迭代順序是他的entries最後的訪問順序
 * in which its entries were last accessed, from least-recently accessed to
 * 從最小的訪問到最大的訪問順序
 * most-recently (<i>access-order</i>).  This kind of map is well-suited to
 * building LRU caches.  Invoking the <tt>put</tt> or <tt>get</tt> method
 * 這個map的樂行能更好的構建LRU緩存
 * results in an access to the corresponding entry (assuming it exists after
 * 調用put或者get方法導致在一個訪問相應的entry
 * the invocation completes).  The <tt>putAll</tt> method generates one entry
 * 假設調用完成之後存在
 * access for each mapping in the specified map, in the order that key-value
 * putAll方法纏身一個entry存取為每個指定map的影射
 * mappings are provided by the specified map's entry set iterator.  <i>No
 * 在k-v影射的順序中提供指定的map的entry的集合迭代器
 * other methods generate entry accesses.</i> In particular, operations on
 * 沒有其他的方法產生entry的存儲訪問
 * collection-views do <i>not</i> affect the order of iteration of the backing
 * 尤其是，操作在集合視圖上不應聲基於map的迭代器的順序
 * map.
 *
 * <p>The {@link #removeEldestEntry(java.util.Map.Entry)} method may be overridden to
 * removeEldestEntry方法能夠複寫加強舊的影射當新的影射添加到map中自動的移除的政策
 * impose a policy for removing stale mappings automatically when new mappings
 * are added to the map.
 *
 * <p>This class provides all of the optional <tt>Map</tt> operations, and
 * 這個類提供了所有map操作
 * permits null elements.  Like <tt>HashMap</tt>, it provides constant-time
 * 并允許null元素
 * performance for the basic operations (<tt>add</tt>, <tt>contains</tt> and
 * 如同hashmap，他提供了很定的時間執行基礎的add，contains，remove操作
 * <tt>remove</tt>), assuming the hash function disperses elements
 * 假設哈希函數很好的子啊快中分散元素
 * properly among the buckets.  Performance is likely to be just slightly
 * below that of <tt>HashMap</tt>, due to the added expense of maintaining the
 * 性能僅僅比hashmap略低，應用維護添加鏈錶的消耗
 *
 * linked list, with one exception: Iteration over the collection-views
 * 附加一個異常
 * of a <tt>LinkedHashMap</tt> requires time proportional to the <i>size</i>
 * 迭代器linkedhashmap的集合視圖要求時間與map的大小成正比
 * of the map, regardless of its capacity.  Iteration over a <tt>HashMap</tt>
 * 而不論他的容量
 * is likely to be more expensive, requiring time proportional to its
 * 迭代器一個hashmap話費更多的，需要時間與容量成正比
 * <i>capacity</i>.
 *
 * <p>A linked hash map has two parameters that affect its performance:
 * 一個鏈錶哈希表有兩個參數影響他的性能
 * <i>initial capacity</i> and <i>load factor</i>.  They are defined precisely
 * 初始的容量及負載因子
 * as for <tt>HashMap</tt>.  Note, however, that the penalty for choosing an
 * 他們就是由hashmap定義的.
 * excessively high value for initial capacity is less severe for this class
 * 注意，但是，對於選擇一個過高的初始化的容量的處罰是更少的嚴重對於這類
 * than for <tt>HashMap</tt>, as iteration times for this class are unaffected
 * 對於迭代器的時間這個類不熟容量的影響
 * by capacity.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * 注意，這個實現是未同步的
 * If multiple threads access a linked hash map concurrently, and at least
 * 如果多線程的並發的存儲一個鏈錶哈希表
 * one of the threads modifies the map structurally, it <em>must</em> be
 * 至少一個線程改變map的結構
 * synchronized externally.  This is typically accomplished by
 * 他必須額外的提供同步
 * synchronizing on some object that naturally encapsulates the map.
 * 這通常由同步的相同的對象map的瘋長完成
 *
 * If no such object exists, the map should be "wrapped" using the
 * 如果沒有這樣的對象存在，map應該用collecions,synchronizedmap提供封裝
 * {@link Collections#synchronizedMap Collections.synchronizedMap}
 * method.  This is best done at creation time, to prevent accidental
 * 在創建時最好的實現，避免訪問未同步的map
 * unsynchronized access to the map:<pre>
 *   Map m = Collections.synchronizedMap(new LinkedHashMap(...));</pre>
 *
 * A structural modification is any operation that adds or deletes one or more
 * 一個結構改變是任意的操作add，delete一個或者更多的影射
 * mappings or, in the case of access-ordered linked hash maps, affects
 * 想哈希表一樣的訪問順序
 * iteration order.  In insertion-ordered linked hash maps, merely changing
 * 影響迭代器順序
 * the value associated with a key that is already contained in the map is not
 * 想哈希表一樣的插入順序，僅僅改變值管理啊一個key鍵在map中已包含的不是一個結構改變
 * a structural modification.  <strong>In access-ordered linked hash maps,
 * merely querying the map with <tt>get</tt> is a structural
 * 在想哈希表一樣的訪問順序僅僅查詢map用get不是一個結構改變
 * modification.</strong>)
 *
 * <p>The iterators returned by the <tt>iterator</tt> method of the collections
 * 迭代器返回的迭代方法有這個類的所有集合舒坦方法返回的是failfast的
 * returned by all of this class's collection view methods are
 * <em>fail-fast</em>: if the map is structurally modified at any time after
 * the iterator is created, in any way except through the iterator's own
 * 如果在迭代器創建之後任意時間結構改變
 * <tt>remove</tt> method, the iterator will throw a {@link
 * ConcurrentModificationException}.  Thus, in the face of concurrent
 *  在迭代器自身除去remove方法的任何方法，跌帶起都會拋出一個異常
 * modification, the iterator fails quickly and cleanly, rather than risking
 * 因此，並發改變的事實，迭代器快速的失敗和清理，而不是依賴不明確的未來的未確定的行為
 * arbitrary, non-deterministic behavior at an undetermined time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * 注意快速失敗的行為是不受委會的
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * 通常的講，在未同步的並發改變中，維護是不可能的
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * 快速失敗迭代器基本拋出一個異常
 * Therefore, it would be wrong to write a program that depended on this
 * 因此，依賴於他的不準確性異常編寫程序是錯誤的
 * exception for its correctness:   <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 * 快速失敗行為僅僅用於檢查bug
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Josh Bloch
 * @see     Object#hashCode()
 * @see     Collection
 * @see     java.util.Map
 * @see     java.util.HashMap
 * @see     TreeMap
 * @see     Hashtable
 * @since   1.4
 */

public class LinkedHashMap<K,V>
        extends HashMap<K,V>
        implements Map<K,V>
{

    private static final long serialVersionUID = 3801124242820219131L;

    /**
     * The head of the doubly linked list.
     */
    private transient Entry<K,V> header;

    /**
     * The iteration ordering method for this linked hash map: <tt>true</tt>
     * for access-order, <tt>false</tt> for insertion-order.
     *
     * @serial
     */
    private final boolean accessOrder;

    /**
     * Constructs an empty insertion-ordered <tt>LinkedHashMap</tt> instance
     * with the specified initial capacity and load factor.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public LinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        accessOrder = false;
    }

    /**
     * Constructs an empty insertion-ordered <tt>LinkedHashMap</tt> instance
     * with the specified initial capacity and a default load factor (0.75).
     *
     * @param  initialCapacity the initial capacity
     * @throws IllegalArgumentException if the initial capacity is negative
     */
    public LinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        accessOrder = false;
    }

    /**
     * Constructs an empty insertion-ordered <tt>LinkedHashMap</tt> instance
     * with the default initial capacity (16) and load factor (0.75).
     */
    public LinkedHashMap() {
        super();
        accessOrder = false;
    }

    /**
     * Constructs an insertion-ordered <tt>LinkedHashMap</tt> instance with
     * the same mappings as the specified map.  The <tt>LinkedHashMap</tt>
     * instance is created with a default load factor (0.75) and an initial
     * capacity sufficient to hold the mappings in the specified map.
     *
     * @param  m the map whose mappings are to be placed in this map
     * @throws NullPointerException if the specified map is null
     */
    public LinkedHashMap( java.util.Map<? extends K, ? extends V> m) {
        super(m);
        accessOrder = false;
    }

    /**
     * Constructs an empty <tt>LinkedHashMap</tt> instance with the
     * specified initial capacity, load factor and ordering mode.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @param  accessOrder     the ordering mode - <tt>true</tt> for
     *         access-order, <tt>false</tt> for insertion-order
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public LinkedHashMap(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }

    /**
     * Called by superclass constructors and pseudoconstructors (clone,
     * readObject) before any entries are inserted into the map.  Initializes
     * the chain.
     */
    @Override
    void init() {
        header = new Entry<>(-1, null, null, null);
        header.before = header.after = header;
    }

    /**
     * Transfers all entries to new table array.  This method is called
     * by superclass resize.  It is overridden for performance, as it is
     * faster to iterate using our linked list.
     */
    @Override
    void transfer( java.util.HashMap.Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e = header.after; e != header; e = e.after) {
            if (rehash)
                e.hash = (e.key == null) ? 0 : hash(e.key);
            int index = indexFor(e.hash, newCapacity);
            e.next = newTable[index];
            newTable[index] = e;
        }
    }


    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the
     * specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     *         specified value
     */
    public boolean containsValue(Object value) {
        // Overridden to take advantage of faster iterator
        if (value==null) {
            for (Entry e = header.after; e != header; e = e.after)
                if (e.value==null)
                    return true;
        } else {
            for (Entry e = header.after; e != header; e = e.after)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     */
    public V get(Object key) {
        Entry<K,V> e = (Entry<K,V>)getEntry(key);
        if (e == null)
            return null;
        e.recordAccess(this);
        return e.value;
    }

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    public void clear() {
        super.clear();
        header.before = header.after = header;
    }

    /**
     * LinkedHashMap entry.
     */
    private static class Entry<K,V> extends java.util.HashMap.Entry<K,V> {
        // These fields comprise the doubly linked list used for iteration.
        Entry<K,V> before, after;

        Entry(int hash, K key, V value, java.util.HashMap.Entry<K,V> next) {
            super(hash, key, value, next);
        }

        /**
         * Removes this entry from the linked list.
         */
        private void remove() {
            before.after = after;
            after.before = before;
        }

        /**
         * Inserts this entry before the specified existing entry in the list.
         */
        private void addBefore(Entry<K,V> existingEntry) {
            after  = existingEntry;
            before = existingEntry.before;
            before.after = this;
            after.before = this;
        }

        /**
         * This method is invoked by the superclass whenever the value
         * of a pre-existing entry is read by Map.get or modified by Map.set.
         * If the enclosing Map is access-ordered, it moves the entry
         * to the end of the list; otherwise, it does nothing.
         */
        void recordAccess( java.util.HashMap<K,V> m) {
            LinkedHashMap<K,V> lm = (LinkedHashMap<K,V>)m;
            if (lm.accessOrder) {
                lm.modCount++;
                remove();
                addBefore(lm.header);
            }
        }

        void recordRemoval( java.util.HashMap<K,V> m) {
            remove();
        }
    }

    private abstract class LinkedHashIterator<T> implements java.util.Iterator<T>
    {
        Entry<K,V> nextEntry    = header.after;
        Entry<K,V> lastReturned = null;

        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return nextEntry != header;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            LinkedHashMap.this.remove(lastReturned.key);
            lastReturned = null;
            expectedModCount = modCount;
        }

        Entry<K,V> nextEntry() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (nextEntry == header)
                throw new NoSuchElementException();

            Entry<K,V> e = lastReturned = nextEntry;
            nextEntry = e.after;
            return e;
        }
    }

    private class KeyIterator extends LinkedHashIterator<K> {
        public K next() { return nextEntry().getKey(); }
    }

    private class ValueIterator extends LinkedHashIterator<V> {
        public V next() { return nextEntry().value; }
    }

    private class EntryIterator extends LinkedHashIterator< java.util.Map.Entry<K,V>> {
        public java.util.Map.Entry<K,V> next() { return nextEntry(); }
    }

    // These Overrides alter the behavior of superclass view iterator() methods
    java.util.Iterator<K> newKeyIterator()   { return new KeyIterator();   }
    java.util.Iterator<V> newValueIterator() { return new ValueIterator(); }
    Iterator<java.util.Map.Entry<K,V>> newEntryIterator() { return new EntryIterator(); }

    /**
     * This override alters behavior of superclass put method. It causes newly
     * allocated entry to get inserted at the end of the linked list and
     * removes the eldest entry if appropriate.
     */
    void addEntry(int hash, K key, V value, int bucketIndex) {
        super.addEntry(hash, key, value, bucketIndex);

        // Remove eldest entry if instructed
        Entry<K,V> eldest = header.after;
        if (removeEldestEntry(eldest)) {
            removeEntryForKey(eldest.key);
        }
    }

    /**
     * This override differs from addEntry in that it doesn't resize the
     * table or remove the eldest entry.
     */
    void createEntry(int hash, K key, V value, int bucketIndex) {
        HashMap.Entry<K,V> old = table[bucketIndex];
        Entry<K,V>         e   = new Entry<>(hash, key, value, old);
        table[bucketIndex] = e;
        e.addBefore(header);
        size++;
    }

    /**
     * Returns <tt>true</tt> if this map should remove its eldest entry.
     * This method is invoked by <tt>put</tt> and <tt>putAll</tt> after
     * inserting a new entry into the map.  It provides the implementor
     * with the opportunity to remove the eldest entry each time a new one
     * is added.  This is useful if the map represents a cache: it allows
     * the map to reduce memory consumption by deleting stale entries.
     *
     * <p>Sample use: this override will allow the map to grow up to 100
     * entries and then delete the eldest entry each time a new entry is
     * added, maintaining a steady state of 100 entries.
     * <pre>
     *     private static final int MAX_ENTRIES = 100;
     *
     *     protected boolean removeEldestEntry(Map.Entry eldest) {
     *        return size() > MAX_ENTRIES;
     *     }
     * </pre>
     *
     * <p>This method typically does not modify the map in any way,
     * instead allowing the map to modify itself as directed by its
     * return value.  It <i>is</i> permitted for this method to modify
     * the map directly, but if it does so, it <i>must</i> return
     * <tt>false</tt> (indicating that the map should not attempt any
     * further modification).  The effects of returning <tt>true</tt>
     * after modifying the map from within this method are unspecified.
     *
     * <p>This implementation merely returns <tt>false</tt> (so that this
     * map acts like a normal map - the eldest element is never removed).
     *
     * @param    eldest The least recently inserted entry in the map, or if
     *           this is an access-ordered map, the least recently accessed
     *           entry.  This is the entry that will be removed it this
     *           method returns <tt>true</tt>.  If the map was empty prior
     *           to the <tt>put</tt> or <tt>putAll</tt> invocation resulting
     *           in this invocation, this will be the entry that was just
     *           inserted; in other words, if the map contains a single
     *           entry, the eldest entry is also the newest.
     * @return   <tt>true</tt> if the eldest entry should be removed
     *           from the map; <tt>false</tt> if it should be retained.
     */
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;
    }
}