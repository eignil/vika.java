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

package cn.vika.client.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Create Record Model
 * @author Shawn Deng
 * @date 2021-02-19 15:41:12
 */
public class CreateRecordRequest {

    @JsonInclude(Include.NON_NULL)
    private FieldKey fieldKey;

    private List<RecordMap> records;

    public FieldKey getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(FieldKey fieldKey) {
        this.fieldKey = fieldKey;
    }

    public List<RecordMap> getRecords() {
        return records;
    }

    public void setRecords(List<RecordMap> records) {
        this.records = records;
    }

    public CreateRecordRequest withRecords(List<RecordMap> records) {
        this.records = records;
        return this;
    }

    public CreateRecordRequest withFieldKey(FieldKey fieldKey) {
        this.fieldKey = fieldKey;
        return this;
    }
}
