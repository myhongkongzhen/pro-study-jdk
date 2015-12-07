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
 *     FileName: z.z.w.jdk.collections.AbstractCollection
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-07 12:20
 *   LastChange: 2015-12-07 12:20
 *      History:
 * </pre>
 *********************************************************************************************/

import org.apache.poi.ss.formula.functions.T;

/**
 * This class provides a skeletal implementation of the <tt>Collection</tt>
 * 這個類提供了集合接口實現的框架
 * interface, to minimize the effort required to implement this interface. <p>
 *            實現了這個接口的所需的最小化的精力.
 * To implement an unmodifiable collection, the programmer needs only to
 * 實現一個無法改變的集合,
 * extend this class and provide implementations for the <tt>iterator</tt> and
 * 程序員僅僅需要擴展這個類并提供實現所需的迭代器及大小的方法即可.
 * <tt>size</tt> methods.  (The iterator returned by the <tt>iterator</tt>
 * method must implement <tt>hasNext</tt> and <tt>next</tt>.)<p>
 * (迭代器返回必須實現hasNext及next方法.)
 * To implement a modifiable collection, the programmer must additionally
 * 實現可改變的集合,
 * override this class's <tt>add</tt> method (which otherwise throws an
 * 程序員需要添加複寫add方法
 * <tt>UnsupportedOperationException</tt>), and the iterator returned by the
 * (另外需要拋出一個未支持操作異常),
 * <tt>iterator</tt> method must additionally implement its <tt>remove</tt>
 * 並且迭代器返回必須添加實現它的remove方法.
 * method.<p>
 * The programmer should generally provide a void (no argument) and
 * 程序員應該提供通用的void(無參的)集合構造器,
 * <tt>Collection</tt> constructor, as per the recommendation in the
 * 作為在集合接口詳述中的每一個建議
 * <tt>Collection</tt> interface specification.<p>
 * The documentation for each non-abstract method in this class describes its
 * 文檔提供在這個類的詳述中對於每個非抽象方法的實現的細節描述
 * implementation in detail.  Each of these methods may be overridden if
 * the collection being implemented admits a more efficient implementation.<p>
 * 這些方法中的每一個都可以重寫當這個結合允許實現更有效的實現時.
 * This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author Josh Bloch
 * @author Neal Gafter
 * @see java.util.Collection
 * @since 1.2
 */
public abstract class AbstractCollection<E> implements Collection<E>
{
	/**
	 * Sole constructor.  (For invocation by subclass constructors, typically
	 * 僅有的構造器.(由子類構造器隱含的調用.)
	 * implicit.)
	 */
	protected AbstractCollection()
	{
	}

	// Query Operations

	/**
	 * Returns an iterator over the elements contained in this collection.
	 * 返回這個集合迭代包含元素的迭代器
	 *
	 * @return an iterator over the elements contained in this collection
	 */
	public abstract Iterator<E> iterator();

	public abstract int size();

