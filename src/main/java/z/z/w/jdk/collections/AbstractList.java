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
 *     FileName: z.z.w.jdk.collections.AbstractList
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-07 16:54
 *   LastChange: 2015-12-07 16:54
 *      History:
 * </pre>
 *********************************************************************************************/


import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/**
 * This class provides a skeletal implementation of the {@link List}
 * 這個類提供一個List接口的實現骨架
 * interface to minimize the effort required to implement this interface
 * 這個骨架實現了最小所需要的基於隨機存儲訪問數據空間的實現.
 * backed by a "random access" data store (such as an array).  For sequential
 *                                        (例如一個數組)
 * access data (such as a linked list), {@link java.util.AbstractSequentialList} should
 * 對於序列訪問數據(例如一個linked的list)而AbstractSequentialList則用於這個類的引用
 * be used in preference to this class.
 *
 * <p>To implement an unmodifiable list, the programmer needs only to extend
 * 實現一個不可改變的list,程序員僅僅需要
 * this class and provide implementations for the {@link #get(int)} and
 * 擴展這個類并提供get(int)，size()方法的實現
 * {@link List#size() size()} methods.
 *
 * <p>To implement a modifiable list, the programmer must additionally
 * 實現一個可變list，程序員需要添加
 * override the {@link #set(int, Object) set(int, E)} method (which otherwise
 * 複寫set(int,Object),set(int,E)方法(否則會拋出一個異常).
 * throws an {@code UnsupportedOperationException}).  If the list is
 * variable-size the programmer must additionally override the
 * 如果這個list是可變大小的，程序員必須添加覆蓋add(int,Object)
 * {@link #add(int, Object) add(int, E)} and {@link #remove(int)} methods.
 * add(int,E)以及remove(int)方法.
 *
 * <p>The programmer should generally provide a void (no argument) and collection
 * 程序員應該提供通用的無參的集合構造器
 * constructor, as per the recommendation in the {@link Collection} interface
 * 作為每個集合接口詳細描述的推薦方法
 * specification.
 *
 * <p>Unlike the other abstract collection implementations, the programmer does
 * 與其他抽象集合實現不同,
 * <i>not</i> have to provide an iterator implementation; the iterator and
 * 程序員不需要提供一個迭代實現，
 * list iterator are implemented by this class, on top of the "random access"
 * 迭代器與list迭代器有這個類實現,作為隨機訪問的頂層方法.
 * methods:
 * {@link #get(int)},
 * {@link #set(int, Object) set(int, E)},
 * {@link #add(int, Object) add(int, E)} and
 * {@link #remove(int)}.
 *
 * <p>The documentation for each non-abstract method in this class describes its
 * 文檔對於每個在這個類中的非抽象方法描述實現的細節.
 * implementation in detail.  Each of these methods may be overridden if the
 *                            每一個方法都可以複寫如果集合允許更高效的實現
 * collection being implemented admits a more efficient implementation.
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @since 1.2
 */

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
	/**
	 * Sole constructor.  (For invocation by subclass constructors, typically
	 * 唯一的構造器.(.隱含的有子類調用)
	 * implicit.)
	 */
	protected AbstractList() {
	}

	/**
	 * Appends the specified element to the end of this list (optional
	 * 添加指定元素到list的末尾，可選的操作
	 * operation).
	 *
	 * <p>Lists that support this operation may place limitations on what
	 * 支持這個操作的list可以限制添加至這個list的的元素的放置地點
	 * elements may be added to this list.  In particular, some
	 *                                      特別說明，
	 * lists will refuse to add null elements, and others will impose
	 * 一些list會拒絕添加null元素，
	 * restrictions on the type of elements that may be added.  List
	 * 而另一些list會加上添加至這個list的元素的類型限制.
	 * classes should clearly specify in their documentation any restrictions
	 * List類要在他們的文檔中明確添加至list的元素的限制條件的詳細說明
	 * on what elements may be added.
	 *
	 * <p>This implementation calls {@code add(size(), e)}.
	 * 這個實現調用add(size(),e).
	 *
	 * <p>Note that this implementation throws an
	 * 注意這個實現如果沒有複寫add(int,Object)
	 * {@code UnsupportedOperationException} unless
	 * add(int ,E)會拋出一個異常 UnsupportedOperationException
	 * {@link #add(int, Object) add(int, E)} is overridden.
	 *
	 * @param e element to be appended to this list
	 * @return {@code true} (as specified by {@link Collection#add})
	 * @throws UnsupportedOperationException if the {@code add} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * @throws IllegalArgumentException if some property of this element
	 *         prevents it from being added to this list
	 */
	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	abstract public E get(int index);

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation always throws an
	 * 這個實現總是拋出異常 UnsupportedOperationException
	 * {@code UnsupportedOperationException}.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation always throws an
	 * {@code UnsupportedOperationException}.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation always throws an
	 * {@code UnsupportedOperationException}.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}


	// Search Operations

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation first gets a list iterator (with
	 * 這個實現首先獲取一個list迭代器(有listIterator獲得)
	 * {@code listIterator()}).  Then, it iterates over the list until the
	 *                           而後,由迭代器遍歷list直到發現指定的元素,
	 * specified element is found or the end of the list is reached.
	 *                            或者list到達list的末尾.
	 *
	 * @throws ClassCastException   {@inheritDoc}
	 * @throws NullPointerException {@inheritDoc}
	 */
	public int indexOf(Object o) {
		//獲取listIterator雙向迭代器
		ListIterator<E> it = listIterator();
		if (o==null) { // 指定元素為null
			while (it.hasNext()) // 遍歷本list
				if (it.next()==null) // 本list存在null元素
					return it.previousIndex(); // 返回 此元素索引
		} else {
			while (it.hasNext())
				if (o.equals(it.next())) // 判斷指定元素與本list中的元素是否相等
					return it.previousIndex();
		}
		return -1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation first gets a list iterator that points to the end
	 * 這個實現首先返回一個指向list結果的迭代器
	 * of the list (with {@code listIterator(size())}).  Then, it iterates
	 * (由listIterator(size)提供)
	 * backwards over the list until the specified element is found, or the
	 * 而後,迭代器向後迭代,知道發現指定的元素
	 * beginning of the list is reached.
	 * 或者到達list的開始.
	 *
	 * @throws ClassCastException   {@inheritDoc}
	 * @throws NullPointerException {@inheritDoc}
	 */
	public int lastIndexOf(Object o) {
		ListIterator<E> it = listIterator(size());
		if (o==null) {
			while (it.hasPrevious()) // 向後遍歷
				if (it.previous()==null) // 後繼是否為null
					return it.nextIndex();
		} else {
			while (it.hasPrevious())
				if (o.equals(it.previous()))
					return it.nextIndex();
		}
		return -1;
	}


	// Bulk Operations
	// 塊操作

	/**
	 * Removes all of the elements from this list (optional operation).
	 * 從集合中移除所有的元素
	 * The list will be empty after this call returns.
	 * 這個方法調用後會返回一個empty集合
	 *
	 * <p>This implementation calls {@code removeRange(0, size())}.
	 *
	 * <p>Note that this implementation throws an
	 * {@code UnsupportedOperationException} unless {@code remove(int
	 * index)} or {@code removeRange(int fromIndex, int toIndex)} is
	 * overridden.
	 *
	 * @throws UnsupportedOperationException if the {@code clear} operation
	 *         is not supported by this list
	 */
	public void clear() {
		removeRange(0, size());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation gets an iterator over the specified collection
	 * 整個實現得到一個訪問指定集合的迭代器，并迭代它
	 * and iterates over it, inserting the elements obtained from the
	 * 通過迭代器在list中適當的位置獲得感興趣的元素,
	 * iterator into this list at the appropriate position, one at a time,
	 *                                                       一次一個的
	 * using {@code add(int, E)}.
	 * 使用add(int, E)
	 * Many implementations will override this method for efficiency.
	 * 許多實現由於效率都會複寫這個實現
	 *
	 * <p>Note that this implementation throws an
	 * {@code UnsupportedOperationException} unless
	 * {@link #add(int, Object) add(int, E)} is overridden.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		rangeCheckForAdd(index);
		boolean modified = false;
		for (E e : c) {
			add(index++, e);
			modified = true;
		}
		return modified;
	}


	// Iterators

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 返回在這個list中的正確的序列的迭代器
	 *
	 * <p>This implementation returns a straightforward implementation of the
	 * 這個實現返回一個有迭代接口返回的簡單實現
	 * iterator interface, relying on the backing list's {@code size()},
	 *  依託list的size(),get(int)以及remove(int)方法
	 * {@code get(int)}, and {@code remove(int)} methods.
	 *
	 * <p>Note that the iterator returned by this method will throw an
	 * {@link UnsupportedOperationException} in response to its
	 * {@code remove} method unless the list's {@code remove(int)} method is
	 * overridden.
	 *
	 * <p>This implementation can be made to throw runtime exceptions in the
	 * face of concurrent modification, as described in the specification
	 * for the (protected) {@link #modCount} field.
	 *
	 * @return an iterator over the elements in this list in proper sequence
	 */
	public Iterator<E> iterator() {
		return new Itr();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation returns {@code listIterator(0)}.
	 * 這個實現返回listIterator(0)
	 *
	 * @see #listIterator(int)
	 */
	public ListIterator<E> listIterator() {
		return listIterator(0);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation returns a straightforward implementation of the
	 * 這個實現返回了一個簡單的ListIterator接口的實現.
	 * {@code ListIterator} interface that extends the implementation of the
	 * 這個實現擴展了由iterator()方法返回的Iterator接口的實現.
	 * {@code Iterator} interface returned by the {@code iterator()} method.
	 * The {@code ListIterator} implementation relies on the backing list's
	 * 這個ListIterator實現依賴於集合的get(int),set(int,E),add(int,E)以及
	 * {@code get(int)}, {@code set(int, E)}, {@code add(int, E)}
	 * and {@code remove(int)} methods.
	 * remove(int)方法為基礎.
	 *
	 * <p>Note that the list iterator returned by this implementation will
	 * 注意由這個實現返回的list迭代器在響應remove,set,add時會拋出一個異常.
	 * throw an {@link UnsupportedOperationException} in response to its
	 * {@code remove}, {@code set} and {@code add} methods unless the
	 * 除非這個list的remove,set,add方法重寫了.
	 * list's {@code remove(int)}, {@code set(int, E)}, and
	 * {@code add(int, E)} methods are overridden.
	 *
	 * <p>This implementation can be made to throw runtime exceptions in the
	 * 這個實現在並發改變時會拋出一個運行時異常,
	 * face of concurrent modification, as described in the specification for
	 * the (protected) {@link #modCount} field.
	 * 在受保護的modCount域中詳細的描述
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public ListIterator<E> listIterator(final int index) {
		rangeCheckForAdd(index); // 範圍校驗

		return new ListItr(index); // private 內部類
	}

	private class Itr implements Iterator<E> {
		/**
		 * Index of element to be returned by subsequent call to next.
		 * 由子序列調用下一個返回的元素的索引
		 */
		int cursor = 0;

		/**
		 * Index of element returned by most recent call to next or
		 * 由最近調用的後繼或前驅返回的元素的索引
		 * previous.  Reset to -1 if this element is deleted by a call
		 *            如果調用remove使得元素刪除了，則重置為-1
		 * to remove.
		 */
		int lastRet = -1;

		/**
		 * The modCount value that the iterator believes that the backing
		 * 迭代器相信list支持的modCount值應該存在.
		 * List should have.  If this expectation is violated, the iterator
		 *                    如果違反了期望,
		 * has detected concurrent modification.
		 * 這個迭代器會檢測到並發的改變.
		 */
		int expectedModCount = modCount;

		// 判斷是否存在下一個
		public boolean hasNext() {
			return cursor != size();
		}

		// 返回下一個元素
		public E next() {
			// fail-fast檢測
			checkForComodification();
			try {
				int i = cursor;
				E next = get(i);
				lastRet = i;
				cursor = i + 1;
				return next;
			} catch (IndexOutOfBoundsException e) {
				checkForComodification();
				throw new NoSuchElementException();
			}
		}

		// 移除
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			checkForComodification();

			try {
				AbstractList.this.remove(lastRet);
				if (lastRet < cursor)
					cursor--;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}
		}

		final void checkForComodification() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
		}
	}

	private class ListItr extends Itr implements ListIterator<E> {
		ListItr(int index) {
			cursor = index;
		}

		// 存在前向元素
		public boolean hasPrevious() {
			return cursor != 0;
		}

		// 返回前驅元素
		public E previous() {
			// 檢查元素是否並發修改了，fail-fast機制
			checkForComodification();
			try {
				int i = cursor - 1;
				E previous = get(i);
				lastRet = cursor = i;
				return previous;
			} catch (IndexOutOfBoundsException e) {
				checkForComodification();
				throw new NoSuchElementException();
			}
		}

		// 後繼索引
		public int nextIndex() {
			return cursor;
		}

		// 前驅索引
		public int previousIndex() {
			return cursor-1;
		}

		public void set(E e) {
			if (lastRet < 0)
				throw new IllegalStateException();
			checkForComodification();

			try {
				AbstractList.this.set(lastRet, e);
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

		public void add(E e) {
			checkForComodification();

			try {
				int i = cursor;
				AbstractList.this.add(i, e);
				lastRet = -1;
				cursor = i + 1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>This implementation returns a list that subclasses
	 * 這個是顯示返回一個AbstractList子類的list
	 * {@code AbstractList}.  The subclass stores, in private fields, the
	 * 這個子類的存儲,私有的域
	 * offset of the subList within the backing list, the size of the subList
	 * 在依據list內的子list的偏移量,
	 * (which can change over its lifetime), and the expected
	 * 改變他的生命週期時，子list的大小
	 * {@code modCount} value of the backing list.  There are two variants
	 * 依據與list的期望的modCount的值
	 * of the subclass, one of which implements {@code RandomAccess}.
	 * 在子類中存在兩個變種，一個實現了RandomAccess
	 * If this list implements {@code RandomAccess} the returned list will
	 * 如果list實現RandomAccess，那麼返回的list將會是實現了RandomAccess的子類的實現
	 * be an instance of the subclass that implements {@code RandomAccess}.
	 *
	 * <p>The subclass's {@code set(int, E)}, {@code get(int)},
	 * {@code add(int, E)}, {@code remove(int)}, {@code addAll(int,
	 * Collection)} and {@code removeRange(int, int)} methods all
	 * 這個子類的set,get,add,remove,addAll,removeRange方法根據響應的基於抽象list的方法
	 * delegate to the corresponding methods on the backing abstract list,
	 * after bounds-checking the index and adjusting for the offset.  The
	 * 在邊界檢查索引后由偏移量調整.
	 * {@code addAll(Collection c)} method merely returns {@code addAll(size,
	 * addAll(c)方法僅僅返回add(size,c)
	 * c)}.
	 *
	 * <p>The {@code listIterator(int)} method returns a "wrapper object"
	 * 迭代方法返回一個基於list的迭代器的封裝的obj
	 * over a list iterator on the backing list, which is created with the
	 * corresponding method on the backing list.  The {@code iterator} method
	 * 由此在基於list上創建了適當的方法
	 * merely returns {@code listIterator()}, and the {@code size} method
	 * 這個方法僅僅返回listIterator並且這個方法僅僅返回子類的size域
	 * merely returns the subclass's {@code size} field.
	 *
	 * <p>All methods first check to see if the actual {@code modCount} of
	 * 所有的方法首先檢測如果基於list的真實的modCount等於他期望的值,
	 * the backing list is equal to its expected value, and throw a
	 * 如果不是，則會拋出一個異常
	 * {@code ConcurrentModificationException} if it is not.
	 *
	 * @throws IndexOutOfBoundsException if an endpoint index value is out of range
	 *         {@code (fromIndex < 0 || toIndex > size)}
	 * @throws IllegalArgumentException if the endpoint indices are out of order
	 *         {@code (fromIndex > toIndex)}
	 */
	public List<E> subList(int fromIndex, int toIndex) {
		return (this instanceof RandomAccess ?
				new RandomAccessSubList<>(this, fromIndex, toIndex) :
				new SubList<>(this, fromIndex, toIndex));
	}

	// Comparison and hashing

	/**
	 * Compares the specified object with this list for equality.  Returns
	 * {@code true} if and only if the specified object is also a list, both
	 * lists have the same size, and all corresponding pairs of elements in
	 * the two lists are <i>equal</i>.  (Two elements {@code e1} and
	 * {@code e2} are <i>equal</i> if {@code (e1==null ? e2==null :
	 * e1.equals(e2))}.)  In other words, two lists are defined to be
	 * equal if they contain the same elements in the same order.<p>
	 *
	 * This implementation first checks if the specified object is this
	 * list. If so, it returns {@code true}; if not, it checks if the
	 * specified object is a list. If not, it returns {@code false}; if so,
	 * it iterates over both lists, comparing corresponding pairs of elements.
	 * If any comparison returns {@code false}, this method returns
	 * {@code false}.  If either iterator runs out of elements before the
	 * other it returns {@code false} (as the lists are of unequal length);
	 * otherwise it returns {@code true} when the iterations complete.
	 *
	 * @param o the object to be compared for equality with this list
	 * @return {@code true} if the specified object is equal to this list
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof List))
			return false;

		ListIterator<E> e1 = listIterator();
		ListIterator    e2 = ((List) o).listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1==null ? o2==null : o1.equals(o2)))
				return false;
		}
		return !(e1.hasNext() || e2.hasNext());
	}

	/**
	 * Returns the hash code value for this list.
	 *
	 * <p>This implementation uses exactly the code that is used to define the
	 * list hash function in the documentation for the {@link List#hashCode}
	 * method.
	 *
	 * @return the hash code value for this list
	 */
	public int hashCode() {
		int hashCode = 1;
		for (E e : this)
			hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
		return hashCode;
	}

	/**
	 * Removes from this list all of the elements whose index is between
	 * 從集合中移除包含fromIndex索引到toIndex除外之間的所有元素。[fromIndex,toIndex)
	 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
	 * Shifts any succeeding elements to the left (reduces their index).
	 * 改變任何成功的元素會向左減少他們的索引.
	 * This call shortens the list by {@code (toIndex - fromIndex)} elements.
	 * 這個方法調用有(toIndex-fromIndex)元素縮短集合.
	 * (If {@code toIndex==fromIndex}, this operation has no effect.)
	 * 如果 toIndex == fromIndex ，那麼，這個操作不熟任何影響
	 *
	 * <p>This method is called by the {@code clear} operation on this list
	 * 這個方法由list或他的子list的clear方法調用
	 * and its subLists.  Overriding this method to take advantage of
	 * the internals of the list implementation can <i>substantially</i>
	 * 複寫這個方法能夠使得list實現的內部有利條件
	 * improve the performance of the {@code clear} operation on this list
	 * 提高list和他的子list的clear操作性能
	 * and its subLists.
	 *
	 * <p>This implementation gets a list iterator positioned before
	 * 這個實現在fromIndex之前獲得一個迭代器位置,
	 * {@code fromIndex}, and repeatedly calls {@code ListIterator.next}
	 * 並且重複調用ListIterator.next方法在ListIterator.remove方法之後，
	 * followed by {@code ListIterator.remove} until the entire range has
	 *                                           直到移除了整個範圍
	 * been removed.  <b>Note: if {@code ListIterator.remove} requires linear
	 * 注意：如果ListIterator.remove需要線性時間
	 * time, this implementation requires quadratic time.</b>
	 * 整個實現需要平方的時間
	 *
	 * @param fromIndex index of first element to be removed
	 * @param toIndex index after last element to be removed
	 */
	protected void removeRange(int fromIndex, int toIndex) {
		ListIterator<E> it = listIterator(fromIndex);
		for (int i=0, n=toIndex-fromIndex; i<n; i++) {
			it.next();
			it.remove();
		}
	}

	/**
	 * The number of times this list has been <i>structurally modified</i>.
	 * 這個list已經結構修改的次數.
	 * Structural modifications are those that change the size of the
	 * 結構修改是 那些list的大小改變了,
	 * list, or otherwise perturb it in such a fashion that iterations in
	 *       或者除此以外的例如迭代器在使用過程中產生不正確結果的狀況.
	 * progress may yield incorrect results.
	 *
	 * <p>This field is used by the iterator and list iterator implementation
	 * 這個域用於有迭代器iterator或者listIterator方法返回的實現.
	 * returned by the {@code iterator} and {@code listIterator} methods.
	 * If the value of this field changes unexpectedly, the iterator (or list
	 * 如果這個域的值無法預料的改變了,
	 * iterator) will throw a {@code ConcurrentModificationException} in
	 * 那麼迭代器會在響應next,remove,previous,set,add操作時拋出一個異常
	 * response to the {@code next}, {@code remove}, {@code previous},
	 * {@code set} or {@code add} operations.  This provides
	 * <i>fail-fast</i> behavior, rather than non-deterministic behavior in
	 * 其提供了fail-fast行為,而不是非確定性行為在迭代過程中並發的改變其表面現象.
	 * the face of concurrent modification during iteration.
	 *
	 * <p><b>Use of this field by subclasses is optional.</b> If a subclass
	 * 子類中這個域的使用是可選的.
	 * wishes to provide fail-fast iterators (and list iterators), then it
	 * 如果一個子類希望提供fail-fast迭代,
	 * merely has to increment this field in its {@code add(int, E)} and
	 * 那麼他僅僅提供這個與在add,remove(和一些其他的複寫list結構改變的結果的方法)方法
	 * {@code remove(int)} methods (and any other methods that it overrides
	 * 的增量
	 * that result in structural modifications to the list).  A single call to
	 * {@code add(int, E)} or {@code remove(int)} must add no more than
	 * 單獨的調用add或者remove必須添加不多於這個域的一個，
	 * one to this field, or the iterators (and list iterators) will throw
	 * 或者迭代器拋出一個虛假的異常
	 * bogus {@code ConcurrentModificationExceptions}.  If an implementation
	 * does not wish to provide fail-fast iterators, this field may be
	 * 如果一個實現不希望提供fail-fast迭代，這個域會ignore
	 * ignored.
	 */
	protected transient int modCount = 0;

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size()) // 索引超出size範圍，數組越界異常
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+size();
	}
}

class SubList<E> extends AbstractList<E> {
	private final AbstractList<E> l;
	private final int offset;
	private int size;

	SubList(AbstractList<E> list, int fromIndex, int toIndex) {
		if (fromIndex < 0)
			throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
		if (toIndex > list.size())
			throw new IndexOutOfBoundsException("toIndex = " + toIndex);
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex +
											   ") > toIndex(" + toIndex + ")");
		l = list;
		offset = fromIndex;
		size = toIndex - fromIndex;
		this.modCount = l.modCount;
	}

	public E set(int index, E element) {
		rangeCheck(index);
		checkForComodification();
		return l.set(index+offset, element);
	}

	public E get(int index) {
		rangeCheck(index);
		checkForComodification();
		return l.get(index+offset);
	}

	public int size() {
		checkForComodification();
		return size;
	}

	public void add(int index, E element) {
		rangeCheckForAdd(index);
		checkForComodification();
		l.add(index+offset, element);
		this.modCount = l.modCount;
		size++;
	}

	public E remove(int index) {
		rangeCheck(index);
		checkForComodification();
		E result = l.remove(index+offset);
		this.modCount = l.modCount;
		size--;
		return result;
	}

	protected void removeRange(int fromIndex, int toIndex) {
		checkForComodification();
		l.removeRange(fromIndex+offset, toIndex+offset);
		this.modCount = l.modCount;
		size -= (toIndex-fromIndex);
	}

	public boolean addAll(Collection<? extends E> c) {
		return addAll(size, c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		rangeCheckForAdd(index);
		int cSize = c.size();
		if (cSize==0)
			return false;

		checkForComodification();
		l.addAll(offset+index, c);
		this.modCount = l.modCount;
		size += cSize;
		return true;
	}

	public Iterator<E> iterator() {
		return listIterator();
	}

	public ListIterator<E> listIterator(final int index) {
		checkForComodification();
		rangeCheckForAdd(index);

		return new ListIterator<E>() {
			private final ListIterator<E> i = l.listIterator(index+offset);

			public boolean hasNext() {
				return nextIndex() < size;
			}

			public E next() {
				if (hasNext())
					return i.next();
				else
					throw new NoSuchElementException();
			}

			public boolean hasPrevious() {
				return previousIndex() >= 0;
			}

			public E previous() {
				if (hasPrevious())
					return i.previous();
				else
					throw new NoSuchElementException();
			}

			public int nextIndex() {
				return i.nextIndex() - offset;
			}

			public int previousIndex() {
				return i.previousIndex() - offset;
			}

			public void remove() {
				i.remove();
				SubList.this.modCount = l.modCount;
				size--;
			}

			public void set(E e) {
				i.set(e);
			}

			public void add(E e) {
				i.add(e);
				SubList.this.modCount = l.modCount;
				size++;
			}
		};
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return new SubList<>(this, fromIndex, toIndex);
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+size;
	}

	private void checkForComodification() {
		if (this.modCount != l.modCount)
			throw new ConcurrentModificationException();
	}
}

class RandomAccessSubList<E> extends SubList<E> implements RandomAccess
{
	RandomAccessSubList(AbstractList<E> list, int fromIndex, int toIndex) {
		super(list, fromIndex, toIndex);
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return new RandomAccessSubList<>(this, fromIndex, toIndex);
	}
}

