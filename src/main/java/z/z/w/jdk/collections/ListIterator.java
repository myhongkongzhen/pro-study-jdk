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
 *     FileName: z.z.w.jdk.collections.ListIterator
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-08 15:24
 *   LastChange: 2015-12-08 15:24
 *      History:
 * </pre>
 *********************************************************************************************/

import java.util.NoSuchElementException;

/**
 * An iterator for lists that allows the programmer
 * 對於list的迭代器，允許程序員在任意方向的訪問.
 * to traverse the list in either direction, modify
 * 在迭代期間改變list
 * the list during iteration, and obtain the iterator's
 * 并獲得在list中迭代器的當前位置.
 * current position in the list. A {@code ListIterator}
 * has no current element; its <I>cursor position</I> always
 * 一個ListIterator沒有當前的元素,
 * lies between the element that would be returned by a call
 * 他的游標位置總是位於由調用previous返回的前驅元素
 * to {@code previous()} and the element that would be
 * 與調用next返回的後繼元素之間
 * returned by a call to {@code next()}.
 * An iterator for a list of length {@code n} has {@code n+1} possible
 * 對於長度N的list的迭代器有n+1的可能的游標位置
 * cursor positions, as illustrated by the carets ({@code ^}) below:
 *                   由符號^在下面舉例說明:
 * <PRE>
 *                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
 * cursor positions:  ^            ^            ^            ^                  ^
 * </PRE>
 * Note that the {@link #remove} and {@link #set(Object)} methods are
 * 注意remove與set方法在游標位置的術語是未定義的
 * <i>not</i> defined in terms of the cursor position;  they are defined to
 * operate on the last element returned by a call to {@link #next} or
 * 他們定義于操作調用next與previous方法返回的最後的元素
 * {@link #previous()}.
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @see Collection
 * @see List
 * @see Iterator
 * @see java.util.Enumeration
 * @see List#listIterator()
 * @since   1.2
 */
public interface ListIterator<E> extends Iterator<E> {
	// Query Operations

	/**
	 * Returns {@code true} if this list iterator has more elements when
	 * 如果這個list的迭代器有更多的元素當朝著前驅方向遍歷list的時候返回true
	 * traversing the list in the forward direction. (In other words,
	 * returns {@code true} if {@link #next} would return an element rather
	 * (換句話說，如果next方法能夠返回一個元素而不是拋出一個異常，則會返回true.)
	 * than throwing an exception.)
	 *
	 * @return {@code true} if the list iterator has more elements when
	 *         traversing the list in the forward direction
	 */
	boolean hasNext();

	/**
	 * Returns the next element in the list and advances the cursor position.
	 * 在list與前驅的游標位置中返回下一個元素
	 * This method may be called repeatedly to iterate through the list,
	 * 這個方法可以重複的調用迭代器穿過list
	 * or intermixed with calls to {@link #previous} to go back and forth.
	 * 或者混合previous方法先前向後調用
	 * (Note that alternating calls to {@code next} and {@code previous}
	 * (注意輪流的調用next與previous將會重複的返回同一個元素)
	 * will return the same element repeatedly.)
	 *
	 * @return the next element in the list
	 * @throws NoSuchElementException if the iteration has no next element
	 */
	E next();

	/**
	 * Returns {@code true} if this list iterator has more elements when
	 * 如果這個list的迭代器有更多的元素當相反的方向遍歷list時,返回true
	 * traversing the list in the reverse direction.  (In other words,
	 * returns {@code true} if {@link #previous} would return an element
	 * (換句話說，如果previous返回一個元素而非拋出一個異常，則會返回true)
	 * rather than throwing an exception.)
	 *
	 * @return {@code true} if the list iterator has more elements when
	 *         traversing the list in the reverse direction
	 */
	boolean hasPrevious();

	/**
	 * Returns the previous element in the list and moves the cursor
	 * 返回這個list中向後移動游標位置前的元素
	 * position backwards.  This method may be called repeatedly to
	 * iterate through the list backwards, or intermixed with calls to
	 * 這個方法可以重複的調用向後迭代list
	 * {@link #next} to go back and forth.  (Note that alternating calls
	 * 或者混合next向前向後調用.
	 * to {@code next} and {@code previous} will return the same
	 * (注意輪流的調用next與previous將會重複的返回相同的元素)
	 * element repeatedly.)
	 *
	 * @return the previous element in the list
	 * @throws NoSuchElementException if the iteration has no previous
	 *         element
	 */
	E previous();

