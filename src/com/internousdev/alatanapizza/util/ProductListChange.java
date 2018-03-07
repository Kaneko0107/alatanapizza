package com.internousdev.alatanapizza.util;

import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.ProductDTO;

public class ProductListChange {

	public ArrayList<ArrayList<ProductDTO>> productListChange(ArrayList<ProductDTO> productList){
		ArrayList<ArrayList<ProductDTO>> trueList = new ArrayList<>();

		int t = 0;
		trueList.add(new ArrayList<ProductDTO>());
		for(int i=1; i<= productList.size() ; i++){
			trueList.get(t).add(productList.get(i - 1));
				if(i % 9 == 0 && i != 0){
					t++;
					trueList.add(new ArrayList<ProductDTO>());
				}
		}
		System.out.println(trueList);
		return trueList;



	}

}
