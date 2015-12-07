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
 *     FileName: z.z.w.collections.List
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-27 16:44
 *   LastChange: 2015-11-27 16:44
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;
import java.util.Iterator;

/**
 * An ordered collection (also known as a <i>sequence</i>).  The user of this
 * 一個排序的集合(也作為一個已知的序列).
 * interface has precise control over where in the list each element is
 * 這個接口的用戶可以嚴格的控制list中的每個元素是可插入的.
 * inserted.  The user can access elements by their integer index (position in
 * 用戶可以由他們的索引(在list中位置)訪問元素
 * the list), and search for elements in the list.<p>
 * 並且可以搜索在list中的元素
 *
 * Unlike sets, lists typically allow duplicate elements.  More formally,
 * 與set不同,list類型運行重複的元素,
 * lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt>
 * 更正是的是list類型允許對狀的元素e1和e2如同e1.equals(e2),
 * such that <tt>e1.equals(e2)</tt>, and they typically allow multiple
 * null elements if they allow null elements at all.  It is not inconceivable
 * 並且他們允許null元素存在，他們的裂隙允許重複的null元素.
 * that someone might wish to implement a list that prohibits duplicates, by
 * 某些希望實現一個禁止重複的list,
 * throwing runtime exceptions when the user attempts to insert them, but we
 * 當用書視圖添加他們的時候，拋出一個運行時異常,
 * expect this usage to be rare.<p>
 * 但是我們期望對於少量的需求是有用的.
 *
 * The <tt>List</tt> interface places additional stipulations, beyond those
 * List接口配置添加約定,
 * specified in the <tt>Collection</tt> interface, on the contracts of the
 * 出來那些在集合接口匯總特定的,
 * <tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and
 * 在約定中的iterator,add,remove,equals, hashCode方法.
 * <tt>hashCode</tt> methods.  Declarations for other inherited methods are
 * also included here for convenience.<p>
 * 有內部方法生命的也方便的包含在這.
 *
 * The <tt>List</tt> interface provides four methods for positional (indexed)
 * List接口提供了四個通過位置索引訪問元素的方法.
 * access to list elements.  Lists (like Java arrays) are zero based.  Note
 * 列表(像Java數組一樣)是零依賴的.
 * that these operations may execute in time proportional to the index value
 * 標記由一些實現提供的操作能執行索引的值保持與時間成正比.
 * for some implementations (the <tt>LinkedList</tt> class, for
 * (例如LinkedList).
 * example). Thus, iterating over the elements in a list is typically
 * 因此,在list中迭代元素,
 * preferable to indexing through it if the caller does not know the
 * 如果調用者不知道實現,那麼通過索引迭代是典型的更可取的方法.
 * implementation.<p>
 *
 * The <tt>List</tt> interface provides a special iterator, called a
 * List接口提供葛一個特殊的迭代器
 * <tt>ListIterator</tt>, that allows element insertion and replacement, and
 * 叫做ListIterator,這個迭代器運行元素插入和替換,
 * bidirectional access in addition to the normal operations that the
 * 雙向的存儲訪問有Iteratro接口提供的添加的一般操作.
 * <tt>Iterator</tt> interface provides.  A method is provided to obtain a
 * list iterator that starts at a specified position in the list.<p>
 * 一個方法通過一個list迭代獲得,這個迭代開始于在list中指定的位置.
 *
 * The <tt>List</tt> interface provides two methods to search for a specified
 * List接口提供了兩個通過指定obj查詢的方法.
 * object.  From a performance standpoint, these methods should be used with
 * 從性能觀點,這些方法要小心的使用.
 * caution.  In many implementations they will perform costly linear
 * 在許多實現中他們執行昂貴的線性搜索.
 * searches.<p>
 *
 * The <tt>List</tt> interface provides two methods to efficiently insert and
 * List接口提供了兩個方法，用於在list中的任意點高效的插入和移出重複的元素
 * remove multiple elements at an arbitrary point in the list.<p>
 *
 * Note: While it is permissible for lists to contain themselves as elements,
 * 注意: list允許包含自身作為元素存在在列表中
 * extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt>
 * 極端小心的建議: equals與hashcode方法
 * methods are no longer well defined on such a list.
 * 在這樣的列表中定義不在是好的.
 *
 * <p>Some list implementations have restrictions on the elements that
 * 一些列表的實現在他們包含的元素中存在約束條件.
 * they may contain.  For example, some implementations prohibit null elements,
 * 例如,一些實現禁止null元素
 * and some have restrictions on the types of their elements.  Attempting to
 * 一些則禁止元素的類型.
 * add an ineligible element throws an unchecked exception, typically
 * 視圖添加一個不合適的元素會拋出一個未檢查異常,
 * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting
 * NullPointerException 或者 ClassCastException 類型異常.
 * to query the presence of an ineligible element may throw an exception,
 * 視圖查詢一個不合適元素是否存在也許會拋出一個異常,
 * or it may simply return false; some implementations will exhibit the former
 * 或者僅僅是返回false
 * behavior and some will exhibit the latter.  More generally, attempting an
 * 一些實現會展示行為模型,一些會稍後展示.
 * operation on an ineligible element whose completion would not result in
 * 一般來講,視圖操作一個不合適的元素向list中添加不合適的元素的結果會拋出一個異常
 * the insertion of an ineligible element into the list may throw an
 * exception or it may succeed, at the option of the implementation.
 * 或者在實現的可選時可以成功,
 * Such exceptions are marked as "optional" in the specification for this
 * 對這個接口，作為可選的時候指定的一些異常.
 * interface.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <E> the type of elements in this list
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see java.util.Collection
 * @see java.util.Set
 * @see java.util.ArrayList
 * @see java.util.LinkedList
 * @see java.util.Vector
 * @see java.util.Arrays#asList(Object[])
 * @see java.util.Collections#nCopies(int, Object)
 * @see java.util.Collections#EMPTY_LIST
 * @see java.util.AbstractList
 * @see java.util.AbstractSequentialList
 * @since 1.2
 */
