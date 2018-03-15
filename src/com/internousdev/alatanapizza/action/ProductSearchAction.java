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
	private String searchWord;
	private String searchWordHiragana;
	private int categoryId;
	private int pageNum;
	private int number;
	private int serachFlg;
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
		System.out.println("CATEGORYID:"+categoryId);
		String ret = ERROR;

		if (searchWord.length() > 16) {
			msgList.add("16字以内で検索してください");
			ret = SUCCESS;
			return ret;
		} else {
			msgList.add(searchWord);
		}

		ToHiragana toHiragana = new ToHiragana();
		/*---------------------------------------------------------
				検索値を全て全角に変換、適切な値に加工
		-----------------------------------------------------------*/
	    searchWordHiragana = Normalizer.normalize(searchWord, Normalizer.Form.NFKC);
		searchWordHiragana = toHiragana.toZenkakuHiragana(searchWordHiragana);
		System.out.println(searchWordHiragana);
		searchWordHiragana = searchWordHiragana.trim();
		if (searchWordHiragana.matches("^[\\p{Punct}]+$")) {
			msgList.add("一般的な検索ワードを使ってください");
			ret = SUCCESS;
			return ret;
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
			for (String str : searchWords) {
				System.out.println(str);
			}

			/*
			 * searchWordを空白の場所ごとに分解
			 */
			keywords = searchWord.replace("　", " ").split("[\\s]+");
			for (String str : keywords) {
				System.out.println(str);
			}
		}



        /*-----------------------------------------------------------------
         *            検索機能
         -------------------------------------------------------------------*/

        if (categoryId == 1) {

        	if (!(searchWord.isEmpty())) {

        		if (kuuhakunobasho > 0) {

        			searchDTOList = searchDAO.byWordsAllCategory(searchWords, keywords);
        		} else {
        			searchDTOList = searchDAO.bySearchWordAllCategory(searchWordHiragana, searchWord);
        		}

        	} else {

        		searchDTOList = searchDAO.allProductInfo();
        	}
        }

        else {

        	if (!(searchWord.isEmpty())) {

        		if (kuuhakunobasho > 0) {
        			searchDTOList = searchDAO.byWords(searchWords, keywords, categoryId);
        		} else {
        			searchDTOList = searchDAO.bySearchWord(searchWordHiragana, searchWord, categoryId);
        			System.out.println("bySearchWord");
        		}

        	} else {

        		searchDTOList = searchDAO.byProductCategory(categoryId);
        		System.out.println("byProductCategory");

        	}

        }

        number = searchDTOList.size();
        System.out.println("number = " + number);



        Iterator<ProductDTO> iterator = searchDTOList.iterator();
        if(!iterator.hasNext()) {
            this.searchDTOList = null;
        }

        if(number > 0) {
			//ページネーション処理
			ArrayList<PageObject> allPages = new ArrayList<PageObject>();
			AllPages allp = new AllPages();
			allPages=allp.paginate(searchDTOList, 9);
			setMaxPage(allp.getMaxPage(searchDTOList, 9));
			setDisplaySearchList(allPages.get(pageNum-1).getPaginatedList());

		}

        ret = SUCCESS;


		/*-----------------------------------------------------------
	      全てのカテゴリーから商品を検索
	 -------------------------------------------------------------

  else if (categoryId == 1 && !(searchWordHiragana.isEmpty())) {
  	searchDTOList = searchDAO.byAllProductCategory(searchWord, searchWordHiragana);
  }

		/*---------------------------------------------------------
		             サイドメニューまたはドリンクを検索
        -----------------------------------------------------------
        else if (categoryId > 2 && !(searchWordHiragana.isEmpty())) {
	    searchDTOList = searchDAO.ByProductCategory(categoryId);
	    ret = SUCCESS;
        }
        */

		/*---------------------------------------------------------
				サイドメニューまたはドリンクを全件検索(検索値なし)
		-----------------------------------------------------------
		else if (categoryId > 2 && searchWordHiragana.isEmpty()) {
			searchDTOList = searchDAO.ByProductCategory(categoryId);
			ret = SUCCESS;
		}
		*/





		searchWordHiragana = searchWord;
		return ret;
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

	public int getSerachFlg() {
		return serachFlg;
	}

	public void setSerachFlg(int serachFlg) {
		this.serachFlg = serachFlg;
	}


}
