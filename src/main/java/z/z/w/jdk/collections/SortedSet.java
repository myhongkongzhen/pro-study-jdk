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
 *     FileName: z.z.w.jdk.collections.SortedSet
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-14 18:05
 *   LastChange: 2015-12-14 18:05
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;

/**
 * A {@link java.util.Set} that further provides a <i>total ordering</i> on its elements.
 * Set提供了排序元素
 * The elements are ordered using their {@linkplain Comparable natural
 * 這些元素用於自然排序，或者由set創建時的Comparator通用提供的排序
 * ordering}, or by a {@link Comparator} typically provided at sorted
 * set creation time.  The set's iterator will traverse the set in
 *                     set迭代器按照升序遍歷set
 * ascending element order. Several additional operations are provided
 * to take advantage of the ordering.  (This interface is the set
 * 多種額外的操作由更深入的排序提供
 * analogue of {@link SortedMap}.)
 * 這個接口類似SortedMap
 *
 * <p>All elements inserted into a sorted set must implement the <tt>Comparable</tt>
 * 所有添加到已排序的set的元素必須實現Comparable接口
 * interface (or be accepted by the specified comparator).  Furthermore, all
 * (或者由指定的Comparator指定)
 * such elements must be <i>mutually comparable</i>: <tt>e1.compareTo(e2)</tt>
 * 另外，所有這樣的元素必須能夠相互比較,e1.compareTo(e2)
 * (or <tt>comparator.compare(e1, e2)</tt>) must not throw a
 * (或者comparator.compare(e1,e2))
 * <tt>ClassCastException</tt> for any elements <tt>e1</tt> and <tt>e2</tt> in
 * 對於任意在已排序的set中的元素e1與e2不能拋出ClassCastException.
 * the sorted set.  Attempts to violate this restriction will cause the
 * 嘗試餵飯這個限制會違反方法或者構造器調用的原因而拋出一個異常
 * offending method or constructor invocation to throw a
 *
 * <tt>ClassCastException</tt>.
 *
 * <p>Note that the ordering maintained by a sorted set (whether or not an
 * 注意排序由已排序的set維持
 * explicit comparator is provided) must be <i>consistent with equals</i> if
 * (一個明確的比較器是否已提供) 必須兼容equals方法
 * the sorted set is to correctly implement the <tt>Set</tt> interface.  (See
 * 如果這個已排序的set正確的實現了Set接口
 * the <tt>Comparable</tt> interface or <tt>Comparator</tt> interface for a
 * (看Comparable接口或者Comparator接口對於兼容equals的明確定義)
 * precise definition of <i>consistent with equals</i>.)  This is so because
 * the <tt>Set</tt> interface is defined in terms of the <tt>equals</tt>
 * 這就是Set接口在equals操作條目中已定義的原因
 * operation, but a sorted set performs all element comparisons using its
 * 但是一個已排序的set執行所有元素的比較用compareTo或者compare方法
 * <tt>compareTo</tt> (or <tt>compare</tt>) method, so two elements that are
 * deemed equal by this method are, from the standpoint of the sorted set,
 * 這兩個元素由這個方法認定相等,從已排序的set立場上相等
 * equal.  The behavior of a sorted set <i>is</i> well-defined even if its
 *         已排序的set行為更好的定義了如果他的順序不符合相等的
 * ordering is inconsistent with equals; it just fails to obey the general
 * contract of the <tt>Set</tt> interface.
 * 他會失敗允許通用的set接口的約定
 *
 * <p>All general-purpose sorted set implementation classes should
 * 所有通用目的的已排序的set實現類應該提供四個基礎構造器
 * provide four "standard" constructors: 1) A void (no arguments)
 * constructor, which creates an empty sorted set sorted according to
 * 1)無慘的構造器，創建一個空的已排序的set，按照元素的的自然順序排序
 * the natural ordering of its elements.  2) A constructor with a
 * single argument of type <tt>Comparator</tt>, which creates an empty
 * 2)一個只有一個Comparator類型的參數的構造器，用於穿件一個空的已排序的set
 * sorted set sorted according to the specified comparator.  3) A
 * 按照指定的comparator順序排序
 * constructor with a single argument of type <tt>Collection</tt>,
 * 3)一個只有一個Collection參數的構造器，用於創建一個新的已排序的set
 * which creates a new sorted set with the same elements as its
 * 用這個結合中的相同的元素
 * argument, sorted according to the natural ordering of the elements.
 * 排序按照元素的自然順序排列
 * 4) A constructor with a single argument of type <tt>SortedSet</tt>,
 * 4)一個只有一個參數的SortedSet類型的構造器
 * which creates a new sorted set with the same elements and the same
 * 用於創建一個新的已排序的set，用這個已排序的set的元素及順序排列
 * ordering as the input sorted set.  There is no way to enforce this
 * recommendation, as interfaces cannot contain constructors.
 * 沒有執行的建議，作為接口不包含構造器時.
 *
 * <p>Note: several methods return subsets with restricted ranges.
 * 注意：多種方法返回子集合由受限的範圍
 * Such ranges are <i>half-open</i>, that is, they include their low
 * 一些範圍是hasf-open的,他們包含了低端點，但不包含高端點
 * endpoint but not their high endpoint (where applicable).
 * (任何地方試用)
 * If you need a <i>closed range</i> (which includes both endpoints), and
 * 如果你需要一個閉合的範圍(包含兩個端點)
 * the element type allows for calculation of the successor of a given
 * 並且元素的類型允許給定值的繼任者的計算
 * value, merely request the subrange from <tt>lowEndpoint</tt> to
 * 僅僅請求子範圍從低端點到繼任者高端端
 * <tt>successor(highEndpoint)</tt>.  For example, suppose that <tt>s</tt>
 * is a sorted set of strings.  The following idiom obtains a view
 * 例如，支持s是一個字符串的已排序的set
 * containing all of the strings in <tt>s</tt> from <tt>low</tt> to
 * 跟隨的慣用方法獲得一個視圖，包含了所有從低到高的字符串集合的元素
 * <tt>high</tt>, inclusive:<pre>
 *   SortedSet&lt;String&gt; sub = s.subSet(low, high+"\0");</pre>
 *
 * A similar technique can be used to generate an <i>open range</i> (which
 * 類似的技術用於通用的開區間
 * contains neither endpoint).  The following idiom obtains a view
 * 不包含尾節點
 * containing all of the Strings in <tt>s</tt> from <tt>low</tt> to
 * <tt>high</tt>, exclusive:<pre>
 *   SortedSet&lt;String&gt; sub = s.subSet(low+"\0", high);</pre>
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <E> the type of elements maintained by this set
 *
 * @author  Josh Bloch
 * @see java.util.Set
 * @see TreeSet
 * @see SortedMap
 * @see java.util.Collection
 * @see Comparable
 * @see Comparator
 * @see ClassCastException
 * @since 1.2
 */

