/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.jdk.collections;

import java.util.Iterator;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.collections.Collection
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-27 16:43
 *   LastChange: 2015-11-27 16:43
 *      History:
 * </pre>
 *********************************************************************************************/

/**
 * The root interface in the <i>collection hierarchy</i>.  A collection
 * 在集合層級中屬於root接口.
 * represents a group of objects, known as its <i>elements</i>.  Some
 * 一個集合描述了一組對象,并指導它的元素.
 * collections allow duplicate elements and others do not.  Some are ordered
 * 一些集合允許重複的元素，一些則不允許.
 * and others unordered.  The JDK does not provide any <i>direct</i>
 * 一些是排序的另一些是非排序的.
 * implementations of this interface: it provides implementations of more
 * JDK不提供這個接口的任何一個直接實現:
 * specific subinterfaces like <tt>Set</tt> and <tt>List</tt>.  This interface
 * JDK提供了更多的特定子接口的實現例如Set\List.
 * is typically used to pass collections around and manipulate them where
 * 這個接口遍歷集合和操作他們擁有最大限度的通用性的特色.
 * maximum generality is desired.
 * <p><i>Bags</i> or <i>multisets</i> (unordered collections that may contain
 * 包或者多重集合(非排序的集合可以包含重複的元素)
 * duplicate elements) should implement this interface directly.
 * 可以即刻的實現這個接口.
 * <p>All general-purpose <tt>Collection</tt> implementation classes (which
 * 所有的通用集合實現類
 * typically implement <tt>Collection</tt> indirectly through one of its
 * (通過他的子接口間接的實現特色集合)
 * subinterfaces) should provide two "standard" constructors: a void (no
 * 將提供連個標準的構造方法:
 * arguments) constructor, which creates an empty collection, and a
 * (無慘)void的構造器,用於創建一個空集合,
 * constructor with a single argument of type <tt>Collection</tt>, which
 * 和一個擁有單個Collection類型參數的構造器,
 * creates a new collection with the same elements as its argument.  In
 * 用於創建一個擁有相同元素作為參數的新集合.
 * effect, the latter constructor allows the user to copy any collection,
 * 事實上,後面的構造器運行用戶拷貝任何一個集合,
 * producing an equivalent collection of the desired implementation type.
 * 產生一個等價的所希望實現類型的集合.
 * There is no way to enforce this convention (as interfaces cannot contain
 * (作為一個藉口不能包含構造器)這個問題是沒有辦法實現的
 * constructors) but all of the general-purpose <tt>Collection</tt>
 * 但是所有的通用實現在Java平台庫中上遵循這個規則.
 * implementations in the Java platform libraries comply.
 * <p>The "destructive" methods contained in this interface, that is, the
 * 這個接口中包含了"破壞的"方法,
 * methods that modify the collection on which they operate, are specified to
 * 改變集合操作的方法,
 * throw <tt>UnsupportedOperationException</tt> if this collection does not
 * 如果集合不支持這個操作，會拋出一個UnsupportedOperationException.
 * support the operation.  If this is the case, these methods may, but are not
 * required to, throw an <tt>UnsupportedOperationException</tt> if the
 * 這些方法也許按照這種方式不必須的,
 * invocation would have no effect on the collection.  For example, invoking
 * 如果在集合中不受期望的調用了,則會拋出一個異常.
 * the {@link #addAll(Collection)} method on an unmodifiable collection may,
 * 例如:調用addAll方法,在一個無法改變的集合中,
 * but is not required to, throw the exception if the collection to be added
 * 但是這個調用是不需要的,如果向集合中添加一個empty的集合就會拋出一個異常.
 * is empty.
 * <p><a name="optional-restrictions"/>
 * Some collection implementations have restrictions on the elements that
 * 一些集合實現存在限制在他們所包含的元素中.
 * they may contain.  For example, some implementations prohibit null elements,
 * 例如:一些實現禁止null元素,
 * and some have restrictions on the types of their elements.  Attempting to
 * 並且一些實現在他們元素的類型上是有限制條件的.
 * add an ineligible element throws an unchecked exception, typically
 * 試圖添加一個不合適的元素會拋出一個未檢查異常,
 * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting
 * 以NullPointerException,ClassCastExcetpion為代表.
 * to query the presence of an ineligible element may throw an exception,
 * 試圖查詢不合適元素的存在也許會拋出一個異常,
 * or it may simply return false; some implementations will exhibit the former
 * 或者僅僅返回false;
 * behavior and some will exhibit the latter.  More generally, attempting an
 * 一些實現會顯示之前的行為一些則顯示後續的行為. 更加通用的,
 * operation on an ineligible element whose completion would not result in
 * 試圖操作一個不合適的元素
 * the insertion of an ineligible element into the collection may throw an
 * 不會有結果的在一個不合適元素添加集合可能會拋出一個異常
 * exception or it may succeed, at the option of the implementation.
 * 或者會成功,在實現可選時.
 * Such exceptions are marked as "optional" in the specification for this
 * 例如異常為這個接口特指的標記為可選.
 * interface.
 * <p>It is up to each collection to determine its own synchronization
 * 由每一個集合自身決定並發政策
 * policy.  In the absence of a stronger guarantee by the
 * 實現在一個強保證的出現中
 * implementation, undefined behavior may result from the invocation
 * 未定義行為使得結果從在集合中由另一個線程操作的任意個方法返回.
 * of any method on a collection that is being mutated by another
 * thread; this includes direct invocations, passing the collection to
 * 這包含了直接的調用關係,
 * a method that might perform invocations, and using an existing
 * 通過集合中的可執行的方法,
 * iterator to examine the collection.
 * 通過一個存在的迭代器測試集合.
 * <p>Many methods in Collections Framework interfaces are defined in
 * 許多集合框架接口的方法有明確的定義依據equals方法.
 * terms of the {@link Object#equals(Object) equals} method.  For example,
 * the specification for the {@link #contains(Object) contains(Object o)}
 * 例如: contains(Object o)這個方法詳細說明:
 * method says: "returns <tt>true</tt> if and only if this collection
 * 返回true,當且僅當集合包含至少一個元素時,判斷(o == null ? e == null : o.equals(e))
 * contains at least one element <tt>e</tt> such that
 * <tt>(o==null ? e==null : o.equals(e))</tt>."  This specification should
 * <i>not</i> be construed to imply that invoking <tt>Collection.contains</tt>
 * 這個說明將會不包含Collection.contains方法調用一個null的參數進行o.equals(e)判斷
 * with a non-null argument <tt>o</tt> will cause <tt>o.equals(e)</tt> to be
 * invoked for any element <tt>e</tt>.  Implementations are free to implement
 * 對於任何元素.
 * optimizations whereby the <tt>equals</tt> invocation is avoided, for
 * 實現最佳化的實現了無效的equals方法調用,
 * example, by first comparing the hash codes of the two elements.  (The
 * 例如,兩個元素受限進行hash code比較
 * {@link Object#hashCode()} specification guarantees that two objects with
 * (Object.hashCode()方法描述保證了兩個對象hash code不等是不會相等的).
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * 通常的說,
 * the various Collections Framework interfaces are free to take advantage of
 * 集合框架接口多樣的實現能夠自由的針對特定的行為增益.
 * the specified behavior of underlying {@link Object} methods wherever the
 * 這些增益使得實現者認為是適當的後續方法.
 * implementor deems it appropriate.
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <E> the type of elements in this collection
 *
 * @author Josh Bloch
 * @author Neal Gafter
 * @see java.util.Set
 * @see java.util.List
 * @see java.util.Map
 * @see java.util.SortedSet
 * @see java.util.SortedMap
 * @see java.util.HashSet
 * @see java.util.TreeSet
 * @see java.util.ArrayList
 * @see java.util.LinkedList
 * @see java.util.Vector
 * @see java.util.Collections
 * @see java.util.Arrays
 * @see java.util.AbstractCollection
 * @since 1.2
 */
