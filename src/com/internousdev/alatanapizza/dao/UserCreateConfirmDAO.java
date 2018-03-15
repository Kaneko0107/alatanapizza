package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.internousdev.alatanapizza.util.DBConnector;

public class UserCreateConfirmDAO {
	//ユーザー情報取得元データベース"db"
		private DBConnector db = new DBConnector();
	//"db"に接続する"con"
		private Connection con = db.getConnection();
	//resultに初期値falseを代入
		private boolean result =false;
	//ユーザー登録情報を格納しておくMap
		public Map<String, Object> session;


		//UserCreate.jspで入力した"loginUserId"と"loginPassword"を当てはめる
		public boolean getUserInfo(String loginUserId, String loginPassword){
			//sqlにある"login_user_transaction"テーブルを"sql"に代入
			String sql="SELECT * FROM user_info";
			try{
				//上の"sql"に接続することを"ps"に代入
				PreparedStatement ps = con.prepareStatement(sql);
				//接続実行した事を"rs"に代入
				ResultSet rs = ps.executeQuery();


				//"login_id"カラムにある情報とUserCreate.jspで入力した"loginUserId"がダブらないか検証
				while(rs.next()){
					//2.loginIdに代入     ↓1."login_id"カラムを呼び出して
					String loginId = rs.getString("login_id");
					//もしUserCreate.jspで入力した"loginUserId"とloginIdが等しかったら
					if(loginId.equals(loginUserId)){
						//既に使われているのでresultにfalseを代入
						result = false;
						//結果を"result"に格納
						return result;
					//既に使われていなかったらresultにtrueを代入(新規登録できる)
					}else{
						result = true;
					}
				}
			//例外が起きて"sql"に接続できなかったら
			}catch(Exception e){
				//標準例外メソッドの"printStackTrace"を呼び出す
				e.printStackTrace();
			}
			//try,catchの結果を"result"に格納
			return result;
		}

		public Map<String, Object> getSession(){
			return session;
		}
		public void setSession(Map<String, Object> session){
			this.session=session;
		}

}
































/*
public class UserCreateConfirmDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	 private boolean result;



	 ログインID重複確認メソッド
	public boolean getLoginUserId(String loginUserId) {

		String sql="SELECT*FROM user_info where user_id=?";

		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet=preparedStatement.executeQuery();

			if (resultSet.next()) {
            	result=true;
			}

		} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
}  */