public interface SortedSet<E> extends Set<E>
{
    /**
     * Returns the comparator used to order the elements in this set,
     * 返回set中用於排列元素的比較器
     * or <tt>null</tt> if this set uses the {@linkplain Comparable
     * 或者如果set用自然排序返回null
     * natural ordering} of its elements.
     *
     * @return the comparator used to order the elements in this set,
     *         or <tt>null</tt> if this set uses the natural ordering
     *         of its elements
     */
    Comparator<? super E> comparator();

    /**
     * Returns a view of the portion of this set whose elements range
     * 返回集合元素從fromElement包含到toElement不包含的一部分的視圖
     * from <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>,
     * exclusive.  (If <tt>fromElement</tt> and <tt>toElement</tt> are
     * equal, the returned set is empty.)  The returned set is backed
     * 如果fromElement與toElement相等，返回空set
     * by this set, so changes in the returned set are reflected in
     * 返回的set基於這個set，這個set中引用改變返回的set
     * this set, and vice-versa.  The returned set supports all
     * 反之亦然
     * optional set operations that this set supports.
     * 返回的set支持所有的set集合支持的操作
     *
     * <p>The returned set will throw an <tt>IllegalArgumentException</tt>
     * 返回的集合會拋出一個異常在視圖添加超出範圍的元素時
     * on an attempt to insert an element outside its range.
     *
     * @param fromElement low endpoint (inclusive) of the returned set
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements range from
     *         <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>, exclusive
     * @throws ClassCastException if <tt>fromElement</tt> and
     *         <tt>toElement</tt> cannot be compared to one another using this
     *         set's comparator (or, if the set has no comparator, using
     *         natural ordering).  Implementations may, but are not required
     *         to, throw this exception if <tt>fromElement</tt> or
     *         <tt>toElement</tt> cannot be compared to elements currently in
     *         the set.
     * @throws NullPointerException if <tt>fromElement</tt> or
     *         <tt>toElement</tt> is null and this set does not permit null
     *         elements
     * @throws IllegalArgumentException if <tt>fromElement</tt> is
     *         greater than <tt>toElement</tt>; or if this set itself
     *         has a restricted range, and <tt>fromElement</tt> or
     *         <tt>toElement</tt> lies outside the bounds of the range
     */
    SortedSet<E> subSet(E fromElement, E toElement);

