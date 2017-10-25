package com.example.a71033.nct_v1.module.model;

import com.example.a71033.nct_v1.common.BaseResponse;

import java.util.List;

/**
 * Created by 71033 on 2017/10/25.
 */

public class ProListResponse extends BaseResponse {

    private List<Product> proList;

    public List<Product> getProducts() {
        return proList;
    }

    public List<Product> getProList() {
        return proList;
    }

    public void setProList(List<Product> proList) {
        this.proList = proList;
    }

    public static class Product{
        private String proName;
        private String proPresentPrice;
        private String proOriginalPrice;
        private String proIcon;
        private String proType;
        private String proVersion;
        private String proDes;
        private List<ProductDetailFigure> lists;

        public String getProName() {
            return proName;
        }

        public void setProName(String proName) {
            this.proName = proName;
        }

        public String getProPresentPrice() {
            return proPresentPrice;
        }

        public void setProPresentPrice(String proPresentPrice) {
            this.proPresentPrice = proPresentPrice;
        }

        public String getProOriginalPrice() {
            return proOriginalPrice;
        }

        public void setProOriginalPrice(String proOriginalPrice) {
            this.proOriginalPrice = proOriginalPrice;
        }

        public String getProIcon() {
            return proIcon;
        }

        public void setProIcon(String proIcon) {
            this.proIcon = proIcon;
        }

        public String getProType() {
            return proType;
        }

        public void setProType(String proType) {
            this.proType = proType;
        }

        public String getProVersion() {
            return proVersion;
        }

        public void setProVersion(String proVersion) {
            this.proVersion = proVersion;
        }

        public String getProDes() {
            return proDes;
        }

        public void setProDes(String proDes) {
            this.proDes = proDes;
        }

        public List<ProductDetailFigure> getLists() {
            return lists;
        }

        public void setLists(List<ProductDetailFigure> lists) {
            this.lists = lists;
        }
    }




    public static class ProductDetailFigure{
        private String proDetailFigureURL;

        public String getProDetailFigureURL() {
            return proDetailFigureURL;
        }

        public void setProDetailFigureURL(String proDetailFigureURL) {
            this.proDetailFigureURL = proDetailFigureURL;
        }
    }
}
