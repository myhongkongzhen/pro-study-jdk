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
 *     FileName: z.z.w.jdk.collections.BlockingDeque
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-11 14:08
 *   LastChange: 2015-12-11 14:08
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * A {@link java.util.Deque} that additionally supports blocking operations that wait
 * 另外支持阻塞操作的deque等待deque成為空empty當檢索一個元素時
 * for the deque to become non-empty when retrieving an element, and wait for
 * space to become available in the deque when storing an element.
 * 存儲元素在deque等待空間成為可用
 *
 * <p><tt>BlockingDeque</tt> methods come in four forms, with different ways
 * 阻塞隊列方法有四個方式,
 * of handling operations that cannot be satisfied immediately, but may be
 * 不同的操作不能立即滿意
 * satisfied at some point in the future:
 * 但可以在未來某一點滿意
 * one throws an exception, the second returns a special value (either
 * 一個是拋出一個異常,         第二是返回一個特定的值
 * <tt>null</tt> or <tt>false</tt>, depending on the operation), the third
 * (依賴於操作可能是null也可能是false)
 * blocks the current thread indefinitely until the operation can succeed,
 * 第三個是一直阻塞當前線程直到操作成功
 * and the fourth blocks for only a given maximum time limit before giving
 * 以及第四點阻塞增長前僅僅給定一個最大的時間限制
 * up.  These methods are summarized in the following table:
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 5> <b>First Element (Head)</b></td>
 *  </tr>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Blocks</em></td>
 *    <td ALIGN=CENTER><em>Times out</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #addFirst addFirst(e)}</td>
 *    <td>{@link #offerFirst(Object) offerFirst(e)}</td>
 *    <td>{@link #putFirst putFirst(e)}</td>
 *    <td>{@link #offerFirst(Object, long, java.util.concurrent.TimeUnit) offerFirst(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *    <td>{@link #pollFirst pollFirst()}</td>
 *    <td>{@link #takeFirst takeFirst()}</td>
 *    <td>{@link #pollFirst(long, java.util.concurrent.TimeUnit) pollFirst(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #getFirst getFirst()}</td>
 *    <td>{@link #peekFirst peekFirst()}</td>
 *    <td><em>not applicable</em></td>
 *    <td><em>not applicable</em></td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 5> <b>Last Element (Tail)</b></td>
 *  </tr>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Blocks</em></td>
 *    <td ALIGN=CENTER><em>Times out</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #addLast addLast(e)}</td>
 *    <td>{@link #offerLast(Object) offerLast(e)}</td>
 *    <td>{@link #putLast putLast(e)}</td>
 *    <td>{@link #offerLast(Object, long, java.util.concurrent.TimeUnit) offerLast(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #removeLast() removeLast()}</td>
 *    <td>{@link #pollLast() pollLast()}</td>
 *    <td>{@link #takeLast takeLast()}</td>
 *    <td>{@link #pollLast(long, java.util.concurrent.TimeUnit) pollLast(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #getLast getLast()}</td>
 *    <td>{@link #peekLast peekLast()}</td>
 *    <td><em>not applicable</em></td>
 *    <td><em>not applicable</em></td>
 *  </tr>
 * </table>
 *
 * <p>Like any {@link java.util.concurrent.BlockingQueue}, a <tt>BlockingDeque</tt> is thread safe,
 * 與BlockingQueue一樣，BlockingDeque是一個線程安全的
 * does not permit null elements, and may (or may not) be
 * 不允許null元素
 * capacity-constrained.
 * 可以有限或無線的容量
 *
 * <p>A <tt>BlockingDeque</tt> implementation may be used directly as a FIFO
 * 一個BlockingDeque實現直接用於一個fifo的blockingqueue隊列
 * <tt>BlockingQueue</tt>. The methods inherited from the
 *                         blockingqueue接口遺傳而來的方法
 * <tt>BlockingQueue</tt> interface are precisely equivalent to
 * <tt>BlockingDeque</tt> methods as indicated in the following table:
 * 與blockingdeque恰好相同
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td ALIGN=CENTER> <b><tt>BlockingQueue</tt> Method</b></td>
 *    <td ALIGN=CENTER> <b>Equivalent <tt>BlockingDeque</tt> Method</b></td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Insert</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #add(Object) add(e)}</td>
 *    <td>{@link #addLast(Object) addLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #offer(Object) offer(e)}</td>
 *    <td>{@link #offerLast(Object) offerLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #put(Object) put(e)}</td>
 *    <td>{@link #putLast(Object) putLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #offer(Object, long, java.util.concurrent.TimeUnit) offer(e, time, unit)}</td>
 *    <td>{@link #offerLast(Object, long, java.util.concurrent.TimeUnit) offerLast(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Remove</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #remove() remove()}</td>
 *    <td>{@link #removeFirst() removeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #poll() poll()}</td>
 *    <td>{@link #pollFirst() pollFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #take() take()}</td>
 *    <td>{@link #takeFirst() takeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #poll(long, java.util.concurrent.TimeUnit) poll(time, unit)}</td>
 *    <td>{@link #pollFirst(long, java.util.concurrent.TimeUnit) pollFirst(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Examine</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #element() element()}</td>
 *    <td>{@link #getFirst() getFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #peek() peek()}</td>
 *    <td>{@link #peekFirst() peekFirst()}</td>
 *  </tr>
 * </table>
 *
 * <p>Memory consistency effects: As with other concurrent
 * 內存一致:
 * collections, actions in a thread prior to placing an object into a
 * 作為使用另外的並發集合, 在一個線程中預先操作數據到blockingdeque對了中
 * {@code BlockingDeque}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code BlockingDeque} in another thread.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.6
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public interface BlockingDeque<E> extends java.util.concurrent.BlockingQueue<E>, java.util.Deque<E>
{
    /*
     * We have "diamond" multiple interface inheritance here, and that
     * 我們有更好的多個接口繼承這里
     * introduces ambiguities.  Methods might end up with different
     * 并介紹各種歧義.
     * specs depending on the branch chosen by javadoc.  Thus a lot of
     * 方法依賴於選擇的分支結束不同的規格
     * methods specs here are copied from superinterfaces.
     * 因而許多方法規格可有子接口拷貝
     */

	/**
	 * Inserts the specified element at the front of this deque if it is
	 * possible to do so immediately without violating capacity restrictions,
	 * throwing an <tt>IllegalStateException</tt> if no space is currently
	 * 沒有可用空間會拋出一個異常
	 * available.  When using a capacity-restricted deque, it is generally
	 * preferable to use {@link #offerFirst(Object) offerFirst}.
	 *
	 * @param e the element to add
	 * @throws IllegalStateException {@inheritDoc}
	 * @throws ClassCastException {@inheritDoc}
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException {@inheritDoc}
	 */
	void addFirst(E e);

	/**
	 * Inserts the specified element at the end of this deque if it is
	 * possible to do so immediately without violating capacity restrictions,
	 * throwing an <tt>IllegalStateException</tt> if no space is currently
	 * available.  When using a capacity-restricted deque, it is generally
	 * preferable to use {@link #offerLast(Object) offerLast}.
	 *
	 * @param e the element to add
	 * @throws IllegalStateException {@inheritDoc}
	 * @throws ClassCastException {@inheritDoc}
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException {@inheritDoc}
	 */
	void addLast(E e);

	/**
	 * Inserts the specified element at the front of this deque if it is
	 * possible to do so immediately without violating capacity restrictions,
	 * returning <tt>true</tt> upon success and <tt>false</tt> if no space is
	 * currently available.
	 * When using a capacity-restricted deque, this method is generally
	 * preferable to the {@link #addFirst(Object) addFirst} method, which can
	 * fail to insert an element only by throwing an exception.
	 *
	 * @param e the element to add
	 * @throws ClassCastException {@inheritDoc}
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException {@inheritDoc}
	 */
	boolean offerFirst(E e);

	/**
	 * Inserts the specified element at the end of this deque if it is
	 * possible to do so immediately without violating capacity restrictions,
	 * returning <tt>true</tt> upon success and <tt>false</tt> if no space is
	 * currently available.
	 * When using a capacity-restricted deque, this method is generally
	 * preferable to the {@link #addLast(Object) addLast} method, which can
	 * fail to insert an element only by throwing an exception.
	 *
	 * @param e the element to add
	 * @throws ClassCastException {@inheritDoc}
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException {@inheritDoc}
	 */
	boolean offerLast(E e);

	/**
	 * Inserts the specified element at the front of this deque,
	 * waiting if necessary for space to become available.
	 * 必須等待空間成為可用
	 *
	 * @param e the element to add
	 * @throws InterruptedException if interrupted while waiting
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	void putFirst(E e) throws InterruptedException;

	/**
	 * Inserts the specified element at the end of this deque,
	 * waiting if necessary for space to become available.
	 *
	 * @param e the element to add
	 * @throws InterruptedException if interrupted while waiting
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	void putLast(E e) throws InterruptedException;

	/**
	 * Inserts the specified element at the front of this deque,
	 * waiting up to the specified wait time if necessary for space to
	 * become available.
	 *
	 * @param e the element to add
	 * @param timeout how long to wait before giving up, in units of
	 *                放棄前等待的時間
	 *        <tt>unit</tt>
	 *        單位時間
	 * @param unit a <tt>TimeUnit</tt> determining how to interpret the
	 *        <tt>timeout</tt> parameter
	 * @return <tt>true</tt> if successful, or <tt>false</tt> if
	 *         the specified waiting time elapses before space is available
	 * @throws InterruptedException if interrupted while waiting
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offerFirst(E e, long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Inserts the specified element at the end of this deque,
	 * waiting up to the specified wait time if necessary for space to
	 * become available.
	 *
	 * @param e the element to add
	 * @param timeout how long to wait before giving up, in units of
	 *        <tt>unit</tt>
	 * @param unit a <tt>TimeUnit</tt> determining how to interpret the
	 *        <tt>timeout</tt> parameter
	 * @return <tt>true</tt> if successful, or <tt>false</tt> if
	 *         the specified waiting time elapses before space is available
	 * @throws InterruptedException if interrupted while waiting
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offerLast(E e, long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Retrieves and removes the first element of this deque, waiting
	 * if necessary until an element becomes available.
	 *
	 * @return the head of this deque
	 * @throws InterruptedException if interrupted while waiting
	 */
	E takeFirst() throws InterruptedException;

	/**
	 * Retrieves and removes the last element of this deque, waiting
	 * if necessary until an element becomes available.
	 *
	 * @return the tail of this deque
	 * @throws InterruptedException if interrupted while waiting
	 */
	E takeLast() throws InterruptedException;

	/**
	 * Retrieves and removes the first element of this deque, waiting
	 * up to the specified wait time if necessary for an element to
	 * become available.
	 *
	 * @param timeout how long to wait before giving up, in units of
	 *        <tt>unit</tt>
	 * @param unit a <tt>TimeUnit</tt> determining how to interpret the
	 *        <tt>timeout</tt> parameter
	 * @return the head of this deque, or <tt>null</tt> if the specified
	 *         waiting time elapses before an element is available
	 * @throws InterruptedException if interrupted while waiting
	 */
	E pollFirst(long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Retrieves and removes the last element of this deque, waiting
	 * up to the specified wait time if necessary for an element to
	 * become available.
	 *
	 * @param timeout how long to wait before giving up, in units of
	 *        <tt>unit</tt>
	 * @param unit a <tt>TimeUnit</tt> determining how to interpret the
	 *        <tt>timeout</tt> parameter
	 * @return the tail of this deque, or <tt>null</tt> if the specified
	 *         waiting time elapses before an element is available
	 * @throws InterruptedException if interrupted while waiting
	 */
	E pollLast(long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Removes the first occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * More formally, removes the first element <tt>e</tt> such that
	 * <tt>o.equals(e)</tt> (if such an element exists).
	 * Returns <tt>true</tt> if this deque contained the specified element
	 * (or equivalently, if this deque changed as a result of the call).
	 *
	 * @param o element to be removed from this deque, if present
	 * @return <tt>true</tt> if an element was removed as a result of this call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 */
	boolean removeFirstOccurrence(Object o);

	/**
	 * Removes the last occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * More formally, removes the last element <tt>e</tt> such that
	 * <tt>o.equals(e)</tt> (if such an element exists).
	 * Returns <tt>true</tt> if this deque contained the specified element
	 * (or equivalently, if this deque changed as a result of the call).
	 *
	 * @param o element to be removed from this deque, if present
	 * @return <tt>true</tt> if an element was removed as a result of this call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 */
	boolean removeLastOccurrence(Object o);

	// *** BlockingQueue methods ***

	/**
	 * Inserts the specified element into the queue represented by this deque
	 *                                              意味著
	 * (in other words, at the tail of this deque) if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and throwing an
	 * <tt>IllegalStateException</tt> if no space is currently available.
	 * When using a capacity-restricted deque, it is generally preferable to
	 * use {@link #offer(Object) offer}.
	 *
	 * <p>This method is equivalent to {@link #addLast(Object) addLast}.
	 *
	 * @param e the element to add
	 * @throws IllegalStateException {@inheritDoc}
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean add(E e);

	/**
	 * Inserts the specified element into the queue represented by this deque
	 * (in other words, at the tail of this deque) if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and <tt>false</tt> if no space is currently
	 * available.  When using a capacity-restricted deque, this method is
	 * generally preferable to the {@link #add} method, which can fail to
	 * insert an element only by throwing an exception.
	 *
	 * <p>This method is equivalent to {@link #offerLast(Object) offerLast}.
	 *
	 * @param e the element to add
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offer(E e);

	/**
	 * Inserts the specified element into the queue represented by this deque
	 * (in other words, at the tail of this deque), waiting if necessary for
	 * space to become available.
	 *
	 * <p>This method is equivalent to {@link #putLast(Object) putLast}.
	 *
	 * @param e the element to add
	 * @throws InterruptedException {@inheritDoc}
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	void put(E e) throws InterruptedException;

	/**
	 * Inserts the specified element into the queue represented by this deque
	 * (in other words, at the tail of this deque), waiting up to the
	 * specified wait time if necessary for space to become available.
	 *
	 * <p>This method is equivalent to
	 * {@link #offerLast(Object,long,TimeUnit) offerLast}.
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> if the element was added to this deque, else
	 *         <tt>false</tt>
	 * @throws InterruptedException {@inheritDoc}
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offer(E e, long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Retrieves and removes the head of the queue represented by this deque
	 * (in other words, the first element of this deque).
	 * This method differs from {@link #poll poll} only in that it
	 * throws an exception if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #removeFirst() removeFirst}.
	 *
	 * @return the head of the queue represented by this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E remove();

	/**
	 * Retrieves and removes the head of the queue represented by this deque
	 * (in other words, the first element of this deque), or returns
	 * <tt>null</tt> if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #pollFirst()}.
	 *
	 * @return the head of this deque, or <tt>null</tt> if this deque is empty
	 */
	E poll();

	/**
	 * Retrieves and removes the head of the queue represented by this deque
	 * (in other words, the first element of this deque), waiting if
	 * necessary until an element becomes available.
	 *
	 * <p>This method is equivalent to {@link #takeFirst() takeFirst}.
	 *
	 * @return the head of this deque
	 * @throws InterruptedException if interrupted while waiting
	 */
	E take() throws InterruptedException;

	/**
	 * Retrieves and removes the head of the queue represented by this deque
	 * (in other words, the first element of this deque), waiting up to the
	 * specified wait time if necessary for an element to become available.
	 *
	 * <p>This method is equivalent to
	 * {@link #pollFirst(long,TimeUnit) pollFirst}.
	 *
	 * @return the head of this deque, or <tt>null</tt> if the
	 *         specified waiting time elapses before an element is available
	 * @throws InterruptedException if interrupted while waiting
	 */
	E poll(long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Retrieves, but does not remove, the head of the queue represented by
	 * this deque (in other words, the first element of this deque).
	 * This method differs from {@link #peek peek} only in that it throws an
	 * exception if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #getFirst() getFirst}.
	 *
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E element();

	/**
	 * Retrieves, but does not remove, the head of the queue represented by
	 * this deque (in other words, the first element of this deque), or
	 * returns <tt>null</tt> if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #peekFirst() peekFirst}.
	 *
	 * @return the head of this deque, or <tt>null</tt> if this deque is empty
	 */
	E peek();

	/**
	 * Removes the first occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * More formally, removes the first element <tt>e</tt> such that
	 * <tt>o.equals(e)</tt> (if such an element exists).
	 * Returns <tt>true</tt> if this deque contained the specified element
	 * (or equivalently, if this deque changed as a result of the call).
	 *
	 * <p>This method is equivalent to
	 * {@link #removeFirstOccurrence(Object) removeFirstOccurrence}.
	 *
	 * @param o element to be removed from this deque, if present
	 * @return <tt>true</tt> if this deque changed as a result of the call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 */
	boolean remove(Object o);

	/**
	 * Returns <tt>true</tt> if this deque contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this deque contains
	 * at least one element <tt>e</tt> such that <tt>o.equals(e)</tt>.
	 *
	 * @param o object to be checked for containment in this deque
	 * @return <tt>true</tt> if this deque contains the specified element
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 */
	public boolean contains(Object o);

	/**
	 * Returns the number of elements in this deque.
	 *
	 * @return the number of elements in this deque
	 */
	public int size();

	/**
	 * Returns an iterator over the elements in this deque in proper sequence.
	 * The elements will be returned in order from first (head) to last (tail).
	 *
	 * @return an iterator over the elements in this deque in proper sequence
	 */
	Iterator<E> iterator();

	// *** Stack methods ***

	/**
	 * Pushes an element onto the stack represented by this deque.  In other
	 *   壓棧                             意味著
	 * words, inserts the element at the front of this deque unless it would
	 *                                                       除非
	 * violate capacity restrictions.
	 *
	 * <p>This method is equivalent to {@link #addFirst(Object) addFirst}.
	 *
	 * @throws IllegalStateException {@inheritDoc}
	 * @throws ClassCastException {@inheritDoc}
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException {@inheritDoc}
	 */
	void push(E e);
}
