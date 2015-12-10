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
 *     FileName: z.z.w.jdk.collections.AbstractSequentialList
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-09 16:56
 *   LastChange: 2015-12-09 16:56
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.NoSuchElementException;

/**
 * This class provides a skeletal implementation of the <tt>List</tt>
 * 這個類提供了List接口的一個實現骨架
 * interface to minimize the effort required to implement this interface
 * 最小化的提供了這個接口基於序列化存儲訪問數據存儲的所必須的實現類的實現
 * backed by a "sequential access" data store (such as a linked list).  For
 *                                            (例如一個鏈錶list)
 * random access data (such as an array), <tt>AbstractList</tt> should be used
 * 對於隨機訪問的數據(例如array),AbstractList可用於這個類的執行
 * in preference to this class.<p>
 *
 * This class is the opposite of the <tt>AbstractList</tt> class in the sense
 * 這個類是與AbstractList類對立的
 * that it implements the "random access" methods (<tt>get(int index)</tt>,
 * 在實現隨機訪問的方法get(index),set(index,element),add(int,index,element)
 * <tt>set(int index, E element)</tt>, <tt>add(int index, E element)</tt> and
 * <tt>remove(int index)</tt>) on top of the list's list iterator, instead of
 * 以及remove(index)以list的list迭代為首的實現上，替代另外的訪問
 * the other way around.<p>
 *
 * To implement a list the programmer needs only to extend this class and
 * 實現一個list程序員僅僅需要擴展這個類
 * provide implementations for the <tt>listIterator</tt> and <tt>size</tt>
 * 并提供listIterator與size方法的實現
 * methods.  For an unmodifiable list, the programmer need only implement the
 *           對於不可改變的list,程序員僅僅需要實現list的迭代器hasNext,next,hasPrevious
 * list iterator's <tt>hasNext</tt>, <tt>next</tt>, <tt>hasPrevious</tt>,
 * <tt>previous</tt> and <tt>index</tt> methods.<p>
 *     previous以及methods方法
 *
 * For a modifiable list the programmer should additionally implement the list
 * 對於一個可改變的list程序員應該添加實現list迭代器的set方法
 * iterator's <tt>set</tt> method.  For a variable-size list the programmer
 * should additionally implement the list iterator's <tt>remove</tt> and
 * 對於一個可變大小的list程序員需要添加list的迭代器的remove，add方法的實現
 * <tt>add</tt> methods.<p>
 *
 * The programmer should generally provide a void (no argument) and collection
 * 程序員一般需要提供一個無慘的構造器,
 * constructor, as per the recommendation in the <tt>Collection</tt> interface
 *              作為每個集合接口詳細描述的建議
 * specification.<p>
 *
 * This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see Collection
 * @see List
 * @see AbstractList
 * @see AbstractCollection
 * @since 1.2
 */

public abstract class AbstractSequentialList<E> extends AbstractList<E> {
	/**
	 * Sole constructor.  (For invocation by subclass constructors, typically
	 * 唯一的構造器
	 * implicit.)
	 */
	protected AbstractSequentialList() {
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * <p>This implementation first gets a list iterator pointing to the
	 * 這個實現首先獲取list迭代器指定的索引元素(使用listIterator(index))
	 * indexed element (with <tt>listIterator(index)</tt>).  Then, it gets
	 * the element using <tt>ListIterator.next</tt> and returns it.
	 * 而後，使用next獲取元素，并返回元素
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E get(int index) {
		try {
			return listIterator(index).next();
		} catch (NoSuchElementException exc) {
			throw new IndexOutOfBoundsException("Index: "+index);
		}
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 *
	 * <p>This implementation first gets a list iterator pointing to the
	 * indexed element (with <tt>listIterator(index)</tt>).  Then, it gets
	 * the current element using <tt>ListIterator.next</tt> and replaces it
	 * with <tt>ListIterator.set</tt>.
	 *
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the list iterator does not
	 * implement the <tt>set</tt> operation.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public E set(int index, E element) {
		try {
			ListIterator<E> e = listIterator(index);
			E oldVal = e.next();
			e.set(element);
			return oldVal;
		} catch (NoSuchElementException exc) {
			throw new IndexOutOfBoundsException("Index: "+index);
		}
	}

	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation).  Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (adds one to their
	 * indices).
	 *
	 * <p>This implementation first gets a list iterator pointing to the
	 * indexed element (with <tt>listIterator(index)</tt>).  Then, it
	 * inserts the specified element with <tt>ListIterator.add</tt>.
	 *
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the list iterator does not
	 * implement the <tt>add</tt> operation.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public void add(int index, E element) {
		try {
			listIterator(index).add(element);
		} catch (NoSuchElementException exc) {
			throw new IndexOutOfBoundsException("Index: "+index);
		}
	}

	/**
	 * Removes the element at the specified position in this list (optional
	 * operation).  Shifts any subsequent elements to the left (subtracts one
	 * from their indices).  Returns the element that was removed from the
	 * list.
	 *
	 * <p>This implementation first gets a list iterator pointing to the
	 * indexed element (with <tt>listIterator(index)</tt>).  Then, it removes
	 * the element with <tt>ListIterator.remove</tt>.
	 *
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the list iterator does not
	 * implement the <tt>remove</tt> operation.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public E remove(int index) {
		try {
			ListIterator<E> e = listIterator(index);
			E outCast = e.next();
			e.remove();
			return outCast;
		} catch (NoSuchElementException exc) {
			throw new IndexOutOfBoundsException("Index: "+index);
		}
	}


	// Bulk Operations

	/**
	 * Inserts all of the elements in the specified collection into this
	 * list at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).  The new elements
	 * will appear in this list in the order that they are returned by the
	 * specified collection's iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 *
	 * <p>This implementation gets an iterator over the specified collection and
	 * a list iterator over this list pointing to the indexed element (with
	 * <tt>listIterator(index)</tt>).  Then, it iterates over the specified
	 * collection, inserting the elements obtained from the iterator into this
	 * list, one at a time, using <tt>ListIterator.add</tt> followed by
	 * <tt>ListIterator.next</tt> (to skip over the added element).
	 *
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the list iterator returned by
	 * the <tt>listIterator</tt> method does not implement the <tt>add</tt>
	 * operation.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IndexOutOfBoundsException     {@inheritDoc}
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		try {
			boolean modified = false;
			ListIterator<E> e1 = listIterator(index);
			Iterator<? extends E> e2 = c.iterator();
			while (e2.hasNext()) {
				e1.add(e2.next());
				modified = true;
			}
			return modified;
		} catch (NoSuchElementException exc) {
			throw new IndexOutOfBoundsException("Index: "+index);
		}
	}


	// Iterators

	/**
	 * Returns an iterator over the elements in this list (in proper
	 * sequence).<p>
	 *
	 * This implementation merely returns a list iterator over the list.
	 *
	 * @return an iterator over the elements in this list (in proper sequence)
	 */
	public Iterator<E> iterator() {
		return listIterator();
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 *
	 * @param  index index of first element to be returned from the list
	 *         iterator (by a call to the <code>next</code> method)
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence)
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public abstract ListIterator<E> listIterator(int index);
}
