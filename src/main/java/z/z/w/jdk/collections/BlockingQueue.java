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
 *     FileName: z.z.w.jdk.collections.BlockingQueue
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-10 14:52
 *   LastChange: 2015-12-10 14:52
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.concurrent.TimeUnit;

/**
 * A {@link java.util.Queue} that additionally supports operations
 * 另外支持的操作的隊列等待隊列成為一個非空隊列
 * that wait for the queue to become non-empty when retrieving an
 * 當檢索一個元素時
 * element, and wait for space to become available in the queue when
 *          並且等待存儲一個元素成為隊列中可用的
 * storing an element.
 *
 * <p><tt>BlockingQueue</tt> methods come in four forms, with different ways
 * BlockingQueue隊列方法存在四個方式
 * of handling operations that cannot be satisfied immediately, but may be
 * 能夠立即制定保存操作的不同方式
 * satisfied at some point in the future:
 * 在未來某些點上是令人滿意的
 * one throws an exception, the second returns a special value (either
 * 一個是拋出一個異常,        第二個是返回一個特定的值
 * <tt>null</tt> or <tt>false</tt>, depending on the operation), the third
 * (或者是null或者是false,依賴於操作)
 * blocks the current thread indefinitely until the operation can succeed,
 * 第三個是阻塞當前的線程知道操作成功,
 * and the fourth blocks for only a given maximum time limit before giving
 * 第四個 是由給定的最大時間限制阻塞增長
 * up.  These methods are summarized in the following table:
 * 這些方法總結在下列表格中
 *
 * <p>
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Blocks</em></td>
 *    <td ALIGN=CENTER><em>Times out</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #add add(e)}</td>
 *    <td>{@link #offer offer(e)}</td>
 *    <td>{@link #put put(e)}</td>
 *    <td>{@link #offer(Object, long, TimeUnit) offer(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #remove remove()}</td>
 *    <td>{@link #poll poll()}</td>
 *    <td>{@link #take take()}</td>
 *    <td>{@link #poll(long, TimeUnit) poll(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #element element()}</td>
 *    <td>{@link #peek peek()}</td>
 *    <td><em>not applicable</em></td>
 *    <td><em>not applicable</em></td>
 *  </tr>
 * </table>
 *
 * <p>A <tt>BlockingQueue</tt> does not accept <tt>null</tt> elements.
 * BlockingQueue不接受null元素
 * Implementations throw <tt>NullPointerException</tt> on attempts
 * 嘗試add，put或者offer添加一個null會拋出一個空指針異常
 * to <tt>add</tt>, <tt>put</tt> or <tt>offer</tt> a <tt>null</tt>.  A
 * <tt>null</tt> is used as a sentinel value to indicate failure of
 * null值用來表示poll操作失敗的哨兵值
 * <tt>poll</tt> operations.
 *
 * <p>A <tt>BlockingQueue</tt> may be capacity bounded. At any given
 * BlockingQueue是容量有界的
 * time it may have a <tt>remainingCapacity</tt> beyond which no
 * 在任何給定的時間有一個剩餘容量用put添加元素不會阻塞
 * additional elements can be <tt>put</tt> without blocking.
 * A <tt>BlockingQueue</tt> without any intrinsic capacity constraints always
 * 一個沒有固有容量的BlockingQueue 包含的max_value值的剩餘容量
 * reports a remaining capacity of <tt>Integer.MAX_VALUE</tt>.
 *
 * <p> <tt>BlockingQueue</tt> implementations are designed to be used
 * BlockingQueue實現設計成為主要用於生產消費者隊列
 * primarily for producer-consumer queues, but additionally support
 * 當另外支持結婚接口
 * the {@link java.util.Collection} interface.  So, for example, it is
 * possible to remove an arbitrary element from a queue using
 * 因此，例如，從隊列中通過remove方法移除隨意的元素是可行的
 * <tt>remove(x)</tt>. However, such operations are in general
 * <em>not</em> performed very efficiently, and are intended for only
 * 一些操作通常不能有效執行,
 * occasional use, such as when a queued message is cancelled.
 * 僅僅是臨時替代,當一個隊列消息是取消的
 *
 * <p> <tt>BlockingQueue</tt> implementations are thread-safe.  All
 * BlockingQueue實現是線程安全的
 * queuing methods achieve their effects atomically using internal
 * 所有的隊列方法用內部鎖實現元素操作
 * locks or other forms of concurrency control. However, the
 * 或者另外的並發控制方式
 * <em>bulk</em> Collection operations <tt>addAll</tt>,
 * 但是，塊的集合操作 addAll，containAll，retainAll以及removeAll
 * <tt>containsAll</tt>, <tt>retainAll</tt> and <tt>removeAll</tt> are
 * <em>not</em> necessarily performed atomically unless specified
 * 非必須的直到另外一個實現 指定執行元素的操作
 * otherwise in an implementation. So it is possible, for example, for
 *                                 因此這是有可能的，例如
 * <tt>addAll(c)</tt> to fail (throwing an exception) after adding
 * 對於addAll，在集合中添加失敗的同樣的元素(拋出一個異常)
 * only some of the elements in <tt>c</tt>.
 *
 * <p>A <tt>BlockingQueue</tt> does <em>not</em> intrinsically support
 * BlockingQueue 沒有本質上支持一些close，shutdown類型
 * any kind of &quot;close&quot; or &quot;shutdown&quot; operation to
 * indicate that no more items will be added.  The needs and usage of
 * 操作指明沒有更多的條目將會添加
 * such features tend to be implementation-dependent. For example, a
 * 這需要和用於一些趨向實現依賴的特征
 * common tactic is for producers to insert special
 * 例如：通用的方式,對於生產者插入指定的流末尾或者位置的對象
 * <em>end-of-stream</em> or <em>poison</em> objects, that are
 * interpreted accordingly when taken by consumers.
 * 從而由消費者解讀標示
 *
 * <p>
 * Usage example, based on a typical producer-consumer scenario.
 * 使用一個例子， 基於典型的生產消費者場景
 * Note that a <tt>BlockingQueue</tt> can safely be used with multiple
 * 注意一個BlockingQueue能安全的用於多個消費者多個生產者
 * producers and multiple consumers.
 * <pre>
 * class Producer implements Runnable {
 *   private final BlockingQueue queue;
 *   Producer(BlockingQueue q) { queue = q; }
 *   public void run() {
 *     try {
 *       while (true) { queue.put(produce()); }
 *     } catch (InterruptedException ex) { ... handle ...}
 *   }
 *   Object produce() { ... }
 * }
 *
 * class Consumer implements Runnable {
 *   private final BlockingQueue queue;
 *   Consumer(BlockingQueue q) { queue = q; }
 *   public void run() {
 *     try {
 *       while (true) { consume(queue.take()); }
 *     } catch (InterruptedException ex) { ... handle ...}
 *   }
 *   void consume(Object x) { ... }
 * }
 *
 * class Setup {
 *   void main() {
 *     BlockingQueue q = new SomeQueueImplementation();
 *     Producer p = new Producer(q);
 *     Consumer c1 = new Consumer(q);
 *     Consumer c2 = new Consumer(q);
 *     new Thread(p).start();
 *     new Thread(c1).start();
 *     new Thread(c2).start();
 *   }
 * }
 * </pre>
 *
 * <p>Memory consistency effects: As with other concurrent
 * 內存一致性
 * collections, actions in a thread prior to placing an object into a
 * 使用另外的並發集合, 在一個線程首先添加一個BlockingQueue
 * {@code BlockingQueue}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * 發生前存儲或移除操作從另一個線程
 * the {@code BlockingQueue} in another thread.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public interface BlockingQueue<E> extends Queue<E> {
	/**
	 * Inserts the specified element into this queue if it is possible to do
	 * so immediately without violating capacity restrictions, returning
	 *                        違反
	 * <tt>true</tt> upon success and throwing an
	 * <tt>IllegalStateException</tt> if no space is currently available.
	 * When using a capacity-restricted queue, it is generally preferable to
	 *              有限容量
	 * use {@link #offer(Object) offer}.
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 * @throws IllegalStateException if the element cannot be added at this
	 *         time due to capacity restrictions
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this queue
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this queue
	 */
	boolean add(E e);

	/**
	 * Inserts the specified element into this queue if it is possible to do
	 * so immediately without violating capacity restrictions, returning
	 * <tt>true</tt> upon success and <tt>false</tt> if no space is currently
	 * available.  When using a capacity-restricted queue, this method is
	 * generally preferable to {@link #add}, which can fail to insert an
	 * element only by throwing an exception.
	 * 當失敗添加一個元素僅僅拋出一個異常
	 *
	 * @param e the element to add
	 * @return <tt>true</tt> if the element was added to this queue, else
	 *         <tt>false</tt>
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this queue
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this queue
	 */
	boolean offer(E e);

	/**
	 * Inserts the specified element into this queue, waiting if necessary
	 * for space to become available.
	 * 如果必要等待隊列可用
	 *
	 * @param e the element to add
	 * @throws InterruptedException if interrupted while waiting
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this queue
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this queue
	 */
	void put(E e) throws InterruptedException;

	/**
	 * Inserts the specified element into this queue, waiting up to the
	 * specified wait time if necessary for space to become available.
	 * 等待指定的時間
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
	 *         prevents it from being added to this queue
	 * @throws NullPointerException if the specified element is null
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this queue
	 */
	boolean offer(E e, long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Retrieves and removes the head of this queue, waiting if necessary
	 * 檢查和移除隊列頭，等待元素可用
	 * until an element becomes available.
	 *
	 * @return the head of this queue
	 * @throws InterruptedException if interrupted while waiting
	 */
	E take() throws InterruptedException;

	/**
	 * Retrieves and removes the head of this queue, waiting up to the
	 * specified wait time if necessary for an element to become available.
	 * 指定時間
	 *
	 * @param timeout how long to wait before giving up, in units of
	 *        <tt>unit</tt>
	 * @param unit a <tt>TimeUnit</tt> determining how to interpret the
	 *        <tt>timeout</tt> parameter
	 * @return the head of this queue, or <tt>null</tt> if the
	 *         specified waiting time elapses before an element is available
	 * @throws InterruptedException if interrupted while waiting
	 */
	E poll(long timeout, TimeUnit unit)
			throws InterruptedException;

	/**
	 * Returns the number of additional elements that this queue can ideally
	 * 返回額外元素的數量 這個隊列理想的為阻塞的接收
	 * (in the absence of memory or resource constraints) accept without
	 * (內存或資源約束不存在)
	 * blocking, or <tt>Integer.MAX_VALUE</tt> if there is no intrinsic
	 *           如果沒有固有的限制，會是MAX_VALUE
	 * limit.
	 *
	 * <p>Note that you <em>cannot</em> always tell if an attempt to insert
	 * 注意你不能總是說明如果一個試圖添加一個元素會成功檢查 remainingCapacity
	 * an element will succeed by inspecting <tt>remainingCapacity</tt>
	 * because it may be the case that another thread is about to
	 * 因為他可能會是另一個線程添加或移除元素的因素
	 * insert or remove an element.
	 *
	 * @return the remaining capacity
	 */
	int remainingCapacity();

	/**
	 * Removes a single instance of the specified element from this queue,
	 * if it is present.  More formally, removes an element <tt>e</tt> such
	 * that <tt>o.equals(e)</tt>, if this queue contains one or more such
	 * elements.
	 * Returns <tt>true</tt> if this queue contained the specified element
	 * (or equivalently, if this queue changed as a result of the call).
	 *
	 * @param o element to be removed from this queue, if present
	 * @return <tt>true</tt> if this queue changed as a result of the call
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this queue
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 */
	boolean remove(Object o);

	/**
	 * Returns <tt>true</tt> if this queue contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this queue contains
	 * at least one element <tt>e</tt> such that <tt>o.equals(e)</tt>.
	 *
	 * @param o object to be checked for containment in this queue
	 * @return <tt>true</tt> if this queue contains the specified element
	 * @throws ClassCastException if the class of the specified element
	 *         is incompatible with this queue
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null
	 *         (<a href="../Collection.html#optional-restrictions">optional</a>)
	 */
	public boolean contains(Object o);

	/**
	 * Removes all available elements from this queue and adds them
	 * 移除所有可用的元素從隊列中，并添加他們到給定的集合中
	 * to the given collection.  This operation may be more
	 * efficient than repeatedly polling this queue.  A failure
	 * 這個操作比起重複的poll這個隊列更加高效
	 * encountered while attempting to add elements to
	 * 當試圖添加元素到集合中遇到一個失敗
	 * collection <tt>c</tt> may result in elements being in neither,
	 * 當關聯的異常拋出來任意一個或者二者，三者在元素中
	 * either or both collections when the associated exception is
	 * thrown.  Attempts to drain a queue to itself result in
	 *          試圖排除一個隊列自己的結果會發生異常
	 * <tt>IllegalArgumentException</tt>. Further, the behavior of
	 * this operation is undefined if the specified collection is
	 *  這個操作的行為是未定義的，如果指定的集合在操作過程改變了
	 * modified while the operation is in progress.
	 *
	 * @param c the collection to transfer elements into
	 * @return the number of elements transferred
	 * @throws UnsupportedOperationException if addition of elements
	 *         is not supported by the specified collection
	 * @throws ClassCastException if the class of an element of this queue
	 *         prevents it from being added to the specified collection
	 * @throws NullPointerException if the specified collection is null
	 * @throws IllegalArgumentException if the specified collection is this
	 *         queue, or some property of an element of this queue prevents
	 *         it from being added to the specified collection
	 */
	int drainTo(Collection<? super E> c);

	/**
	 * Removes at most the given number of available elements from
	 * this queue and adds them to the given collection.  A failure
	 * encountered while attempting to add elements to
	 * collection <tt>c</tt> may result in elements being in neither,
	 * either or both collections when the associated exception is
	 * thrown.  Attempts to drain a queue to itself result in
	 * <tt>IllegalArgumentException</tt>. Further, the behavior of
	 * this operation is undefined if the specified collection is
	 * modified while the operation is in progress.
	 *
	 * @param c the collection to transfer elements into
	 * @param maxElements the maximum number of elements to transfer
	 *                    要運轉的元素的最大數量
	 * @return the number of elements transferred
	 * @throws UnsupportedOperationException if addition of elements
	 *         is not supported by the specified collection
	 * @throws ClassCastException if the class of an element of this queue
	 *         prevents it from being added to the specified collection
	 * @throws NullPointerException if the specified collection is null
	 * @throws IllegalArgumentException if the specified collection is this
	 *         queue, or some property of an element of this queue prevents
	 *         it from being added to the specified collection
	 */
	int drainTo(Collection<? super E> c, int maxElements);
}
