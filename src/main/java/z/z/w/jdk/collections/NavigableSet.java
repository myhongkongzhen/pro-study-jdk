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
 *     FileName: z.z.w.jdk.collections.NavigableSet
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-15 11:15
 *   LastChange: 2015-12-15 11:15
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.Collections;
import java.util.Comparator;

/**
 * A {@link java.util.SortedSet} extended with navigation methods reporting
 * SortedSet由導航的方法擴展由給定的搜索目標報告最接近的匹配
 * closest matches for given search targets. Methods {@code lower},
 * {@code floor}, {@code ceiling}, and {@code higher} return elements
 * 方法lower，floor，ceiling，higher返回的元素分別為少於，少於或等於，大於或等於
 * respectively less than, less than or equal, greater than or equal,
 * and greater than a given element, returning {@code null} if there
 * 大於給定的元素，如果沒有這樣的元素，則返回null
 * is no such element.  A {@code NavigableSet} may be accessed and
 * traversed in either ascending or descending order.  The {@code
 * 一個NavigableSet能夠存儲訪問正序或倒序的遍歷
 * descendingSet} method returns a view of the set with the senses of
 * descendingSet方法返回一個集合的視圖，所有相關定向倒序的視圖
 * all relational and directional methods inverted. The performance of
 * ascending operations and views is likely to be faster than that of
 *  ascending操作的執行和視圖比起descending更快
 * descending ones.  This interface additionally defines methods
 * {@code pollFirst} and {@code pollLast} that return and remove the
 * 這個接口額外的定義了方法pollFirst，pollLast用於返回和移除最低以及最高的元素
 * lowest and highest element, if one exists, else returning {@code
 * null}.  Methods {@code subSet}, {@code headSet},
 * 如果存在，否則返回null，方法subSet，headSet，tailSet不同之處像名字一樣
 * and {@code tailSet} differ from the like-named {@code
 * SortedSet} methods in accepting additional arguments describing
 * 的方法檢查額外的倒序參數
 * whether lower and upper bounds are inclusive versus exclusive.
 * 是否高或低的幫定包含與排除
 * Subsets of any {@code NavigableSet} must implement the {@code
 * NavigableSet中的任何Subset必須實現NavigableSet接口
 * NavigableSet} interface.
 *
 * <p> The return values of navigation methods may be ambiguous in
 * 導航方法返回的值必須含糊允許null元素在實現中
 * implementations that permit {@code null} elements. However, even
 * in this case the result can be disambiguated by checking
 * 然而，這種情況結果能夠由contains(null)檢查而消除歧義
 * {@code contains(null)}. To avoid such issues, implementations of
 * this interface are encouraged to <em>not</em> permit insertion of
 * 為了避免這樣的問題，這個接口的實現鼓勵不允許添加null元素
 * {@code null} elements. (Note that sorted sets of {@link
 * Comparable} elements intrinsically do not permit {@code null}.)
 * 注意已排序的set的元素本質是不允許null元素的
 *
 * <p>Methods
 * {@link #subSet(Object, Object) subSet(E, E)},
 * {@link #headSet(Object) headSet(E)}, and
 * {@link #tailSet(Object) tailSet(E)}
 * are specified to return {@code SortedSet} to allow existing
 * 方法subSet，headSet，tailSet由SortedSet指定的返回允許存在SortedSet存在
 * implementations of {@code SortedSet} to be compatibly retrofitted to
 * 鼓勵NavigableSet實現改造
 * implement {@code NavigableSet}, but extensions and implementations
 * of this interface are encouraged to override these methods to return
 * 但是，擴展與實現這個接口，鼓勵複寫這些NavigableSet返回的方法
 * {@code NavigableSet}.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author Doug Lea
 * @author Josh Bloch
 * @param <E> the type of elements maintained by this set
 * @since 1.6
 */
