package com.me.dao;

import com.me.pojo.CardDetails;

public class CardDao extends DAO{

	public  CardDetails getCardDetails(int userId) {
		// TODO Auto-generated method stub

		CardDetails card  = (CardDetails) getSession().get(CardDetails.class, userId);
		return card;
	}

}
