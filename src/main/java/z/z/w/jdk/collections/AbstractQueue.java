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
 *     FileName: z.z.w.jdk.collections.AbstractQueue
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-11 15:55
 *   LastChange: 2015-12-11 15:55
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;

/**
 * This class provides skeletal implementations of some {@link java.util.Queue}
 * 這個類提供某些queue操作的骨架實現
 * operations. The implementations in this class are appropriate when
 *             在類中的實現適合當基本的實現不允許null元素
 * the base implementation does <em>not</em> allow <tt>null</tt>
 * elements.  Methods {@link #add add}, {@link #remove remove}, and
 * {@link #element element} are based on {@link #offer offer}, {@link
 * #poll poll}, and {@link #peek peek}, respectively, but throw
 * 方法add，remove，element分別基於offer，poll以及peek
 * exceptions instead of indicating failure via <tt>false</tt> or
 * 但是會拋出異常替代通過false或者null返回表明失敗
 * <tt>null</tt> returns.
 *
 * <p>A <tt>Queue</tt> implementation that extends this class must
 * queue實現擴展與這類
 * minimally define a method {@link java.util.Queue#offer} which does not permit
 * 必須最小化的定義一個offer方法
 * insertion of <tt>null</tt> elements, along with methods {@link
 * java.util.Queue#peek}, {@link java.util.Queue#poll}, {@link java.util.Collection#size}, and
 * {@link java.util.Collection#iterator}.  Typically, additional methods will be
 * 方法不允許插入null，還有 用於peek,poll,size,iterator.
 * overridden as well.  If these requirements cannot be met, consider
 * 通常情況下，另外的方法會最好重寫
 * instead subclassing {@link java.util.AbstractCollection}.
 * 如果這些是非必須的，考慮替代子類AbstractCollection.
 *
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public abstract class AbstractQueue<E>
		extends AbstractCollection<E>
		implements Queue<E>
{

	/**
	 * Constructor for use by subclasses.
	 */
	protected AbstractQueue() {
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and throwing an <tt>IllegalStateException</tt>
	 * if no space is currently available.
	 *
	 * <p>This implementation returns <tt>true</tt> if <tt>offer</tt> succeeds,
	 * 如果offer操作成功，這個實現返回true，否則拋出一個異常
	 * else throws an <tt>IllegalStateException</tt>.
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> (as specified by {@link java.util.Collection#add})
	 * @throws IllegalStateException if the element cannot be added at this
	 *         time due to capacity restrictions
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this queue
	 * @throws NullPointerException if the specified element is null and
	 *         this queue does not permit null elements
	 * @throws IllegalArgumentException if some property of this element
	 *         prevents it from being added to this queue
	 */
	public boolean add(E e) {
		if (offer(e))
			return true;
		else
			throw new IllegalStateException("Queue full");
	}

	/**
	 * Retrieves and removes the head of this queue.  This method differs
	 * from {@link #poll poll} only in that it throws an exception if this
	 * queue is empty.
	 *
	 * <p>This implementation returns the result of <tt>poll</tt>
	 * unless the queue is empty.
	 *
	 * @return the head of this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public E remove() {
		E x = poll();
		if (x != null)
			return x;
		else
			throw new NoSuchElementException();
	}

	/**
	 * Retrieves, but does not remove, the head of this queue.  This method
	 * differs from {@link #peek peek} only in that it throws an exception if
	 * this queue is empty.
	 *
	 * <p>This implementation returns the result of <tt>peek</tt>
	 * unless the queue is empty.
	 *
	 * @return the head of this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public E element() {
		E x = peek();
		if (x != null)
			return x;
		else
			throw new NoSuchElementException();
	}

	/**
	 * Removes all of the elements from this queue.
	 * The queue will be empty after this call returns.
	 *
	 * <p>This implementation repeatedly invokes {@link #poll poll} until it
	 * returns <tt>null</tt>.
	 */
	public void clear() {
		while (poll() != null)
			;
	}

	/**
	 * Adds all of the elements in the specified collection to this
	 * queue.  Attempts to addAll of a queue to itself result in
	 *         視圖在一個隊列中添加自身會拋出一個異常
	 * <tt>IllegalArgumentException</tt>. Further, the behavior of
	 * this operation is undefined if the specified collection is
	 * modified while the operation is in progress.
	 *
	 * <p>This implementation iterates over the specified collection,
	 * and adds each element returned by the iterator to this
	 * queue, in turn.  A runtime exception encountered while
	 *                  一個運行時異常發生當嘗試添加一個元素
	 * trying to add an element (including, in particular, a
	 *                                         特定的
	 * <tt>null</tt> element) may result in only some of the elements
	 * 元素導致僅僅相同的元素成功添加當關聯的異常拋出的時候
	 * having been successfully added when the associated exception is
	 * thrown.
	 *
	 * @param c collection containing elements to be added to this queue
	 * @return <tt>true</tt> if this queue changed as a result of the call
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this queue
	 * @throws NullPointerException if the specified collection contains a
	 *         null element and this queue does not permit null elements,
	 *         or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this
	 *         queue, or if the specified collection is this queue
	 * @throws IllegalStateException if not all the elements can be added at
	 *         this time due to insertion restrictions
	 * @see #add(Object)
	 */
	public boolean addAll(Collection<? extends E> c) {
		if (c == null)
			throw new NullPointerException();
		if (c == this)
			throw new IllegalArgumentException();
		boolean modified = false;
		for (E e : c)
			if (add(e))
				modified = true;
		return modified;
	}

}
