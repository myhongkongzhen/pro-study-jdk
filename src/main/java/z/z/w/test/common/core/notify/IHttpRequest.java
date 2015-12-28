/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.common.core.notify;

import z.z.w.test.common.core.notify.exception.HttpRequestException;

/**************************************************************************
 * <pre>
 *     FileName: IHttpRequest
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-28 23:56
 *   LastChange: 2015-12-28 23:56
 *      History:
 * </pre>
 **************************************************************************/
public interface IHttpRequest< T >
{
    String send() throws HttpRequestException;

    String httpUrl();

    void httpParam( T t );

    void httpHeader( T t );
}
