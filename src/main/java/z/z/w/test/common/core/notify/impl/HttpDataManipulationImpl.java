/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.common.core.notify.impl;

import z.z.w.test.common.core.notify.IDataManipulation;
import z.z.w.test.common.core.notify.entity.NotifyEntity;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.common.core.notify.impl.HttpDataManipulationImpl
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-29 00:04
 *   LastChange: 2015-12-29 00:04
 *      History:
 * </pre>
 **************************************************************************/
public abstract class HttpDataManipulationImpl extends HttpServiceFactory implements IDataManipulation< NotifyEntity >
{

    IDataManipulation< NotifyEntity > reSendDataManipulation = null;
    IDataManipulation< NotifyEntity > succDataManipulation   = null;

    public void operating( NotifyEntity notifyEntity )
    {

    }
}
