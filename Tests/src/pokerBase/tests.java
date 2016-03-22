
}
@Test
public void TestRoyalFlush() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> RoyalFlush = new ArrayList<Card>();
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.TEN,0));
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.JACK,0));
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.QUEEN,0));		
	RoyalFlush.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.ACE,0));
	Collections.sort(RoyalFlush);
	Hand h = new Hand();
	h = SetHand(RoyalFlush,h);
	
	boolean bActualIsRoyalFlush = Hand.isHandRoyalFlush(h, hs);
	boolean bExpectedIsRoyalFlush = true;
	
	assertEquals(bExpectedIsRoyalFlush,bActualIsRoyalFlush);		
	
	assertEquals(hs.getHiHand(),eRank.JOKER.getiRankNbr());	
}
	}
	
	@Test
	public void TestRoyalFlushEval() {
		
	HandScore hs = new HandScore();
	ArrayList<Card> RoyalFlush = new ArrayList<Card>();
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.TEN,0));
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.JACK,0));
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.QUEEN,0));		
	RoyalFlush.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	RoyalFlush.add(new Card(eSuit.CLUBS,eRank.ACE,0));
		Collections.sort(RoyalFlush);
		Hand h = new Hand();
		h = SetHand(RoyalFlush,h);
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (HandException e) {			
			e.printStackTrace();
			fail("TestStraightEval failed");
		}		

		int iActualIsHandRoyalFlush = h.getHandScore().getHandStrength();
		int iExpectedIsHandRoyalFlush = eHandStrength.RoyalFlush.getHandStrength();
		
		assertEquals(iActualIsHandRoyalFlush,iExpectedIsHandRoyalFlush);		
		assertEquals(h.getHandScore().getHiHand(),eRank.JOKER.getiRankNbr());		
	}
	
@Test
public void TestFiveOfAKindEval() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> FiveOfAKind = new ArrayList<Card>();
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));	
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	
	Hand h = new Hand();
	h = SetHand(FiveOfAKind,h);
	

	try {
		h = Hand.EvaluateHand(h);
	} catch (HandException e) {			
		e.printStackTrace();
		fail("TestFiveOfAKindEval failed");
	}		
	
	
	
	
	int iActualIsHandFivefAKind = h.getHandScore().getHandStrength();
	int iExpectedIsHandFiveOfAKind = eHandStrength.FiveOfAKind.getHandStrength();
	
	//	Did this evaluate to Five of a Kind?
	assertEquals(iActualIsHandFivefAKind,iExpectedIsHandFiveOfAKind);		
	//	Was the four of a kind an Joker?
	assertEquals(h.getHandScore().getHiHand(),eRank.JOKER.getiRankNbr());		
}

@Test
public void TestFourOfAKind() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> FourOfAKind = new ArrayList<Card>();
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));	
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FourOfAKind.add(new Card(eSuit.CLUBS,eRank.KING,0));
	Collections.sort(FourOfAKind);
	Hand h = new Hand();
	h = SetHand(FourOfAKind,h);
	
	boolean bActualIsHandFourOfAKind = Hand.isHandFourOfAKind(h, hs);
	boolean bExpectedIsHandFourOfAKind = true;
	
	//	Did this evaluate to Four of a Kind?
	assertEquals(bActualIsHandFourOfAKind,bExpectedIsHandFourOfAKind);		
	//	Was the four of a kind a Joker?
	assertEquals(hs.getHiHand(),eRank.JOKER.getiRankNbr());		
	//	FOAK has one kicker.  Was it a Club?
	assertEquals(hs.getKickers().get(eCardNo.FirstCard.getCardNo()).geteSuit(), eSuit.CLUBS);
	//	FOAK has one kicker.  Was it a King?		
	assertEquals(hs.getKickers().get(eCardNo.FirstCard.getCardNo()).geteRank(), eRank.KING);
}
@Test
public void TestFourOfAKindEval1() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> FourOfAKind = new ArrayList<Card>();
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));	
	FourOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FourOfAKind.add(new Card(eSuit.CLUBS,eRank.KING,0));
	Collections.sort(FourOfAKind);
	Hand h = new Hand();
	h = SetHand(FourOfAKind,h);
	
	try {
		h = Hand.EvaluateHand(h);
	} catch (HandException e) {			
		e.printStackTrace();
		fail("TestFourOfAKindEval failed");
	}
	HandScore hs = h.getHandScore();
	int iActualIsHandFourOfAKind = hs.getHandStrength();
	int iExpectedIsHandFourOfAKind = eHandStrength.FourOfAKind.getHandStrength();
	
	//	Did this evaluate to Four of a Kind?
	assertEquals(iActualIsHandFourOfAKind,iExpectedIsHandFourOfAKind);		
	//	Was the four of a kind a Joker?
	assertEquals(hs.getHiHand(),eRank.JOKER.getiRankNbr());		
	//	FOAK has one kicker.  Was it a Club?
	assertEquals(hs.getKickers().get(eCardNo.FirstCard.getCardNo()).geteSuit(), eSuit.CLUBS);
	//	FOAK has one kicker.  Was it a King?		
	assertEquals(hs.getKickers().get(eCardNo.FirstCard.getCardNo()).geteRank(), eRank.KING);
}	