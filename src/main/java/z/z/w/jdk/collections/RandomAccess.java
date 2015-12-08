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
 *     FileName: z.z.w.jdk.collections.RandomAccess
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-08 14:40
 *   LastChange: 2015-12-08 14:40
 *      History:
 * </pre>
 *********************************************************************************************/
/**
 * Marker interface used by <tt>List</tt> implementations to indicate that
 * 標記用於List的實現的接口指出支持快速隨機訪問存儲.
 * they support fast (generally constant time) random access.  The primary
 *                   (恆定的時間)
 * purpose of this interface is to allow generic algorithms to alter their
 * 這個接口主要的目的是運行通用的算法改變他們的行為當應用隨機或是序列訪問list時
 * behavior to provide good performance when applied to either random or
 * 提供更好的性能
 * sequential access lists.
 *
 * <p>The best algorithms for manipulating random access lists (such as
 * 用於操作隨機訪問list的最好的算法
 * <tt>ArrayList</tt>) can produce quadratic behavior when applied to
 * (例如ArrayList)能夠產生二次行為當應用
 * sequential access lists (such as <tt>LinkedList</tt>).  Generic list
 * 序列訪問list時(例如LinkedList)
 * algorithms are encouraged to check whether the given list is an
 * 通用的list算法是受鼓勵的，用於檢查給定的list是實現,
 * <tt>instanceof</tt> this interface before applying an algorithm that would
 * 這個實現應用于一個算法之前
 * provide poor performance if it were applied to a sequential access list,
 * 這個算法將提供差性能的，如果它應用於一個序列的訪問list,
 * and to alter their behavior if necessary to guarantee acceptable
 * 並且如果保證接收性能而改變他們的行為
 * performance.
 *
 * <p>It is recognized that the distinction between random and sequential
 * 經常模糊區分隨機和序列的訪問是可認可的.
 * access is often fuzzy.  For example, some <tt>List</tt> implementations
 *                         例如,一些List實現
 * provide asymptotically linear access times if they get huge, but constant
 * 提供了漸進的線性訪問時間如果他們漸漸大起來
 * access times in practice.  Such a <tt>List</tt> implementation
 * 但在實戰中恆定的訪問時間.
 * should generally implement this interface.  As a rule of thumb, a
 * 例如一個List實現一般應該實現這個歌接口.
 * <tt>List</tt> implementation should implement this interface if,
 * 作為一個規範的規則,一個List的實現應該實現這個接口.
 *
 * for typical instances of the class, this loop:
 * <pre>
 *     for (int i=0, n=list.size(); i &lt; n; i++)
 *         list.get(i);
 * </pre>
 * runs faster than this loop:
 * <pre>
 *     for (Iterator i=list.iterator(); i.hasNext(); )
 *         i.next();
 * </pre>
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.4
 */
public interface RandomAccess {
}