public interface List<E> extends Collection<E>
{
	// Query Operations

	/**
	 * Returns the number of elements in this list.  If this list contains
	 * more than <tt>Integer.MAX_VALUE</tt> elements, returns
	 * <tt>Integer.MAX_VALUE</tt>.
	 *
	 * @return the number of elements in this list
	 */
	int size();

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 *
	 * @return <tt>true</tt> if this list contains no elements
	 */
	boolean isEmpty();

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this list contains
	 * 更正式的講:
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *            互不相容的
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	boolean contains(Object o);

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 *            返回一個在list中的按照本是序列的元素的迭代器
	 * @return an iterator over the elements in this list in proper sequence
	 */
	Iterator<E> iterator();

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element).
	 *
	 * <p>The returned array will be "safe" in that no references to it are
	 * 返回到數組將會是安全的在由這個list維護的無引用他的情況下.
	 * maintained by this list.  (In other words, this method must
	 * allocate a new array even if this list is backed by an array).
	 * (換句換說,這個方法必須分配一個新的數組即使他是支持數組的).
	 * The caller is thus free to modify the returned array.
	 * 調用者因此可以自由的修改返回的數組.
	 *
	 * <p>This method acts as bridge between array-based and collection-based
	 * APIs.
	 *
	 * @return an array containing all of the elements in this list in proper
	 *         sequence
	 * @see Arrays#asList(Object[])
	 */
	Object[] toArray();

	/**
	 * Returns an array containing all of the elements in this list in
	 * proper sequence (from first to last element); the runtime type of
	 * the returned array is that of the specified array.  If the list fits
	 * in the specified array, it is returned therein.  Otherwise, a new
	 * array is allocated with the runtime type of the specified array and
	 * the size of this list.
	 *
	 * <p>If the list fits in the specified array with room to spare (i.e.,
	 * the array has more elements than the list), the element in the array
	 * immediately following the end of the list is set to <tt>null</tt>.
	 * (This is useful in determining the length of the list <i>only</i> if
	 * (這有助於測試當調用者知道列表中不能包含任何null元素時list的長度.)
	 * the caller knows that the list does not contain any null elements.)
	 *
	 * <p>Like the {@link #toArray()} method, this method acts as bridge between
	 * array-based and collection-based APIs.  Further, this method allows
	 *                                         更進一步的,
	 * precise control over the runtime type of the output array, and may,
	 * 精確的
	 * under certain circumstances, be used to save allocation costs.
	 * 在某種確定情況下,
	 * <p>Suppose <tt>x</tt> is a list known to contain only strings.
	 * The following code can be used to dump the list into a newly
	 * allocated array of <tt>String</tt>:
	 *
	 * <pre>
	 *     String[] y = x.toArray(new String[0]);</pre>
	 *
	 * Note that <tt>toArray(new Object[0])</tt> is identical in function to
	 *                                              完全相同的
	 * <tt>toArray()</tt>.
	 *
	 * @param a the array into which the elements of this list are to
	 *          足夠大的放入列表元素的空間
	 *          be stored, if it is big enough; otherwise, a new array of the
	 *          另外,一個相同運行時類型的新的數組為了這個目的分配.
	 *          same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this list
	 * @throws ArrayStoreException if the runtime type of the specified array
	 *         is not a supertype of the runtime type of every element in
	 *         this list
	 * @throws NullPointerException if the specified array is null
	 */
	<T> T[] toArray(T[] a);


	// Modification Operations

	/**
	 * Appends the specified element to the end of this list (optional
	 * operation).
	 *
	 * <p>Lists that support this operation may place limitations on what
	 * 支持這個操作的列表也許在添加元素到列表中存在局限性.
	 * elements may be added to this list.  In particular, some
	 *                                      詳細來講,
	 * lists will refuse to add null elements, and others will impose
	 * 一些list會拒絕添加null元素,
	 * restrictions on the type of elements that may be added.  List
	 * 而另一些會強加可添加元素類型的限制條件
	 * classes should clearly specify in their documentation any restrictions
	 * 列表類應該明確的在他們的文檔中指出可以添加的元素的任何的限制條件
	 * on what elements may be added.
	 *
	 * @param e element to be appended to this list
	 *          添加至list的元素
	 * @return <tt>true</tt> (as specified by {@link java.util.Collection#add})
	 * @throws UnsupportedOperationException if the <tt>add</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 *         阻止
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * @throws IllegalArgumentException if some property of this element
	 *         prevents it from being added to this list
	 */
	boolean add(E e);

	/**
	 * Removes the first occurrence of the specified element from this list,
	 * 從list中移出第一個出現的指定的元素.
	 * if it is present (optional operation).  If this list does not contain
	 * 如果存在(可選的操作)
	 * the element, it is unchanged.  More formally, removes the element with
	 * 如果list不包含這個元素，不會改變. 更正式的講,
	 * the lowest index <tt>i</tt> such that
	 * 移除(o == null ? get(i) == null : o.equals(get(i))) 存在的最低索引的元素
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
	 * (if such an element exists).  Returns <tt>true</tt> if this list
	 * contained the specified element (or equivalently, if this list changed
	 *                                     相等的,
	 * as a result of the call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return <tt>true</tt> if this list contained the specified element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *            互不相容的
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws UnsupportedOperationException if the <tt>remove</tt> operation
	 *         is not supported by this list
	 */
	boolean remove(Object o);


	// Bulk Modification Operations

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the
	 * 如果這個集合包含所有的指定集合的元素，返回true
	 * specified collection.
	 *
	 * @param  c collection to be checked for containment in this list
	 *           這個list中包含的要檢查的集合
	 * @return <tt>true</tt> if this list contains all of the elements of the
	 *         specified collection
	 * @throws ClassCastException if the types of one or more elements
	 *         in the specified collection are incompatible with this
	 *         list
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #contains(Object)
	 */
	boolean containsAll( java.util.Collection<?> c);

	/**
	 * Appends all of the elements in the specified collection to the end of
	 * 在這個list末尾添加指定集合中的所有元素.
	 * this list, in the order that they are returned by the specified
	 * 按照指定集合的跌倒順序返回.
	 * collection's iterator (optional operation).  The behavior of this
	 * operation is undefined if the specified collection is modified while
	 * 這個操作的行為是未定義的如果當操作在過程中將指定的集合改變了.
	 * the operation is in progress.  (Note that this will occur if the
	 * specified collection is this list, and it's nonempty.)
	 * (如果指定的集合是這個list,並且他不是空的,將會發生這樣的事情.)
	 *
	 * @param c collection containing elements to be added to this list
	 *          將要添加到這個list的集合元素
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this list
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this list
	 * @see #add(Object)
	 */
	boolean addAll( java.util.Collection<? extends E> c);

	/**
	 * Inserts all of the elements in the specified collection into this
	 * 向list指定位置添加指定集合的所有元素.
	 * list at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * 改變元素現有的位置(如果存在)並且後續的元素在其右邊
	 * elements to the right (increases their indices).  The new elements
	 *                       (增長他們的目錄).
	 * will appear in this list in the order that they are returned by the
	 * 這些新的元素將會按照在list中的指定集合的迭代順序出現.
	 * specified collection's iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 *
	 * @param index index at which to insert the first element from the
	 *              從指定集合中插入的第一個元素的索引
	 *              specified collection
	 * @param c collection containing elements to be added to this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this list
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this list
	 *         如果指定集合中的一個元素的某些屬性阻止添加進這個集合，將會拋出異常
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *                                   索引超出範圍
	 *         (<tt>index &lt; 0 || index &gt; size()</tt>)
	 */
	boolean addAll(int index, java.util.Collection<? extends E> c);

	/**
	 * Removes from this list all of its elements that are contained in the
	 * 從集合中移除所有的包含在指定集合中的元素
	 * specified collection (optional operation).
	 *
	 * @param c collection containing elements to be removed from this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the <tt>removeAll</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	boolean removeAll( java.util.Collection<?> c);

	/**
	 * Retains only the elements in this list that are contained in the
	 * 保存在這個list中的僅僅在指定集合中的元素
	 * specified collection (optional operation).  In other words, removes
	 * from this list all of its elements that are not contained in the
	 * 換句話說，移除所有的list的中元素，這些元素不包含在指定集合中.
	 * specified collection.
	 *
	 * @param c collection containing elements to be retained in this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	boolean retainAll( java.util.Collection<?> c);

	/**
	 * Removes all of the elements from this list (optional operation).
	 * The list will be empty after this call returns.
	 *
	 * @throws UnsupportedOperationException if the <tt>clear</tt> operation
	 *         is not supported by this list
	 */
	void clear();


	// Comparison and hashing

	/**
	 * Compares the specified object with this list for equality.  Returns
	 * 比較指定的obj與這個list相等性.
	 * <tt>true</tt> if and only if the specified object is also a list, both
	 * 當且僅當指定的obj也是一個list,
	 * lists have the same size, and all corresponding pairs of elements in
	 * 兩個list有相同的size，在兩個list中相應的元素是相等的.
	 * the two lists are <i>equal</i>.  (Two elements <tt>e1</tt> and
	 * <tt>e2</tt> are <i>equal</i> if <tt>(e1==null ? e2==null :
	 * (e1 == null ? e2 == null : eq.equals(e2))
	 * e1.equals(e2))</tt>.)  In other words, two lists are defined to be
	 * equal if they contain the same elements in the same order.  This
	 * definition ensures that the equals method works properly across
	 * 這個定義確保了equals方法在List接口的不同實現的適當工作.
	 * different implementations of the <tt>List</tt> interface.
	 *
	 * @param o the object to be compared for equality with this list
	 * @return <tt>true</tt> if the specified object is equal to this list
	 */
	boolean equals(Object o);

	/**
	 * Returns the hash code value for this list.  The hash code of a list
	 * is defined to be the result of the following calculation:
	 * <pre>
	 *  int hashCode = 1;
	 *  for (E e : list)
	 *      hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
	 * </pre>
	 * This ensures that <tt>list1.equals(list2)</tt> implies that
	 * <tt>list1.hashCode()==list2.hashCode()</tt> for any two lists,
	 * <tt>list1</tt> and <tt>list2</tt>, as required by the general
	 * contract of {@link Object#hashCode}.
	 *
	 * @return the hash code value for this list
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
	int hashCode();


	// Positional Access Operations

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
	 */
	E get(int index);

	/**
	 * Replaces the element at the specified position in this list with the
	 * 替換指定位置的元素用指定的元素
	 * specified element (optional operation).
	 *
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws UnsupportedOperationException if the <tt>set</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and
	 *         this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
	 */
	E set(int index, E element);

	/**
	 * Inserts the specified element at the specified position in this list
	 * 在指定的位置添加指定的元素.
	 * (optional operation).  Shifts the element currently at that position
	 *  改變元素當前的位置
	 * (if any) and any subsequent elements to the right (adds one to their
	 *  任何後續的元素在其右邊(他們的目錄下添加)
	 * indices).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws UnsupportedOperationException if the <tt>add</tt> operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and
	 *         this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         (<tt>index &lt; 0 || index &gt; size()</tt>)
	 */
	void add(int index, E element);

	/**
	 * Removes the element at the specified position in this list (optional
	 * operation).  Shifts any subsequent elements to the left (subtracts one
	 * from their indices).  Returns the element that was removed from the
	 * 返回這個移出list的元素
	 * list.
	 *
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 *                     先前的
	 * @throws UnsupportedOperationException if the <tt>remove</tt> operation
	 *         is not supported by this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
	 */
	E remove(int index);


	// Search Operations

	/**
	 * Returns the index of the first occurrence of the specified element
	 * 返回在list中第一個范閒指定元素的索引
	 * in this list, or -1 if this list does not contain the element.
	 * 或者返回-1當這個list不包含這個元素時
	 * More formally, returns the lowest index <tt>i</tt> such that
	 * 更正式的講,
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * ( o == null ? get( i ) == null : o.equals( get( i ) ) )
	 * or -1 if there is no such index.
	 *
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	int indexOf(Object o);

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the highest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * or -1 if there is no such index.
	 *
	 * @param o element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	int lastIndexOf(Object o);


	// List Iterators

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 *                                                            適當的
	 * sequence).
	 *
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence)
	 */
	ListIterator<E> listIterator();

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence), starting at the specified position in the list.
	 * The specified index indicates the first element that would be
	 * 指定的索引表示第一個初始調ListIterator.next()用返回的元素.
	 * returned by an initial call to {@link ListIterator#next next}.
	 * An initial call to {@link ListIterator#previous previous} would
	 * 初始調用ListIterator.previous()將會返回指定索引減一的元素
	 * return the element with the specified index minus one.
	 *
	 * @param index index of the first element to be returned from the
	 *        list iterator (by a call to {@link ListIterator#next next})
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence), starting at the specified position in the list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	ListIterator<E> listIterator(int index);

	// View

	/**
	 * Returns a view of the portion of this list between the specified
	 * 返回這個list指定位置的視圖，
	 * <tt>fromIndex</tt>, inclusive, and <tt>toIndex</tt>, exclusive.  (If
	 * 在包含指定的fromIndex與不包含的toIndex索引的位置之間
	 * <tt>fromIndex</tt> and <tt>toIndex</tt> are equal, the returned list is
	 * (如果fromIndex與toIndex相等,則返回空的list.)
	 * empty.)  The returned list is backed by this list, so non-structural
	 *          返回的list基於這個list,因此返回的list沒有結構化的改變反應這個list
	 * changes in the returned list are reflected in this list, and vice-versa.
	 *                                                          反之亦然
	 * The returned list supports all of the optional list operations supported
	 * 返回的list支持所有這個集合支持的可選操作
	 * by this list.<p>
	 *
	 * This method eliminates the need for explicit range operations (of
	 * 這個方法消除了對於明確範圍操作的需要
	 * the sort that commonly exist for arrays).  Any operation that expects
	 * (對於數組一般的存在的方式).
	 * a list can be used as a range operation by passing a subList view
	 * 任何期望list能用於範圍操作的操作通過整個一個子list視圖代替整個list
	 * instead of a whole list.  For example, the following idiom
	 * removes a range of elements from a list:
	 * 例如：從一個list移出一個範圍的元素的習慣操作
	 * <pre>
	 *      list.subList(from, to).clear();
	 * </pre>
	 * Similar idioms may be constructed for <tt>indexOf</tt> and
	 * 類似的習慣可以用於構建indexOf與lastIndexOf
	 * <tt>lastIndexOf</tt>, and all of the algorithms in the
	 * 並且集合中的所有算法都支持子列表.
	 * <tt>Collections</tt> class can be applied to a subList.<p>
	 *
	 * The semantics of the list returned by this method become undefined if
	 * 整個方法返回的集合的語意未定義的，如果基於這個集合是經由任何渠道上結構上的改變
	 * the backing list (i.e., this list) is <i>structurally modified</i> in
	 * any way other than via the returned list.  (Structural modifications are
	 * those that change the size of this list, or otherwise perturb it in such
	 * (結構上的改變是集合size的改變,或者在迭代過程中增益的正確的結果的樣式其他的擾亂.)
	 * a fashion that iterations in progress may yield incorrect results.)
	 *
	 * @param fromIndex low endpoint (inclusive) of the subList
	 *                  包含的最低的節點
	 * @param toIndex high endpoint (exclusive) of the subList
	 *                不包含的最高的節點
	 * @return a view of the specified range within this list
	 * @throws IndexOutOfBoundsException for an illegal endpoint index value
	 *         (<tt>fromIndex &lt; 0 || toIndex &gt; size ||
	 *         (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
	 *         fromIndex &gt; toIndex</tt>)
	 */
	List<E> subList(int fromIndex, int toIndex);
}
