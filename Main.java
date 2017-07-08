# Printer-System


public class Main {

	public static void main(String[] args) {
		Printer printer = new Printer(49, false);
		
		printer.printPage(3);
		printer.tonerLevel(90);
		
		System.out.println(printer.getTonerLevel());

	}

}


public class Printer {
	private int inkAmount;
	private int totalPagesPrinted;
	private boolean isSingle = true;
	
	public Printer(int tonerLevelIn,  boolean isSingleIn) {
		if(tonerLevelIn>0 && tonerLevelIn<100){
			this.inkAmount = tonerLevelIn;
		} else {
			this.inkAmount = 100;
		}
		this.totalPagesPrinted = 0;
		this.isSingle = isSingleIn;
	}
	
	public void tonerLevel(int topUp){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		if((inkAmount + topUp)>100){
			System.out.println("Too much ink for printer, "+ (100-inkAmount)+" is the needed amount to top of the ink");
			return;
		} else {
			inkAmount = inkAmount + topUp;
			System.out.println("New ink Level is "+ inkAmount);
		}
	}
	
	public void printPage(int docNum){
		if (inkAmount>(2*docNum)){
			totalPagesPrinted = totalPagesPrinted + docNum ;
		}
		if(inkAmount<=(2*docNum)){
			System.out.println("Empty ink cartridge, please refill");
			return;
		}
		inkAmount= inkAmount - (2*docNum);
		if(inkAmount<15){
			System.out.println("Ink Level is low");
		}
		System.out.println((totalPagesPrinted+" pages have been printed"));	
	}
	

	public int sheetsNeededForJob(int docNum){
		if(isSingle == false){
			int x = docNum%2;
			int y = docNum/2;
			return (x+y);
		} else {
			return docNum;
		}
	}

	public int getTonerLevel() {
		return inkAmount;
	}

	public int getPageNumber() {
		return totalPagesPrinted;
	}
	

}
