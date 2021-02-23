/*
 * Copyright (C) 2021 vikadata
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package cn.vika.core.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * a client-side HTTP request
 *
 * @author Shawn Deng
 * @date 2020-10-26 19:09:21
 */
public interface ClientHttpRequest {

    /**
     * Return the headers of this message.
     *
     * @return a corresponding {@link HttpHeader} object (never {@code null})
     */
    HttpHeader getHeaders();

    /**
     * Return the body of the message as an output stream.
     *
     * @return the output stream body (never {@code null})
     * @throws IOException in case of I/O errors
     */
    OutputStream getBody() throws IOException;

    /**
     * Execute request
     *
     * @return the response result of the execution
     * @throws IOException in case of I/O errors
     */
    ClientHttpResponse execute() throws IOException;
}