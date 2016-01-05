/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.service.notify;

import z.z.w.jdk.collections.Collection;
import z.z.w.test.common.core.notify.entity.NotifyEntity;
import z.z.w.test.facade.notify.INotifyFacade;
import z.z.w.test.facade.notify.check.IDataCheckFacade;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.notify.MailNotifyService
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-28 23:37
 *   LastChange: 2015-12-28 23:37
 *      History:
 * </pre>
 **************************************************************************/
public class MailNotifyService implements INotifyFacade< NotifyEntity >
{
    // 郵件數據校驗
    IDataCheckFacade dataCheckFacade;

    public String singleSend( NotifyEntity notifyEntity )
    {
        return null;
    }

    public String multSend( Collection< NotifyEntity > tList )
    {
        return null;
    }
}
