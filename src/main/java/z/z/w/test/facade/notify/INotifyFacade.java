/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.facade.notify;

import z.z.w.jdk.collections.Collection;

/**************************************************************************
 * <pre>
 *     FileName: INotifyFacade
 *         Desc: 單發群發功能
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-28 23:34
 *   LastChange: 2015-12-28 23:34
 *      History:
 * </pre>
 **************************************************************************/
public interface INotifyFacade< T >
{
    public String singleSend( T t );

    public String multSend( Collection< T > tList );
}
