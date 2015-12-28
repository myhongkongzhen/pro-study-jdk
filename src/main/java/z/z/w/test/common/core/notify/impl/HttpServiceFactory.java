/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.common.core.notify.impl;

import z.z.w.test.common.core.notify.IHttpRequest;
import z.z.w.test.common.core.notify.IHttpResponse;
import z.z.w.test.common.core.notify.entity.NotifyEntity;
import z.z.w.test.common.core.notify.exception.HttpRequestException;

import java.util.Map;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.common.core.notify.impl.HttpServiceFactory
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-29 00:01
 *   LastChange: 2015-12-29 00:01
 *      History:
 * </pre>
 **************************************************************************/
public abstract class HttpServiceFactory implements IHttpRequest< NotifyEntity >, IHttpResponse< NotifyEntity, NotifyEntity >
{
    protected Map< String, String > param  = null;
    protected Map< String, String > header = null;

    public String httpReq() throws HttpRequestException
    {
//        HttpClientUtil.INSTANCE.httpPost( httpUrl(), param, header );
        return null;
    }
}
