/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.common.core.notify;

import z.z.w.test.common.core.notify.exception.DataManipulationException;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.common.core.notify.IHttpResponse
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-28 23:57
 *   LastChange: 2015-12-28 23:57
 *      History:
 * </pre>
 **************************************************************************/
public interface IHttpResponse< T, W >
{
    T parseResult( W w ) throws DataManipulationException;
}
