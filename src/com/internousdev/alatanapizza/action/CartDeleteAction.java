package com.internousdev.alatanapizza.action;

import java.util.ArrayList;
import java.util.Map;
import java.sql.*;

//カート内削除アクション　担当：上原→かねごんにバトンタッチします！ごめん

//①ログインしている場合
//		（１）全削除メソッド
//		（２）チェックしたものだけを削除するメソッド
//②ログインしていない場合（ゲストユーザー）
//		（３）全削除メソッド
//		（４）チェックしたものだけを削除するメソッド

//※４つのメソッドを作るのがめんどいと思ったが、これしか方法はない。
//なお、ここでもログインしているか否かは、しっかりと判別する必要あり。



public class CartDeleteAction extends ActionSupport implements SessionAware {
	private String userId;//ユーザーID
	private int tempId;
	private String productId;//商品ID
	private Map<String, Object> session;
	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();
	private String message;



	public String execute() throws SQLException {
		String result = ERROR;
		CartInfoDAO cartdao = new CartInfoDAO();
		CartDeleteDAO deletedao = new CartDeleteDAO();



		//-----------------------------------------------------------------------
		//①ログインしている場合
		if(session.containsKey("userId")){

			//①－(1)全件削除
			if(deletFlg.equals("1")){
			cartInfoList=cartDAO.getCartInfo(session.get("userId").toString());
			deleteAll()
			return "delete";}

			//①－(2)個別削除（チェックしたものだけを削除）
			else if(deleteFlg.equals("2") &&checkList !=null){
			cartInfoList=cartDAO.getCartInfo(session.get("userId").toString());
			for(int i : 0 ; i<cartInfoList.size() ; i++){
			for(String checkId : cheackList){
			int id=Integer.parseInt(checkId);
			CartDeleteDAO.PartDeleteCart(userId,id);
			}}
			return "delete";}

		}


		//-----------------------------------------------------------------------
		//②ログインしていない場合
		if(!session.containsKey("userId")){
				//②－(1)全件削除
			if(deletFlg.equals("1")){
			cartInfoList=cartDAO.getCartInfo(session.get("tempId").toString());
				deleteAllGest();
				retrun result;
				return "delete";}

				//②－(2)個別削除（チェックしたものだけを削除）
			else if(deleteFlg.equals("2") &&checkList !=null){
			cartInfoList=cartDAO.getCartInfo(session.get("tempId").toString());
			for(int i : 0 ; i<cartInfoList.size() ; i++){
			for(String checkId : cheackList){
			int id=Integer.parseInt(checkId);
			CartDeleteDAO.PartDeleteCartGest(tempId,id);}}
			return "delete";}
		}

	}

		//-----------------------------------------------------------------------
		//全件削除のメソッド（ログイン後）
		public void deleteAll(int id)throws SQLException{
		String userId = session.get("userId").toString();
		CartDeleteDAO.AlldeleteCart(userId);
		if(res>0){
		Cartinfo=null;
		setMessage("カートを全て削除しました。");
		}else if(res==0){

		setMessage("カートの削除が失敗しました。");}}


		//-----------------------------------------------------------------------
		//全件削除のメソッド（ログインしていない）
		public void deleteAllGest(int id)throws SQLException{
		String userId = session.get("tempId").toString();
		CartDeleteDAO.AlldeleteGestCart(tempId);
		if(res>0){
		Cartinfo=null;
		setMessage("カートを全て削除しました。");
		}else if(res==0){

		setMessage("カートの削除が失敗しました。");}

		}}












