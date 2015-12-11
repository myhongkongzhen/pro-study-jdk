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
 *     FileName: z.z.w.jdk.collections.Deque
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-10 17:12
 *   LastChange: 2015-12-10 17:12
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.*;
import java.util.Iterator;

/**
 * A linear collection that supports element insertion and removal at
 * 支持元素在兩端插入移除的線性的集合
 * both ends.  The name <i>deque</i> is short for "double ended queue"
 * and is usually pronounced "deck".  Most <tt>Deque</tt>
 * implementations place no fixed limits on the number of elements
 * 大多數的Deque實現不適合有限的能夠存儲的元素的數量
 * they may contain, but this interface supports capacity-restricted
 *                   但這個實習支持容量受限的deques
 * deques as well as those with no fixed size limit.
 * 比起那些不受限制的隊列
 *
 * <p>This interface defines methods to access the elements at both
 * 這個接口定義的方法在隊列兩端訪問元素
 * ends of the deque.  Methods are provided to insert, remove, and
 *                     方法提供各類insert,remove,以及檢查元素
 * examine the element.  Each of these methods exists in two forms:
 *                       每個方法都存在兩個方式：
 * one throws an exception if the operation fails, the other returns a
 * 一個如果操作失敗拋出異常
 * special value (either <tt>null</tt> or <tt>false</tt>, depending on
 * 另一個返回一個特定的值(或者null或者false)依賴於操作
 * the operation).  The latter form of the insert operation is
 *                  後面的插入操作的方式設計成為特別使用容量有限的實現
 * designed specifically for use with capacity-restricted
 * <tt>Deque</tt> implementations; in most implementations, insert
 * operations cannot fail.
 * 在大多數實現中，插入操作不能失敗
 *
 * <p>The twelve methods described above are summarized in the
 * 12個方法描述在表格中總結：
 * following table:
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>First Element (Head)</b></td>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Last Element (Tail)</b></td>
 *  </tr>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #addFirst addFirst(e)}</td>
 *    <td>{@link #offerFirst offerFirst(e)}</td>
 *    <td>{@link #addLast addLast(e)}</td>
 *    <td>{@link #offerLast offerLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *    <td>{@link #pollFirst pollFirst()}</td>
 *    <td>{@link #removeLast removeLast()}</td>
 *    <td>{@link #pollLast pollLast()}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #getFirst getFirst()}</td>
 *    <td>{@link #peekFirst peekFirst()}</td>
 *    <td>{@link #getLast getLast()}</td>
 *    <td>{@link #peekLast peekLast()}</td>
 *  </tr>
 * </table>
 *
 * <p>This interface extends the {@link java.util.Queue} interface.  When a deque is
 * 這個接口擴展自Queue接口，
 * used as a queue, FIFO (First-In-First-Out) behavior results.  Elements are
 * 當一個deque作為一個隊列使用個，返回fifo行為.
 * added at the end of the deque and removed from the beginning.  The methods
 * 元素添加與隊列的末尾，并從開頭移除
 * inherited from the <tt>Queue</tt> interface are precisely equivalent to
 * queue接口的內部方法恰恰與deque方法等效的說明在下列表格中
 * <tt>Deque</tt> methods as indicated in the following table:
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td ALIGN=CENTER> <b><tt>Queue</tt> Method</b></td>
 *    <td ALIGN=CENTER> <b>Equivalent <tt>Deque</tt> Method</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#add add(e)}</td>
 *    <td>{@link #addLast addLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#offer offer(e)}</td>
 *    <td>{@link #offerLast offerLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#remove remove()}</td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#poll poll()}</td>
 *    <td>{@link #pollFirst pollFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#element element()}</td>
 *    <td>{@link #getFirst getFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#peek peek()}</td>
 *    <td>{@link #peek peekFirst()}</td>
 *  </tr>
 * </table>
 *
 * <p>Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
 * Deques也可以用於LIFO棧
 * interface should be used in preference to the legacy {@link java.util.Stack} class.
 * 這個接口應該用於執行Stack遺留類
 * When a deque is used as a stack, elements are pushed and popped from the
 * 當一個deque作為一個棧使用,          元素從隊列的開始入棧和出棧
 * beginning of the deque.  Stack methods are precisely equivalent to
 *                          棧方法恰恰相同與Deque方法在下列表格中
 * <tt>Deque</tt> methods as indicated in the table below:
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td ALIGN=CENTER> <b>Stack Method</b></td>
 *    <td ALIGN=CENTER> <b>Equivalent <tt>Deque</tt> Method</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #push push(e)}</td>
 *    <td>{@link #addFirst addFirst(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #pop pop()}</td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #peek peek()}</td>
 *    <td>{@link #peekFirst peekFirst()}</td>
 *  </tr>
 * </table>
 *
 * <p>Note that the {@link #peek peek} method works equally well when
 * 注意peek方法當deque用於一個queue與stack剛好相同
 * a deque is used as a queue or a stack; in either case, elements are
 * drawn from the beginning of the deque.
 * 另外的情況，元素從隊列頭部放入
 *
 * <p>This interface provides two methods to remove interior
 * 這個接口提供兩個方法移除內部元素
 * elements, {@link #removeFirstOccurrence removeFirstOccurrence} and
 * {@link #removeLastOccurrence removeLastOccurrence}.
 *
 * <p>Unlike the {@link java.util.List} interface, this interface does not
 * 不同於List接口，
 * provide support for indexed access to elements.
 * 這個接口不提供支持索引的訪問元素
 *
 * <p>While <tt>Deque</tt> implementations are not strictly required
 * 當deque實現不必嚴格要求禁止添加null元素時
 * to prohibit the insertion of null elements, they are strongly
 * encouraged to do so.  Users of any <tt>Deque</tt> implementations
 * 他們強烈鼓勵這樣做.      一些deque實現的用戶允許null元素
 * that do allow null elements are strongly encouraged <i>not</i> to
 *                                 是強烈鼓勵添加null能力的非重要要點
 * take advantage of the ability to insert nulls.  This is so because
 * <tt>null</tt> is used as a special return value by various methods
 * 這就是因為null用於一個特定的返回值在多個方法中
 * to indicated that the deque is empty.
 * 說明deque是empty
 *
 * <p><tt>Deque</tt> implementations generally do not define
 * deque實現一般不會定義基本的元素版本針對於equeals與hashCode
 * element-based versions of the <tt>equals</tt> and <tt>hashCode</tt>
 * methods, but instead inherit the identity-based versions from class
 * 但是替代的用內部的從Object繼承而來的基本標示
 * <tt>Object</tt>.
 *
 * <p>This interface is a member of the <a
 * href="{@docRoot}/../technotes/guides/collections/index.html"> Java Collections
 * Framework</a>.
 *
 * @author Doug Lea
 * @author Josh Bloch
 * @since  1.6
 * @param <E> the type of elements held in this collection
 */