public interface Collection<E> extends Iterable<E>
{
	// Query Operations

	/**
	 * Returns the number of elements in this collection.  If this collection
	 * 返回集合中元素的個數.
	 * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
	 * 如果集合中包含了多餘Integer.MAX_VALUE個元素，
	 * <tt>Integer.MAX_VALUE</tt>.
	 * 則返回Integer.MAX_VALUE.
	 *
	 * @return the number of elements in this collection
	 */
	int size();

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * 如果集合中沒有包含元素則返回true
	 *
	 * @return <tt>true</tt> if this collection contains no elements
	 */
	boolean isEmpty();

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element.
	 * 如果集合包含了指定的元素，則返回true
	 * More formally, returns <tt>true</tt> if and only if this collection
	 * 更正式的講:當且僅當集合包含了至少一個元素存在(o == null ? e == null : o.equals(s))
	 * contains at least one element <tt>e</tt> such that
	 * 時返回true
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this collection is to be tested
	 *          集合中測試的元素
	 *
	 * @return <tt>true</tt> if this collection contains the specified
	 *                       如果集合中包含這個指定的元素返回true
	 * element
	 *
	 * @throws ClassCastException   if the type of the specified element
	 *                              如果指定的元素類型與集合不相兼容，會拋出此異常
	 *                              is incompatible with this collection
	 *                              (<a href="#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *                              如果指定的元素為null並且這個集合不允許null元素，
	 *                              collection does not permit null elements
	 *                              則會拋出異常
	 *                              (<a href="#optional-restrictions">optional</a>)
	 */
	boolean contains( Object o );

	/**
	 * Returns an iterator over the elements in this collection.  There are no
	 * 返回這個集合的迭代器.
	 * guarantees concerning the order in which the elements are returned
	 * 這個方法關於元素的返回是不保證順序的.
	 * (unless this collection is an instance of some class that provides a
	 * (除非這個集合是一個一些提供保證的類的實現).
	 * guarantee).
	 *
	 * @return an <tt>Iterator</tt> over the elements in this collection
	 */
	Iterator<E> iterator();

	/**
	 * Returns an array containing all of the elements in this collection.
	 * 返回一個數組包含了這個集合中的所有元素
	 * If this collection makes any guarantees as to what order its elements
	 * 如果這個集合提供了由他的迭代器返回元素的順序的保證
	 * are returned by its iterator, this method must return the elements in
	 * 那麼這個方法必須返回相同元素順序
	 * the same order.
	 * <p>The returned array will be "safe" in that no references to it are
	 * 這個返回的數組是安全的由這個集合維護的沒有引用的情況下
	 * maintained by this collection.  (In other words, this method must
	 * (換句話說,這個方法必須分配一個新的數組當這個集合依賴一個數組的時候).
	 * allocate a new array even if this collection is backed by an array).
	 * The caller is thus free to modify the returned array.
	 * 調用者因此可以自由更改返回的數組.
	 * <p>This method acts as bridge between array-based and collection-based
	 * 這個方法作為兩個數組基礎和集合基礎的橋樑
	 * APIs.
	 *
	 * @return an array containing all of the elements in this collection
	 */
	Object[] toArray();

	/**
	 * Returns an array containing all of the elements in this collection;
	 * 返回一個包含集合中所有元素的數組
	 * the runtime type of the returned array is that of the specified array.
	 * 返回的數組運行時類型是那個指定的數組.
	 * If the collection fits in the specified array, it is returned therein.
	 * 如果集合適合這個指定的數組,則返回其中的數組.
	 * Otherwise, a new array is allocated with the runtime type of the
	 * 另外,由指定的數組的運行時類型和集合的大小分配一個新的數組
	 * specified array and the size of this collection.
	 * <p>If this collection fits in the specified array with room to spare
	 * 如果這個集合適合指定數組分配的空間
	 * (i.e., the array has more elements than this collection), the element
	 * (比如:數組有多餘集合個數的元素),
	 * in the array immediately following the end of the collection is set to
	 * 數組中的跟隨在集合尾部的元素會設置為null
	 * <tt>null</tt>.  (This is useful in determining the length of this
	 * (這對於決定集合長度是有用的,如果調用者知道這個集合不能包含任何null元素).
	 * collection <i>only</i> if the caller knows that this collection does
	 * not contain any <tt>null</tt> elements.)
	 * <p>If this collection makes any guarantees as to what order its elements
	 * 如果這個集合提供了任何保證他的迭代器返回元素的順序,
	 * are returned by its iterator, this method must return the elements in
	 * 這個方法必須返回相同的元素順序.
	 * the same order.
	 * <p>Like the {@link #toArray()} method, this method acts as bridge between
	 * 同toArray()方法一樣,
	 * array-based and collection-based APIs.  Further, this method allows
	 * 這個方法作為基礎數組與基礎集合的橋樑.
	 * precise control over the runtime type of the output array, and may,
	 * 進一步的,這個方法允許精確的控制輸出數組的運行時類型,
	 * under certain circumstances, be used to save allocation costs.
	 * 也許,在某一個情況下,可以用於保存分配消耗.
	 * <p>Suppose <tt>x</tt> is a collection known to contain only strings.
	 * 支持X是一個僅僅包含string的一直集合
	 * The following code can be used to dump the collection into a newly
	 * 跟隨的代碼可以用於傾倒集合到一個新的分配的string數組中
	 * allocated array of <tt>String</tt>:
	 * <pre>
	 *     String[] y = x.toArray(new String[0]);</pre>
	 * Note that <tt>toArray(new Object[0])</tt> is identical in function to
	 * 注意toArray(new Object[0])與toArray()方法功能完全相同.
	 * <tt>toArray()</tt>.
	 *
	 * @param a the array into which the elements of this collection are to be
	 *          用於存儲集合中的元素的足夠大的數組.
	 *          stored, if it is big enough; otherwise, a new array of the same
	 *          另外,一個新的相同運行時類型的數組為此目的而得到分配.
	 *          runtime type is allocated for this purpose.
	 *
	 * @return an array containing all of the elements in this collection
	 *
	 * @throws ArrayStoreException  if the runtime type of the specified array
	 *                              is not a supertype of the runtime type of every element in
	 *                              如果指定數組的運行時類型不是集合中每個元素的運行時類型的子類型
	 *                              this collection
	 *                              則會拋出一個異常
	 * @throws NullPointerException if the specified array is null
	 *                              如果指定的數組為null
	 */
	<T> T[] toArray( T[] a );

	// Modification Operations

	/**
	 * Ensures that this collection contains the specified element (optional
	 * 保證集合包含特定的元素(可選的操作)
	 * operation).  Returns <tt>true</tt> if this collection changed as a
	 * 如果結婚由於這個調用而改變了,則返回true
	 * result of the call.  (Returns <tt>false</tt> if this collection does
	 * not permit duplicates and already contains the specified element.)<p>
	 * (如果集合不允許重複的操作並且已經包含了指定的元素則返回false.)
	 * Collections that support this operation may place limitations on what
	 * 支持向集合中添加元素不瘦邊界限制的操作.
	 * elements may be added to this collection.  In particular, some
	 * collections will refuse to add <tt>null</tt> elements, and others will
	 * 詳細來講,一些集合會拒絕添加null元素,
	 * impose restrictions on the type of elements that may be added.
	 * 另一些將收到可添加元素的類型的限制條件.
	 * Collection classes should clearly specify in their documentation any
	 * 集合類會明確的在文檔中指定元素添加的任意限制條件.
	 * restrictions on what elements may be added.<p>
	 * If a collection refuses to add a particular element for any reason
	 * 如果一個集合拒絕添加一個特定元素除了他已包含元素之外的原因,
	 * other than that it already contains the element, it <i>must</i> throw
	 * an exception (rather than returning <tt>false</tt>).  This preserves
	 * 他會拋出一個異常(而不是返回false).
	 * the invariant that a collection always contains the specified element
	 * 一個結合總是包含特定的元素在這個方法調用返回后是保持不便的.
	 * after this call returns.
	 *
	 * @param e element whose presence in this collection is to be ensured
	 *          集合中出現的元素將是確定的.
	 *
	 * @return <tt>true</tt> if this collection changed as a result of the
	 *                       調用后的結果改變了結合，則會返回true
	 * call
	 *
	 * @throws UnsupportedOperationException if the <tt>add</tt> operation
	 *                                        如果集合不支持add操作，則會拋出這個異常
	 *                                       is not supported by this collection
	 * @throws ClassCastException            if the class of the specified element
	 *                                       如果指定元素的類型阻止添加進這個集合,則會拋出一個異常
	 *                                       prevents it from being added to this collection
	 * @throws NullPointerException          if the specified element is null and this
	 *                                       如果指定的元素為null這個結合不允許null元素
	 *                                       collection does not permit null elements
	 *                                       則會拋出一個異常
	 * @throws IllegalArgumentException      if some property of the element
	 *                                       如果元素的一些屬性組織添加進這個集合
	 *                                       prevents it from being added to this collection
	 *                                       則會拋出一個異常
	 * @throws IllegalStateException         if the element cannot be added at this
	 *                                       如果元素不允許時間超時的插入限制
	 *                                       time due to insertion restrictions
	 *                                       則會拋出一個異常
	 */
	boolean add( E e );

	/**
	 * Removes a single instance of the specified element from this
	 * 從集合中移出一個指定的元素實例
	 * collection, if it is present (optional operation).  More formally,
	 * removes an element <tt>e</tt> such that
	 * 更嚴格的說,移出一個(o == null ? e == null : o.equals(e))的元素,
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>, if
	 * this collection contains one or more such elements.  Returns
	 * 如果集合包含了一個或更多的這個元素.
	 * <tt>true</tt> if this collection contained the specified element (or
	 * 如果集合包含指定的元素則返回true
	 * equivalently, if this collection changed as a result of the call).
	 * (或者相同的,如果集合因為這個調用的結果而改變了).
	 *
	 * @param o element to be removed from this collection, if present
	 *          如果存在,從集合中移出這個元素.
	 *
	 * @return <tt>true</tt> if an element was removed as a result of this call
	 *                       如果因為方法的調用的結果移出了元素，則返回true
	 *
	 * @throws ClassCastException            if the type of the specified element
	 *                                       is incompatible with this collection
	 *                                       如果指定的元素的類型與這個集合互不相容，則拋出一個異常
	 *                                       (<a href="#optional-restrictions">optional</a>)
	 * @throws NullPointerException          if the specified element is null and this
	 *                                       collection does not permit null elements
	 *                                       如果指定的元素為null並且結婚不允許null元素，則拋出一個異常
	 *                                       (<a href="#optional-restrictions">optional</a>)
	 * @throws UnsupportedOperationException if the <tt>remove</tt> operation
	 *                                       如果這個集合不支持移除操作則會拋出一個異常
	 *                                       is not supported by this collection
	 */
	boolean remove( Object o );

	// Bulk Operations

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements
	 * 如果集合包含指定集合中的所有元素，則返回true
	 * in the specified collection.
	 *
	 * @param c collection to be checked for containment in this collection
	 *          在集合中要檢查的集合內容
	 *
	 * @return <tt>true</tt> if this collection contains all of the elements
	 *                       如果集合包含了指定集合的所有元素，則返回true
	 * in the specified collection
	 *
	 * @throws ClassCastException   if the types of one or more elements
	 *                              如果在指定的集合中的一個或者更多的元素的類型與這個集合不匹配
	 *                              in the specified collection are incompatible with this
	 *                              則會拋出一個異常
	 *                              collection
	 *                              (<a href="#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified collection contains one
	 *                              如果指定集合包含一個或多個null元素並且這個集合是不允許null元素時
	 *                              or more null elements and this collection does not permit null
	 *                              拋出一個異常
	 *                              elements
	 *                              (<a href="#optional-restrictions">optional</a>),
	 *                              or if the specified collection is null.
	 * @see #contains(Object)
	 */
	boolean containsAll( Collection<?> c );

	/**
	 * Adds all of the elements in the specified collection to this collection
	 * 添加指定集合的所有元素到這個集合中
	 * (optional operation).  The behavior of this operation is undefined if
	 * (可選的操作).
	 * the specified collection is modified while the operation is in progress.
	 * 這個操作的行為是不明確的,如果在操作過程中指定的集合改變了.
	 * (This implies that the behavior of this call is undefined if the
	 * (這就意味著調用的行為是未明確的如果指定的集合是這個集合,並且這個集合是非空的集合.)
	 * specified collection is this collection, and this collection is
	 * nonempty.)
	 *
	 * @param c collection containing elements to be added to this collection
	 *          集合包含添加進的集合的元素
	 *
	 * @return <tt>true</tt> if this collection changed as a result of the call
	 *                       如果這個調用的結果改變了集合，那麼返回true
	 *
	 * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
	 *                                       如果集合不支持addAll操作
	 *                                       is not supported by this collection
	 * @throws ClassCastException            if the class of an element of the specified
	 *                                       如果指定集合的元素的類型阻止從這個集合中添加
	 *                                       collection prevents it from being added to this collection
	 * @throws NullPointerException          if the specified collection contains a
	 *                                       如果指定的集合包含null元素並且集合不允許null元素
	 *                                       null element and this collection does not permit null elements,
	 *                                       or if the specified collection is null
	 *                                       或者指定的集合為null.
	 * @throws IllegalArgumentException      if some property of an element of the
	 *                                       如果指定集合的元素的某些熟悉阻止向這個集合中添加
	 *                                       specified collection prevents it from being added to this
	 *                                       collection
	 * @throws IllegalStateException         if not all the elements can be added at
	 *                                       如果在運行的時間超時的限制下沒有將所有元素添加進入集合
	 *                                       this time due to insertion restrictions
	 * @see #add(Object)
	 */
	boolean addAll( Collection<? extends E> c );

	/**
	 * Removes all of this collection's elements that are also contained in the
	 * 移出所有的包含在指定集合中的元素
	 * specified collection (optional operation).  After this call returns,
	 * (可選的操作).
	 * this collection will contain no elements in common with the specified
	 * 這個調用返回之後,集合將不包含任何指定集合中的元素
	 * collection.
	 *
	 * @param c collection containing elements to be removed from this collection
	 *          從這個集合中移出集合包含的元素
	 *
	 * @return <tt>true</tt> if this collection changed as a result of the
	 *                       如果這個調用的結果改變了這個集合，則返回true
	 * call
	 *
	 * @throws UnsupportedOperationException if the <tt>removeAll</tt> method
	 *                                       如果集合不支持removeAll操作
	 *                                       is not supported by this collection
	 * @throws ClassCastException            if the types of one or more elements
	 *                                       如果這個集合中的一個或多個元素的類型與制定集合不匹配
	 *                                       in this collection are incompatible with the specified
	 *                                       collection
	 *                                       (<a href="#optional-restrictions">optional</a>)
	 * @throws NullPointerException          if this collection contains one or more
	 *                                       如果集合包含一個或多個null元素並且制定集合不支持null
	 *                                       null elements and the specified collection does not support
	 *                                       null elements
	 *                                       (<a href="#optional-restrictions">optional</a>),
	 *                                       or if the specified collection is null
	 *                                       或者指定集合為null
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	boolean removeAll( Collection<?> c );

	/**
	 * Retains only the elements in this collection that are contained in the
	 * 保證集合中的元素包含在指定集合中
	 * specified collection (optional operation).  In other words, removes from
	 * (可選的操作).
	 * this collection all of its elements that are not contained in the
	 * 換句話說,就是移出所有不在指定集合中的這個集合中的元素
	 * specified collection.
	 *
	 * @param c collection containing elements to be retained in this collection
	 *          保證這個集合中的包含的元素
	 *
	 * @return <tt>true</tt> if this collection changed as a result of the call
	 *
	 * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation
	 *                                       如果集合不支持retainAll操作
	 *                                       is not supported by this collection
	 * @throws ClassCastException            if the types of one or more elements
	 *                                       如果集合中的一個或多個元素的類型與指定集合不匹配
	 *                                       in this collection are incompatible with the specified
	 *                                       collection
	 *                                       (<a href="#optional-restrictions">optional</a>)
	 * @throws NullPointerException          if this collection contains one or more
	 *                                       如果集合包含一個或多個null元素並且指定集合不允許null元素
	 *                                       null elements and the specified collection does not permit null
	 *                                       elements
	 *                                       (<a href="#optional-restrictions">optional</a>),
	 *                                       or if the specified collection is null
	 *                                       或者指定集合為null
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	boolean retainAll( Collection<?> c );

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * 移出集合中的所有元素(可選的操作)
	 * The collection will be empty after this method returns.
	 * 這個方法調用返回之後集合將會是empty的
	 *
	 * @throws UnsupportedOperationException if the <tt>clear</tt> operation
	 *                                       如果這個集合不支持clear操作
	 *                                       is not supported by this collection
	 */
	void clear();

	// Comparison and hashing

	/**
	 * Compares the specified object with this collection for equality. <p>
	 * 將指定obj與當前集合比較相等.
	 * While the <tt>Collection</tt> interface adds no stipulations to the
	 *
	 * general contract for the <tt>Object.equals</tt>, programmers who
	 * implement the <tt>Collection</tt> interface "directly" (in other words,
	 * create a class that is a <tt>Collection</tt> but is not a <tt>Set</tt>
	 * or a <tt>List</tt>) must exercise care if they choose to override the
	 * <tt>Object.equals</tt>.  It is not necessary to do so, and the simplest
	 * course of action is to rely on <tt>Object</tt>'s implementation, but
	 * the implementor may wish to implement a "value comparison" in place of
	 * the default "reference comparison."  (The <tt>List</tt> and
	 * <tt>Set</tt> interfaces mandate such value comparisons.)<p>
	 * The general contract for the <tt>Object.equals</tt> method states that
	 * equals must be symmetric (in other words, <tt>a.equals(b)</tt> if and
	 * only if <tt>b.equals(a)</tt>).  The contracts for <tt>List.equals</tt>
	 * and <tt>Set.equals</tt> state that lists are only equal to other lists,
	 * and sets to other sets.  Thus, a custom <tt>equals</tt> method for a
	 * collection class that implements neither the <tt>List</tt> nor
	 * <tt>Set</tt> interface must return <tt>false</tt> when this collection
	 * is compared to any list or set.  (By the same logic, it is not possible
	 * to write a class that correctly implements both the <tt>Set</tt> and
	 * <tt>List</tt> interfaces.)
	 *
	 * @param o object to be compared for equality with this collection
	 *
	 * @return <tt>true</tt> if the specified object is equal to this
	 * collection
	 *
	 * @see Object#equals(Object)
	 * @see java.util.Set#equals(Object)
	 * @see java.util.List#equals(Object)
	 */
	boolean equals( Object o );

	/**
	 * Returns the hash code value for this collection.  While the
	 * <tt>Collection</tt> interface adds no stipulations to the general
	 * contract for the <tt>Object.hashCode</tt> method, programmers should
	 * take note that any class that overrides the <tt>Object.equals</tt>
	 * method must also override the <tt>Object.hashCode</tt> method in order
	 * to satisfy the general contract for the <tt>Object.hashCode</tt> method.
	 * In particular, <tt>c1.equals(c2)</tt> implies that
	 * <tt>c1.hashCode()==c2.hashCode()</tt>.
	 *
	 * @return the hash code value for this collection
	 *
	 * @see Object#hashCode()
	 * @see Object#equals(Object)
	 */
	int hashCode();
}
