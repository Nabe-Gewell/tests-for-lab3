@Test
public void TestFlushJoker() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> Flush = new ArrayList<Card>();
	Flush.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	Flush.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	Flush.add(new Card(eSuit.JOKER,eRank.JOKER,0));	
	Flush.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	Flush.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	Collections.sort(Flush);
	Hand h = new Hand();
	h = SetHand(Flush,h);
	
	boolean bActualIsHandFlush = Hand.isHandFlush(h, hs);
	boolean bExpectedIsFlush = true;
	
	assertEquals(bActualIsHandFlush,bExpectedIsFlush);		
	assertEquals(hs.getHiHand(),eRank.JOKER.getiRankNbr());		
}

@Test
public void TestFlushEvalJoker() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> Flush = new ArrayList<Card>();
	Flush.add(new Card(eSuit.JOKER,eRank.ACE,0));
	Flush.add(new Card(eSuit.JOKER,eRank.KING,0));
	Flush.add(new Card(eSuit.JOKER,eRank.JACK,0));		
	Flush.add(new Card(eSuit.JOKER,eRank.QUEEN,0));
	Flush.add(new Card(eSuit.JOKER,eRank.FOUR,0));
	Collections.sort(Flush);
	Hand h = new Hand();
	h = SetHand(Flush,h);
	
	try {
		h = Hand.EvaluateHand(h);
	} catch (HandException e) {			
		e.printStackTrace();
		fail("TestStraightEval failed");
	}		

	int iActualIsHandFlush = h.getHandScore().getHandStrength();
	int iExpectedIsHandFlush = eHandStrength.Flush.getHandStrength();
	
	assertEquals(iActualIsHandFlush,iExpectedIsHandFlush);		
	assertEquals(h.getHandScore().getHiHand(),eRank.ACE.getiRankNbr());			
}	


@Test
public void TestFiveOfAKindJoker() {
	
	HandScore hs = new HandScore();
	ArrayList<Card> FiveOfAKind = new ArrayList<Card>();
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));	
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	FiveOfAKind.add(new Card(eSuit.JOKER,eRank.JOKER,0));
	
	Hand h = new Hand();
	h = SetHand(FiveOfAKind,h);
	
	boolean bActualIsHandFivefAKind = Hand.isHandFiveOfAKind(h, hs);
	boolean bExpectedIsHandFiveOfAKind = true;
	
	//	Did this evaluate to Five of a Kind?
	assertEquals(bActualIsHandFivefAKind,bExpectedIsHandFiveOfAKind);		
	//	Was the five of a kind an Joker?
	assertEquals(hs.getHiHand(),eRank.JOKER.getiRankNbr());		
}
	
@Test
public void TestFiveOfAKindEvalJoker() {

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
public void TestFourOfAKindJoker() {

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
public void TestFourOfAKindEvalJoker() {

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
HandScore hs1 = h.getHandScore();
int iActualIsHandFourOfAKind = hs1.getHandStrength();
int iExpectedIsHandFourOfAKind = eHandStrength.FourOfAKind.getHandStrength();

//	Did this evaluate to Four of a Kind?
assertEquals(iActualIsHandFourOfAKind,iExpectedIsHandFourOfAKind);		
//	Was the four of a kind a Joker?
assertEquals(hs1.getHiHand(),eRank.JOKER.getiRankNbr());		
//	FOAK has one kicker.  Was it a Club?
assertEquals(hs1.getKickers().get(eCardNo.FirstCard.getCardNo()).geteSuit(), eSuit.CLUBS);
//	FOAK has one kicker.  Was it a King?		
assertEquals(hs1.getKickers().get(eCardNo.FirstCard.getCardNo()).geteRank(), eRank.KING);
}	

