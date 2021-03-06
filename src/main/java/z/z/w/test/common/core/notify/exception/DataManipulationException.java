/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.common.core.notify.exception;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.common.core.notify.exception.DataManipulationException
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-28 23:58
 *   LastChange: 2015-12-28 23:58
 *      History:
 * </pre>
 **************************************************************************/
public class DataManipulationException extends RuntimeException
{
    public DataManipulationException()
    {
        super();
    }

    public DataManipulationException( String s )
    {
        super( s );
    }

    public DataManipulationException( String s, Throwable throwable )
    {
        super( s, throwable );
    }

    @Override
    public synchronized Throwable fillInStackTrace()
    {
        return super.fillInStackTrace();
    }
}