	/**
	 * {@inheritDoc}
	 * <p>This implementation returns <tt>size() == 0</tt>.
	 * 這個實現返回(size() == 0)
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over the elements in the collection,
	 * 這個實現迭代集合中的所有元素
	 * checking each element in turn for equality with the specified element.
	 * 依次檢查每一個元素與指定元素相等性
	 *
	 * @throws ClassCastException   {@inheritDoc}
	 * @throws NullPointerException {@inheritDoc}
	 */
	public boolean contains( Object o )
	{
		Iterator<E> it = iterator();
		if ( o == null )
		{
			while ( it.hasNext() ) if ( it.next() == null ) return true;
		}
		else
		{
			while ( it.hasNext() ) if ( o.equals( it.next() ) ) return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation returns an array containing all the elements
	 * 這個實現返回一個數組，包含了所有的元素.
	 * returned by this collection's iterator, in the same order, stored in
	 * 由這個集合的迭代器,按照相同的順序,
	 * consecutive elements of the array, starting with index {@code 0}.
	 * 從索引0開始的連貫的數組中的元素.
	 * The length of the returned array is equal to the number of elements
	 * 返回的數組的長度等於由迭代器返回的元素的個數,
	 * returned by the iterator, even if the size of this collection changes
	 *                           甚至這個集合的大小在迭代過程中改變了
	 * during iteration, as might happen if the collection permits
	 * 如果集合允許在迭代中並發的改變是可發生的.
	 * concurrent modification during iteration.  The {@code size} method is
	 * called only as an optimization hint; the correct result is returned
	 * size方法僅僅作為一個優化的提示被調用;正確的結果可返回
	 * even if the iterator returns a different number of elements.
	 * 儘管迭代者返回一個不同元素個數
	 * <p>This method is equivalent to:
	 *                   等價的
	 * <pre> {@code
	 * List<E> list = new ArrayList<E>(size());
	 * for (E e : this)
	 *     list.add(e);
	 * return list.toArray();
	 * }</pre>
	 */
	public Object[] toArray()
	{
		// Estimate size of array; be prepared to see more or fewer elements
		// 預估數組的大小
		Object[]    r  = new Object[ size() ];
		Iterator<E> it = iterator();
		for ( int i = 0 ; i < r.length ; i++ )
		{
			if ( !it.hasNext() ) // fewer elements than expected
			    //當集合中不存在下一個元素時，返回一個新的拷貝的數組.
				return Arrays.copyOf( r, i );
			r[ i ] = it.next(); //將集合迭代元素依次放入臨時Obj[]中
		}
		/* 如果size為0，判斷集合是否有下一個元素 */
		/* 如果不存在，返回一個空的數組 */
		/* 如果存在，進行finishToArray()操作 */
		return it.hasNext() ? finishToArray( r, it ) : r;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation returns an array containing all the elements
	 * returned by this collection's iterator in the same order, stored in
	 * consecutive elements of the array, starting with index {@code 0}.
	 * 連貫的數
	 * If the number of elements returned by the iterator is too large to
	 * 如果由迭代器返回的元素的個數太大了
	 * fit into the specified array, then the elements are returned in a
	 * 而不適合指定的數組,
	 * newly allocated array with length equal to the number of elements
	 * 那麼在一個重新分配的由迭代者返回元素的個數相等的長度的數組中返回元素
	 * returned by the iterator, even if the size of this collection
	 * changes during iteration, as might happen if the collection permits
	 * 儘管集合在迭代中改變了大小,
	 * concurrent modification during iteration.  The {@code size} method is
	 * 如果集合允許在迭代中並發修改的發生.
	 * called only as an optimization hint; the correct result is returned
	 *                   優化的提示
	 * even if the iterator returns a different number of elements.
	 * <p>This method is equivalent to:
	 * <pre> {@code
	 * List<E> list = new ArrayList<E>(size());
	 * for (E e : this)
	 *     list.add(e);
	 * return list.toArray(a);
	 * }</pre>
	 *
	 * @throws ArrayStoreException  {@inheritDoc}
	 * @throws NullPointerException {@inheritDoc}
	 */
	public <T> T[] toArray( T[] a )
	{
		// Estimate size of array; be prepared to see more or fewer elements
		int         size = size();
		                                          //創建一個新的數組，由指定類型，底層由native方法newArray實現數組的創建
		T[]         r    = a.length >= size ? a : ( T[] ) java.lang.reflect.Array.newInstance( a.getClass().getComponentType(), size );
		Iterator<E> it   = iterator();

		for ( int i = 0 ; i < r.length ; i++ )
		{
			if ( !it.hasNext() )
			{ // fewer elements than expected
				if ( a == r )
				{
					r[ i ] = null; // null-terminate
				}
				else if ( a.length < i )
				{
					return Arrays.copyOf( r, i );
				}
				else
				{
					System.arraycopy( r, 0, a, 0, i );
					if ( a.length > i )
					{
						a[ i ] = null;
					}
				}
				return a;
			}
			r[ i ] = ( T ) it.next();
		}
		// more elements than expected
		return it.hasNext() ? finishToArray( r, it ) : r;
	}

	/**
	 * The maximum size of array to allocate.
	 * Some VMs reserve some header words in an array.
	 * 一些vm在數組里提供某些header信息
	 * Attempts to allocate larger arrays may result in
	 * 嘗試分配更大的數組會拋出OutOfMemoryError.
	 * OutOfMemoryError: Requested array size exceeds VM limit
	 *                   請求的數組大小超過vm的限制
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	/**
	 * Reallocates the array being used within toArray when the iterator
	 * 重新分配數組用於在toArray內，迭代器返回比期望更多的元素時，
	 * returned more elements than expected, and finishes filling it from
	 *                                       并完成從迭代器填充.
	 * the iterator.
	 *
	 * @param r  the array, replete with previously stored elements
	 *           一個數組，充滿了先前的元素的
	 * @param it the in-progress iterator over this collection
	 *           迭代這個集合的迭代器
	 *
	 * @return array containing the elements in the given array, plus any
	 *         返回數組包含了在特定數組中的元素,
	 * further elements returned by the iterator, trimmed to size
	 * 由迭代器返回添加任意將來的元素,消減規模
	 */
	private static <T> T[] finishToArray( T[] r, Iterator<?> it )
	{
		int i = r.length;
		while ( it.hasNext() )
		{
			int cap = r.length;
			if ( i == cap )
			{
				int newCap = cap + ( cap >> 1 ) + 1;
				// overflow-conscious code
				// 合理的溢出代碼
				if ( newCap - MAX_ARRAY_SIZE > 0 ) newCap = hugeCapacity( cap + 1 );
				r = Arrays.copyOf( r, newCap );
			}
			r[ i++ ] = ( T ) it.next();
		}
		// trim if overallocated
		return ( i == r.length ) ? r : Arrays.copyOf( r, i );
	}

	/*最小容量校驗，負值判斷,0x7fffffff最大整數判斷*/
	private static int hugeCapacity( int minCapacity )
	{
		if ( minCapacity < 0 ) // overflow
			throw new OutOfMemoryError( "Required array size too large" );
		return ( minCapacity > MAX_ARRAY_SIZE ) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	// Modification Operations

	/**
	 * {@inheritDoc}
	 * <p>This implementation always throws an
	 * 這個實現總是拋出一個UnsupportedOperationException
	 * <tt>UnsupportedOperationException</tt>.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IllegalStateException         {@inheritDoc}
	 */
	public boolean add( E e )
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over the collection looking for the
	 * 這個實現通過迭代集合尋找指定的元素
	 * specified element.  If it finds the element, it removes the element
	 *                     如果找到元素,移除這個元素從結婚中,使用迭代器的remove方法
	 * from the collection using the iterator's remove method.
	 * <p>Note that this implementation throws an
	 * 注意這個實現會拋出一個不支持操作異常，
	 * <tt>UnsupportedOperationException</tt> if the iterator returned by this
	 *                                        如果又集合的迭代器方法沒有實現remove方法
	 * collection's iterator method does not implement the <tt>remove</tt>
	 * method and this collection contains the specified object.
	 * 並且集合包含指定的實體的迭代器.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 */
	public boolean remove( Object o )
	{
		Iterator<E> it = iterator();
		if ( o == null )
		{
			while ( it.hasNext() )
			{
				if ( it.next() == null )
				{
					it.remove();
					return true;
				}
			}
		}
		else
		{
			while ( it.hasNext() )
			{
				if ( o.equals( it.next() ) )
				{
					it.remove();
					return true;
				}
			}
		}
		return false;
	}

	// Bulk Operations

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over the specified collection,
	 * checking each element returned by the iterator in turn to see
	 * if it's contained in this collection.  If all elements are so
	 * contained <tt>true</tt> is returned, otherwise <tt>false</tt>.
	 *
	 * @throws ClassCastException   {@inheritDoc}
	 * @throws NullPointerException {@inheritDoc}
	 * @see #contains(Object)
	 */
	public boolean containsAll( java.util.Collection<?> c )
	{
		for ( Object e : c )
			if ( !contains( e ) ) return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over the specified collection, and adds
	 * each object returned by the iterator to this collection, in turn.
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> unless <tt>add</tt> is
	 * overridden (assuming the specified collection is non-empty).
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @throws IllegalArgumentException      {@inheritDoc}
	 * @throws IllegalStateException         {@inheritDoc}
	 * @see #add(Object)
	 */
	public boolean addAll( java.util.Collection<? extends E> c )
	{
		boolean modified = false;
		for ( E e : c )
			if ( add( e ) ) modified = true;
		return modified;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over this collection, checking each
	 * element returned by the iterator in turn to see if it's contained
	 * in the specified collection.  If it's so contained, it's removed from
	 * this collection with the iterator's <tt>remove</tt> method.
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the iterator returned by the
	 * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
	 * and this collection contains one or more elements in common with the
	 * specified collection.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	public boolean removeAll( java.util.Collection<?> c )
	{
		boolean     modified = false;
		Iterator<?> it       = iterator();
		while ( it.hasNext() )
		{
			if ( c.contains( it.next() ) )
			{
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over this collection, checking each
	 * element returned by the iterator in turn to see if it's contained
	 * in the specified collection.  If it's not so contained, it's removed
	 * from this collection with the iterator's <tt>remove</tt> method.
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the iterator returned by the
	 * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
	 * and this collection contains one or more elements not present in the
	 * specified collection.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 * @throws ClassCastException            {@inheritDoc}
	 * @throws NullPointerException          {@inheritDoc}
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	public boolean retainAll( java.util.Collection<?> c )
	{
		boolean     modified = false;
		Iterator<E> it       = iterator();
		while ( it.hasNext() )
		{
			if ( !c.contains( it.next() ) )
			{
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * {@inheritDoc}
	 * <p>This implementation iterates over this collection, removing each
	 * element using the <tt>Iterator.remove</tt> operation.  Most
	 * implementations will probably choose to override this method for
	 * efficiency.
	 * <p>Note that this implementation will throw an
	 * <tt>UnsupportedOperationException</tt> if the iterator returned by this
	 * collection's <tt>iterator</tt> method does not implement the
	 * <tt>remove</tt> method and this collection is non-empty.
	 *
	 * @throws UnsupportedOperationException {@inheritDoc}
	 */
	public void clear()
	{
		Iterator<E> it = iterator();
		while ( it.hasNext() )
		{
			it.next();
			it.remove();
		}
	}

	//  String conversion

	/**
	 * Returns a string representation of this collection.  The string
	 * 返回這個集合的字符串表示.
	 * representation consists of a list of the collection's elements in the
	 * 這個字符串表示包含集合元素的列表
	 * order they are returned by its iterator, enclosed in square brackets
	 * 由他的迭代器返回的順序的列表,在封閉的括號內
	 * (<tt>"[]"</tt>).  Adjacent elements are separated by the characters
	 *                   合適的元素由逗號和空格分離
	 * <tt>", "</tt> (comma and space).  Elements are converted to strings as
	 *                                   由String.valueOf()方法轉換為字符串.
	 * by {@link String#valueOf(Object)}.
	 *
	 * @return a string representation of this collection
	 */
	public String toString()
	{
		Iterator<E> it = iterator();
		if ( !it.hasNext() ) return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append( '[' );
		for ( ; ; )
		{
			E e = it.next();
			sb.append( e == this ? "(this Collection)" : e );
			if ( !it.hasNext() ) return sb.append( ']' ).toString();
			sb.append( ',' ).append( ' ' );
		}
	}
}