	/**
	 * Returns the index of the element that would be returned by a
	 * 返回一個又子序列調用next返回的元素的索引
	 * subsequent call to {@link #next}. (Returns list size if the list
	 * iterator is at the end of the list.)
	 * (如果list迭代器在list的最後，返回list的大小)
	 *
	 * @return the index of the element that would be returned by a
	 *         subsequent call to {@code next}, or list size if the list
	 *         iterator is at the end of the list
	 */
	int nextIndex();

	/**
	 * Returns the index of the element that would be returned by a
	 * 返回由一個子序列調用previous返回的元素的索引
	 * subsequent call to {@link #previous}. (Returns -1 if the list
	 * iterator is at the beginning of the list.)
	 * (如果list的迭代器在list的開始，返回-1)
	 *
	 * @return the index of the element that would be returned by a
	 *         subsequent call to {@code previous}, or -1 if the list
	 *         iterator is at the beginning of the list
	 */
	int previousIndex();


	// Modification Operations

	/**
	 * Removes from the list the last element that was returned by {@link
	 * #next} or {@link #previous} (optional operation).  This call can
	 * 從list中移除由next與previous調用返回的最近的元素.
	 * only be made once per call to {@code next} or {@code previous}.
	 * 這個調用在沒調用一次next或者previous時發生一次
	 * It can be made only if {@link #add} has not been
	 * called after the last call to {@code next} or {@code previous}.
	 * 如果在最後調用next或這個previous之後，add是可以不調用的
	 *
	 * @throws UnsupportedOperationException if the {@code remove}
	 *         operation is not supported by this list iterator
	 * @throws IllegalStateException if neither {@code next} nor
	 *         無論next還是previous是否調用,
	 *         {@code previous} have been called, or {@code remove} or
	 *         在最後調用next或previous之後，調用remove或者add都會
	 *         {@code add} have been called after the last call to
	 *         拋出一個異常
	 *         {@code next} or {@code previous}
	 */
	void remove();

	/**
	 * Replaces the last element returned by {@link #next} or
	 * 用指定的元素替代由next或者previous返回的最後的元素
	 * {@link #previous} with the specified element (optional operation).
	 * This call can be made only if neither {@link #remove} nor {@link
	 * #add} have been called after the last call to {@code next} or
	 * 這個調用僅僅用於在next還是previous最後調用之後,remove或者add調用
	 * {@code previous}.
	 *
	 * @param e the element with which to replace the last element returned by
	 *          {@code next} or {@code previous}
	 * @throws UnsupportedOperationException if the {@code set} operation
	 *         is not supported by this list iterator
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws IllegalArgumentException if some aspect of the specified
	 *         element prevents it from being added to this list
	 * @throws IllegalStateException if neither {@code next} nor
	 *         {@code previous} have been called, or {@code remove} or
	 *         {@code add} have been called after the last call to
	 *         {@code next} or {@code previous}
	 */
	void set(E e);

	/**
	 * Inserts the specified element into the list (optional operation).
	 * 在list中插入指定的元素
	 * The element is inserted immediately before the element that
	 * 這個元素會立即添加入在元素前,
	 * would be returned by {@link #next}, if any, and after the element
	 * 這些元素有next返回之前，有previous返回之後,
	 * that would be returned by {@link #previous}, if any.  (If the
	 * list contains no elements, the new element becomes the sole element
	 * 如果這個list不包含元素，那麼新的元素會成為這個list中的唯一的元素
	 * on the list.)  The new element is inserted before the implicit
	 * cursor: a subsequent call to {@code next} would be unaffected, and a
	 * 這個元素在隨機的游標之前添加入,子序列調用next不會受影響
	 * subsequent call to {@code previous} would return the new element.
	 * 並且子序列調用previous會返回這個新的元素.
	 * (This call increases by one the value that would be returned by a
	 * (這個元素增加了一個有nextIndex或者previousIndex調用返回的值)
	 * call to {@code nextIndex} or {@code previousIndex}.)
	 *
	 * @param e the element to insert
	 * @throws UnsupportedOperationException if the {@code add} method is
	 *         not supported by this list iterator
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws IllegalArgumentException if some aspect of this element
	 *                                          方面
	 *         prevents it from being added to this list
	 *         防止
	 */
	void add(E e);
}

