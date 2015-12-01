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
 *     FileName: z.z.w.jdk.collections.Iterable
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-01 15:09
 *   LastChange: 2015-12-01 15:09
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.Iterator;

/**
 * Implementing this interface allows an object to be the target of
 * 實現了這個接口允許一個實體對其foreach遍歷目標
 * the "foreach" statement.
 *
 * @param <T> the type of elements returned by the iterator
 *            由iterator返回元素的類型
 *
 * @since 1.5
 */
public interface Iterable<T>
{
	/**
	 * Returns an iterator over a set of elements of type T.
	 * 返回一個迭代器的類型T的元素的集合
	 *
	 * @return an Iterator.
	 */
	Iterator<T> iterator();
}
