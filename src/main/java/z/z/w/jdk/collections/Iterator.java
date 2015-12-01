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
 *     FileName: z.z.w.jdk.collections.Iterator
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-01 15:14
 *   LastChange: 2015-12-01 15:14
 *      History:
 * </pre>
 *********************************************************************************************/

/**
 * An iterator over a collection.  {@code Iterator} takes the place of
 * 迭代器遍歷集合.
 * {@link java.util.Enumeration} in the Java Collections Framework.  Iterators
 * 在java集合框架中在枚舉類需要的時候遍歷.
 * differ from enumerations in two ways:
 * 迭代器與枚舉類不同之處:
 * <ul>
 * <li> Iterators allow the caller to remove elements from the
 * underlying collection during the iteration with well-defined
 * 迭代器允許調用者移除元素在迭代期間擁有很好的語義定義
 * semantics.
 * <li> Method names have been improved.
 * 方法名增進
 * </ul>
 * <p>This interface is a member of the
 * 接口簡介
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <E> the type of elements returned by this iterator
 *
 * @author Josh Bloch
 * @see java.util.Collection
 * @see java.util.ListIterator
 * @see java.lang.Iterable
 * @since 1.2
 */
public interface Iterator<E>
{
	/**
	 * Returns {@code true} if the iteration has more elements.
	 * 如果迭代器有更多的元素，則返回true.
	 * (In other words, returns {@code true} if {@link #next} would
	 * 換句話說,如果返回true則是將要返回一個元素,而不是拋出一個異常
	 * return an element rather than throwing an exception.)
	 *
	 * @return {@code true} if the iteration has more elements
	 * 如果迭代器存在更多的元素，則返回true
	 */
	boolean hasNext();

	/**
	 * Returns the next element in the iteration.
	 * 返回迭代器中的下一個元素
	 *
	 * @return the next element in the iteration
	 * 返回迭代器中的下一個元素
	 *
	 * @throws java.util.NoSuchElementException if the iteration has no more elements
	 *                                          如果迭代器中沒有更多的元素,則會拋出一個異常
	 */
	E next();

	/**
	 * Removes from the underlying collection the last element returned
	 * 刪除底層集合中由集合(可選的操作)返回的最後的元素
	 * by this iterator (optional operation).  This method can be called
	 * only once per call to {@link #next}.  The behavior of an iterator
	 * 這個方法只能在調用next方法后調用一次.
	 * is unspecified if the underlying collection is modified while the
	 * 迭代器的行為是未說明的,如果修改了底層集合,
	 * iteration is in progress in any way other than by calling this
	 * 那麼迭代器是在調用這個方法以外的任何方法中進行.
	 * method.
	 *
	 * @throws UnsupportedOperationException if the {@code remove}
	 *                                       如果移除操作在這個迭代器中是不允許的,則會拋出異常
	 *                                       operation is not supported by this iterator
	 * @throws IllegalStateException         if the {@code next} method has not
	 *                                       如果方法還沒有調用,
	 *                                       yet been called, or the {@code remove} method has already
	 *                                       或者移除方法已經調用了,
	 *                                       been called after the last call to the {@code next}
	 *                                       那麼在最後調用next方法是會拋出異常.
	 *                                       method
	 */
	void remove();
}
