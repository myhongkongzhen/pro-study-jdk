/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.service.notify.check;

import z.z.w.test.common.core.notify.ISmsNotify;
import z.z.w.test.facade.notify.check.IDataCheckFacade;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.notify.check.SmsDataCheckService
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-29 00:12
 *   LastChange: 2015-12-29 00:12
 *      History:
 * </pre>
 **************************************************************************/
public class SmsDataCheckService< T > implements IDataCheckFacade< T >
{
    // 實現單發，群發
    private ISmsNotify smsNotify;

    public String notifyDataCheck( T t )
    {
        return null;
    }
}
