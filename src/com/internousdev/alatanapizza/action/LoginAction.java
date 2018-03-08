package com.internousdev.alatanapizza.action;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.LoginDAO;
import com.internousdev.alatanapizza.dto.LoginDTO;
import com.internousdev.alatanapizza.util.ErrorMessageConstants;

//import com.internousdev.alatanapizza.dao.GoCartInfoDAO;
//import com.internousdev.alatanapizza.dto.GoCartInfoDTO;
//import com.internousdev.alatanapizza.dao.DestinationInfoDAO;
//import com.internousdev.alatanapizza.dto.DestinationInfoDTO;
//import com.internousdev.alatanapizza.dto.UserInfoDTO;
//import com.internousdev.alatanapizza.util.ErrorMessageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ログインに必要な情報
	 * 登録した内容
	 * →ID,PASSWORD
	 *
	 * カート内容を引継ぎするために仮IDを本IDで上書きするにはどうするか
	 *× →LoginDAOのほうでPreparedStatementにてSQL文でtemp_user_idをuser_idでUpdateしたので解決？
	 *→id書き換えだけだとログインしていたときにカートに入れていた情報が引き継がれない
	 *→条件によってsql文を使い分ける？
	 *
	 * エラーメッセージ
	 *
	 * くらい？
	 */
	//ログインID
	private String loginId;
	//ログインPASSWORD
	private String loginPassword;
	//処理結果を格納
	private String result;
	//ログイン情報を格納
	public Map<String,Object> session;
	//ログイン情報を取得するDAO
	private LoginDAO loginDAO=new LoginDAO();
	//取得したログイン情報を格納するDTO
	private LoginDTO loginDTO=new LoginDTO();
	//以下エラー時用
	public String idErrorMsg;
	public String passwordErrorMsg;
	//i
	public int i;

	//public ArrayList<UserCreateCompleteDTO>
	//private ArrayList<String> errorMessageList=new ArrayList<>();


//手直し中
	public String execute() throws SQLException{
		result =ERROR;

		session.put("unknown", "");
		session.put("idError", "");
		session.put("passwordError", "");

		//IDについて
//		Pattern p1 =Pattern.compile("^[0-9a-zA-Z]*$");
//		Matcher m1= p1.matcher(loginId);

		//エラー対応ここからの注釈部分はとりあえず写経しただけ　後で改変します
		/*
		if(m1.find()==false){
			String idErrorMsg="IDは半角英数字で入力してください";
			this.idErrorMsg=idErrorMsg;
		}
		int length1=loginId.getBytes().length;
		if(length1<1){//最小文字数よりも少なかった場合


		*/

		loginDTO=loginDAO.loginUserInfo(loginId,loginPassword);

		/**
		 * 管理者画面へのログイン機能
		 */
			if(idErrorMsg==null && passwordErrorMsg==null){
				if(loginDTO.getLoginId().equals(""/*ここに管理者用のIDを入れて*/)){
					if(loginDTO.getLoginPassword().equals(""/*ここに管理者用のPASSを入れて*/)){
						session.put("master_flg", "1");
						session.put("idError", "");
						session.put("passwordError", "");
						result ="master";
						return result;
					}
					/**
					 * 通常ログイン機能
					 * どこからログインしてるかの判定、どこへ戻るのかのコード
					 */
				}else if(loginDTO.getLoginId().equals(loginId)){
					if(loginDTO.getLoginPassword().equals(loginPassword)){
						session.put("trueId", loginId);
						session.put("loginId", loginDTO.getLoginId());//使ってない？
						session.put("loginPass", loginDTO.getLoginPassword());
						session.put("firstName", loginDTO.getFirstName());
						session.put("familyName",loginDTO.getFamilyName());
						session.put("firstNameKana",loginDTO.getFirstNameKana());
						session.put("familyName",loginDTO.getFamilyNameKana());
						session.put("sex",loginDTO.getSex());
						session.put("email", loginDTO.getEmail());

						if(session.get("status")==("settlement"/*決済*/)){
							session.put("idError","");
							session.put("passwordError", "");
							session.put("status","");

							i=loginDAO.cartInfo(session.get("temp_user_id").toString(),loginDTO.getLoginId());

							if(i>=0){
								result ="settlement";
								return result;
							}

						}else if(session.get("status")==("cart"/*カート*/)){
							session.put("idError", "");
							session.put("passwordError", "");
							session.put("status", "");

							i=loginDAO.cartInfo(session.get("temp_user_id").toString(),loginDTO.getLoginId());

							if(i>=0){
								result ="cart";
								return result;
							}

						}else{
							session.put("idError", "");
							session.put("passwordError", "");
							session.put("status", "");

							i=loginDAO.cartInfo(session.get("temp_user_id").toString(),loginDTO.getLoginId());

							if(i>=0){
								result ="myPage";
								return result;
							}

						}

					}else if(loginDTO.getLoginId().equals("noID") || loginDTO.getLoginPassword().equals("noPASS")){
						session.put("unknown","入力されたIDもしくはパスワードが異なります");
						result = ERROR;
						return result;
					}

				}
					session.put("idError",this.idErrorMsg);
					session.put("passwordError", this.passwordErrorMsg);
					return result;
			}
	}
		@Override
		public void setSession(Map<String,Object> session){
			this.session=session;
		}

		public String getLoginId(){
			return loginId;
		}
		public void setLoginId(String loginId){
			this.loginId=loginId;
		}
		public String getLoginPassword(){
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword){
			this.loginPassword=loginPassword;
		}
		public int getI(){
			return i;
		}
		public void setI(int i){
			this.i=i;
		}

	}
/*		String result = ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginId,loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			session.put("login_user_id",loginDTO.getLoginId());
		→これをあとで追加	session.put("loginUser",loginFlg);
			return result;

		}
		return result;
	}
/**
 * カート内容の引継ぎ、仮IDと登録済みIDとのリンク機能、それに関するDBとの通信機能、
 * 未入力欄がある場合のエラーメッセージを追加したい
 * @return
 */
/*
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
*/

}
