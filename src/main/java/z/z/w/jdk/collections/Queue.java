package z.z.w.jdk.collections;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.jdk.collections.Queue
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-10 11:52
 *   LastChange: 2015-12-10 11:52
 *      History:
 * </pre>
 *********************************************************************************************/

/**
 * A collection designed for holding elements prior to processing.
 * 一個集合設計成為維護元素進行的先驅順序
 * Besides basic {@link java.util.Collection Collection} operations,
 * 包含基本的集合操作
 * queues provide additional insertion, extraction, and inspection
 * 隊列提供增加的插入，提取，檢查操作
 * operations.  Each of these methods exists in two forms: one throws
 *              每個方法都存在兩個形式:
 * an exception if the operation fails, the other returns a special
 * 如果操作失敗，拋出一個異常,
 * value (either <tt>null</tt> or <tt>false</tt>, depending on the
 *  另外的返回一個特定的值null或者fasle
 * operation).  The latter form of the insert operation is designed
 * 依賴於操作.    插入操作最新的形式是特別設計成為容量限定的queue的實現
 * specifically for use with capacity-restricted <tt>Queue</tt>
 * implementations; in most implementations, insert operations cannot
 *                  大多數實現，插入操作不能失敗
 * fail.
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Returns special value</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #add add(e)}</td>
 *    <td>{@link #offer offer(e)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #remove remove()}</td>
 *    <td>{@link #poll poll()}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #element element()}</td>
 *    <td>{@link #peek peek()}</td>
 *  </tr>
 * </table>
 *
 * <p>Queues typically, but do not necessarily, order elements in a
 * 一般的隊列，但不是必要的，元素按照fifo方式排列
 * FIFO (first-in-first-out) manner.  Among the exceptions are
 * priority queues, which order elements according to a supplied
 * 在異常中優先的隊列,按照提供的比較器排列元素順序
 * comparator, or the elements' natural ordering, and LIFO queues (or
 *             或者按照元素自然順序排列
 * stacks) which order the elements LIFO (last-in-first-out).
 * lifo的隊列(或者棧)按照lifo順序排列元素
 * Whatever the ordering used, the <em>head</em> of the queue is that
 * 無論使用哪種順序,             隊列的頭是調用remove或者poll方法移除的元素
 * element which would be removed by a call to {@link #remove() } or
 * {@link #poll()}.  In a FIFO queue, all new elements are inserted at
 *                   在一個fifo隊列中,所有新元素添加在隊列的末尾
 * the <em> tail</em> of the queue. Other kinds of queues may use
 * different placement rules.  Every <tt>Queue</tt> implementation
 * 另一些類型的queue有不同的放置規則
 * must specify its ordering properties.
 * 每一個queue實現都必須指定他的排序屬性
 *
 * <p>The {@link #offer offer} method inserts an element if possible,
 * 如果可以offer方法插入一個元素
 * otherwise returning <tt>false</tt>.  This differs from the {@link
 * java.util.Collection#add Collection.add} method, which can fail to
 * 否則返回false                         與Collection.add方法不同，
 * add an element only by throwing an unchecked exception.  The
 * 失敗的添加一個元素僅僅拋出一個未檢查異常
 * <tt>offer</tt> method is designed for use when failure is a normal,
 * offer方法設計成當通常的錯誤,而不是發生異常
 * rather than exceptional occurrence, for example, in fixed-capacity
 *                                     例如，在合適的容量的隊列
 * (or &quot;bounded&quot;) queues.
 *
 * <p>The {@link #remove()} and {@link #poll()} methods remove and
 * remove與poll方法移除和返回隊列的頭
 * return the head of the queue.
 * Exactly which element is removed from the queue is a
 * 從隊列移除的元素恰好是一個隊列排序政策的不同實現的方法
 * function of the queue's ordering policy, which differs from
 * implementation to implementation. The <tt>remove()</tt> and
 * <tt>poll()</tt> methods differ only in their behavior when the
 * remove,poll方法當隊列為空時行為不同
 * queue is empty: the <tt>remove()</tt> method throws an exception,
 *                 remove拋出一個異常
 * while the <tt>poll()</tt> method returns <tt>null</tt>.
 * poll返回null
 *
 * <p>The {@link #element()} and {@link #peek()} methods return, but do
 * element與peek方法返回隊列的頭，但不移除
 * not remove, the head of the queue.
 *
 * <p>The <tt>Queue</tt> interface does not define the <i>blocking queue
 * 隊列的接口未定義阻塞隊列方法
 * methods</i>, which are common in concurrent programming.  These methods,
 *              這些方法是通用的在並發程序中
 * which wait for elements to appear or for space to become available, are
 * 等待元素出現成為可用的空間
 * defined in the {@link java.util.concurrent.BlockingQueue} interface, which
 * 這些方法在BlockingQueue接口中定義，擴展這個接口,
 * extends this interface.
 *
 * <p><tt>Queue</tt> implementations generally do not allow insertion
 * queue實現一般運行插入null元素，
 * of <tt>null</tt> elements, although some implementations, such as
 *                            儘管一些實現
 * {@link java.util.LinkedList}, do not prohibit insertion of <tt>null</tt>.
 * 例如LinkedList,                不阻止插入null
 * Even in the implementations that permit it, <tt>null</tt> should
 * 每一個實現都允許，null不應插入queue
 * not be inserted into a <tt>Queue</tt>, as <tt>null</tt> is also
 * used as a special return value by the <tt>poll</tt> method to
 *  因為null也應用於一個特殊的有poll方法表示的隊列包含的元素的返回值
 * indicate that the queue contains no elements.
 *
 * <p><tt>Queue</tt> implementations generally do not define
 * queue實現一般不定義equals與hashCode方法的基本版本
 * element-based versions of methods <tt>equals</tt> and
 * <tt>hashCode</tt> but instead inherit the identity based versions
 * 但會用Object基本的版本替代表示
 * from class <tt>Object</tt>, because element-based equality is not
 * always well-defined for queues with the same elements but different
 * 因為基本元素同樣的不允許定義好的，相同元素但不同排序屬性的隊列
 * ordering properties.
 *
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @see java.util.Collection
 * @see java.util.LinkedList
 * @see java.util.PriorityQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.BlockingQueue
 * @see java.util.concurrent.ArrayBlockingQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.PriorityBlockingQueue
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public interface Queue<E> extends Collection<E>
{
	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * 當沒有違反容量限制立刻插入指定元素到隊列中
	 * immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and throwing an <tt>IllegalStateException</tt>
	 * 返回true表示成功，如果當前沒有可用的空間，拋出一個異常
	 * if no space is currently available.
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
	boolean add(E e);

	/**
	 * Inserts the specified element into this queue if it is possible to do
	 * so immediately without violating capacity restrictions.
	 * When using a capacity-restricted queue, this method is generally
	 * 當使用容量受限的隊列，
	 * preferable to {@link #add}, which can fail to insert an element only
	 * 這個方法是通常最好比使用add,   他可以錯誤的添加一個元素僅僅由拋出的異常
	 * by throwing an exception.
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> if the element was added to this queue, else
	 *         <tt>false</tt>
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this queue
	 * @throws NullPointerException if the specified element is null and
	 *         this queue does not permit null elements
	 * @throws IllegalArgumentException if some property of this element
	 *         prevents it from being added to this queue
	 */
	boolean offer(E e);

	/**
	 * Retrieves and removes the head of this queue.  This method differs
	 * 檢索
	 * from {@link #poll poll} only in that it throws an exception if this
	 * 這個方法與poll不同的地方僅僅在隊列為空時拋出一個異常
	 * queue is empty.
	 *
	 * @return the head of this queue
	 * @throws java.util.NoSuchElementException if this queue is empty
	 */
	E remove();

	/**
	 * Retrieves and removes the head of this queue,
	 * or returns <tt>null</tt> if this queue is empty.
	 * 如果隊列為null返回null
	 *
	 * @return the head of this queue, or <tt>null</tt> if this queue is empty
	 */
	E poll();

	/**
	 * Retrieves, but does not remove, the head of this queue.  This method
	 * 檢索,      但不刪除,
	 * differs from {@link #peek peek} only in that it throws an exception
	 * 這個方法與peek的不同之處僅在 如果隊列為null拋出一個異常
	 * if this queue is empty.
	 *
	 * @return the head of this queue
	 * @throws java.util.NoSuchElementException if this queue is empty
	 */
	E element();

	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * or returns <tt>null</tt> if this queue is empty.
	 * 如果隊列為null返回null
	 *
	 * @return the head of this queue, or <tt>null</tt> if this queue is empty
	 */
	E peek();
}