public interface Deque<E> extends java.util.Queue<E>
{
	/**
	 * Inserts the specified element at the front of this deque if it is
	 * 插入指定的元素在deque的前驅
	 * possible to do so immediately without violating capacity restrictions.
	 * 如果沒有違反容量限制會理解插入
	 * When using a capacity-restricted deque, it is generally preferable to
	 * 當使用有限容量的deque,
	 * use method {@link #offerFirst}.
	 * 一般更喜歡使用offerFirst方法
	 *
	 * @param e the element to add
	 * @throws IllegalStateException if the element cannot be added at this
	 *         time due to capacity restrictions
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	void addFirst(E e);

	/**
	 * Inserts the specified element at the end of this deque if it is
	 * 插入指定的元素在deque的末尾
	 * possible to do so immediately without violating capacity restrictions.
	 * 如果滅有違反容量限制就會立即執行
	 * When using a capacity-restricted deque, it is generally preferable to
	 * 當使用一個有限容量的deque
	 * use method {@link #offerLast}.
	 * 通常更好的操作是使用offerLast方法
	 *
	 * <p>This method is equivalent to {@link #add}.
	 *
	 * @param e the element to add
	 * @throws IllegalStateException if the element cannot be added at this
	 *         time due to capacity restrictions
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	void addLast(E e);

	/**
	 * Inserts the specified element at the front of this deque unless it would
	 * 插入一個指定的元素在deque的前驅
	 * violate capacity restrictions.  When using a capacity-restricted deque,
	 * 直到他違反了容量限制
	 * this method is generally preferable to the {@link #addFirst} method,
	 * 當使用一個有限容量deque,這個方法通常比addFirst方法更好
	 * which can fail to insert an element only by throwing an exception.
	 * 它能夠由拋出一個異常表示添加元素失敗
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> if the element was added to this deque, else
	 *         <tt>false</tt>
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 *         防止
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offerFirst(E e);

	/**
	 * Inserts the specified element at the end of this deque unless it would
	 * 添加指定的元素在deque的末尾
	 * violate capacity restrictions.  When using a capacity-restricted deque,
	 * 直到違反容量限制
	 * this method is generally preferable to the {@link #addLast} method,
	 * 當使用一個有限容量deque，這個方法通常是更優於addLast方法
	 * which can fail to insert an element only by throwing an exception.
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> if the element was added to this deque, else
	 *         <tt>false</tt>
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offerLast(E e);

	/**
	 * Retrieves and removes the first element of this deque.  This method
	 * 檢查和移除deque的首元素
	 * differs from {@link #pollFirst pollFirst} only in that it throws an
	 * 這個方法與pollFirst方法不同之處僅僅在於如果deque是一個empty他會拋出一個異常
	 * exception if this deque is empty.
	 *
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E removeFirst();

	/**
	 * Retrieves and removes the last element of this deque.  This method
	 * differs from {@link #pollLast pollLast} only in that it throws an
	 * exception if this deque is empty.
	 *
	 * @return the tail of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E removeLast();

	/**
	 * Retrieves and removes the first element of this deque,
	 * 檢查和移除隊列中的首元素
	 * or returns <tt>null</tt> if this deque is empty.
	 * 如果隊列為空，返回null
	 *
	 * @return the head of this deque, or <tt>null</tt> if this deque is empty
	 */
	E pollFirst();

