package com.internousdev.alatanapizza.util;

public class InputChecker {

	//入力チェック全般を担当するシステム
	public String familyNameChk(String familyName){
		String result ="OK";

		if(familyName.equals("")){
			result ="【姓を入力してください】";
		}else if(familyName.length() <1 || familyName.length() >16){
			result ="【姓は1文字以上16文字以下で入力してください】";
		}else if(!familyName.matches("^[a-zA-Zぁ-ゞ一-龠々]+$")){
			//"^[]+$"で囲われたうちのどれか一文字が使われたとき以外の時
			//※^は否定の意味ではなく行の先頭の意味で使われているので注意　正規表現で検索
			result ="【姓は半角英語、漢字、ひらがなで入力してください】";
		}
		return result;
	}

	public String firstNameChk(String firstName){
		String result ="OK";

		if(firstName.equals("")){
			result ="【名を入力してください】";
		}else if(firstName.length() <1 || firstName.length() >16){
			result ="【名は1文字以上16文字以下で入力してください】";
		}else if(!firstName.matches("^[a-zA-Zぁ-ゞ一-龠々]+$")){
			result ="【名は半角英語、漢字、ひらがなで入力してください】";
		}

		return result;
	}

	public String familyNameKanaChk(String familyNameKana){
		String result ="OK";

		if(familyNameKana.equals("")){
			result ="【姓のふりがなを入力してください】";
		}else if(familyNameKana.length() <1 || familyNameKana.length() >16){
			result ="【姓のふりがなは1文字以上16文字以下で入力してください】";
		}else if(!familyNameKana.matches("^[ぁ-ゞ]+$")){
			result ="【姓のふりがなはひらがなで入力してください】";
		}
		return result;
	}

	public String firstNameKanaChk(String firstNameKana){
		String result ="OK";

		if(firstNameKana.equals("")){
			result ="【名のふりがなを入力してください】";
		}else if(firstNameKana.length() <1 || firstNameKana.length() >16){
			result ="【名のふりがなは1文字以上16文字以下で入力してください】";
		}else if(!firstNameKana.matches("^[ぁ-ゞ]+$")){
			result ="【名のふりがなはひらがなで入力してください】";
		}
		return result;
	}

	public String userIdChk(String userId){
		String result ="OK";

		if(userId.equals("")){
			result ="【ユーザーIDを入力してください】";
		}else if(userId.length() <1 || userId.length() >8){
			result ="【ユーザーIDは1文字以上8文字以下で入力してください】";
		}else if(!userId.matches("^[a-zA-Z0-9]+$")){
			result ="【ユーザーIDは半角英数字で入力してください】";
		}
		return result;
	}

	public String passwordChk(String password){
		String result ="OK";

		if(password.equals("")){
			result ="【パスワードを入力してください】";
		}else if(password.length() <1 || password.length() >16){
			result ="【パスワードは1文字以上16文字以下で入力してください】";
		}else if(!password.matches("^[a-zA-Z0-9]+$")){
			result ="【パスワードは半角英数字で入力してください】";
		}
		return result;
	}

	public String passwordcChk(String passwordc,String password){
		String result ="OK";

		if(passwordc.equals("")){
			result ="【再確認パスワードを入力してください】";
		}else if(passwordc.length() <1 || passwordc.length() >16){
			result ="【再確認パスワードは1文字以上16文字以下で入力してください】";
		}else if(!passwordc.matches("^[a-zA-Z0-9]+$")){
			result ="【再確認パスワードは半角英数字で入力してください】";
		}else if(!(passwordc.equals(password))){ //passwordc ==passwordではない時
			result ="【入力されたパスワードが異なります】";
		}
		return result;
	}

	public String zip11Chk(String zip11){
		String result ="OK";

		if(zip11.equals("")){
			result ="【郵便番号を入力してください】";
		}else if(zip11.length() <7 || zip11.length() >8){
			result ="【郵便番号は7文字以上8文字以下で入力してください】";
		}else if(!zip11.matches("^[0-9-]+$")){
			result ="【郵便番号は半角数字で入力してください】";
		}
		return result;

	}

	public String addr11Chk(String addr11){
		String result ="OK";

		if(addr11.equals("")){
			result ="【住所を入力してください】";
		}else if(addr11.length() <15 || addr11.length() >50){
			result ="【住所は15文字以上50文字以下で入力してください】";
		}else if(!addr11.matches("^[a-zA-Z0-9ぁ-ゞァ-ヾ一-龠々!-~]+$")){
			result ="【住所は半角英数字、漢字、ひらがな、カタカナおよび半角記号で入力してください】";
		}
		return result;

	}

	public String telNumberChk(String telNumber){
		String result ="OK";

		if(telNumber.equals("")){
			result ="【電話番号を入力してください】";
		}else if(telNumber.length() <11 || telNumber.length() >13){
			result ="【電話番号は11文字以上13文字以下で入力してください】";
		}else if(!telNumber.matches("^[0-9]+-+[0-9]+-+[0-9]+$")){
			result ="【電話番号は半角数字で、正しいものを入力してください】";
		}
		return result;
	}

	public String emailChk(String email){
		String result ="OK";

		if(email.equals("")){
			result ="【メールアドレスを入力してください】";
		}else if(email.length() <14 || email.length() >32){
			result ="【メールアドレスは14文字以上32文字以下で入力してください】";
		}else if(!email.matches("^[a-zA-Z0-9@.,;:!#$%&'*+-/=?^_`{|}~]+@+[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+.+[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
			result ="【メールアドレスは半角英数字記号で、正しいものを入力してください】";
		}
		return result;
	}


	//検索ワードの入力チェック
	public String keywordChk(String keywords){
		String result ="";

		if(keywords.length() <1 || keywords.length() >16){
			result ="【検索は、1文字以上16文字以下で入力してください】";
		}else if(!keywords.matches("^[a-zA-Z0-9ぁ-ゞ一-龠々ァ-ヾ]+$")){
			result ="【検索は半角英数字、漢字、ひらがな、カタカナで入力してください】";
		}
		return result;
	}


}
