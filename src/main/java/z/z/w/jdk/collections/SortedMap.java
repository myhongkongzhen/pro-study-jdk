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
 *     FileName: z.z.w.jdk.collections.SortedMap
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-15 15:32
 *   LastChange: 2015-12-15 15:32
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;

/**
 * A {@link java.util.Map} that further provides a <em>total ordering</em> on its keys.
 * Map依據他的key提供了總共的排序
 * The map is ordered according to the {@linkplain Comparable natural
 * map按照自然順序排序
 * ordering} of its keys, or by a {@link Comparator} typically
 * 或者由Comparator提供的排列順序
 * provided at sorted map creation time.  This order is reflected when
 * iterating over the sorted map's collection views (returned by the
 * 這個順序會由迭代器遍歷map集合視圖的時候引用
 * {@code entrySet}, {@code keySet} and {@code values} methods).
 * 由entrySet，keySet，values方法返回
 * Several additional operations are provided to take advantage of the
 * 多個額外的操作由更深入的排序提供
 * ordering.  (This interface is the map analogue of {@link java.util.SortedSet}.)
 * 這個接口與SortedSet類似的集合
 *
 * <p>All keys inserted into a sorted map must implement the {@code Comparable}
 * 所有keys插入排序的map必須實現Comparable接口
 * interface (or be accepted by the specified comparator).  Furthermore, all
 *                                                          此外
 * such keys must be <em>mutually comparable</em>: {@code k1.compareTo(k2)} (or
 * 所有這樣的keys必須相互比較
 * {@code comparator.compare(k1, k2)}) must not throw a
 * {@code ClassCastException} for any keys {@code k1} and {@code k2} in
 * the sorted map.  Attempts to violate this restriction will cause the
 *                  試圖違反這個限制將會導致違反方法或者構造器調用拋出一個異常
 * offending method or constructor invocation to throw a
 * {@code ClassCastException}.
 *
 * <p>Note that the ordering maintained by a sorted map (whether or not an
 * 注意排序的map維護順序
 * explicit comparator is provided) must be <em>consistent with equals</em> if
 * 必須兼容equals
 * the sorted map is to correctly implement the {@code Map} interface.  (See
 * 如果已排序的map正確的實現了Map接口
 * the {@code Comparable} interface or {@code Comparator} interface for a
 * precise definition of <em>consistent with equals</em>.)  This is so because
 * the {@code Map} interface is defined in terms of the {@code equals}
 * 這就是由equals操作條目定義的接口的原因
 * operation, but a sorted map performs all key comparisons using its
 * 但是已排序的map執行所有的key的比較用compareTo或者compare方法
 * {@code compareTo} (or {@code compare}) method, so two keys that are
 * deemed equal by this method are, from the standpoint of the sorted map,
 * 兩個keys認為是相等的又這個方法，從排序的map的角度
 * equal.  The behavior of a tree map <em>is</em> well-defined even if its
 * treemap的行為是更好的實現，如果他的排序不適合用equals
 * ordering is inconsistent with equals; it just fails to obey the general
 * contract of the {@code Map} interface.
 *
 * <p>All general-purpose sorted map implementation classes should provide four
 * "standard" constructors. It is not possible to enforce this recommendation
 *                                                執行             建議
 * though as required constructors cannot be specified by interfaces. The
 * expected "standard" constructors for all sorted map implementations are:
 * <ol>
 *   <li>A void (no arguments) constructor, which creates an empty sorted map
 *   sorted according to the natural ordering of its keys.</li>
 *   <li>A constructor with a single argument of type {@code Comparator}, which
 *   creates an empty sorted map sorted according to the specified comparator.</li>
 *   <li>A constructor with a single argument of type {@code Map}, which creates
 *   a new map with the same key-value mappings as its argument, sorted
 *   according to the keys' natural ordering.</li>
 *   <li>A constructor with a single argument of type {@code SortedMap}, which
 *   creates a new sorted map with the same key-value mappings and the same
 *   ordering as the input sorted map.</li>
 * </ol>
 *
 * <p><strong>Note</strong>: several methods return submaps with restricted key
 * 注意：幾個方法返回submaps由受限的key範圍
 * ranges. Such ranges are <em>half-open</em>, that is, they include their low
 * endpoint but not their high endpoint (where applicable).  If you need a
 * <em>closed range</em> (which includes both endpoints), and the key type
 * allows for calculation of the successor of a given key, merely request
 * the subrange from {@code lowEndpoint} to
 * {@code successor(highEndpoint)}.  For example, suppose that {@code m}
 * is a map whose keys are strings.  The following idiom obtains a view
 * containing all of the key-value mappings in {@code m} whose keys are
 * between {@code low} and {@code high}, inclusive:<pre>
 *   SortedMap&lt;String, V&gt; sub = m.subMap(low, high+"\0");</pre>
 *
 * A similar technique can be used to generate an <em>open range</em>
 * (which contains neither endpoint).  The following idiom obtains a
 * view containing all of the key-value mappings in {@code m} whose keys
 * are between {@code low} and {@code high}, exclusive:<pre>
 *   SortedMap&lt;String, V&gt; sub = m.subMap(low+"\0", high);</pre>
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Josh Bloch
 * @see java.util.Map
 * @see TreeMap
 * @see java.util.SortedSet
 * @see Comparator
 * @see Comparable
 * @see java.util.Collection
 * @see ClassCastException
 * @since 1.2
 */