public interface NavigableSet<E> extends SortedSet<E>
{
    /**
     * Returns the greatest element in this set strictly less than the
     * 返回最高的元素在這個集合中嚴格小於給定元素，如果沒有這樣的元素，返回null
     * given element, or {@code null} if there is no such element.
     *
     * @param e the value to match
     * @return the greatest element less than {@code e},
     *         or {@code null} if there is no such element
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the set
     * @throws NullPointerException if the specified element is null
     *         and this set does not permit null elements
     */
    E lower(E e);

    /**
     * Returns the greatest element in this set less than or equal to
     * 返回貴高的元素在這個集合中小於或等於給定的元素
     * the given element, or {@code null} if there is no such element.
     *
     * @param e the value to match
     * @return the greatest element less than or equal to {@code e},
     *         or {@code null} if there is no such element
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the set
     * @throws NullPointerException if the specified element is null
     *         and this set does not permit null elements
     */
    E floor(E e);

    /**
     * Returns the least element in this set greater than or equal to
     * the given element, or {@code null} if there is no such element.
     *
     * @param e the value to match
     * @return the least element greater than or equal to {@code e},
     *         or {@code null} if there is no such element
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the set
     * @throws NullPointerException if the specified element is null
     *         and this set does not permit null elements
     */
    E ceiling(E e);

    /**
     * Returns the least element in this set strictly greater than the
     * given element, or {@code null} if there is no such element.
     *
     * @param e the value to match
     * @return the least element greater than {@code e},
     *         or {@code null} if there is no such element
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the set
     * @throws NullPointerException if the specified element is null
     *         and this set does not permit null elements
     */
    E higher(E e);

    /**
     * Retrieves and removes the first (lowest) element,
     * or returns {@code null} if this set is empty.
     *
     * @return the first element, or {@code null} if this set is empty
     */
    E pollFirst();

    /**
     * Retrieves and removes the last (highest) element,
     * or returns {@code null} if this set is empty.
     *
     * @return the last element, or {@code null} if this set is empty
     */
    E pollLast();

    /**
     * Returns an iterator over the elements in this set, in ascending order.
     *
     * @return an iterator over the elements in this set, in ascending order
     */
     Iterator<E> iterator();

    /**
     * Returns a reverse order view of the elements contained in this set.
     * 返回這個集合包含元素相反的視圖
     * The descending set is backed by this set, so changes to the set are
     * 倒序的set基於這個set
     * reflected in the descending set, and vice-versa.  If either set is
     * 在倒序的set中改變這個結合是引用的，反之亦然
     * modified while an iteration over either set is in progress (except
     * 如果任意set當迭代任意set在過程中
     * through the iterator's own {@code remove} operation), the results of
     * the iteration are undefined.
     * 迭代的結果是為定義的
     *
     * <p>The returned set has an ordering equivalent to
     * <tt>{@link Collections#reverseOrder(Comparator) Collections.reverseOrder}(comparator())</tt>.
     * The expression {@code s.descendingSet().descendingSet()} returns a
     * view of {@code s} essentially equivalent to {@code s}.
     *
     * @return a reverse order view of this set
     */
    NavigableSet<E> descendingSet();

    /**
     * Returns an iterator over the elements in this set, in descending order.
     * Equivalent in effect to {@code descendingSet().iterator()}.
     *
     * @return an iterator over the elements in this set, in descending order
     */
    Iterator<E> descendingIterator();