	/**
	 * Retrieves and removes the last element of this deque,
	 * or returns <tt>null</tt> if this deque is empty.
	 *
	 * @return the tail of this deque, or <tt>null</tt> if this deque is empty
	 */
	E pollLast();

	/**
	 * Retrieves, but does not remove, the first element of this deque.
	 * 檢查，但不移除隊列中的首元素
	 * This method differs from {@link #peekFirst peekFirst} only in that it
	 * 與peekFirst方法不同之處僅僅為當隊列為空，拋出一個異常
	 * throws an exception if this deque is empty.
	 *
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E getFirst();

	/**
	 * Retrieves, but does not remove, the last element of this deque.
	 * This method differs from {@link #peekLast peekLast} only in that it
	 * throws an exception if this deque is empty.
	 *
	 * @return the tail of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E getLast();

	/**
	 * Retrieves, but does not remove, the first element of this deque,
	 * or returns <tt>null</tt> if this deque is empty.
	 * 如果隊列為空，返回null
	 *
	 * @return the head of this deque, or <tt>null</tt> if this deque is empty
	 */
	E peekFirst();

	/**
	 * Retrieves, but does not remove, the last element of this deque,
	 * or returns <tt>null</tt> if this deque is empty.
	 *
	 * @return the tail of this deque, or <tt>null</tt> if this deque is empty
	 */
	E peekLast();

	/**
	 * Removes the first occurrence of the specified element from this deque.
	 * 移除隊列中第一個發現的指定元素
	 * If the deque does not contain the element, it is unchanged.
	 * 如果隊列中不包含這個元素,隊列不會改變
	 * More formally, removes the first element <tt>e</tt> such that
	 * 更嚴格的講，移除第一個元素e
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>
	 * 當(o == null ? e == null : e.equals(e))
	 * (if such an element exists).
	 * 如果這樣的元素存在
	 * Returns <tt>true</tt> if this deque contained the specified element
	 * 如果隊列包含了指定元素，返回true
	 * (or equivalently, if this deque changed as a result of the call).
	 * 與之相應的，作為調用的結果對聯改變了。
	 *
	 * @param o element to be removed from this deque, if present
	 * @return <tt>true</tt> if an element was removed as a result of this call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	boolean removeFirstOccurrence(Object o);

	/**
	 * Removes the last occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * More formally, removes the last element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>
	 * (if such an element exists).
	 * Returns <tt>true</tt> if this deque contained the specified element
	 * (or equivalently, if this deque changed as a result of the call).
	 *
	 * @param o element to be removed from this deque, if present
	 * @return <tt>true</tt> if an element was removed as a result of this call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	boolean removeLastOccurrence(Object o);

	// *** Queue methods ***

	/**
	 * Inserts the specified element into the queue represented by this deque
	 * 添加指定的元素到隊列中意味著如果沒有違反容量限制，他會立即執行
	 * (in other words, at the tail of this deque) if it is possible to do so
	 * (換句話說，在隊列的末尾)
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and throwing an
	 * 成功返回true
	 * <tt>IllegalStateException</tt> if no space is currently available.
	 * 如果當前沒有可用空間會拋出一個異常
	 * When using a capacity-restricted deque, it is generally preferable to
	 * 當使用一個有限隊列，通常更好的做法是使用offer方法
	 * use {@link #offer(Object) offer}.
	 *
	 * <p>This method is equivalent to {@link #addLast}.
	 * 這個方法等效于addLast方法
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> (as specified by {@link java.util.Collection#add})
	 * @throws IllegalStateException if the element cannot be added at this
	 *         time due to capacity restrictions
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean add(E e);

	/**
	 * Inserts the specified element into the queue represented by this deque
	 * (in other words, at the tail of this deque) if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and <tt>false</tt> if no space is currently
	 *                                如果沒有可用空間，返回false
	 * available.  When using a capacity-restricted deque, this method is
	 * generally preferable to the {@link #add} method, which can fail to
	 * insert an element only by throwing an exception.
	 * 僅僅由拋出一個異常表示添加元素失敗
	 *
	 * <p>This method is equivalent to {@link #offerLast}.
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> if the element was added to this deque, else
	 *         <tt>false</tt>
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	boolean offer(E e);

	/**
	 * Retrieves and removes the head of the queue represented by this deque
	 * (in other words, the first element of this deque).
	 * This method differs from {@link #poll poll} only in that it throws an
	 * exception if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #removeFirst()}.
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
	 * @return the first element of this deque, or <tt>null</tt> if
	 *         this deque is empty
	 */
	E poll();