public interface SortedMap<K,V> extends Map<K,V>
{
    /**
     * Returns the comparator used to order the keys in this map, or
     * {@code null} if this map uses the {@linkplain Comparable
     * natural ordering} of its keys.
     *
     * @return the comparator used to order the keys in this map,
     *         or {@code null} if this map uses the natural ordering
     *         of its keys
     */
    Comparator<? super K> comparator();

    /**
     * Returns a view of the portion of this map whose keys range from
     * {@code fromKey}, inclusive, to {@code toKey}, exclusive.  (If
     * {@code fromKey} and {@code toKey} are equal, the returned map
     * is empty.)  The returned map is backed by this map, so changes
     * in the returned map are reflected in this map, and vice-versa.
     * The returned map supports all optional map operations that this
     * map supports.
     *
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey low endpoint (inclusive) of the keys in the returned map
     * @param toKey high endpoint (exclusive) of the keys in the returned map
     * @return a view of the portion of this map whose keys range from
     *         {@code fromKey}, inclusive, to {@code toKey}, exclusive
     * @throws ClassCastException if {@code fromKey} and {@code toKey}
     *         cannot be compared to one another using this map's comparator
     *         (or, if the map has no comparator, using natural ordering).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromKey} or {@code toKey}
     *         cannot be compared to keys currently in the map.
     * @throws NullPointerException if {@code fromKey} or {@code toKey}
     *         is null and this map does not permit null keys
     * @throws IllegalArgumentException if {@code fromKey} is greater than
     *         {@code toKey}; or if this map itself has a restricted
     *         range, and {@code fromKey} or {@code toKey} lies
     *         outside the bounds of the range
     */
    SortedMap<K,V> subMap(K fromKey, K toKey);

    /**
     * Returns a view of the portion of this map whose keys are
     * strictly less than {@code toKey}.  The returned map is backed
     * by this map, so changes in the returned map are reflected in
     * this map, and vice-versa.  The returned map supports all
     * optional map operations that this map supports.
     *
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param toKey high endpoint (exclusive) of the keys in the returned map
     * @return a view of the portion of this map whose keys are strictly
     *         less than {@code toKey}
     * @throws ClassCastException if {@code toKey} is not compatible
     *         with this map's comparator (or, if the map has no comparator,
     *         if {@code toKey} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code toKey} cannot be compared to keys
     *         currently in the map.
     * @throws NullPointerException if {@code toKey} is null and
     *         this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *         restricted range, and {@code toKey} lies outside the
     *         bounds of the range
     */
    SortedMap<K,V> headMap(K toKey);

    /**
     * Returns a view of the portion of this map whose keys are
     * greater than or equal to {@code fromKey}.  The returned map is
     * backed by this map, so changes in the returned map are
     * reflected in this map, and vice-versa.  The returned map
     * supports all optional map operations that this map supports.
     *
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey low endpoint (inclusive) of the keys in the returned map
     * @return a view of the portion of this map whose keys are greater
     *         than or equal to {@code fromKey}
     * @throws ClassCastException if {@code fromKey} is not compatible
     *         with this map's comparator (or, if the map has no comparator,
     *         if {@code fromKey} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromKey} cannot be compared to keys
     *         currently in the map.
     * @throws NullPointerException if {@code fromKey} is null and
     *         this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *         restricted range, and {@code fromKey} lies outside the
     *         bounds of the range
     */
    SortedMap<K,V> tailMap(K fromKey);

    /**
     * Returns the first (lowest) key currently in this map.
     *
     * @return the first (lowest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    K firstKey();

    /**
     * Returns the last (highest) key currently in this map.
     *
     * @return the last (highest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    K lastKey();

    /**
     * Returns a {@link java.util.Set} view of the keys contained in this map.
     * The set's iterator returns the keys in ascending order.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own {@code remove} operation), the results of
     * the iteration are undefined.  The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear}
     * operations.  It does not support the {@code add} or {@code addAll}
     * operations.
     *
     * @return a set view of the keys contained in this map, sorted in
     *         ascending order
     */
    Set<K> keySet();

    /**
     * Returns a {@link java.util.Collection} view of the values contained in this map.
     * The collection's iterator returns the values in ascending order
     * of the corresponding keys.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own {@code remove} operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the {@code Iterator.remove},
     * {@code Collection.remove}, {@code removeAll},
     * {@code retainAll} and {@code clear} operations.  It does not
     * support the {@code add} or {@code addAll} operations.
     *
     * @return a collection view of the values contained in this map,
     *         sorted in ascending key order
     */
    Collection<V> values();

    /**
     * Returns a {@link java.util.Set} view of the mappings contained in this map.
     * The set's iterator returns the entries in ascending key order.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own {@code remove} operation, or through the
     * {@code setValue} operation on a map entry returned by the
     * iterator) the results of the iteration are undefined.  The set
     * supports element removal, which removes the corresponding
     * mapping from the map, via the {@code Iterator.remove},
     * {@code Set.remove}, {@code removeAll}, {@code retainAll} and
     * {@code clear} operations.  It does not support the
     * {@code add} or {@code addAll} operations.
     *
     * @return a set view of the mappings contained in this map,
     *         sorted in ascending key order
     */
    Set<Entry<K, V>> entrySet();

}