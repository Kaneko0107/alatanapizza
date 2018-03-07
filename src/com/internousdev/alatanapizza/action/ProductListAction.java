package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ProductListDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.ProductListChange;
import com.opensymphony.xwork2.ActionSupport;


public class ProductListAction extends ActionSupport implements SessionAware {
    //セッション情報取得
	public Map<String, Object> session;
	//商品情報取得
    private ProductListDAO productListDAO = new ProductListDAO();
    //商品情報格納
    public ArrayList<ProductDTO> productList = new ArrayList<>();
    //productListを18個ごとに格納したList
    private ArrayList<ArrayList<ProductDTO>> trueList = new ArrayList<>();
    private int pageSelect;
    private int pageCount;
    private List<Integer> pageList = new ArrayList<>();

    /* 商品情報取得メソッド */
    public String execute() throws SQLException {
        productList = productListDAO.getProductInfo();

        Iterator<ProductDTO> iterator = productList.iterator();
        if(!iterator.hasNext()) {
            this.productList = null;
        }

        //productListを18個ごとに格納
        ProductListChange change = new ProductListChange();
        trueList = change.productListChange(productList);

        for (int i = 0; i < trueList.size(); i++) {
			pageList.add(i + 1);
		}

        for (int i = 0; i < trueList.size(); i++) {
			if (i == pageSelect) {
				productList = trueList.get(i);
				break;
            }
        }

        String result = SUCCESS;
		return result;
    }



    @Override
    public void setSession(Map<String, Object> session) {
       this.session = session;
    }

    public Map<String, Object> getSession() {
       return this.session;
    }

    public ProductListDAO getProductListDAO() {
       return this.productListDAO;
    }

    public void setProductListDAO(ProductListDAO productListDAO) {
       this.productListDAO = productListDAO;
    }

    public ArrayList<ProductDTO> getProductList() {
       return this.productList;
    }

    public void setProductList(ArrayList<ProductDTO> productList) {
       this.productList = productList;
    }

    public ArrayList<ArrayList<ProductDTO>> getTrueList() {
       return this.trueList;
    }

    public void setTrueList(ArrayList<ArrayList<ProductDTO>> trueList) {
       this.trueList = trueList;
    }

    public int getPageSelect() {
       return this.pageSelect;
    }

    public void setPageSelect(int pageSelect) {
       this.pageSelect = pageSelect;
    }

    public List<Integer> getPageList() {
       return this.pageList;
    }

    public void setPageList(List<Integer> pageList) {
       this.pageList = pageList;
    }

    public int getPageCount() {
       return this.pageCount;
    }

    public void setPageCount(int pageCount) {
       this.pageCount = pageCount;
    }
 }