    /**
     * Returns a view of the portion of this set whose elements are
     * strictly less than <tt>toElement</tt>.  The returned set is
     * 嚴格小於
     * backed by this set, so changes in the returned set are
     * reflected in this set, and vice-versa.  The returned set
     * supports all optional set operations that this set supports.
     *
     * <p>The returned set will throw an <tt>IllegalArgumentException</tt>
     * on an attempt to insert an element outside its range.
     *
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements are strictly
     *         less than <tt>toElement</tt>
     * @throws ClassCastException if <tt>toElement</tt> is not compatible
     *         with this set's comparator (or, if the set has no comparator,
     *         if <tt>toElement</tt> does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if <tt>toElement</tt> cannot be compared to elements
     *         currently in the set.
     * @throws NullPointerException if <tt>toElement</tt> is null and
     *         this set does not permit null elements
     * @throws IllegalArgumentException if this set itself has a
     *         restricted range, and <tt>toElement</tt> lies outside the
     *         bounds of the range
     */
    SortedSet<E> headSet(E toElement);

    /**
     * Returns a view of the portion of this set whose elements are
     * greater than or equal to <tt>fromElement</tt>.  The returned
     * 大於
     * set is backed by this set, so changes in the returned set are
     * reflected in this set, and vice-versa.  The returned set
     * supports all optional set operations that this set supports.
     *
     * <p>The returned set will throw an <tt>IllegalArgumentException</tt>
     * on an attempt to insert an element outside its range.
     *
     * @param fromElement low endpoint (inclusive) of the returned set
     * @return a view of the portion of this set whose elements are greater
     *         than or equal to <tt>fromElement</tt>
     * @throws ClassCastException if <tt>fromElement</tt> is not compatible
     *         with this set's comparator (or, if the set has no comparator,
     *         if <tt>fromElement</tt> does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if <tt>fromElement</tt> cannot be compared to elements
     *         currently in the set.
     * @throws NullPointerException if <tt>fromElement</tt> is null
     *         and this set does not permit null elements
     * @throws IllegalArgumentException if this set itself has a
     *         restricted range, and <tt>fromElement</tt> lies outside the
     *         bounds of the range
     */
    SortedSet<E> tailSet(E fromElement);

    /**
     * Returns the first (lowest) element currently in this set.
     *
     * @return the first (lowest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    E first();

    /**
     * Returns the last (highest) element currently in this set.
     *
     * @return the last (highest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    E last();
}