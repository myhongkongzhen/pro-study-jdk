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
 *     FileName: z.z.w.jdk.collections.Map
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-15 14:34
 *   LastChange: 2015-12-15 14:34
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.HashMap;
import java.util.Hashtable;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * An object that maps keys to values.  A map cannot contain duplicate keys;
 * 一個影射key-value的對象
 * each key can map to at most one value.
 * 一個map不能包含重複的key，每一個key能影射最多一個value
 *
 * <p>This interface takes the place of the <tt>Dictionary</tt> class, which
 * 這個接口提供了字典類
 * was a totally abstract class rather than an interface.
 * 是完全的抽象類，而不是一個接口
 *
 * <p>The <tt>Map</tt> interface provides three <i>collection views</i>, which
 * Map接口提供三個集合視圖
 * allow a map's contents to be viewed as a set of keys, collection of values,
 *  允許一個map的內容由key的集合展示,values的集合，或者k-v影射的結合
 * or set of key-value mappings.  The <i>order</i> of a map is defined as
 * the order in which the iterators on the map's collection views return their
 * 一個map的順序由這個map元素返回的集合視圖的迭代器順序定義
 * elements.  Some map implementations, like the <tt>TreeMap</tt> class, make
 *            一些map實現，像TreeMap類
 * specific guarantees as to their order; others, like the <tt>HashMap</tt>
 *  特殊的維護他們的順序，另外的，像HashMap類，不維護順序
 * class, do not.
 *
 * <p>Note: great care must be exercised if mutable objects are used as map
 * 注意：最關心的必須是多變的對象的應用用於map的key
 * keys.  The behavior of a map is not specified if the value of an object is
 *        一個map的行為是沒有特定的，如果一個對象的值改變了在 map的的對象是個key
 * changed in a manner that affects <tt>equals</tt> comparisons while the
 * 比較equals方式
 * object is a key in the map.  A special case of this prohibition is that it
 * is not permissible for a map to contain itself as a key.  While it is
 * 這種違規的特殊情況的寓意一個map包含他自己作為一個key是不允許的
 * permissible for a map to contain itself as a value, extreme caution is
 *  當他允許作為一個map包含自身的一個值時，
 * advised: the <tt>equals</tt> and <tt>hashCode</tt> methods are no longer
 * 極端的警告是：equals與hashCode方法不能作為一個map更好的定義
 * well defined on such a map.
 *
 * <p>All general-purpose map implementation classes should provide two
 * 所有通用目的的map實現類應該提供過兩個基本的構造器
 * "standard" constructors: a void (no arguments) constructor which creates an
 * 一個無參數的構造器，用於創建一個空的map
 * empty map, and a constructor with a single argument of type <tt>Map</tt>,
 * 一個只有一個Map類型的參數的構造器
 * which creates a new map with the same key-value mappings as its argument.
 * 用於創建一個相同k-v影射的參數
 * In effect, the latter constructor allows the user to copy any map,
 * 事實上，最新的構造器允許用戶拷貝任何map
 * producing an equivalent map of the desired class.  There is no way to
 * 生產處一個希望的類的相同的map
 * enforce this recommendation (as interfaces cannot contain constructors) but
 * 沒有方法執行這個建議(作為接口不能包含構造器)
 * all of the general-purpose map implementations in the JDK comply.
 * 但是所有的通用目的的map實現在JDK中執行
 *
 * <p>The "destructive" methods contained in this interface, that is, the
 * 這接口包含了不好的方法
 * methods that modify the map on which they operate, are specified to throw
 * 這些方法就是在他們操作中改變map
 * <tt>UnsupportedOperationException</tt> if this map does not support the
 *  如果這個map不支持這些操作，將會指定拋出一個異常
 * operation.  If this is the case, these methods may, but are not required
 * 這些方法能夠，但不是必須的，如果在map中不期望的調用，拋出一個異常的原因
 * to, throw an <tt>UnsupportedOperationException</tt> if the invocation would
 * have no effect on the map.  For example, invoking the {@link #putAll(Map)}
 * 列入，調用putAll方法在一個不可改變map中，
 * method on an unmodifiable map may, but is not required to, throw the
 * 不是必須的，如果jap影射支持空，會拋出一個異常
 * exception if the map whose mappings are to be "superimposed" is empty.
 *
 * <p>Some map implementations have restrictions on the keys and values they
 * 一些map實現存在限制，在他們包含的k-v上
 * may contain.  For example, some implementations prohibit null keys and
 * 例如，一些實現禁止null的key與values
 * values, and some have restrictions on the types of their keys.  Attempting
 * 一些則限制key的類型
 * to insert an ineligible key or value throws an unchecked exception,
 * 常識添加一個不適合的key或者value拋出一個未檢查異常
 * typically <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.
 * 通常是 NullPointerException or ClassCastException異常
 * Attempting to query the presence of an ineligible key or value may throw an
 * 常識查詢一個不合適的key與value是否村子，也許拋出一個異常
 * exception, or it may simply return false; some implementations will exhibit
 * 或者簡單的返回false
 * the former behavior and some will exhibit the latter.  More generally,
 * 一些實現將展示前驅的行為，一些將展示後繼的行為
 * attempting an operation on an ineligible key or value whose completion
 * 更通俗的講，視圖操作一個不適合的key與value在不合適的元素插入一個map完成是沒有結果的
 * would not result in the insertion of an ineligible element into the map may
 * throw an exception or it may succeed, at the option of the implementation.
 * 或許拋出一個異常，或者他可能成功，在可選的實現中
 * Such exceptions are marked as "optional" in the specification for this
 * 一些異常是標記為可選的對於這個接口
 * interface.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * <p>Many methods in Collections Framework interfaces are defined
 * 在集合框架接口中許多方法是定義的在equals條目上
 * in terms of the {@link Object#equals(Object) equals} method.  For
 * example, the specification for the {@link #containsKey(Object)
 * 例如，忒定的containKey方法：
 * containsKey(Object key)} method says: "returns <tt>true</tt> if and
 * 返回true當且僅當map包含key ( key == null ? k == null: key.equals(k))的情況下
 * only if this map contains a mapping for a key <tt>k</tt> such that
 * <tt>(key==null ? k==null : key.equals(k))</tt>." This specification should
 * <i>not</i> be construed to imply that invoking <tt>Map.containsKey</tt>
 * 特定將不會解釋意味著調用Map.containsKey用一個非空餐宿key對於任意k調用
 * with a non-null argument <tt>key</tt> will cause <tt>key.equals(k)</tt> to
 * be invoked for any key <tt>k</tt>.  Implementations are free to
 * implement optimizations whereby the <tt>equals</tt> invocation is avoided,
 * 實現是自由的對於實現優化任何避免調用equals的地方
 * for example, by first comparing the hash codes of the two keys.  (The
 * 例如，用於比較兩個key的hashcode
 * {@link Object#hashCode()} specification guarantees that two objects with
 * hashCode特定維護兩個對象不同的hashcode不會相等
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * the various Collections Framework interfaces are free to take advantage of
 * 更通暢的講，各個集合框架接口的實現自由的指定底層方法的行為
 * the specified behavior of underlying {@link Object} methods wherever the
 * implementor deems it appropriate.
 * 在任何認為適當的地方實現
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Josh Bloch
 * @see HashMap
 * @see TreeMap
 * @see Hashtable
 * @see SortedMap
 * @see java.util.Collection
 * @see java.util.Set
 * @since 1.2
 */
public interface Map<K,V> {
    // Query Operations

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified
     * key.  More formally, returns <tt>true</tt> if and only if
     * this map contains a mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified
     *         key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this map
     *         does not permit null keys
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsKey(Object key);

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the
     * specified value.  More formally, returns <tt>true</tt> if and only if
     * this map contains at least one mapping to a value <tt>v</tt> such that
     * <tt>(value==null ? v==null : value.equals(v))</tt>.  This operation
     * will probably require time linear in the map size for most
     * implementations of the <tt>Map</tt> interface.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     *         specified value
     * @throws ClassCastException if the value is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this
     *         map does not permit null values
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsValue(Object value);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>If this map permits null values, then a return value of
     * {@code null} does not <i>necessarily</i> indicate that the map
     *                                          表明
     * contains no mapping for the key; it's also possible that the map
     * explicitly maps the key to {@code null}.  The {@link #containsKey
     * 明確
     * containsKey} operation may be used to distinguish these two cases.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this map contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this map
     *         does not permit null keys
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    V get(Object key);

    // Modification Operations

    /**
     * Associates the specified value with the specified key in this map
     * 關聯
     * (optional operation).  If the map previously contained a mapping for
     *                        如果集合先前包含了key的影射
     * the key, the old value is replaced by the specified value.  (A map
     *          舊值會由指定的值指定
     * <tt>m</tt> is said to contain a mapping for a key <tt>k</tt> if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * <tt>true</tt>.)
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>,
     *         if the implementation supports <tt>null</tt> values.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this map
     * @throws NullPointerException if the specified key or value is null
     *         and this map does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this map
     */
    V put(K key, V value);

    /**
     * Removes the mapping for a key from this map if it is present
     * (optional operation).   More formally, if this map contains a mapping
     * from key <tt>k</tt> to value <tt>v</tt> such that
     * <code>(key==null ?  k==null : key.equals(k))</code>, that mapping
     * is removed.  (The map can contain at most one such mapping.)
     *
     * <p>Returns the value to which this map previously associated the key,
     * 返回先前map中關聯這個key的值
     * or <tt>null</tt> if the map contained no mapping for the key.
     * 如果沒有影射返回null
     *
     * <p>If this map permits null values, then a return value of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the map
     * contained no mapping for the key; it's also possible that the map
     * explicitly mapped the key to <tt>null</tt>.
     *
     * <p>The map will not contain a mapping for the specified key once the
     * call returns.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this map
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this
     *         map does not permit null keys
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    V remove(Object key);


    // Bulk Operations

    /**
     * Copies all of the mappings from the specified map to this map
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object,Object) put(k, v)} on this map once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified map.  The behavior of this operation is undefined if the
     * specified map is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this map
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this map
     * @throws ClassCastException if the class of a key or value in the
     *         specified map prevents it from being stored in this map
     * @throws NullPointerException if the specified map is null, or if
     *         this map does not permit null keys or values, and the
     *         specified map contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified map prevents it from being stored in this map
     */
    void putAll(Map<? extends K, ? extends V> m);

    /**
     * Removes all of the mappings from this map (optional operation).
     * The map will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *         is not supported by this map
     */
    void clear();


    // Views

    /**
     * Returns a {@link java.util.Set} view of the keys contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation), the results of
     * the iteration are undefined.  The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
     * operations.
     *
     * @return a set view of the keys contained in this map
     */
    Set<K> keySet();

    /**
     * Returns a {@link java.util.Collection} view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a collection view of the values contained in this map
     */
    Collection<V> values();

    /**
     * Returns a {@link java.util.Set} view of the mappings contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation, or through the
     * <tt>setValue</tt> operation on a map entry returned by the
     * iterator) the results of the iteration are undefined.  The set
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
     * <tt>clear</tt> operations.  It does not support the
     * <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a set view of the mappings contained in this map
     */
    Set< z.z.w.jdk.collections.Map.Entry<K, V>> entrySet();

    /**
     * A map entry (key-value pair).  The <tt>Map.entrySet</tt> method returns
     * a collection-view of the map, whose elements are of this class.  The
     * <i>only</i> way to obtain a reference to a map entry is from the
     * iterator of this collection-view.  These <tt>Map.Entry</tt> objects are
     * valid <i>only</i> for the duration of the iteration; more formally,
     * the behavior of a map entry is undefined if the backing map has been
     * modified after the entry was returned by the iterator, except through
     * the <tt>setValue</tt> operation on the map entry.
     *
     * @see Map#entrySet()
     * @since 1.2
     */
    interface Entry<K,V> {
        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
        K getKey();

        /**
         * Returns the value corresponding to this entry.  If the mapping
         * has been removed from the backing map (by the iterator's
         * <tt>remove</tt> operation), the results of this call are undefined.
         *
         * @return the value corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
        V getValue();

        /**
         * Replaces the value corresponding to this entry with the specified
         * value (optional operation).  (Writes through to the map.)  The
         * behavior of this call is undefined if the mapping has already been
         * removed from the map (by the iterator's <tt>remove</tt> operation).
         *
         * @param value new value to be stored in this entry
         * @return old value corresponding to the entry
         * @throws UnsupportedOperationException if the <tt>put</tt> operation
         *         is not supported by the backing map
         * @throws ClassCastException if the class of the specified value
         *         prevents it from being stored in the backing map
         * @throws NullPointerException if the backing map does not permit
         *         null values, and the specified value is null
         * @throws IllegalArgumentException if some property of this value
         *         prevents it from being stored in the backing map
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
        V setValue(V value);

        /**
         * Compares the specified object with this entry for equality.
         * Returns <tt>true</tt> if the given object is also a map entry and
         * the two entries represent the same mapping.  More formally, two
         * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
         * if<pre>
         *     (e1.getKey()==null ?
         *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
         *     (e1.getValue()==null ?
         *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
         * </pre>
         * This ensures that the <tt>equals</tt> method works properly across
         * different implementations of the <tt>Map.Entry</tt> interface.
         *
         * @param o object to be compared for equality with this map entry
         * @return <tt>true</tt> if the specified object is equal to this map
         *         entry
         */
        boolean equals(Object o);

        /**
         * Returns the hash code value for this map entry.  The hash code
         * of a map entry <tt>e</tt> is defined to be: <pre>
         *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
         *     (e.getValue()==null ? 0 : e.getValue().hashCode())
         * </pre>
         * This ensures that <tt>e1.equals(e2)</tt> implies that
         * <tt>e1.hashCode()==e2.hashCode()</tt> for any two Entries
         * <tt>e1</tt> and <tt>e2</tt>, as required by the general
         * contract of <tt>Object.hashCode</tt>.
         *
         * @return the hash code value for this map entry
         * @see Object#hashCode()
         * @see Object#equals(Object)
         * @see #equals(Object)
         */
        int hashCode();
    }

    // Comparison and hashing

    /**
     * Compares the specified object with this map for equality.  Returns
     * <tt>true</tt> if the given object is also a map and the two maps
     * represent the same mappings.  More formally, two maps <tt>m1</tt> and
     * <tt>m2</tt> represent the same mappings if
     * <tt>m1.entrySet().equals(m2.entrySet())</tt>.  This ensures that the
     * <tt>equals</tt> method works properly across different implementations
     * of the <tt>Map</tt> interface.
     *
     * @param o object to be compared for equality with this map
     * @return <tt>true</tt> if the specified object is equal to this map
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this map.  The hash code of a map is
     * defined to be the sum of the hash codes of each entry in the map's
     * <tt>entrySet()</tt> view.  This ensures that <tt>m1.equals(m2)</tt>
     * implies that <tt>m1.hashCode()==m2.hashCode()</tt> for any two maps
     * <tt>m1</tt> and <tt>m2</tt>, as required by the general contract of
     * {@link Object#hashCode}.
     *
     * @return the hash code value for this map
     * @see Map.Entry#hashCode()
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

}