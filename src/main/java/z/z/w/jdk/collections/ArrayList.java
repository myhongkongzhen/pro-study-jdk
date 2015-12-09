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
 *     FileName: z.z.w.jdk.collections.ArrayList
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-08 17:47
 *   LastChange: 2015-12-08 17:47
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Resizable-array implementation of the <tt>List</tt> interface.  Implements
 * List接口的可變大小的數組實現.
 * all optional list operations, and permits all elements, including
 * 實現了所有的可選的list操作,允許所有的元素包含null
 * <tt>null</tt>.  In addition to implementing the <tt>List</tt> interface,
 *                 在List接口添加實現
 * this class provides methods to manipulate the size of the array that is
 * 這個類提供方法來操作用於list空間內的數組的大小
 * used internally to store the list.  (This class is roughly equivalent to
 * <tt>Vector</tt>, except that it is unsynchronized.)
 * (這個類大致同Vector相同，除了他是未同步的)
 *
 * <p>The <tt>size</tt>, <tt>isEmpty</tt>, <tt>get</tt>, <tt>set</tt>,
 * size(),isEmpty(),get(),set(),iterator()以及listIterator()
 * <tt>iterator</tt>, and <tt>listIterator</tt> operations run in constant
 * 操作運行消耗常量時間.
 * time.  The <tt>add</tt> operation runs in <i>amortized constant time</i>,
 *        add()操作消耗攤還常量時間
 * that is, adding n elements requires O(n) time.  All of the other operations
 * 添加一個元素需要O(n)時間複雜度.
 * run in linear time (roughly speaking).  The constant factor is low compared
 * 另外的所有操作都是線性的時間複雜度(大概的講)
 * to that for the <tt>LinkedList</tt> implementation.
 * 常量因子用來與LinkedList實現更低的比較
 *
 * <p>Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
 * 每一個ArrayList實現都擁有一個容量.
 * the size of the array used to store the elements in the list.  It is always
 * 這個容量是用來在list中存儲數組的大小.
 * at least as large as the list size.  As elements are added to an ArrayList,
 * 這個容量至少同list的size一樣大.         當一個元素添加至一個ArrayList
 * its capacity grows automatically.  The details of the growth policy are not
 * 他的容量自動增長.
 * specified beyond the fact that adding an element has constant amortized
 * 這個增長策略的詳情不是特別指定的,事實上除了添加元素會降低時間消耗之外
 * time cost.
 *
 * <p>An application can increase the capacity of an <tt>ArrayList</tt> instance
 * 一個ArrayList實現的一個應用可以自動增長容量,
 * before adding a large number of elements using the <tt>ensureCapacity</tt>
 * 在用確定容量操作之前添加大量數據
 * operation.  This may reduce the amount of incremental reallocation.
 *             這可能會降低重新分配增量的數量
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * 注意，這個實現是未同步的.
 * If multiple threads access an <tt>ArrayList</tt> instance concurrently,
 * 如果多個線程並發的存儲訪問一個ArrraList實例
 * and at least one of the threads modifies the list structurally, it
 * 至少一個線程改變了list的結構,
 * <i>must</i> be synchronized externally.  (A structural modification is
 * 那麼必須提供外部的同步.
 * any operation that adds or deletes one or more elements, or explicitly
 * (一個結構化的改變是指任何add,delete一個或者多個元素，或者基於數組外部的重新
 * resizes the backing array; merely setting the value of an element is not
 * 改變大小的操作；僅僅設置一個元素的值不是結構化的改變.)
 * a structural modification.)  This is typically accomplished by
 * synchronizing on some object that naturally encapsulates the list.
 * 這通常用於完城某些list的自然封裝的對象的同步.
 *
 * If no such object exists, the list should be "wrapped" using the
 * 如果不存在這個對象,           這個list會用
 * {@link Collections#synchronizedList Collections.synchronizedList}
 * Collections.synchronizedList進行封裝
 * method.  This is best done at creation time, to prevent accidental
 *          這是在創建時最好的做法,                防止意外未同步存儲訪問list
 * unsynchronized access to the list:<pre>
 *
 *   List list = Collections.synchronizedList(new ArrayList(...));</pre>
 *
 * <p><a name="fail-fast"/>
 * The iterators returned by this class's {@link #iterator() iterator} and
 * 有這個類的iterator和listIterator返回的迭代器是fail-fast的
 * {@link #listIterator(int) listIterator} methods are <em>fail-fast</em>:
 * if the list is structurally modified at any time after the iterator is
 * 如果這個list在iterator創建之後的任何時間，結構改變了,
 * created, in any way except through the iterator's own
 *           在任意期望迭代自身的remove,add方法，
 * {@link ListIterator#remove() remove} or
 * {@link ListIterator#add(Object) add} methods, the iterator will throw a
 * 迭代器都會拋出一個異常.
 * {@link ConcurrentModificationException}.  Thus, in the face of
 * concurrent modification, the iterator fails quickly and cleanly, rather
 * 因此，事實上並發的改變,      迭代器會快速的失敗和清理,
 * than risking arbitrary, non-deterministic behavior at an undetermined
 * 而不是冒著任意風險的,在為確定的時間中不確定的行為.
 * time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * 注意，一個迭代器的快速失敗機制是不能保證的，通常的講，在未同步的並發改變中的任意困難的保證
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * 是不可能的.
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw {@code ConcurrentModificationException} on a best-effort basis.
 * 快速失敗在最省力的基礎上拋出一個異常
 * Therefore, it would be wrong to write a program that depended on this
 * 因此，由於他的正確性依賴於一個異常而錯誤的編寫一個程序
 * exception for its correctness:  <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 * 迭代器的快速失敗機制僅僅用於檢測bug.
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Collection
 * @see     List
 * @see     LinkedList
 * @see     Vector
 * @since   1.2
 */

public class ArrayList<E> extends AbstractList<E>
		implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
	// 序列化
	private static final long serialVersionUID = 8683452581122892189L;

	/**
	 * Default initial capacity.
	 * 默認的初始容量
	 */
	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * Shared empty array instance used for empty instances.
	 * 用於empty實例的共享的數組實例
	 */
	private static final Object[] EMPTY_ELEMENTDATA = {};

	/**
	 * The array buffer into which the elements of the ArrayList are stored.
	 * 數組的緩存用於ArrayList存儲元素的空間
	 * The capacity of the ArrayList is the length of this array buffer. Any
	 * ArrayList的容量是數組緩存的長度.
	 * empty ArrayList with elementData == EMPTY_ELEMENTDATA will be expanded to
	 * 任何空的ArrayList的 elementData == EMPTY_ELEMENTDATA 在第一個元素添加時
	 * DEFAULT_CAPACITY when the first element is added.
	 * 擴大 10 容量
	 */
	private transient Object[] elementData; // 非序列化的

	/**
	 * The size of the ArrayList (the number of elements it contains).
	 *
	 * @serial
	 */
	private int size;

	/**
	 * Constructs an empty list with the specified initial capacity.
	 * 構造一個指定初始容量的空list
	 *
	 * @param  initialCapacity  the initial capacity of the list
	 * @throws IllegalArgumentException if the specified initial capacity
	 *         is negative
	 *            負
	 */
	public ArrayList(int initialCapacity) {
		super(); // 調用AbstractList構造方法
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "+
											   initialCapacity);
		                   // 新建數組
		this.elementData = new Object[initialCapacity];
	}

	/**
	 * Constructs an empty list with an initial capacity of ten.
	 * 創建一個空的list，大小為10，默認大小
	 */
	public ArrayList() {
		super();
		                   // 默認提供的共享數組空間
		this.elementData = EMPTY_ELEMENTDATA;
	}

	/**
	 * Constructs a list containing the elements of the specified
	 * 構造一個包含指定集合元素的list
	 * collection, in the order they are returned by the collection's
	 *             按照集合的迭代返回的順序
	 * iterator.
	 *
	 * @param c the collection whose elements are to be placed into this list
	 * @throws NullPointerException if the specified collection is null
	 */
	public ArrayList(Collection<? extends E> c) {
		elementData = c.toArray(); // 將指定集合轉成 數組
		size = elementData.length;
		// c.toArray might (incorrectly) not return Object[] (see 6260652)
		if (elementData.getClass() != Object[].class) // 判斷類型
		    // 數組拷貝
			elementData = Arrays.copyOf(elementData, size, Object[].class);
	}

	/**
	 * Trims the capacity of this <tt>ArrayList</tt> instance to be the
	 * 修正ArrayList實例的容量為當前list的大小
	 * list's current size.  An application can use this operation to minimize
	 * the storage of an <tt>ArrayList</tt> instance.
	 * 應用程序可用於一個ArrayList實例最小存儲空間
	 */
	public void trimToSize() {
		modCount++; // 集合結構改變計數+1
		if (size < elementData.length) {
			// 修剪元素
			elementData = Arrays.copyOf(elementData, size);
		}
	}

	/**
	 * Increases the capacity of this <tt>ArrayList</tt> instance, if
	 * ArrayList實例的增加的容量,
	 * necessary, to ensure that it can hold at least the number of elements
	 * 如果必要,   確保容量可以容納指定的最小容量參數的元素個數
	 * specified by the minimum capacity argument.
	 *
	 * @param   minCapacity   the desired minimum capacity
	 *                            期望的  最小容量
	 */
	public void ensureCapacity(int minCapacity) {
		 // 最小的擴容
		int minExpand = (elementData != EMPTY_ELEMENTDATA)
						// any size if real element table
						? 0
						// larger than default for empty table. It's already supposed to be
						// at default size.
						: DEFAULT_CAPACITY; // 10

		if (minCapacity > minExpand) {
			// 確定明確容量
			ensureExplicitCapacity(minCapacity);
		}
	}

	// 明確內部容量
	private void ensureCapacityInternal(int minCapacity) {
		if (elementData == EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}

		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;

		// overflow-conscious code
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	/**
	 * The maximum size of array to allocate.
	 * 分配的數組最大的值
	 * Some VMs reserve some header words in an array.
	 * 一些vm在數組中保留了一些頭信息
	 * Attempts to allocate larger arrays may result in
	 * 嘗試分配更大的數組結果會出現 OutOfMemoryError
	 * OutOfMemoryError: Requested array size exceeds VM limit
	 *                   請求數組的元素超過了vm的極限
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	/**
	 * Increases the capacity to ensure that it can hold at least the
	 * 增加容量確保容量能夠提供由最小容量參數指定的元素個數.
	 * number of elements specified by the minimum capacity argument.
	 *
	 * @param minCapacity the desired minimum capacity
	 *                        期望的
	 */
	private void grow(int minCapacity) {
		// overflow-conscious code
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		// minCapacity is usually close to size, so this is a win:
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) // overflow
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ?
			   Integer.MAX_VALUE :
			   MAX_ARRAY_SIZE;
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 *
	 * @return <tt>true</tt> if this list contains no elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this list contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 *                        存在
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * 返回list中指定元素的首次范閒的索引
	 * in this list, or -1 if this list does not contain the element.
	 *               或者不包含元素時返回-1
	 * More formally, returns the lowest index <tt>i</tt> such that
	 * 更正式的講，    返回 ( o == null ? get(i) == null : o.equals( get(i) ) )
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * 最低的索引
	 * or -1 if there is no such index.
	 * 如果沒有這樣的索引，返回-1
	 */
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i]==null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * 返回list中指定元素的最後發現的索引
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the highest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * or -1 if there is no such index.
	 * 不存在這樣的索引返回-1
	 */
	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size-1; i >= 0; i--)
				if (elementData[i]==null)
					return i;
		} else {
			for (int i = size-1; i >= 0; i--)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	/**
	 * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The
	 * 返回List實例的淺拷貝
	 * elements themselves are not copied.)
	 * (元素自身不能複製)
	 *
	 * @return a clone of this <tt>ArrayList</tt> instance
	 */
	public Object clone() {
		try {
			@SuppressWarnings("unchecked")
			ArrayList<E> v = (ArrayList<E>) super.clone();
			v.elementData = Arrays.copyOf(elementData, size);
			v.modCount = 0;
			return v;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}

	/**
	 * Returns an array containing all of the elements in this list
	 * 返回一個數組包含了所有list中的正確序列的元素
	 * in proper sequence (from first to last element).
	 *
	 * <p>The returned array will be "safe" in that no references to it are
	 * 返回的數組是安全的，因為沒有引用維護這個list
	 * maintained by this list.  (In other words, this method must allocate
	 *                           (換句話說,這個方法必須分配一個新的數組)
	 * a new array).  The caller is thus free to modify the returned array.
	 *                調用者因而自由的改變返回的數組
	 *
	 * <p>This method acts as bridge between array-based and collection-based
	 * 這個方法的行為作為數組和集合基礎的橋樑
	 * APIs.
	 *
	 * @return an array containing all of the elements in this list in
	 *         proper sequence
	 *         正確
	 */
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element); the runtime type of the returned
	 * array is that of the specified array.  If the list fits in the
	 * 返回數組的運行時類型是這個指定數組的類型.
	 * specified array, it is returned therein.  Otherwise, a new array is
	 *                                 在其中     否則，
	 * allocated with the runtime type of the specified array and the size of
	 * 一個新的數組又指定數組的運行時類型與list的大小分配
	 * this list.
	 *
	 * <p>If the list fits in the specified array with room to spare
	 * (i.e., the array has more elements than the list), the element in
	 * the array immediately following the end of the collection is set to
	 *           立即
	 * <tt>null</tt>.  (This is useful in determining the length of the
	 *                                    確定
	 * list <i>only</i> if the caller knows that the list does not contain
	 * any null elements.)
	 *
	 * @param a the array into which the elements of the list are to
	 *          be stored, if it is big enough; otherwise, a new array of the
	 *          same runtime type is allocated for this purpose.
	 * @return an array containing the elements of the list
	 * @throws ArrayStoreException if the runtime type of the specified array
	 *         is not a supertype of the runtime type of every element in
	 *         this list
	 * @throws NullPointerException if the specified array is null
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			// Make a new array of a's runtime type, but my contents:
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	// Positional Access Operations

	@SuppressWarnings("unchecked")
	E elementData(int index) {
		// 返回內部數組中索引位置的元素
		// 非公開訪問的方法，只在同包結構下
		return (E) elementData[index];
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param  index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E get(int index) {
		// 範圍檢測，不會檢測索引為負的情況,只會檢測索引是否超過size值
		rangeCheck(index);

		return elementData(index);
	}

	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 *
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 *         返回設定值之前的舊值
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E set(int index, E element) {
		rangeCheck(index);

		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 在list末尾添加元素
	 *
	 * @param e element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 */
	public boolean add(E e) {
		ensureCapacityInternal(size + 1);  // Increments modCount!!
		elementData[size++] = e;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * 在指定位置添加元素
	 * list. Shifts the element currently at that position (if any) and
	 * any subsequent elements to the right (adds one to their indices).
	 *     隨後的元素向右移動(索引加一)
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);

		ensureCapacityInternal(size + 1);  // Increments modCount!!
		// 指定位置后的元素拷貝
		System.arraycopy(elementData, index, elementData, index + 1,
						 size - index);
		elementData[index] = element;
		size++;
	}

	/**
	 * Removes the element at the specified position in this list.
	 * 移除list中指定位置的元素
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * 隨後的元素左移(索引減一)
	 * indices).
	 *
	 * @param index the index of the element to be removed
	 *              返回移除索引位置時的舊數據
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E remove(int index) {
		rangeCheck(index);

		modCount++;
		E oldValue = elementData(index);

		int numMoved = size - index - 1;
		if (numMoved > 0) // 指定位置元素前移
			System.arraycopy(elementData, index+1, elementData, index,
							 numMoved);
		elementData[--size] = null; // clear to let GC do its work

		return oldValue;
	}

	/**
	 * Removes the first occurrence of the specified element from this list,
	 * 移除list中指定的首次發現的元素
	 * if it is present.  If the list does not contain the element, it is
	 * 如果它存在的話       如果不包含這樣的元素，不發生改變
	 * unchanged.  More formally, removes the element with the lowest index
	 *             更正式的說，移除符合( o == null ? get(i) == null : o.equalse(get(i)) )
	 * <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
	 * 規則的最低索引的元素
	 * (if such an element exists).  Returns <tt>true</tt> if this list
	 * (如果這樣的元素存在)
	 * contained the specified element (or equivalently, if this list
	 * 如果list中包含指定元素返回true
	 * changed as a result of the call).
	 * (或者等效的,這個list因為這個方法的調用改變了結果)
	 *
	 * @param o element to be removed from this list, if present
	 * @return <tt>true</tt> if this list contained the specified element
	 */
	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (elementData[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(elementData[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	/*
	 * Private remove method that skips bounds checking and does not
	 * 不做校驗的是快速刪除方法，不返回刪除的元素
	 * return the value removed.
	 */
	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index+1, elementData, index,
							 numMoved);
		elementData[--size] = null; // clear to let GC do its work
	}

	/**
	 * Removes all of the elements from this list.  The list will
	 * be empty after this call returns.
	 */
	public void clear() {
		modCount++;

		// clear to let GC do its work
		for (int i = 0; i < size; i++)
			elementData[i] = null;

		size = 0;
	}

	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this list, in the order that they are returned by the
	 * specified collection's Iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the operation
	 * is in progress.  (This implies that the behavior of this call is
	 * undefined if the specified collection is this list, and this
	 * list is nonempty.)
	 *
	 * @param c collection containing elements to be added to this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws NullPointerException if the specified collection is null
	 */
	public boolean addAll(Collection<? extends E> c) {
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityInternal(size + numNew);  // Increments modCount
		System.arraycopy(a, 0, elementData, size, numNew);
		size += numNew;
		return numNew != 0;
	}

	/**
	 * Inserts all of the elements in the specified collection into this
	 * list, starting at the specified position.  Shifts the element
	 * currently at that position (if any) and any subsequent elements to
	 * the right (increases their indices).  The new elements will appear
	 * in the list in the order that they are returned by the
	 * specified collection's iterator.
	 *
	 * @param index index at which to insert the first element from the
	 *              specified collection
	 * @param c collection containing elements to be added to this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws NullPointerException if the specified collection is null
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		rangeCheckForAdd(index);

		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityInternal(size + numNew);  // Increments modCount

		int numMoved = size - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew,
							 numMoved);

		System.arraycopy(a, 0, elementData, index, numNew);
		size += numNew;
		return numNew != 0;
	}

	/**
	 * Removes from this list all of the elements whose index is between
	 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
	 * Shifts any succeeding elements to the left (reduces their index).
	 * This call shortens the list by {@code (toIndex - fromIndex)} elements.
	 * (If {@code toIndex==fromIndex}, this operation has no effect.)
	 *
	 * @throws IndexOutOfBoundsException if {@code fromIndex} or
	 *         {@code toIndex} is out of range
	 *         ({@code fromIndex < 0 ||
	 *          fromIndex >= size() ||
	 *          toIndex > size() ||
	 *          toIndex < fromIndex})
	 */
	protected void removeRange(int fromIndex, int toIndex) {
		modCount++;
		int numMoved = size - toIndex;
		System.arraycopy(elementData, toIndex, elementData, fromIndex,
						 numMoved);

		// clear to let GC do its work
		int newSize = size - (toIndex-fromIndex);
		for (int i = newSize; i < size; i++) {
			elementData[i] = null;
		}
		size = newSize;
	}

	/**
	 * Checks if the given index is in range.  If not, throws an appropriate
	 * 檢查指定的索引是否在範圍內,                   如果不在，拋出一個適當的
	 * runtime exception.  This method does *not* check if the index is
	 * 運行時異常            這個方法不會檢查所以是否為負數
	 * negative: It is always used immediately prior to an array access,
	 *           這個方法總是立即用於預先的數組訪問
	 * which throws an ArrayIndexOutOfBoundsException if index is negative.
	 * 如果索引為負數，會拋出一個數組越界異常
	 */
	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	/**
	 * A version of rangeCheck used by add and addAll.
	 * 由add和addAll使用的範圍檢查的版本
	 */
	private void rangeCheckForAdd(int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	/**
	 * Constructs an IndexOutOfBoundsException detail message.
	 * Of the many possible refactorings of the error handling code,
	 * this "outlining" performs best with both server and client VMs.
	 */
	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+size;
	}

	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection.
	 *
	 * @param c collection containing elements to be removed from this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see Collection#contains(Object)
	 */
	public boolean removeAll(Collection<?> c) {
		return batchRemove(c, false);
	}

	/**
	 * Retains only the elements in this list that are contained in the
	 * specified collection.  In other words, removes from this list all
	 * of its elements that are not contained in the specified collection.
	 *
	 * @param c collection containing elements to be retained in this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see Collection#contains(Object)
	 */
	public boolean retainAll(Collection<?> c) {
		return batchRemove(c, true);
	}

	private boolean batchRemove(Collection<?> c, boolean complement) {
		final Object[] elementData = this.elementData;
		int r = 0, w = 0;
		boolean modified = false;
		try {
			for (; r < size; r++)
				if (c.contains(elementData[r]) == complement)
					elementData[w++] = elementData[r];
		} finally {
			// Preserve behavioral compatibility with AbstractCollection,
			// even if c.contains() throws.
			if (r != size) {
				System.arraycopy(elementData, r,
								 elementData, w,
								 size - r);
				w += size - r;
			}
			if (w != size) {
				// clear to let GC do its work
				for (int i = w; i < size; i++)
					elementData[i] = null;
				modCount += size - w;
				size = w;
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Save the state of the <tt>ArrayList</tt> instance to a stream (that
	 * is, serialize it).
	 *
	 * @serialData The length of the array backing the <tt>ArrayList</tt>
	 *             instance is emitted (int), followed by all of its elements
	 *             (each an <tt>Object</tt>) in the proper order.
	 */
	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException{
		// Write out element count, and any hidden stuff
		int expectedModCount = modCount;
		s.defaultWriteObject();

		// Write out size as capacity for behavioural compatibility with clone()
		s.writeInt(size);

		// Write out all elements in the proper order.
		for (int i=0; i<size; i++) {
			s.writeObject(elementData[i]);
		}

		if (modCount != expectedModCount) {
			throw new ConcurrentModificationException();
		}
	}

	/**
	 * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
	 * deserialize it).
	 */
	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		elementData = EMPTY_ELEMENTDATA;

		// Read in size, and any hidden stuff
		s.defaultReadObject();

		// Read in capacity
		s.readInt(); // ignored

		if (size > 0) {
			// be like clone(), allocate array based upon size not capacity
			ensureCapacityInternal(size);

			Object[] a = elementData;
			// Read in all elements in the proper order.
			for (int i=0; i<size; i++) {
				a[i] = s.readObject();
			}
		}
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence), starting at the specified position in the list.
	 * The specified index indicates the first element that would be
	 * returned by an initial call to {@link ListIterator#next next}.
	 * An initial call to {@link ListIterator#previous previous} would
	 * return the element with the specified index minus one.
	 *
	 * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public ListIterator<E> listIterator(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: "+index);
		return new ListItr(index);
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 *
	 * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
	 *
	 * @see #listIterator(int)
	 */
	public ListIterator<E> listIterator() {
		return new ListItr(0);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 *
	 * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
	 *
	 * @return an iterator over the elements in this list in proper sequence
	 */
	public Iterator<E> iterator() {
		return new Itr();
	}

	/**
	 * An optimized version of AbstractList.Itr
	 */
	private class Itr implements Iterator<E> {
		int cursor;       // index of next element to return
		int lastRet = -1; // index of last element returned; -1 if no such
		int expectedModCount = modCount;

		public boolean hasNext() {
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		public E next() {
			checkForComodification();
			int i = cursor;
			if (i >= size)
				throw new NoSuchElementException();
			Object[] elementData = ArrayList.this.elementData;
			if (i >= elementData.length)
				throw new ConcurrentModificationException();
			cursor = i + 1;
			return (E) elementData[lastRet = i];
		}

		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			checkForComodification();

			try {
				ArrayList.this.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

		final void checkForComodification() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
		}
	}

	/**
	 * An optimized version of AbstractList.ListItr
	 */
	private class ListItr extends Itr implements ListIterator<E> {
		ListItr(int index) {
			super();
			cursor = index;
		}

		public boolean hasPrevious() {
			return cursor != 0;
		}

		public int nextIndex() {
			return cursor;
		}

		public int previousIndex() {
			return cursor - 1;
		}

		@SuppressWarnings("unchecked")
		public E previous() {
			checkForComodification();
			int i = cursor - 1;
			if (i < 0)
				throw new NoSuchElementException();
			Object[] elementData = ArrayList.this.elementData;
			if (i >= elementData.length)
				throw new ConcurrentModificationException();
			cursor = i;
			return (E) elementData[lastRet = i];
		}

		public void set(E e) {
			if (lastRet < 0)
				throw new IllegalStateException();
			checkForComodification();

			try {
				ArrayList.this.set(lastRet, e);
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

		public void add(E e) {
			checkForComodification();

			try {
				int i = cursor;
				ArrayList.this.add(i, e);
				cursor = i + 1;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}
	}

	/**
	 * Returns a view of the portion of this list between the specified
	 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
	 * {@code fromIndex} and {@code toIndex} are equal, the returned list is
	 * empty.)  The returned list is backed by this list, so non-structural
	 * changes in the returned list are reflected in this list, and vice-versa.
	 * The returned list supports all of the optional list operations.
	 *
	 * <p>This method eliminates the need for explicit range operations (of
	 * the sort that commonly exist for arrays).  Any operation that expects
	 * a list can be used as a range operation by passing a subList view
	 * instead of a whole list.  For example, the following idiom
	 * removes a range of elements from a list:
	 * <pre>
	 *      list.subList(from, to).clear();
	 * </pre>
	 * Similar idioms may be constructed for {@link #indexOf(Object)} and
	 * {@link #lastIndexOf(Object)}, and all of the algorithms in the
	 * {@link Collections} class can be applied to a subList.
	 *
	 * <p>The semantics of the list returned by this method become undefined if
	 * the backing list (i.e., this list) is <i>structurally modified</i> in
	 * any way other than via the returned list.  (Structural modifications are
	 * those that change the size of this list, or otherwise perturb it in such
	 * a fashion that iterations in progress may yield incorrect results.)
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws IllegalArgumentException {@inheritDoc}
	 */
	public List<E> subList(int fromIndex, int toIndex) {
		subListRangeCheck(fromIndex, toIndex, size);
		return new SubList(this, 0, fromIndex, toIndex);
	}

	static void subListRangeCheck(int fromIndex, int toIndex, int size) {
		if (fromIndex < 0)
			throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
		if (toIndex > size)
			throw new IndexOutOfBoundsException("toIndex = " + toIndex);
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex +
											   ") > toIndex(" + toIndex + ")");
	}

	private class SubList extends AbstractList<E> implements RandomAccess {
		private final AbstractList<E> parent;
		private final int parentOffset;
		private final int offset;
		int size;

		SubList(AbstractList<E> parent,
				int offset, int fromIndex, int toIndex) {
			this.parent = parent;
			this.parentOffset = fromIndex;
			this.offset = offset + fromIndex;
			this.size = toIndex - fromIndex;
			this.modCount = ArrayList.this.modCount;
		}

		public E set(int index, E e) {
			rangeCheck(index);
			checkForComodification();
			E oldValue = ArrayList.this.elementData(offset + index);
			ArrayList.this.elementData[offset + index] = e;
			return oldValue;
		}

		public E get(int index) {
			rangeCheck(index);
			checkForComodification();
			return ArrayList.this.elementData(offset + index);
		}

		public int size() {
			checkForComodification();
			return this.size;
		}

		public void add(int index, E e) {
			rangeCheckForAdd(index);
			checkForComodification();
			parent.add(parentOffset + index, e);
			this.modCount = parent.modCount;
			this.size++;
		}

		public E remove(int index) {
			rangeCheck(index);
			checkForComodification();
			E result = parent.remove(parentOffset + index);
			this.modCount = parent.modCount;
			this.size--;
			return result;
		}

		protected void removeRange(int fromIndex, int toIndex) {
			checkForComodification();
			parent.removeRange(parentOffset + fromIndex,
							   parentOffset + toIndex);
			this.modCount = parent.modCount;
			this.size -= toIndex - fromIndex;
		}

		public boolean addAll(Collection<? extends E> c) {
			return addAll(this.size, c);
		}

		public boolean addAll(int index, Collection<? extends E> c) {
			rangeCheckForAdd(index);
			int cSize = c.size();
			if (cSize==0)
				return false;

			checkForComodification();
			parent.addAll(parentOffset + index, c);
			this.modCount = parent.modCount;
			this.size += cSize;
			return true;
		}

		public Iterator<E> iterator() {
			return listIterator();
		}

		public ListIterator<E> listIterator(final int index) {
			checkForComodification();
			rangeCheckForAdd(index);
			final int offset = this.offset;

			return new ListIterator<E>() {
				int cursor = index;
				int lastRet = -1;
				int expectedModCount = ArrayList.this.modCount;

				public boolean hasNext() {
					return cursor != SubList.this.size;
				}

				@SuppressWarnings("unchecked")
				public E next() {
					checkForComodification();
					int i = cursor;
					if (i >= SubList.this.size)
						throw new NoSuchElementException();
					Object[] elementData = ArrayList.this.elementData;
					if (offset + i >= elementData.length)
						throw new ConcurrentModificationException();
					cursor = i + 1;
					return (E) elementData[offset + (lastRet = i)];
				}

				public boolean hasPrevious() {
					return cursor != 0;
				}

				@SuppressWarnings("unchecked")
				public E previous() {
					checkForComodification();
					int i = cursor - 1;
					if (i < 0)
						throw new NoSuchElementException();
					Object[] elementData = ArrayList.this.elementData;
					if (offset + i >= elementData.length)
						throw new ConcurrentModificationException();
					cursor = i;
					return (E) elementData[offset + (lastRet = i)];
				}

				public int nextIndex() {
					return cursor;
				}

				public int previousIndex() {
					return cursor - 1;
				}

				public void remove() {
					if (lastRet < 0)
						throw new IllegalStateException();
					checkForComodification();

					try {
						SubList.this.remove(lastRet);
						cursor = lastRet;
						lastRet = -1;
						expectedModCount = ArrayList.this.modCount;
					} catch (IndexOutOfBoundsException ex) {
						throw new ConcurrentModificationException();
					}
				}

				public void set(E e) {
					if (lastRet < 0)
						throw new IllegalStateException();
					checkForComodification();

					try {
						ArrayList.this.set(offset + lastRet, e);
					} catch (IndexOutOfBoundsException ex) {
						throw new ConcurrentModificationException();
					}
				}

				public void add(E e) {
					checkForComodification();

					try {
						int i = cursor;
						SubList.this.add(i, e);
						cursor = i + 1;
						lastRet = -1;
						expectedModCount = ArrayList.this.modCount;
					} catch (IndexOutOfBoundsException ex) {
						throw new ConcurrentModificationException();
					}
				}

				final void checkForComodification() {
					if (expectedModCount != ArrayList.this.modCount)
						throw new ConcurrentModificationException();
				}
			};
		}

		public List<E> subList(int fromIndex, int toIndex) {
			subListRangeCheck(fromIndex, toIndex, size);
			return new SubList(this, offset, fromIndex, toIndex);
		}

		private void rangeCheck(int index) {
			if (index < 0 || index >= this.size)
				throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}

		private void rangeCheckForAdd(int index) {
			if (index < 0 || index > this.size)
				throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}

		private String outOfBoundsMsg(int index) {
			return "Index: "+index+", Size: "+this.size;
		}

		private void checkForComodification() {
			if (ArrayList.this.modCount != this.modCount)
				throw new ConcurrentModificationException();
		}
	}
}

