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

package cn.vika.client.api.datasheet;

import cn.vika.client.api.model.AbstractModel;
import cn.vika.client.api.model.HttpResult;
import cn.vika.core.http.GenericTypeReference;

/**
 * attachment api
 *
 * @author Zoe Zheng
 * @date 2020-12-17 16:15:54
 */
public interface IAttachmentApi {

    /**
     * upload datasheet attachment
     *
     * @param params add attachment data
     * @param responseType response type
     * @return responseType
     */
    <T> T uploadAttachment(String datasheetId, AbstractModel params, GenericTypeReference<HttpResult<T>> responseType) throws Exception;
}
