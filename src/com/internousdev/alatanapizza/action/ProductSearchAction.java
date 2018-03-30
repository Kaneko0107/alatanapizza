package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ProductSearchDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.AllPages;
import com.internousdev.alatanapizza.util.PageObject;
import com.internousdev.alatanapizza.util.ToHiragana;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * @author kei-kenmochi
 *
 */

public class ProductSearchAction extends ActionSupport implements SessionAware {
	private String searchWord = null;
	private String searchWordHiragana;
	private int categoryId;
	private int pageNum;
	private int number;
	private int searchFlg;
	private ProductSearchDAO searchDAO = new ProductSearchDAO();
	private ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();

	private String[] searchWords;

	public Map<String, Object> session;
	private ArrayList<String> msgList = new ArrayList<String>();

	/**
	* 検索数
	*/
	private int maxPage;
	public ArrayList<ProductDTO> displaySearchList = new ArrayList<ProductDTO>();


	public String execute() throws SQLException {

		if (categoryId == 0){
			return "target";
		}

		String result = ERROR;


		if (searchWord.length() > 16) {
			msgList.add("16字以内で検索してください");
			result = SUCCESS;
			return result;
		} else {
			msgList.add(searchWord);
		}

		ToHiragana toHiragana = new ToHiragana();
		/*---------------------------------------------------------
				検索値を全て全角に変換、適切な値に加工
		-----------------------------------------------------------*/
	    searchWordHiragana = Normalizer.normalize(searchWord, Normalizer.Form.NFKC);
		searchWordHiragana = toHiragana.toZenkakuHiragana(searchWordHiragana);

		searchWordHiragana = searchWordHiragana.trim();
		if (searchWordHiragana.matches("^[\\p{Punct}]+$")) {
			msgList.add("一般的な検索ワードを使ってください");
			result = SUCCESS;
			return result;
		}



		/*---------------------------------------------------------
		 *       検索値が複数あった場合
		 ----------------------------------------------------------*/
		int kuuhakunobasho = searchWordHiragana.indexOf(" ");
		String[] searchWords = null;
		String[] keywords = null;

		if (kuuhakunobasho > 0) {

			/*
			 * searchWordHiraganaを空白の場所ごとに分解
			 */
			searchWords = searchWordHiragana.replace("　", " ").split("[\\s]+");

			/*
			 * searchWordを空白の場所ごとに分解
			 */
			keywords = searchWord.replace("　", " ").split("[\\s]+");

		}



        /*-----------------------------------------------------------------
         *            検索機能
         -------------------------------------------------------------------*/


        if (categoryId == 1) {
        	//全てのカテゴリーを選択した場合
//        	if (!(searchWord.isEmpty())) {
        	if (!(searchWord.isEmpty())) {
        		//検索ワードを入力した場合
        		if (kuuhakunobasho > 0) {
        			//検索ワードが複数あった場合
        			searchDTOList = searchDAO.byWords(searchWords, keywords, categoryId);
        		} else {
        			//検索ワードが一つだった場合
        			searchDTOList = searchDAO.bySearchWord(searchWordHiragana, searchWord, categoryId);
        		}
        	} else {
        		//検索ワードを入力しなかった場合
        		searchDTOList = searchDAO.byProductCategory(categoryId);
        	}

        	pageNation(number);
        	result = SUCCESS;

        } else if (categoryId > 1 && categoryId < 5){
        	//「全てのカテゴリー」以外を選択した場合
        	if (!(searchWord.isEmpty())) {
        		//検索ワードを入力した場合
        		if (kuuhakunobasho > 0) {
        			//検索ワードが複数あった場合
        			searchDTOList = searchDAO.byWords(searchWords, keywords, categoryId);
        		} else {
        			//検索ワードが一つだった場合
        			searchDTOList = searchDAO.bySearchWord(searchWordHiragana, searchWord, categoryId);
        		}
        	} else {
        		//検索ワードを入力しなかった場合
        		searchDTOList = searchDAO.byProductCategory(categoryId);

        	}

        	pageNation(number);
        	result = SUCCESS;

        } else {
        	categoryId = 1;
        	searchDTOList = searchDAO.byProductCategory(categoryId);
        	pageNation(number);
        }

		return result;
	}



	public void pageNation(int number) {

		//商品の数をnumberに格納
        this.number = searchDTOList.size();

        Iterator<ProductDTO> iterator = searchDTOList.iterator();
        if(!iterator.hasNext()) {
            searchDTOList = null;
        }

        if(this.number > 0) {
			//ページネーション処理
			ArrayList<PageObject> allPages = new ArrayList<PageObject>();
			AllPages allp = new AllPages();
			allPages=allp.paginate(searchDTOList, 9);
			setMaxPage(allp.getMaxPage(searchDTOList, 9));
			setDisplaySearchList(allPages.get(pageNum-1).getPaginatedList());

		}
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public ArrayList<ProductDTO> getDisplaySearchList() {
		return displaySearchList;
	}

	public void setDisplaySearchList(ArrayList<ProductDTO> displaySearchList) {
		this.displaySearchList = displaySearchList;
	}

	public ProductSearchDAO getSearchDAO() {
		return searchDAO;
	}

	public void setSearchDAO(ProductSearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}

	public ArrayList<ProductDTO> getSearchDTOList() {
		return searchDTOList;
	}

	public void setSearchDTOList(ArrayList<ProductDTO> searchDTOList) {
		this.searchDTOList = searchDTOList;
	}

	public ArrayList<String> getMsgList() {
		return msgList;
	}

	public void setMsgList(ArrayList<String> msgList) {
		this.msgList = msgList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String[] getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String[] searchWords) {
		this.searchWords = searchWords;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getSearchFlg() {
		return searchFlg;
	}

	public void setSearchFlg(int searchFlg) {
		this.searchFlg = searchFlg;
	}


}
