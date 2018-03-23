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

//	private static final String KESSAI="kessai";

	private String userId;//ユーザーID
	private String password;//パスワード
	private boolean saveLogin;//ID保持
	private Map<String,Object>session;//セッション
	private ArrayList<String> errorMessageList=new ArrayList<>();//jsp側で表示するエラーメッセージを格納するリスト
	//決済ページへ
//	private int kessai;
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

		//if("loginFlg".equals(true)){
		//	loginFlgMessageList.add("すでにログイン済みです");
		//}else if("loginFlg".equals(false)){
		//	loginFlgMessageList.add("未ログイン");
		//}
		String result=ERROR;
		LoginDTO loginDTO=new LoginDTO();
		LoginDAO loginDAO=new LoginDAO();

		//ユーザーID入力チェック
		if(userId==null){
			return "login";
		}
		if(userId.equals("")){ //userIdが空欄
			errorMessageList.add("ユーザーIDを入力してください");
		}else if(userId.length()<1 || userId.length()>8){ //userIdの長さが1以下か8以上のとき
			errorMessageList.add("ユーザーIDは1文字以上8文字以下で入力してください");
		}else if(!userId.matches("^[a-zA-Z0-9]+$")){ //userIdに英数字以外が含まれているとき
			errorMessageList.add("ユーザーIDは半角英数字で入力してください");
		}

		//パスワード入力チェック
		if(password.equals("")){ //passwordが空欄
			errorMessageList.add("パスワードを入力してください");
		}else if(password.length()<1 || password.length()>8){ //passwordの長さが1以下か8以上のとき
			errorMessageList.add("パスワードは1文字以上8文字以下で入力してください");
		}else if(!password.matches("^[a-zA-Z0-9]+$")){ //passwordに英数字以外が含まれているとき
			errorMessageList.add("パスワードは半角英数字で入力してください");
		}

		//ID保持
		//jsp側でvalue指定で呼び出す
		if(loginDTO != null){
			if(saveLogin){ //boolean型を使ったif文
				//trueの時の処理
				//System.out.println("ID保持=="+userId);
				session.put("saveId", userId);
			}else{
				//falseの時の処理
				//System.out.println("ID保持は希望しない");
				session.remove("saveId");
			}
		}

		//ログインチェック
		if(!userId.equals("")){ //Idが空欄ではないとき
			if(!password.equals("")){ //passも空欄ではないとき

				loginDTO=loginDAO.select(userId,password);

				//ユーザーIDがDBに存在するか確認
				if(!loginDAO.existsUserId(userId)){ //ユーザーIDがない
					errorMessageList.add("IDが正しくありません");
					result=ERROR;
				}else if(loginDTO.isMaster()){ //管理者ログイン判定
					session.put("userId", loginDTO.getUserId()); //
					session.put("masterFlg", true);//管理者フラグをたてる
					session.put("loginFlg", true);
					//System.out.println("管理者フラグ=true");
					//System.out.println("管理者ログイン");
					result = "master";

				}else{

					//ログイン判定
					if(userId.equals(loginDTO.getUserId()) && password.equals(loginDTO.getPassword())){ //二つとも一致した場合
						loginDAO.login(loginDTO);
						//System.out.println("ログイン成功");
						result=SUCCESS;

						//Mapセッション情報の更新をする
						session.put("userId", loginDTO.getUserId()); //
						session.put("loginFirstName", loginDTO.getFirstName());
						session.put("loginFlg", true); //ログインフラグ立て
						//System.out.println("ログインフラグ=true");
						session.put("masterFlg", false);//管理者フラグ立て
						//System.out.println("管理者フラグ=false");

						CartInfoDAO cartInfoDAO=new CartInfoDAO(); //newカートリスト
						DestinationDAO destinationDAO=new DestinationDAO(); //new宛先
						ArrayList<CartInfoDTO> tempCartList=new ArrayList<CartInfoDTO>(); //ゲスト用カートリスト
						//ArrayList<Integer> productIdList=new ArrayList<Integer>(); //整数型　製品リスト
						//ArrayList<Integer> tempProductIdList=new ArrayList<Integer>(); //整数型　ゲスト用製品リスト

						//Mapのsessionから取得するのでString型として取得したuserIdのカート情報をすべて引き出すメソッドを代入
						cartList=cartInfoDAO.showUserCartList(session.get("userId").toString());
						//tempUserIdのカート情報をすべて引き出すメソッドを代入
						tempCartList=cartInfoDAO.showUserCartList(session.get("tempUserId").toString());

						//ログイン後のカートの中身を生成
						//int i=0;
						//for(i=0;i<cartList.size();i++){
						//	productIdList.add(cartList.get(i).getProductId());
						//}

						//ゲスト時のカートの中身をリストとして生成
						//i=0;
						//for(i=0;i<tempCartList.size();i++){
						//	tempProductIdList.add(tempCartList.get(i).getProductId());
						//}

//						//カートの中身の重複を確認
//						if(cartList.size()<tempCartList.size()){ //ログイン時のカートリスト < ゲスト用のカートリスト
//							i=0;
//							for(i=0;i<productIdList.size();i++){
//
//								boolean exist=tempProductIdList.contains(productIdList.get(i));
//								if(exist){
//									cartInfoDAO.changeProductStock(Integer.valueOf(cartList.get(i).getProductCount()),
//											Integer.valueOf(productIdList.get(i)),session.get("userId").toString());
//									//BuyItemCompleteActionにて合計金額の算出コードの記載あるのでこちらではいらない？
//									cartInfoDAO.deleteSeparate(session.get("tempUserId").toString(),
//											Integer.valueOf(productIdList.get(i)));
//								}else{
//									cartInfoDAO.changeUserId(session.get("tempUserId").toString(),
//											session.get("userId").toString());
//								}
//								//System.out.println("TEST1"+exist);
//							}
//
//						}else{ //ログインカートリスト < ゲスト用カートリスト　以外のケース
//							i=0;
//							for(i=0;i<tempProductIdList.size();i++){
//
//								boolean exist=productIdList.contains(tempProductIdList.get(i));
//								if(exist){
//									cartInfoDAO.changeProductStock(Integer.valueOf(cartList.get(i).getProductCount()),
//											Integer.valueOf(productIdList.get(i)),session.get("userId").toString());
//									cartInfoDAO.deleteSeparate(session.get("tempUserId").toString(),
//											Integer.valueOf(tempProductIdList.get(i)));
//								}else{
//									cartInfoDAO.changeUserId(session.get("tempUserId").toString(),
//											session.get("userId").toString());
//								}
//								//System.out.println("TEST2"+ exist);
//							}
//						}
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

//						//合計金額の計算
//						totalPrice=calcTotalPrice(cartList); //calc==計算　の意味
//
//						//カート、宛先情報を引き継ぐ
//						System.out.println("kessai:"+kessai);
//
//						if(kessai==1){
//							if((boolean) session.get("loginFlg")){
//								destinationInfoListDTO=destinationDAO
//										.obtainingDestinationInfo(session.get("userId").toString());
//							}
//
//							if(destinationInfoListDTO.size()>0){
//								result=SUCCESS;
//							}else if(!(boolean) session.get("loginFlg")){
//								result=ERROR;
//								kessai=1;
//								return result;
//							}else{
//								result="destination";
//								return result;
//							}
//
//							System.out.println("LoginAction:kessaiは1");
//
//							//合計金額の計算
//							totalPrice=calcTotalPrice(cartList);
//							return KESSAI;
//						}

					}else{
						errorMessageList.add("入力されたパスワードが異なります。");
						result=ERROR;
					}

				}

			}else{
				//System.out.println("Passwordが入力されていません");
				result =ERROR;
			}

		}else{
			//System.out.println("IDが入力されていません");
			result =ERROR;
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

//	public int getKessai(){
//		return kessai;
//	}
//	public void setKessai(int kessai){
//		this.kessai=kessai;
//	}

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

	//合計金額を計算するメソッド
	public int calcTotalPrice(ArrayList<CartInfoDTO> cartList){
		int totalPrice = 0; //初期合計金額0
		for(CartInfoDTO cartInfoDTO : cartList){ //拡張for文　for(型 変数名 : 式){文}
			//cartInfoDTOにcartListの値を代入して配列の数だけcartInfoDTOの表示を繰り返す
			totalPrice += cartInfoDTO.getPrice() * cartInfoDTO.getProductCount();
			System.out.println("合計" + totalPrice + "円");
		}
		return totalPrice;
	}

	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice=totalPrice;
	}
}

