package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dao.DestinationDAO;
import com.internousdev.alatanapizza.dao.LoginDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.internousdev.alatanapizza.dto.LoginDTO;
import com.internousdev.alatanapizza.util.ErrorMessageConstants;

//import com.internousdev.alatanapizza.dao.GoCartInfoDAO;
//import com.internousdev.alatanapizza.dto.GoCartInfoDTO;
//import com.internousdev.alatanapizza.dao.DestinationInfoDAO;
//import com.internousdev.alatanapizza.dto.DestinationInfoDTO;
//import com.internousdev.alatanapizza.dto.UserInfoDTO;
//import com.internousdev.alatanapizza.util.ErrorMessageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware,ErrorMessageConstants {


	private String userId;//ユーザーID
	private String password;//パスワード
	private boolean saveLogin;//ID保持
	private Map<String,Object>session;//セッション
	private ArrayList<String> errorMessageList=new ArrayList<>();//jsp側で表示するエラーメッセージを格納するリスト
	//決済ページへ
	private int totalPrice;//合計金額

	private ArrayList<DestinationDTO> destinationInfoListDTO= new ArrayList<DestinationDTO>();//宛先情報一覧
	private ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();//ログインカートリスト

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	public String execute() throws SQLException{


		String result="login";
		LoginDTO loginDTO=new LoginDTO();
		LoginDAO loginDAO=new LoginDAO();


		//ユーザーID入力チェック
		if(userId==null){
			return "login";
		}


		if(userId.equals("")){ //userIdが空欄
			errorMessageList.add("【ユーザーIDを入力してください】");
		}else if(userId.length()<1 || userId.length()>8){ //userIdの長さが1以下か8以上のとき
			errorMessageList.add("【ユーザーIDは1文字以上8文字以下で入力してください】");
		}else if(!userId.matches("^[a-zA-Z0-9]+$")){ //userIdに英数字以外が含まれているとき
			errorMessageList.add("【ユーザーIDは半角英数字で入力してください】");
		}

		//パスワード入力チェック
		if(password.equals("")){ //passwordが空欄
			errorMessageList.add("【パスワードを入力してください】");
		}else if(password.length()<1 || password.length()>8){ //passwordの長さが1以下か8以上のとき
			errorMessageList.add("【パスワードは1文字以上8文字以下で入力してください】");
		}else if(!password.matches("^[a-zA-Z0-9]+$")){ //passwordに英数字以外が含まれているとき
			errorMessageList.add("【パスワードは半角英数字で入力してください】");
		}



		//ID保持
		//jsp側でvalue指定で呼び出す
		if(loginDTO != null){
			if(saveLogin){ //boolean型を使ったif文
				//trueの時の処理
				session.put("saveId", userId);
			}else{
				//falseの時の処理
				session.remove("saveId");
			}
		}

		//ログインチェック
		if(!userId.equals("")){ //Idが空欄ではないとき
			if(!password.equals("")){ //passも空欄ではないとき

				loginDTO=loginDAO.select(userId,password);//userIdとpasswordがどちらも存在する場所からuser_infoを参照

				//ユーザーIDがDBに存在するか確認
				if(!loginDAO.existsUserId(userId)){ //ユーザーIDがない
					errorMessageList.add("【IDが正しくありません】");
					result="login";
				}else if(loginDTO.isMaster()){ //管理者ログイン判定
					session.put("userId", loginDTO.getUserId()); //
					session.put("masterFlg", true);//管理者フラグをたてる
					session.put("loginFlg", true);

					result = "master";

				}else{

					//ログイン判定
					if(userId.equals(loginDTO.getUserId()) && password.equals(loginDTO.getPassword())){ //二つとも一致した場合
						loginDAO.login(loginDTO);

						result=SUCCESS;

						//Mapセッション情報の更新をする
						session.put("userId", loginDTO.getUserId()); //
						session.put("loginFirstName", loginDTO.getFirstName());
						session.put("loginFlg", true); //ログインフラグ立て

						session.put("masterFlg", false);//管理者フラグ立て


						CartInfoDAO cartInfoDAO=new CartInfoDAO(); //newカートリスト
						DestinationDAO destinationDAO=new DestinationDAO(); //new宛先
						ArrayList<CartInfoDTO> tempCartList=new ArrayList<CartInfoDTO>(); //ゲスト用カートリスト


						String tempUserId = session.get("tempUserId").toString();
						for(int i = 0; i < cartList.size(); i++) {
							CartInfoDTO cart = cartList.get(i);
							Integer tempCartId = cartInfoDAO.isAlreadyIntoCart(tempUserId, cart.getProductId(), cart.getPizzaSize(), cart.getToppingIds());
							if (tempCartId != null) {
								for (int j = 0; j < tempCartList.size(); j++) {
									CartInfoDTO tempCart = tempCartList.get(j);
									if (tempCart.getId() == tempCartId) {
										cartInfoDAO.changeProductStock(tempCart.getProductCount(), cart.getId());
										cartInfoDAO.deleteSeparate(tempCart.getId());
									}
								}
							}
						}


						//cartInfoDAO内のchangeUserIdメソッドを使用、SQLのUPDATE文にてtempUserIdに一致するtemp_user_idを
						//持つユーザーのuser_idとtemp_user_idをuserIdで上書きしている
						cartInfoDAO.changeUserId(session.get("tempUserId").toString(),session.get("userId").toString());
						//userIdの情報すべてを引き出すメソッドを代入
						cartList=cartInfoDAO.showUserCartList(session.get("userId").toString());
						destinationInfoListDTO=destinationDAO
								.obtainingDestinationInfo(session.get("userId").toString());


						//カートページから跳んできた場合の判定
						String target =(String) session.get("target");
						if(target != null && session.containsKey("loginFlg")){
							session.remove("target");
						result = "target";
						}

					}else{
						//Passwordが異なる
						errorMessageList.add("【入力されたパスワードが異なります】");
						result="login";
					}

				}

			}else{
				//Passwordが入力されていない
				result ="login";
			}

		}else{
			//IDが入力されていない
			result ="login";

		}


	return result;

	}



	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}

	public boolean isSaveLogin(){ //booleanだからis
		return saveLogin;
	}
	public void setSaveLogin(boolean saveLogin){
		this.saveLogin=saveLogin;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<String> getErrorMessageList(){
		return errorMessageList;
	}
	public void setErrorMessageList(ArrayList<String> errorMessageList){
		this.errorMessageList=errorMessageList;
	}

	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName=familyName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}

	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}

	public String getTelNumber(){
		return telNumber;
	}
	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}

	public String getUserAddress(){
		return userAddress;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}

	public ArrayList<DestinationDTO> getDestinationInfoListDTO(){
		return destinationInfoListDTO;
	}
	public void setDestinationInfoListDTO(ArrayList<DestinationDTO> destinationInfoListDTO){
		this.destinationInfoListDTO=destinationInfoListDTO;
	}

	public ArrayList<CartInfoDTO> getCartList(){
		return cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO> cartList){
		this.cartList=cartList;
	}

	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice=totalPrice;
	}
}

