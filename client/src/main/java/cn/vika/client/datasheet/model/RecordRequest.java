package cn.vika.client.datasheet.model;

import java.util.HashMap;

import cn.vika.client.api.model.AbstractModel;

/**
 * create record request params
 *
 * @author Zoe Zheng
 * @date 2020-12-17 11:22:01
 */
public class RecordRequest extends AbstractModel {

    private RecordDetail[] records;
    private String fieldKey;

    public RecordDetail[] getRecords() {
        return records;
    }

    public void setRecords(RecordDetail[] records) {
        this.records = records;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    /**
     * request query param to map
     *
     * @param map
     */
    @Override
    public void toMap(HashMap<String, String> map, String prefix) {}
}