	/**
	 * Retrieves, but does not remove, the head of the queue represented by
	 * 檢查，但不移除
	 * this deque (in other words, the first element of this deque).
	 * This method differs from {@link #peek peek} only in that it throws an
	 * exception if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #getFirst()}.
	 *
	 * @return the head of the queue represented by this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	E element();

	/**
	 * Retrieves, but does not remove, the head of the queue represented by
	 * this deque (in other words, the first element of this deque), or
	 * returns <tt>null</tt> if this deque is empty.
	 *
	 * <p>This method is equivalent to {@link #peekFirst()}.
	 *
	 * @return the head of the queue represented by this deque, or
	 *         <tt>null</tt> if this deque is empty
	 */
	E peek();


	// *** Stack methods ***

	/**
	 * Pushes an element onto the stack represented by this deque (in other
	 * 壓入一個元到棧中意味著這個隊列如果沒有違反容量限制會立即執行
	 * words, at the head of this deque) if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and throwing an
	 * 成功返回true
	 * <tt>IllegalStateException</tt> if no space is currently available.
	 * 如果滅有可用空間拋出一個異常
	 *
	 * <p>This method is equivalent to {@link #addFirst}.
	 *
	 * @param e the element to push
	 * @throws IllegalStateException if the element cannot be added at this
	 *         time due to capacity restrictions
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this deque
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this deque
	 */
	void push(E e);

	/**
	 * Pops an element from the stack represented by this deque.  In other
	 * words, removes and returns the first element of this deque.
	 *        移除和返回隊列中的第一個元素
	 *
	 * <p>This method is equivalent to {@link #removeFirst()}.
	 *
	 * @return the element at the front of this deque (which is the top
	 *         of the stack represented by this deque)
	 * @throws NoSuchElementException if this deque is empty
	 */
	E pop();


	// *** Collection methods ***

	/**
	 * Removes the first occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * More formally, removes the first element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>
	 * (if such an element exists).
	 * Returns <tt>true</tt> if this deque contained the specified element
	 * (or equivalently, if this deque changed as a result of the call).
	 *
	 * <p>This method is equivalent to {@link #removeFirstOccurrence}.
	 *
	 * @param o element to be removed from this deque, if present
	 * @return <tt>true</tt> if an element was removed as a result of this call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this deque
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	boolean remove(Object o);

	/**
	 * Returns <tt>true</tt> if this deque contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this deque contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this deque is to be tested
	 * @return <tt>true</tt> if this deque contains the specified element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this deque
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	boolean contains(Object o);

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

	/**
	 * Returns an iterator over the elements in this deque in reverse
	 *                                                        相反
	 * sequential order.  The elements will be returned in order from
	 * 的序列順序
	 * last (tail) to first (head).
	 * 從尾到頭
	 *
	 * @return an iterator over the elements in this deque in reverse
	 * sequence
	 */
	Iterator<E> descendingIterator();

}