    /**
     * Returns a view of the portion of this set whose elements range from
     * {@code fromElement} to {@code toElement}.  If {@code fromElement} and
     * {@code toElement} are equal, the returned set is empty unless {@code
     * fromInclusive} and {@code toInclusive} are both true.  The returned set
     * is backed by this set, so changes in the returned set are reflected in
     * this set, and vice-versa.  The returned set supports all optional set
     * operations that this set supports.
     *
     * <p>The returned set will throw an {@code IllegalArgumentException}
     * on an attempt to insert an element outside its range.
     *
     * @param fromElement low endpoint of the returned set
     * @param fromInclusive {@code true} if the low endpoint
     *        is to be included in the returned view
     * @param toElement high endpoint of the returned set
     * @param toInclusive {@code true} if the high endpoint
     *        is to be included in the returned view
     * @return a view of the portion of this set whose elements range from
     *         {@code fromElement}, inclusive, to {@code toElement}, exclusive
     * @throws ClassCastException if {@code fromElement} and
     *         {@code toElement} cannot be compared to one another using this
     *         set's comparator (or, if the set has no comparator, using
     *         natural ordering).  Implementations may, but are not required
     *         to, throw this exception if {@code fromElement} or
     *         {@code toElement} cannot be compared to elements currently in
     *         the set.
     * @throws NullPointerException if {@code fromElement} or
     *         {@code toElement} is null and this set does
     *         not permit null elements
     * @throws IllegalArgumentException if {@code fromElement} is
     *         greater than {@code toElement}; or if this set itself
     *         has a restricted range, and {@code fromElement} or
     *         {@code toElement} lies outside the bounds of the range.
     */
    NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
                           E toElement,   boolean toInclusive);

    /**
     * Returns a view of the portion of this set whose elements are less than
     * (or equal to, if {@code inclusive} is true) {@code toElement}.  The
     * returned set is backed by this set, so changes in the returned set are
     * reflected in this set, and vice-versa.  The returned set supports all
     * optional set operations that this set supports.
     *
     * <p>The returned set will throw an {@code IllegalArgumentException}
     * on an attempt to insert an element outside its range.
     *
     * @param toElement high endpoint of the returned set
     * @param inclusive {@code true} if the high endpoint
     *        is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than
     *         (or equal to, if {@code inclusive} is true) {@code toElement}
     * @throws ClassCastException if {@code toElement} is not compatible
     *         with this set's comparator (or, if the set has no comparator,
     *         if {@code toElement} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code toElement} cannot be compared to elements
     *         currently in the set.
     * @throws NullPointerException if {@code toElement} is null and
     *         this set does not permit null elements
     * @throws IllegalArgumentException if this set itself has a
     *         restricted range, and {@code toElement} lies outside the
     *         bounds of the range
     */
    NavigableSet<E> headSet(E toElement, boolean inclusive);

    /**
     * Returns a view of the portion of this set whose elements are greater
     * than (or equal to, if {@code inclusive} is true) {@code fromElement}.
     * The returned set is backed by this set, so changes in the returned set
     * are reflected in this set, and vice-versa.  The returned set supports
     * all optional set operations that this set supports.
     *
     * <p>The returned set will throw an {@code IllegalArgumentException}
     * on an attempt to insert an element outside its range.
     *
     * @param fromElement low endpoint of the returned set
     * @param inclusive {@code true} if the low endpoint
     *        is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater
     *         than or equal to {@code fromElement}
     * @throws ClassCastException if {@code fromElement} is not compatible
     *         with this set's comparator (or, if the set has no comparator,
     *         if {@code fromElement} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromElement} cannot be compared to elements
     *         currently in the set.
     * @throws NullPointerException if {@code fromElement} is null
     *         and this set does not permit null elements
     * @throws IllegalArgumentException if this set itself has a
     *         restricted range, and {@code fromElement} lies outside the
     *         bounds of the range
     */
    NavigableSet<E> tailSet(E fromElement, boolean inclusive);

    /**
     * {@inheritDoc}
     *
     * <p>Equivalent to {@code subSet(fromElement, true, toElement, false)}.
     *
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    SortedSet<E> subSet( E fromElement, E toElement);

    /**
     * {@inheritDoc}
     *
     * <p>Equivalent to {@code headSet(toElement, false)}.
     *
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
    na     */
   SortedSet<E> headSet( E toElement);

    /**
     * {@inheritDoc}
     *
     * <p>Equivalent to {@code tailSet(fromElement, true)}.
     *
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    SortedSet<E> tailSet( E fromElement);
}