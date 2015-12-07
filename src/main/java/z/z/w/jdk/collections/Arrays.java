/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.jdk.collections;

import java.lang.reflect.Array;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.jdk.collections.Arrays
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-07 15:27
 *   LastChange: 2015-12-07 15:27
 *      History:
 * </pre>
 *********************************************************************************************/
public class Arrays
{
	// Cloning

	/**
	 * Copies the specified array, truncating or padding with nulls (if necessary)
	 * 拷貝指定的數組，用null截斷或者填充(如果必須的)
	 * so the copy has the specified length.  For all indices that are
	 * 因此這個拷貝有一個指定的長度.
	 * valid in both the original array and the copy, the two arrays will
	 * 對於所有的在元array與拷貝array中有效的指數,
	 * contain identical values.  For any indices that are valid in the
	 * 兩個數組將包含相同的值.
	 * copy but not the original, the copy will contain <tt>null</tt>.
	 * 對於一些在copy中但不在元數組中的指標,拷貝將包含null.
	 * Such indices will exist if and only if the specified length
	 * 一些指標當且僅當在指定的長度時存在比起元數組更長
	 * is greater than that of the original array.
	 * The resulting array is of exactly the same class as the original array.
	 * 返回的數組恰好與元數組相同的類.
	 *
	 * @param original the array to be copied
	 *                 要拷貝的原數組
	 * @param newLength the length of the copy to be returned
	 *                  拷貝數組要返回的長度
	 * @return a copy of the original array, truncated or padded with nulls
	 *         返回一個原數組的拷貝,
	 *     to obtain the specified length
	 *     用null截斷或者填充來獲得一個指定的長度.
	 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
	 *                                    如果長度為負數
	 * @throws NullPointerException if <tt>original</tt> is null
	 *                              如果元數組為null
	 * @since 1.6
	 */
	public static <T> T[] copyOf(T[] original, int newLength) {
		return (T[]) copyOf(original, newLength, original.getClass());
	}

	/**
	 * Copies the specified array, truncating or padding with nulls (if necessary)
	 * so the copy has the specified length.  For all indices that are
	 * valid in both the original array and the copy, the two arrays will
	 * contain identical values.  For any indices that are valid in the
	 * copy but not the original, the copy will contain <tt>null</tt>.
	 * Such indices will exist if and only if the specified length
	 * is greater than that of the original array.
	 * The resulting array is of the class <tt>newType</tt>.
	 *
	 * @param original the array to be copied
	 * @param newLength the length of the copy to be returned
	 * @param newType the class of the copy to be returned
	 * @return a copy of the original array, truncated or padded with nulls
	 *     to obtain the specified length
	 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
	 * @throws NullPointerException if <tt>original</tt> is null
	 * @throws ArrayStoreException if an element copied from
	 *     <tt>original</tt> is not of a runtime type that can be stored in
	 *     an array of class <tt>newType</tt>
	 * @since 1.6
	 */
	public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
		/* 類型判斷 */
		T[] copy = ((Object)newType == (Object)Object[].class)
				   ? (T[]) new Object[newLength]
				   : (T[]) Array.newInstance( newType.getComponentType(), newLength);
		/* native 本地數組拷貝算法 */
		System.arraycopy(original, 0, copy, 0,
						 Math.min(original.length, newLength));
		return copy;
	}
}
