package com.example.a71033.nct_v1.module.model;

import com.example.a71033.nct_v1.common.BaseResponse;

import java.util.List;

/**
 * Created by 71033 on 2017/10/11.
 */

public class AmoyResponse extends BaseResponse {

    private List<Amoy> amoyList;


    public List<Amoy> getAmoyList() {
        return amoyList;
    }

    public void setAmoyList(List<Amoy> amoyList) {
        this.amoyList = amoyList;
    }

    public static class Amoy{

        private String typeName;

        private String typeId;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        @Override
        public String toString() {
            return "Amoy{" +
                    "typeName='" + typeName + '\'' +
                    ", typeId='" + typeId + '\'' +
                    '}';
        }
    }
}
