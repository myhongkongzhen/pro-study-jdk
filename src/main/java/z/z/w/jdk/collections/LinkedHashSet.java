/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.jdk.collections;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.jdk.collections.LinkedHashSet
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-21 19:55
 *   LastChange: 2015-12-21 19:55
 *      History:
 * </pre>
 **************************************************************************/

import java.util.*;

/**
 * <p>Hash table and linked list implementation of the <tt>Set</tt> interface,
 * 哈希表與鏈錶實現set接口，可預測迭代順序
 * with predictable iteration order.  This implementation differs from
 * <tt>HashSet</tt> in that it maintains a doubly-linked list running through
 * 這個實現與HashSet不同，他維護了一個雙向裂變在所有實體訪問期間
 * all of its entries.  This linked list defines the iteration ordering,
 * which is the order in which elements were inserted into the set
 * 這個鏈錶定義了 迭代順序，元素插入set結婚的插入順序
 * (<i>insertion-order</i>).  Note that insertion order is <i>not</i> affected
 * if an element is <i>re-inserted</i> into the set.  (An element <tt>e</tt>
 * 注意這個插入順序不受影響重新插入的元素
 * is reinserted into a set <tt>s</tt> if <tt>s.add(e)</tt> is invoked when
 * <tt>s.contains(e)</tt> would return <tt>true</tt> immediately prior to
 * the invocation.)
 *
 * <p>This implementation spares its clients from the unspecified, generally
 * 這個實現替補的從未指定的，一般亂序的客戶端，由hashSet提供
 * chaotic ordering provided by {@link java.util.HashSet}, without incurring the
 * increased cost associated with {@link java.util.TreeSet}.  It can be used to
 * 不會招致增長花費的關聯TreeSet
 * produce a copy of a set that has the same order as the original, regardless
 * 它可用於生產一個set的拷貝，與他有同樣順序的的起源的，而不論起源是否是set的實現
 * of the original set's implementation:
 * <pre>
 *     void foo(Set s) {
 *         Set copy = new LinkedHashSet(s);
 *         ...
 *     }
 * </pre>
 * This technique is particularly useful if a module takes a set on input,
 * 這個歌技術尤其有用腐肉一個魔窟需要輸入一個set，拷貝他
 * copies it, and later returns results whose order is determined by that of
 * 最近返回的結果，順序由整個拷貝定義
 * the copy.  (Clients generally appreciate having things returned in the same
 * order they were presented.)
 * 客戶端通常展現了同樣的參考的順序
 *
 * <p>This class provides all of the optional <tt>Set</tt> operations, and
 * 這個類提供了所有的set的操作，并允許null元素
 * permits null elements.  Like <tt>HashSet</tt>, it provides constant-time
 * 如同hashset一樣，他提供了基礎的add，contains，remove恆定的性能操作時間
 * performance for the basic operations (<tt>add</tt>, <tt>contains</tt> and
 * <tt>remove</tt>), assuming the hash function disperses elements
 * 嘉定哈希函數訪問整個塊屬性
 * properly among the buckets.  Performance is likely to be just slightly
 * below that of <tt>HashSet</tt>, due to the added expense of maintaining the
 * 性能僅僅略低於hashset，  應有增加了維護list的開銷
 * linked list, with one exception: Iteration over a <tt>LinkedHashSet</tt>
 * 一個例外，
 * requires time proportional to the <i>size</i> of the set, regardless of
 * 迭代一個linkedhashset，需要與set的size成正比的時間複雜度
 * its capacity.  Iteration over a <tt>HashSet</tt> is likely to be more
 * 而不是他的容量，迭代一個hashset，更多的花銷，所需的時間在他的容量上
 * expensive, requiring time proportional to its <i>capacity</i>.
 *
 * <p>A linked hash set has two parameters that affect its performance:
 * 一個鏈錶哈希set需要兩個桉樹對於他的性能
 * <i>initial capacity</i> and <i>load factor</i>.  They are defined precisely
 * 初始容量以及負載因子
 * as for <tt>HashSet</tt>.  Note, however, that the penalty for choosing an
 * 他們恰恰為hashset所定義。注意，但是，
 * excessively high value for initial capacity is less severe for this class
 * 選擇一個過高的值對於初始容量更瘦的服務對於這個類比起hashset
 * than for <tt>HashSet</tt>, as iteration times for this class are unaffected
 *  退與這個類的插入時間不依賴容量
 * by capacity.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * 注意這個實現是未同步的
 * If multiple threads access a linked hash set concurrently, and at least
 * one of the threads modifies the set, it <em>must</em> be synchronized
 * externally.  This is typically accomplished by synchronizing on some
 * object that naturally encapsulates the set.
 *
 * If no such object exists, the set should be "wrapped" using the
 * {@link Collections#synchronizedSet Collections.synchronizedSet}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the set: <pre>
 *   Set s = Collections.synchronizedSet(new LinkedHashSet(...));</pre>
 *
 * <p>The iterators returned by this class's <tt>iterator</tt> method are
 * <em>fail-fast</em>: if the set is modified at any time after the iterator
 * is created, in any way except through the iterator's own <tt>remove</tt>
 * method, the iterator will throw a {@link ConcurrentModificationException}.
 * Thus, in the face of concurrent modification, the iterator fails quickly
 * and cleanly, rather than risking arbitrary, non-deterministic behavior at
 * an undetermined time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness:   <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <E> the type of elements maintained by this set
 *
 * @author  Josh Bloch
 * @see     Object#hashCode()
 * @see     java.util.Collection
 * @see     java.util.Set
 * @see     java.util.HashSet
 * @see     java.util.TreeSet
 * @see     Hashtable
 * @since   1.4
 */

public class LinkedHashSet<E>
        extends HashSet<E>
        implements Set<E>, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = -2851667679971038690L;

    /**
     * Constructs a new, empty linked hash set with the specified initial
     * capacity and load factor.
     *
     * @param      initialCapacity the initial capacity of the linked hash set
     * @param      loadFactor      the load factor of the linked hash set
     * @throws     IllegalArgumentException  if the initial capacity is less
     *               than zero, or if the load factor is nonpositive
     */
    public LinkedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }

    /**
     * Constructs a new, empty linked hash set with the specified initial
     * capacity and the default load factor (0.75).
     *
     * @param   initialCapacity   the initial capacity of the LinkedHashSet
     * @throws  IllegalArgumentException if the initial capacity is less
     *              than zero
     */
    public LinkedHashSet(int initialCapacity) {
        super(initialCapacity, .75f, true);
    }

    /**
     * Constructs a new, empty linked hash set with the default initial
     * capacity (16) and load factor (0.75).
     */
    public LinkedHashSet() {
        super(16, .75f, true);
    }

    /**
     * Constructs a new linked hash set with the same elements as the
     * specified collection.  The linked hash set is created with an initial
     * capacity sufficient to hold the elements in the specified collection
     * and the default load factor (0.75).
     *
     * @param c  the collection whose elements are to be placed into
     *           this set
     * @throws NullPointerException if the specified collection is null
     */
    public LinkedHashSet( Collection<? extends E> c) {
        super(Math.max(2*c.size(), 11), .75f, true);
        addAll(c);
    }

}
